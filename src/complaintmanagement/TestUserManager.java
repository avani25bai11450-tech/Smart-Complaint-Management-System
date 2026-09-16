package complaintmanagement;

import complaintmanagement.model.User;
import complaintmanagement.service.UserManager;

public class TestUserManager {

    public static void main(String[] args) {

        UserManager userManager =
                new UserManager();

        // Register first user
        User user1 = new User(
                "avani",
                "1234",
                "Avani Khare"
        );

        // Register second user
        User user2 = new User(
                "rahul",
                "5678",
                "Rahul Sharma"
        );

        System.out.println("USER REGISTRATION:");

        userManager.registerUser(user1);
        userManager.registerUser(user2);

        // Try duplicate username
        System.out.println("\nDUPLICATE USERNAME TEST:");

        User duplicateUser = new User(
                "avani",
                "9999",
                "Another Avani"
        );

        userManager.registerUser(duplicateUser);

        // Display all users
        System.out.println("\nALL REGISTERED USERS:");

        userManager.viewAllUsers();

        // Successful login
        System.out.println("\nSUCCESSFUL LOGIN:");

        userManager.loginUser(
                "avani",
                "1234"
        );

        // Failed login
        System.out.println("\nFAILED LOGIN:");

        userManager.loginUser(
                "avani",
                "wrongpassword"
        );
    }
}