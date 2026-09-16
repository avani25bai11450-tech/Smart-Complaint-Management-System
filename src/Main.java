package complaintmanagement;

import complaintmanagement.model.User;
import complaintmanagement.service.AdminManager;
import complaintmanagement.service.ComplaintManager;
import complaintmanagement.service.UserManager;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        UserManager userManager = new UserManager();
        AdminManager adminManager = new AdminManager();
        ComplaintManager complaintManager = new ComplaintManager();

        boolean running = true;

        while (running) {

            System.out.println("\n=================================");
            System.out.println(" SMART COMPLAINT MANAGEMENT SYSTEM");
            System.out.println("=================================");
            System.out.println("1. User Registration");
            System.out.println("2. User Login");
            System.out.println("3. Admin Login");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:

                    System.out.println("\nUSER REGISTRATION");

                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter username: ");
                    String username = scanner.nextLine();

                    System.out.print("Enter password: ");
                    String password = scanner.nextLine();

                    User user = new User(
                            username,
                            password,
                            name
                    );

                    userManager.registerUser(user);

                    break;

                case 2:

                    System.out.println("\nUSER LOGIN");

                    System.out.print("Enter username: ");
                    String loginUsername = scanner.nextLine();

                    System.out.print("Enter password: ");
                    String loginPassword = scanner.nextLine();

                    boolean userLoginSuccessful =
                            userManager.loginUser(
                                    loginUsername,
                                    loginPassword
                            );

                    if (userLoginSuccessful) {

                        UserMenu.showUserMenu(
                                scanner,
                                complaintManager,
                                loginUsername
                        );
                    }

                    break;

                case 3:

                    System.out.println("\nADMIN LOGIN");

                    System.out.print("Enter admin username: ");
                    String adminUsername = scanner.nextLine();

                    System.out.print("Enter admin password: ");
                    String adminPassword = scanner.nextLine();

                    boolean adminLoginSuccessful =
                            adminManager.loginAdmin(
                                    adminUsername,
                                    adminPassword
                            );

                    if (adminLoginSuccessful) {

                        AdminMenu.showAdminMenu(
                                scanner,
                                complaintManager
                        );
                    }

                    break;

                case 4:

                    running = false;

                    System.out.println(
                            "Thank you for using Smart Complaint Management System!"
                    );

                    break;

                default:

                    System.out.println(
                            "Invalid choice. Please try again."
                    );
            }
        }

        scanner.close();
    }
}