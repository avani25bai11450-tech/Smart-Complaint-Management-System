package complaintmanagement.service;

import complaintmanagement.model.Complaint;
import complaintmanagement.model.ComplaintStatus;
import complaintmanagement.model.Priority;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class ComplaintManager {

    // List stores all complaints
    private List<Complaint> complaints;

    // Map searches complaints using complaint ID
    private Map<Integer, Complaint> complaintMap;

    // Stack stores complaint actions and history
    private Stack<String> complaintHistory;

    // Automatically generated complaint ID
    private int nextComplaintId;

    // File path
    private final String filePath = "data/complaints.txt";

    // Constructor
    public ComplaintManager() {

        complaints = new ArrayList<>();

        complaintMap = new HashMap<>();

        complaintHistory = new Stack<>();

        nextComplaintId = 101;

        createDataFolder();

        loadComplaintsFromFile();

        updateNextComplaintId();
    }

    // Create data folder if it does not exist
    private void createDataFolder() {

        File folder = new File("data");

        if (!folder.exists()) {

            folder.mkdir();
        }
    }

    // Generate a new complaint ID
    public int generateComplaintId() {

        return nextComplaintId++;
    }

    // Update next ID according to existing complaints
    private void updateNextComplaintId() {

        for (Complaint complaint : complaints) {

            if (
                    complaint.getComplaintId()
                            >= nextComplaintId
            ) {

                nextComplaintId =
                        complaint.getComplaintId() + 1;
            }
        }
    }

    // Add a new complaint
    public void addComplaint(Complaint complaint) {

        if (
                complaintMap.containsKey(
                        complaint.getComplaintId()
                )
        ) {

            System.out.println(
                    "Complaint ID already exists!"
            );

            return;
        }

        complaints.add(complaint);

        complaintMap.put(
                complaint.getComplaintId(),
                complaint
        );

        complaintHistory.push(
                "Complaint registered: "
                        + complaint.getComplaintId()
        );

        saveComplaintsToFile();

        System.out.println(
                "Complaint registered successfully!"
        );
    }

    // View all complaints
    public void viewAllComplaints() {

        if (complaints.isEmpty()) {

            System.out.println(
                    "No complaints found."
            );

            return;
        }

        for (Complaint complaint : complaints) {

            complaint.displayComplaint();

            System.out.println(
                    "----------------------------"
            );
        }
    }

    // Search complaint using complaint ID
    public void searchComplaint(int complaintId) {

        Complaint complaint =
                complaintMap.get(complaintId);

        if (complaint != null) {

            complaint.displayComplaint();

        } else {

            System.out.println(
                    "Complaint not found."
            );
        }
    }

    // Update complaint status
    public void updateComplaintStatus(
            int complaintId,
            ComplaintStatus newStatus
    ) {

        Complaint complaint =
                complaintMap.get(complaintId);

        if (complaint != null) {

            complaint.updateStatus(newStatus);

            complaintHistory.push(
                    "Status updated for complaint: "
                            + complaintId
                            + " -> "
                            + newStatus
            );

            saveComplaintsToFile();

            System.out.println(
                    "Complaint status updated successfully!"
            );

        } else {

            System.out.println(
                    "Complaint not found."
            );
        }
    }

    // View the latest complaint
    public void viewLatestComplaint() {

        if (complaints.isEmpty()) {

            System.out.println(
                    "No complaints available."
            );

            return;
        }

        Complaint latestComplaint =
                complaints.get(complaints.size() - 1);

        latestComplaint.displayComplaint();
    }

    // View complaint history
    public void viewHistory() {

        if (complaintHistory.isEmpty()) {

            System.out.println(
                    "No complaint history available."
            );

            return;
        }

        System.out.println(
                "\nRecent Complaint Actions:"
        );

        for (String action : complaintHistory) {

            System.out.println(action);
        }
    }

    // Save complaints into complaints.txt
    private void saveComplaintsToFile() {

        try (
                PrintWriter writer =
                        new PrintWriter(
                                new FileWriter(filePath)
                        )
        ) {

            for (Complaint complaint : complaints) {

                writer.println(
                        complaint.getComplaintId()
                                + "|"
                                + complaint.getTitle()
                                + "|"
                                + complaint.getDescription()
                                + "|"
                                + complaint.getCategory()
                                + "|"
                                + complaint.getUsername()
                                + "|"
                                + complaint.getPriority()
                                + "|"
                                + complaint.getStatus()
                );
            }

        } catch (IOException e) {

            System.out.println(
                    "Error saving complaints: "
                            + e.getMessage()
            );
        }
    }

    // Load complaints from complaints.txt
    private void loadComplaintsFromFile() {

        File file = new File(filePath);

        if (!file.exists()) {

            return;
        }

        try (
                BufferedReader reader =
                        new BufferedReader(
                                new FileReader(file)
                        )
        ) {

            String line;

            while ((line = reader.readLine()) != null) {

                if (line.trim().isEmpty()) {

                    continue;
                }

                String[] data =
                        line.split("\\|", -1);

                if (data.length != 7) {

                    continue;
                }

                int complaintId =
                        Integer.parseInt(data[0]);

                String title = data[1];

                String description = data[2];

                String category = data[3];

                String username = data[4];

                Priority priority =
                        Priority.valueOf(data[5]);

                ComplaintStatus status =
                        ComplaintStatus.valueOf(data[6]);

                Complaint complaint =
                        new Complaint(
                                complaintId,
                                title,
                                description,
                                category,
                                username,
                                priority
                        );

                complaint.updateStatus(status);

                complaints.add(complaint);

                complaintMap.put(
                        complaintId,
                        complaint
                );
            }

        } catch (IOException e) {

            System.out.println(
                    "Error loading complaints: "
                            + e.getMessage()
            );

        } catch (NumberFormatException e) {

            System.out.println(
                    "Invalid complaint ID in file."
            );

        } catch (IllegalArgumentException e) {

            System.out.println(
                    "Invalid priority or status in file."
            );
        }
    }

    // Return all complaints to other classes
    public List<Complaint> getComplaints() {

        return complaints;
    }
}