package complaintmanagement.model;

public class Admin extends User {

    private String adminId;

    public Admin(
            String username,
            String password,
            String name,
            String adminId
    ) {

        super(username, password, name);

        this.adminId = adminId;
    }

    public String getAdminId() {
        return adminId;
    }

    public void displayAdmin() {

        System.out.println("Admin Name: " + getName());
        System.out.println("Admin Username: " + getUsername());
        System.out.println("Admin ID: " + adminId);
    }
}