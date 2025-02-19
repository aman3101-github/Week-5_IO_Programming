package org.example.practiceproblems.JSONValidator;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;

public class JsonValidator {
    public static boolean isValidJson(String filePath) {
        try {
            // Create ObjectMapper instance
            ObjectMapper objectMapper = new ObjectMapper();

            // Read the JSON file
            JsonNode jsonNode = objectMapper.readTree(new File(filePath));

            // If it reaches here, the JSON is valid
            return true;
        }
        catch (IOException e) {
            // JSON is invalid or file reading failed
            System.out.println("Invalid JSON: " + e.getMessage());
            return false;
        }
    }
}
