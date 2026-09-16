package complaintmanagement.service;

import complaintmanagement.model.Complaint;
import complaintmanagement.model.Priority;

import java.util.List;

public class PriorityManager {

    // Display complaints according to priority
    public void showComplaintsByPriority(
            List<Complaint> complaints,
            Priority requiredPriority
    ) {

        boolean found = false;

        System.out.println(
                "\nCOMPLAINTS WITH PRIORITY: "
                        + requiredPriority
        );

        for (Complaint complaint : complaints) {

            if (complaint.getPriority() == requiredPriority) {

                complaint.displayComplaint();
                found = true;
            }
        }

        if (!found) {
            System.out.println(
                    "No complaints found with this priority."
            );
        }
    }

    // Display urgent complaints
    public void showUrgentComplaints(
            List<Complaint> complaints
    ) {

        showComplaintsByPriority(
                complaints,
                Priority.URGENT
        );
    }
}