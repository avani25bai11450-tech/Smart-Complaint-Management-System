package complaintmanagement.service;

import complaintmanagement.model.User;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class UserManager {

    // Store all registered users
    private List<User> users;

    // File path
    private final String filePath = "data/users.txt";

    // Constructor
    public UserManager() {

        users = new ArrayList<>();

        createDataFolder();

        loadUsersFromFile();
    }

    // Create data folder if it does not exist
    private void createDataFolder() {

        File folder = new File("data");

        if (!folder.exists()) {

            folder.mkdir();
        }
    }

    // Register a new user
    public void registerUser(User user) {

        for (User existingUser : users) {

            if (existingUser.getUsername()
                    .equalsIgnoreCase(user.getUsername())) {

                System.out.println(
                        "Username already exists!"
                );

                return;
            }
        }

        users.add(user);

        saveUsersToFile();

        System.out.println(
                "User registered successfully!"
        );
    }

    // Login user
    public boolean loginUser(
            String username,
            String password
    ) {

        for (User user : users) {

            if (
                    user.getUsername().equals(username)
                    &&
                    user.getPassword().equals(password)
            ) {

                System.out.println(
                        "User login successful!"
                );

                System.out.println(
                        "Welcome, " + user.getName() + "!"
                );

                return true;
            }
        }

        System.out.println(
                "Invalid username or password."
        );

        return false;
    }

    // Display all registered users
    public void viewAllUsers() {

        if (users.isEmpty()) {

            System.out.println(
                    "No registered users found."
            );

            return;
        }

        for (User user : users) {

            user.displayUser();

            System.out.println();
        }
    }

    // Save users into users.txt
    private void saveUsersToFile() {

        try (
                PrintWriter writer =
                        new PrintWriter(
                                new FileWriter(filePath)
                        )
        ) {

            for (User user : users) {

                writer.println(
                        user.getUsername()
                                + "|"
                                + user.getPassword()
                                + "|"
                                + user.getName()
                );
            }

        } catch (IOException e) {

            System.out.println(
                    "Error saving users: "
                            + e.getMessage()
            );
        }
    }

    // Load users from users.txt
    private void loadUsersFromFile() {

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

                if (data.length != 3) {

                    continue;
                }

                String username = data[0];

                String password = data[1];

                String name = data[2];

                User user =
                        new User(
                                username,
                                password,
                                name
                        );

                users.add(user);
            }

        } catch (IOException e) {

            System.out.println(
                    "Error loading users: "
                            + e.getMessage()
            );
        }
    }

    // Return user list
    public List<User> getUsers() {

        return users;
    }
}