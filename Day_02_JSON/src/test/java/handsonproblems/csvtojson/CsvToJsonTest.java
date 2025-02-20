package handsonproblems.csvtojson;

import org.example.handsonproblems.csvtojson.Main;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CsvToJsonTest {

    @Test
    public void testValidCsvToJsonConversion() {
        // Sample CSV input
        String csvData = "name,age,email\nAman,25,aman@example.com\nJohn,30,john@example.com";

        // Expected JSON structure
        JSONArray expectedJsonArray = new JSONArray();

        JSONObject obj1 = new JSONObject();
        obj1.put("name", "Aman");
        obj1.put("age", "25");
        obj1.put("email", "aman@example.com");

        JSONObject obj2 = new JSONObject();
        obj2.put("name", "John");
        obj2.put("age", "30");
        obj2.put("email", "john@example.com");

        expectedJsonArray.put(obj1);
        expectedJsonArray.put(obj2);

        // Convert CSV to JSON
        String actualJsonString = Main.convertCsvToJson(csvData);

        // Compare the expected JSON with the actual JSON output
        assertEquals(expectedJsonArray.toString(), actualJsonString.trim());
    }

    @Test
    public void testEmptyCsvInput() {
        // Empty CSV input
        String csvData = "";

        // Convert CSV to JSON
        String actualJsonString = Main.convertCsvToJson(csvData);

        // Expected error message
        String expectedError = "Error: CSV string is empty or has no data!";

        assertEquals(expectedError, actualJsonString);
    }

    @Test
    public void testCsvWithOnlyHeaders() {
        // CSV with only headers and no data
        String csvData = "name,age,email\n";

        // Convert CSV to JSON
        String actualJsonString = Main.convertCsvToJson(csvData);

        // Expected empty JSON array
        assertEquals("[]", actualJsonString);
    }
}
