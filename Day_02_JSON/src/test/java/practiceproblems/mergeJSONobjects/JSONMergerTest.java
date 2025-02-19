package practiceproblems.mergeJSONobjects;

import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class JsonMergerTest {

    @Test
    void testJsonMerge() {
        // Creating the first JSON object
        JSONObject firstJSON = new JSONObject();
        firstJSON.put("Name", "Aman");
        firstJSON.put("Email", "aman.example@gmail.com");

        // Creating the second JSON object
        JSONObject secondJSON = new JSONObject();
        secondJSON.put("City", "Bhopal");
        secondJSON.put("Zip", 462022);

        // Merging both objects
        for (String key : secondJSON.keySet()) {
            firstJSON.put(key, secondJSON.get(key));
        }

        // Expected JSON after merging
        JSONObject expectedJSON = new JSONObject();
        expectedJSON.put("Name", "Aman");
        expectedJSON.put("Email", "aman.example@gmail.com");
        expectedJSON.put("City", "Bhopal");
        expectedJSON.put("Zip", 462022);

        // Assert that the merged JSON matches the expected JSON
        assertEquals(expectedJSON.toString(), firstJSON.toString());
    }
}
