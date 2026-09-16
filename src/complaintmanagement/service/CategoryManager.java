package complaintmanagement.service;

import complaintmanagement.model.Complaint;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CategoryManager {

    // Display the number of complaints in each category
    public void showCategoryWiseAnalysis(
            List<Complaint> complaints
    ) {

        if (complaints.isEmpty()) {

            System.out.println(
                    "No complaints available for analysis."
            );

            return;
        }

        Map<String, Integer> categoryCount =
                new HashMap<>();

        for (Complaint complaint : complaints) {

            String category =
                    complaint.getCategory();

            categoryCount.put(
                    category,
                    categoryCount.getOrDefault(category, 0) + 1
            );
        }

        System.out.println();

        for (Map.Entry<String, Integer> entry
                : categoryCount.entrySet()) {

            System.out.println(
                    entry.getKey()
                            + " : "
                            + entry.getValue()
                            + " complaint(s)"
            );
        }
    }
}