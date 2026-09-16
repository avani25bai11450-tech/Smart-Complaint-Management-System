package complaintmanagement.model;

public class Complaint {

    private int complaintId;
    private String title;
    private String description;
    private String category;
    private String username;

    private Priority priority;
    private ComplaintStatus status;

    public Complaint(
            int complaintId,
            String title,
            String description,
            String category,
            String username,
            Priority priority
    ) {
        this.complaintId = complaintId;
        this.title = title;
        this.description = description;
        this.category = category;
        this.username = username;
        this.priority = priority;
        this.status = ComplaintStatus.PENDING;
    }

    public int getComplaintId() {
        return complaintId;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getCategory() {
        return category;
    }

    public String getUsername() {
        return username;
    }

    public Priority getPriority() {
        return priority;
    }

    public ComplaintStatus getStatus() {
        return status;
    }

    public void updateStatus(ComplaintStatus status) {
        this.status = status;
    }

    public void updatePriority(Priority priority) {
        this.priority = priority;
    }

    public void displayComplaint() {

        System.out.println("----------------------------------");
        System.out.println("Complaint ID: " + complaintId);
        System.out.println("Title: " + title);
        System.out.println("Description: " + description);
        System.out.println("Category: " + category);
        System.out.println("Registered By: " + username);
        System.out.println("Priority: " + priority);
        System.out.println("Status: " + status);
        System.out.println("----------------------------------");
    }
}