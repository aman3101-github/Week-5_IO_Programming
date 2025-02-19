package practiceproblems.extractJSONfields;

import org.example.practiceproblems.extractJSONfields.JsonReader;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import java.io.FileWriter;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class JsonReaderTest {

    // Temporary test file path
    private static final String TEST_FILE_PATH = "src/test/resources/test_data.json";

    // Method to create a test JSON file dynamically
    private void createTestJsonFile() throws IOException {
        JSONObject testJson = new JSONObject();
        testJson.put("name", "Aman");
        testJson.put("email", "aman.example@gmail.com");

        try (FileWriter file = new FileWriter(TEST_FILE_PATH)) {
            file.write(testJson.toString());
        }
    }

    @Test
    void testExtractFields() throws IOException {
        // Arrange: Create test JSON file
        createTestJsonFile();

        // Act: Run the method
        JsonReader jsonReader = new JsonReader();
        jsonReader.extractFields(TEST_FILE_PATH);

    }
}
