package org.example.practiceproblems.extractJSONfields;

import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class JsonReader {
    // Method to extract the fields
    public void extractFields(String filePath){

        try{
            // Read the JSON file content and save as a string
            String jsonData = readFile(filePath);

            // Convert the JSON string as a JSON object
            JSONObject jsonObject = new JSONObject(jsonData);

            // Extract the specific fields
            String name = jsonObject.getString("name");
            String email = jsonObject.getString("email");

            System.out.println("Name: " + name);
            System.out.println("Email: " + email);
        }
        catch (IOException e){
            System.out.println("Error reading: " + e.getMessage());
        }
    }

        // Method to read the file and the return the content as a string
        private String readFile(String filePath) throws IOException {
            StringBuilder content = new StringBuilder();
            try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    content.append(line);
                }
            }
            return content.toString();
        }
    }

