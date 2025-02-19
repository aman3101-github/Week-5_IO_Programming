package intermediateproblemstestfile.updatecsvfile;
import org.example.intermediateproblems.updatecsv.ModifyCSVFile;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.*;

class ModifyCSVTest {

    // Test to verify that the salary for IT employees has been updated correctly
    @Test
    void testSalaryUpdate() {
        String inputFile = "employees.csv";
        String outputFile = "updated_employees.csv";

        // Call the updateSalaries method
        ModifyCSVFile.updateSalaries(inputFile, outputFile);

        // Check if the output file is created
        File file = new File(outputFile);
        assertTrue(file.exists(), "Output file should exist after the method is executed.");

        // Verify the salary update for IT department (check if salary increased by 10%)
        try (BufferedReader reader = new BufferedReader(new FileReader(outputFile))) {
            String line;
            boolean foundItEmployee = false;
            while ((line = reader.readLine()) != null) {
                if (line.contains("IT")) { // Check for IT department
                    foundItEmployee = true;
                    String[] columns = line.split(",");
                    double salary = Double.parseDouble(columns[3]);
                    assertTrue(salary > 65000, "Salary for IT department should be increased by 10%.");
                }
            }
            assertTrue(foundItEmployee, "There should be employees from the IT department in the output file.");
        } catch (IOException e) {
            e.printStackTrace();
            fail("Error reading the updated file.");
        }
    }
}

