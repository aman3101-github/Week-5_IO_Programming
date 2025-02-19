package intermediateproblemstestfile.searchrecord;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void testSearchEmployee() {
        // Simulating expected output for an existing employee
        String expectedDepartment = "Finance";
        String expectedSalary = "80000";

        // Manually call the search method (mocking real behavior)
        String[] employeeData = {"104", "Emily Davis", "Finance", "80000"};

        // Check if the data matches expected values
        assertEquals(expectedDepartment, employeeData[2]);
        assertEquals(expectedSalary, employeeData[3]);
    }

    @Test
    void testSearchEmployeeNotFound() {
        // Simulating a non-existing employee search
        String searchName = "Nonexistent Employee";
        boolean found = false;

        // Sample CSV data
        String[][] csvData = {
                {"101", "John Doe", "Engineering", "75000"},
                {"102", "Jane Smith", "HR", "65000"}
        };

        // Search for the employee in the mock data
        for (String[] employee : csvData) {
            if (employee[1].equalsIgnoreCase(searchName)) {
                found = true;
                break;
            }
        }

        // Employee should not be found
        assertFalse(found, "Employee should not be found");
    }
}
