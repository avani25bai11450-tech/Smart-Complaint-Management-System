package complaintmanagement;

import complaintmanagement.model.Complaint;
import complaintmanagement.model.ComplaintStatus;
import complaintmanagement.service.ComplaintManager;
import complaintmanagement.service.DepartmentManager;

import java.util.Scanner;

public class AdminMenu {

    public static void showAdminMenu(
            Scanner scanner,
            ComplaintManager complaintManager
    ) {

        DepartmentManager departmentManager =
                new DepartmentManager();

        boolean loggedIn = true;

        while (loggedIn) {

            System.out.println("\n==============================");
            System.out.println("        ADMIN DASHBOARD");
            System.out.println("==============================");
            System.out.println("1. View All Complaints");
            System.out.println("2. Search Complaint");
            System.out.println("3. Update Complaint Status");
            System.out.println("4. View Latest Complaint");
            System.out.println("5. View Complaint History");
            System.out.println("6. Assign Department");
            System.out.println("7. View Department Assignment");
            System.out.println("8. View All Department Assignments");
            System.out.println("9. Logout");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:

                    System.out.println("\nALL COMPLAINTS:");

                    complaintManager.viewAllComplaints();

                    break;

                case 2:

                    System.out.print("Enter complaint ID: ");

                    int searchId = scanner.nextInt();
                    scanner.nextLine();

                    complaintManager.searchComplaint(searchId);

                    break;

                case 3:

                    System.out.print("Enter complaint ID: ");

                    int complaintId = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("\nSelect New Status:");
                    System.out.println("1. PENDING");
                    System.out.println("2. IN_PROGRESS");
                    System.out.println("3. RESOLVED");
                    System.out.println("4. REJECTED");
                    System.out.print("Enter status choice: ");

                    int statusChoice = scanner.nextInt();
                    scanner.nextLine();

                    ComplaintStatus status;

                    switch (statusChoice) {

                        case 1:
                            status = ComplaintStatus.PENDING;
                            break;

                        case 2:
                            status = ComplaintStatus.IN_PROGRESS;
                            break;

                        case 3:
                            status = ComplaintStatus.RESOLVED;
                            break;

                        case 4:
                            status = ComplaintStatus.REJECTED;
                            break;

                        default:
                            System.out.println(
                                    "Invalid status choice."
                            );
                            continue;
                    }

                    complaintManager.updateComplaintStatus(
                            complaintId,
                            status
                    );

                    break;

                case 4:

                    System.out.println("\nLATEST COMPLAINT:");

                    complaintManager.viewLatestComplaint();

                    break;

                case 5:

                    complaintManager.viewHistory();

                    break;

                case 6:

                    System.out.print("Enter complaint ID: ");

                    int departmentComplaintId = scanner.nextInt();
                    scanner.nextLine();

                    Complaint complaint =
                            findComplaint(
                                    complaintManager,
                                    departmentComplaintId
                            );

                    if (complaint != null) {

                        departmentManager.assignDepartment(
                                complaint
                        );

                    } else {

                        System.out.println(
                                "Complaint not found."
                        );
                    }

                    break;

                case 7:

                    System.out.print("Enter complaint ID: ");

                    int assignedComplaintId = scanner.nextInt();
                    scanner.nextLine();

                    departmentManager.showDepartment(
                            assignedComplaintId
                    );

                    break;

                case 8:

                    departmentManager.showAllDepartments();

                    break;

                case 9:

                    loggedIn = false;

                    System.out.println(
                            "Admin logged out successfully!"
                    );

                    break;

                default:

                    System.out.println(
                            "Invalid choice. Please try again."
                    );
            }
        }
    }

    private static Complaint findComplaint(
            ComplaintManager complaintManager,
            int complaintId
    ) {

        for (Complaint complaint :
                complaintManager.getComplaints()) {

            if (complaint.getComplaintId() == complaintId) {

                return complaint;
            }
        }

        return null;
    }
}