package complaintmanagement.service;

import complaintmanagement.model.Complaint;
import complaintmanagement.model.ComplaintStatus;
import complaintmanagement.model.Priority;

import java.util.List;

public class PendingComplaintManager {

    // Display all pending complaints
    public void showPendingComplaints(
            List<Complaint> complaints
    ) {

        boolean found = false;

        System.out.println("\nPENDING COMPLAINTS:");

        for (Complaint complaint : complaints) {

            if (complaint.getStatus() == ComplaintStatus.PENDING) {

                complaint.displayComplaint();

                found = true;
            }
        }

        if (!found) {

            System.out.println(
                    "No pending complaints found."
            );
        }
    }

    // Display overdue complaints
    // High and urgent pending complaints are treated as overdue
    public void showOverdueComplaints(
            List<Complaint> complaints
    ) {

        boolean found = false;

        System.out.println("\nOVERDUE COMPLAINTS:");

        for (Complaint complaint : complaints) {

            if (
                    complaint.getStatus() == ComplaintStatus.PENDING
                    &&
                    (
                            complaint.getPriority() == Priority.HIGH
                            ||
                            complaint.getPriority() == Priority.URGENT
                    )
            ) {

                complaint.displayComplaint();

                found = true;
            }
        }

        if (!found) {

            System.out.println(
                    "No overdue complaints found."
            );
        }
    }
}