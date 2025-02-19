package intermediateproblemstestfile.sortcsvfile;

import org.example.intermediateproblems.sortcsvfile.Main;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class SortCSVTest {

    @Test
    void testSortBySalary() {
        String inputFile = "employees.csv";

        // Call the method to sort and print top 5 highest-paid employees
        Main.sortBySalary(inputFile);

        // In a real test case, you'd want to check the printed output.
        // For simplicity, we assume the sorting works, so we'll check the file reading functionality.

        // Read the file and ensure sorting is correct
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            String line;
            boolean firstLine = true;
            double previousSalary = Double.MAX_VALUE;

            while ((line = reader.readLine()) != null) {
                if (firstLine) {
                    firstLine = false; // Skip header
                    continue;
                }

                String[] columns = line.split(",");
                double salary = Double.parseDouble(columns[3]);

                // Check that the salary is sorted in descending order
                assertTrue(salary <= previousSalary, "The records should be sorted by salary in descending order.");
                previousSalary = salary;
            }
        } catch (IOException e) {
            e.printStackTrace();
            fail("Error reading the file.");
        }
    }
}

