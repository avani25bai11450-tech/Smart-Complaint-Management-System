package complaintmanagement.service;

import complaintmanagement.model.Complaint;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DepartmentManager {

    // Store department assigned to each complaint
    private Map<Integer, String> complaintDepartments;

    // Constructor
    public DepartmentManager() {

        complaintDepartments = new HashMap<>();
    }

    // Assign department according to complaint category
    public void assignDepartment(Complaint complaint) {

        String category =
                complaint.getCategory().toLowerCase();

        String department;

        switch (category) {

            case "hostel":
                department = "Hostel Department";
                break;

            case "network":
            case "internet":
            case "computer":
                department = "IT Department";
                break;

            case "medical":
                department = "Medical Department";
                break;

            case "academic":
            case "study":
            case "exam":
                department = "Academic Department";
                break;

            default:
                department = "Administration Department";
        }

        complaintDepartments.put(
                complaint.getComplaintId(),
                department
        );

        System.out.println(
                "Department assigned successfully!"
        );
    }

    // Display department assigned to a complaint
    public void showDepartment(int complaintId) {

        String department =
                complaintDepartments.get(complaintId);

        if (department != null) {

            System.out.println(
                    "Complaint ID: "
                            + complaintId
                            + " -> "
                            + department
            );

        } else {

            System.out.println(
                    "No department assigned to this complaint."
            );
        }
    }

    // Display all department assignments
    public void showAllDepartments() {

        if (complaintDepartments.isEmpty()) {

            System.out.println(
                    "No department assignments found."
            );

            return;
        }

        System.out.println("\nDEPARTMENT ASSIGNMENTS:");

        for (Map.Entry<Integer, String> entry
                : complaintDepartments.entrySet()) {

            System.out.println(
                    "Complaint ID: "
                            + entry.getKey()
                            + " -> "
                            + entry.getValue()
            );
        }
    }
}