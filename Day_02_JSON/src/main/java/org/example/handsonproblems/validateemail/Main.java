package org.example.handsonproblems.validateemail;

import org.everit.json.schema.Schema;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;
import org.json.JSONException;
import org.everit.json.schema.ValidationException;

public class Main {

    // Define JSON Schema for email validation
    private static final String EMAIL_SCHEMA_JSON = "{"
            + "  \"$schema\": \"https://json-schema.org/draft/2020-12/schema\","
            + "  \"type\": \"object\","
            + "  \"properties\": {"
            + "    \"email\": {"
            + "      \"type\": \"string\","
            + "      \"format\": \"email\""
            + "    }"
            + "  },"
            + "  \"required\": [\"email\"]"
            + "}";

    // Method to validate email JSON
    public static void validateEmail(String emailJson) {
        try {
            JSONObject schemaJson = new JSONObject(EMAIL_SCHEMA_JSON);
            Schema schema = SchemaLoader.load(schemaJson);

            JSONObject emailObject = new JSONObject(emailJson);
            schema.validate(emailObject); // Validate email JSON

            System.out.println("Valid email format!");
        } catch (ValidationException e) {
            System.out.println(" Invalid email format: " + e.getMessage());
        } catch (JSONException e) {
            System.out.println(" Invalid JSON structure: " + e.getMessage());
        }
    }

    //  Test the email validation
    public static void main(String[] args) {
        // Valid email test case
        String validEmail = "{ \"email\": \"aman@example.com\" }";
        System.out.println("Testing valid email:");
        validateEmail(validEmail);

        // Invalid email test case
        String invalidEmail = "{ \"email\": \"invalid-email\" }";
        System.out.println("\nTesting invalid email:");
        validateEmail(invalidEmail);
    }
}
