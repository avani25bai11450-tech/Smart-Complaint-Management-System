package complaintmanagement.service;

import complaintmanagement.model.Complaint;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FrequentComplainerManager {

    // Display the number of complaints registered by each user
    public void showFrequentComplainers(
            List<Complaint> complaints
    ) {

        if (complaints.isEmpty()) {

            System.out.println(
                    "No complaints available for analysis."
            );

            return;
        }

        Map<String, Integer> userComplaintCount =
                new HashMap<>();

        // Count complaints for each user
        for (Complaint complaint : complaints) {

            String username =
                    complaint.getUsername();

            userComplaintCount.put(
                    username,
                    userComplaintCount.getOrDefault(username, 0) + 1
            );
        }


        for (Map.Entry<String, Integer> entry
                : userComplaintCount.entrySet()) {

            System.out.println(
                    entry.getKey()
                            + " : "
                            + entry.getValue()
                            + " complaint(s)"
            );
        }
    }
}