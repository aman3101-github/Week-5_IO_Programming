package handsonproblems.mergejsonfiles;

import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

public class JsonMergerTest {

    @Test
    void testJsonMerging() throws Exception {
        // Sample JSON data
        String json1 = "{ \"name\": \"Aman\", \"age\": 25 }";
        String json2 = "{ \"email\": \"aman@example.com\", \"phone\": \"99999999\" }";

        // Convert Strings to JSON Objects
        JSONObject jsonObject1 = new JSONObject(json1);
        JSONObject jsonObject2 = new JSONObject(json2);

        // Merge JSON Objects
        JSONObject mergedJson = new JSONObject(jsonObject1, JSONObject.getNames(jsonObject1));
        for (String key : JSONObject.getNames(jsonObject2)) {
            mergedJson.put(key, jsonObject2.get(key));
        }

        // Expected JSON
        JSONObject expectedJson = new JSONObject();
        expectedJson.put("name", "Aman");
        expectedJson.put("age", 25);
        expectedJson.put("email", "aman@example.com");
        expectedJson.put("phone", "99999999");

        // Verify merged JSON matches expected JSON
        assertEquals(expectedJson.toString(), mergedJson.toString());
    }
}

