package complaintmanagement;

import complaintmanagement.service.AdminManager;

public class TestAdminManager {

    public static void main(String[] args) {

        AdminManager adminManager =
                new AdminManager();

        // Successful admin login
        System.out.println("SUCCESSFUL ADMIN LOGIN:");

        adminManager.loginAdmin(
                "admin",
                "admin123"
        );

        // Failed admin login
        System.out.println("\nFAILED ADMIN LOGIN:");

        adminManager.loginAdmin(
                "admin",
                "wrongpassword"
        );

        // Display admin details
        System.out.println("\nADMIN DETAILS:");

        adminManager.displayAdminDetails();
    }
}