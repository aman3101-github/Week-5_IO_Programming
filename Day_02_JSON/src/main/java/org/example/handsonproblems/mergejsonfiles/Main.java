package org.example.handsonproblems.mergejsonfiles;
import org.json.JSONObject;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        String filePath1 = "src/main/java/org/example/handsonproblems/mergejsonfiles/file1.json";
        String filePath2 = "src/main/java/org/example/handsonproblems/mergejsonfiles/file2.json";

        try {
            // Read JSON files as Strings
            String jsonContent1 = new String(Files.readAllBytes(Paths.get(filePath1)));
            String jsonContent2 = new String(Files.readAllBytes(Paths.get(filePath2)));

            // Convert Strings to JSONObject
            JSONObject jsonObject1 = new JSONObject(jsonContent1);
            JSONObject jsonObject2 = new JSONObject(jsonContent2);

            // Merge both JSON Objects
            JSONObject mergedJson = new JSONObject(jsonObject1, JSONObject.getNames(jsonObject1));
            for (String key : JSONObject.getNames(jsonObject2)) {
                mergedJson.put(key, jsonObject2.get(key));
            }

            // Print merged JSON object
            System.out.println("Merged JSON: " + mergedJson.toString(4));

        } catch (IOException e) {
            System.out.println("Error reading JSON files: " + e.getMessage());
        }
    }
}

