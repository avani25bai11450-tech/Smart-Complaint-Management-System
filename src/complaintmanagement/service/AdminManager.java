package complaintmanagement.service;

import complaintmanagement.model.Admin;

public class AdminManager {

    // Store one default admin
    private Admin admin;

    // Constructor
    public AdminManager() {

        admin = new Admin(
                "admin",
                "admin123",
                "System Administrator",
                "ADM001"
        );
    }

    // Verify admin login
    public boolean loginAdmin(
            String username,
            String password
    ) {

        if (
                admin.getUsername().equals(username)
                &&
                admin.getPassword().equals(password)
        ) {

            System.out.println(
                    "Admin login successful!"
            );

            System.out.println(
                    "Welcome, " + admin.getName() + "!"
            );

            return true;
        }

        System.out.println(
                "Invalid admin username or password."
        );

        return false;
    }

    // Display admin details
    public void displayAdminDetails() {

        admin.displayAdmin();
    }
}