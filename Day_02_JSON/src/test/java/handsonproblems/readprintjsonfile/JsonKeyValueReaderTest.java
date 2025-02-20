package handsonproblems.readprintjsonfile;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class JsonKeyValueReaderTest {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void testJsonFileParsing() throws IOException {
        // Read JSON from file
        List<Map<String, Object>> jsonData = objectMapper.readValue(new File("data.json"), new TypeReference<List<Map<String, Object>>>() {});

        // Assertions
        assertNotNull(jsonData);
        // Ensure JSON is not empty
        assertFalse(jsonData.isEmpty());
        // There are 5 records in the JSON file
        assertEquals(5, jsonData.size());

        // Checking first record
        Map<String, Object> firstRecord = jsonData.get(0);
        assertEquals("John", firstRecord.get("name"));
        assertEquals(30, firstRecord.get("age"));
        assertEquals("New York", firstRecord.get("city"));

        // Checking last record
        Map<String, Object> lastRecord = jsonData.get(4);
        assertEquals("Michael", lastRecord.get("name"));
        assertEquals(35, lastRecord.get("age"));
        assertEquals("Houston", lastRecord.get("city"));
        assertEquals("Male", lastRecord.get("gender"));
    }
}

