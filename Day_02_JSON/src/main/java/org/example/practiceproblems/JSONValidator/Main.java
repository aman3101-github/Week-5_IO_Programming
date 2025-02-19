package org.example.practiceproblems.JSONValidator;

public class Main {
    public static void main(String[] args) {
        // Define the file path for the JSON file
        String filePath = "src/main/java/org/example/practiceproblems/JSONValidator/file.json";

        // Validate the JSON file
        boolean isValid = JsonValidator.isValidJson(filePath);

        // Print the validation result
        if (isValid) {
            System.out.println("The JSON file is valid.");
        } else {
            System.out.println("The JSON file is invalid.");
        }
    }
}
