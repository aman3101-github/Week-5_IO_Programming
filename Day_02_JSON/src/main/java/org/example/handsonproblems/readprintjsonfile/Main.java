package org.example.handsonproblems.readprintjsonfile;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        // Creating the new object mapper object
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            // Read JSON from file into List of Maps
            List<Map<String, Object>> jsonData = objectMapper.readValue(new File("src/main/java/org/example/handsonproblems/readprintjsonfile/sample.json"), new TypeReference<List<Map<String, Object>>>() {});

            // Iterate over each JSON object
            for (int i = 0; i < jsonData.size(); i++) {
                System.out.println("Record " + (i + 1) + ":");

                // Step 3: Iterate over each key-value pair in the object
                for (Map.Entry<String, Object> entry : jsonData.get(i).entrySet()) {
                    System.out.println("  " + entry.getKey() + ": " + entry.getValue());
                }
                System.out.println();
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
