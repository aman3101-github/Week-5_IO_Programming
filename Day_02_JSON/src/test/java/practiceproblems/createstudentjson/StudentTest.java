package practiceproblems.createstudentjson;

import org.example.practiceproblems.createstudentjson.Student;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StudentTest {

    @Test
    public void testStudentJSON() {
        // Call the method to generate the JSON object
        JSONObject studentJSON = Student.studentJSON();

        // Verify that the JSON object is not null
        assertNotNull(studentJSON, "Student JSON should not be null");

        // Verify that the JSON contains expected keys
        assertTrue(studentJSON.has("Name"), "JSON should contain 'Name' key");
        assertTrue(studentJSON.has("Age"), "JSON should contain 'Age' key");
        assertTrue(studentJSON.has("Subjects"), "JSON should contain 'Subjects' key");

        // Verify the values of Name and Age
        assertEquals("Aman", studentJSON.getString("Name"), "Name should be 'Aman'");
        assertEquals(23, studentJSON.getInt("Age"), "Age should be 23");

        // Verify the Subjects array
        JSONArray subjects = studentJSON.getJSONArray("Subjects");
        assertNotNull(subjects, "Subjects array should not be null");
        assertEquals(3, subjects.length(), "Subjects array should contain 3 elements");
        assertEquals("Maths", subjects.getString(0), "First subject should be 'Maths'");
        assertEquals("Physics", subjects.getString(1), "Second subject should be 'Physics'");
        assertEquals("Chemistry", subjects.getString(2), "Third subject should be 'Chemistry'");
    }
}
