package complaintmanagement;

import complaintmanagement.model.Complaint;
import complaintmanagement.model.Priority;
import complaintmanagement.model.ComplaintStatus;

import complaintmanagement.service.ComplaintManager;
import complaintmanagement.service.PriorityManager;
import complaintmanagement.service.CategoryManager;
import complaintmanagement.service.FrequentComplainerManager;
import complaintmanagement.service.PendingComplaintManager;
import complaintmanagement.service.DepartmentManager;

public class TestComplaintManager {

    public static void main(String[] args) {

        // Create ComplaintManager object
        ComplaintManager manager =
                new ComplaintManager();

        // Create first complaint
        Complaint complaint1 = new Complaint(
                101,
                "Hostel Water Problem",
                "Water supply is not working properly.",
                "Hostel",
                "avani",
                Priority.HIGH
        );

        // Create second complaint
        Complaint complaint2 = new Complaint(
                102,
                "Internet Issue",
                "Internet connection is very slow.",
                "Network",
                "rahul",
                Priority.MEDIUM
        );

        // Create third complaint
        Complaint complaint3 = new Complaint(
                103,
                "Emergency Medical Issue",
                "Medical assistance is required.",
                "Medical",
                "avani",
                Priority.URGENT
        );

        // Add complaints to ComplaintManager
        manager.addComplaint(complaint1);
        manager.addComplaint(complaint2);
        manager.addComplaint(complaint3);

        // Display all complaints
        System.out.println("\nALL COMPLAINTS:");

        manager.viewAllComplaints();

        // Search complaint by ID
        System.out.println("\nSEARCH COMPLAINT:");

        manager.searchComplaint(101);

        // Display latest complaint
        System.out.println("\nLATEST COMPLAINT:");

        manager.viewLatestComplaint();

        // Update complaint status
        System.out.println("\nUPDATING STATUS:");

        manager.updateComplaintStatus(
                101,
                ComplaintStatus.IN_PROGRESS
        );

        // Display complaint history
        System.out.println("\nCOMPLAINT HISTORY:");

        manager.viewHistory();

        // Create PriorityManager object
        PriorityManager priorityManager =
                new PriorityManager();

        // Display high-priority complaints
        System.out.println("\nHIGH PRIORITY COMPLAINTS:");

        priorityManager.showComplaintsByPriority(
                manager.getComplaints(),
                Priority.HIGH
        );

        // Display urgent complaints
        System.out.println("\nURGENT COMPLAINTS:");

        priorityManager.showUrgentComplaints(
                manager.getComplaints()
        );

        // Create CategoryManager object
        CategoryManager categoryManager =
                new CategoryManager();

        // Display category-wise analysis
        System.out.println("\nCATEGORY-WISE ANALYSIS:");

        categoryManager.showCategoryWiseAnalysis(
                manager.getComplaints()
        );

        // Create FrequentComplainerManager object
        FrequentComplainerManager frequentComplainerManager =
                new FrequentComplainerManager();

        // Display frequent complainer analysis
        System.out.println("\nFREQUENT COMPLAINER ANALYSIS:");

        frequentComplainerManager.showFrequentComplainers(
                manager.getComplaints()
        );

        // Create PendingComplaintManager object
        PendingComplaintManager pendingComplaintManager =
                new PendingComplaintManager();

        // Display pending complaints
        pendingComplaintManager.showPendingComplaints(
                manager.getComplaints()
        );

        // Display overdue complaints
        pendingComplaintManager.showOverdueComplaints(
                manager.getComplaints()
        );

        // Create DepartmentManager object
        DepartmentManager departmentManager =
                new DepartmentManager();

        // Assign departments to all complaints
        System.out.println("\nASSIGNING DEPARTMENTS:");

        for (Complaint complaint : manager.getComplaints()) {

            departmentManager.assignDepartment(complaint);
        }

        // Display all department assignments
        departmentManager.showAllDepartments();

        // Display department of one complaint
        System.out.println("\nSEARCH DEPARTMENT:");

        departmentManager.showDepartment(101);
    }
}