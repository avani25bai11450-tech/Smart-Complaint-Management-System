package complaintmanagement;

import complaintmanagement.model.Complaint;
import complaintmanagement.model.Priority;
import complaintmanagement.service.ComplaintManager;

import java.util.Scanner;

public class UserMenu {

    public static void showUserMenu(
            Scanner scanner,
            ComplaintManager complaintManager,
            String username
    ) {

        while (true) {

            System.out.println("\n==============================");
            System.out.println("        USER DASHBOARD");
            System.out.println("==============================");
            System.out.println("1. Register Complaint");
            System.out.println("2. View My Complaints");
            System.out.println("3. View All Complaints");
            System.out.println("4. Search Complaint");
            System.out.println("5. View Latest Complaint");
            System.out.println("6. Logout");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:

                    System.out.println("\nREGISTER COMPLAINT");

                    int complaintId =
                            complaintManager.generateComplaintId();

                    System.out.println(
                            "Your Complaint ID is: " + complaintId
                    );

                    System.out.print("Enter complaint title: ");
                    String title = scanner.nextLine();

                    System.out.print("Enter complaint description: ");
                    String description = scanner.nextLine();

                    System.out.print("Enter complaint category: ");
                    String category = scanner.nextLine();

                    System.out.print(
                            "Enter priority (LOW, MEDIUM, HIGH): "
                    );

                    Priority priority;

                    try {
                        priority = Priority.valueOf(
                                scanner.nextLine().toUpperCase()
                        );
                    } catch (IllegalArgumentException e) {
                        System.out.println(
                                "Invalid priority! Setting priority to MEDIUM."
                        );
                        priority = Priority.MEDIUM;
                    }

                    Complaint complaint = new Complaint(
                            complaintId,
                            title,
                            description,
                            category,
                            username,
                            priority
                    );

                    complaintManager.addComplaint(complaint);

                    break;

                case 2:

                    System.out.println("\nMY COMPLAINTS");

                    boolean found = false;

                    for (Complaint c : complaintManager.getComplaints()) {

                        if (c.getUsername().equalsIgnoreCase(username)) {
                            c.displayComplaint();
                            found = true;
                        }
                    }

                    if (!found) {
                        System.out.println(
                                "You have not registered any complaints."
                        );
                    }

                    break;

                case 3:

                    System.out.println("\nALL COMPLAINTS");

                    complaintManager.viewAllComplaints();

                    break;

                case 4:

                    System.out.println("\nSEARCH COMPLAINT");

                    System.out.print("Enter complaint ID to search: ");
                    int searchId = scanner.nextInt();
                    scanner.nextLine();

                    complaintManager.searchComplaint(searchId);

                    break;

                case 5:

                    System.out.println("\nLATEST COMPLAINT");

                    complaintManager.viewLatestComplaint();

                    break;

                case 6:

                    System.out.println("Logging out...");

                    return;

                default:

                    System.out.println(
                            "Invalid choice! Please try again."
                    );
            }
        }
    }
}