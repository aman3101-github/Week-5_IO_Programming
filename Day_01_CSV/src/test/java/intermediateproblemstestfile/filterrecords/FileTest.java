package intermediateproblemstestfile.filterrecords;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.example.intermediateproblems.filterrecords.Main;
import org.example.intermediateproblems.filterrecords.Student;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

class FilterRecordTest {

    @Test
    void testReadAndFilterStudents() throws IOException, CsvValidationException {
        // Simulated CSV data
        String csvData = "ID,Name,Age,Marks\n" +
                "101,John,20,85.5\n" +
                "102,Alice,22,90.0\n" +
                "103,Bob,19,75.0\n" +
                "104,Emma,21,88.0\n" +
                "105,Tom,23,79.5";

        // Use StringReader to simulate a file
        Reader reader = new StringReader(csvData);
        CSVReader csvReader = new CSVReader(reader);

        // Read and filter students (Mocked CSV)
        List<Student> filteredStudents = Main.readAndFilterStudents(String.valueOf(csvReader), 80.0);

        // Assertions
        assertEquals(3, filteredStudents.size()); // 3 students have marks > 80
        assertEquals("John", filteredStudents.get(0).getName());
        assertEquals("Alice", filteredStudents.get(1).getName());
        assertEquals("Emma", filteredStudents.get(2).getName());
    }
}
