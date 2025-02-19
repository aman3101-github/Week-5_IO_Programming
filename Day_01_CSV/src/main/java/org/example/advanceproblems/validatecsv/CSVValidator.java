package org.example.advanceproblems.validatecsv;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CSVValidator {

    // Regular expression for validating email format
    private static final String EMAIL_REGEX = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

    // Method to validate each row of the CSV file
    public static void validateCSV(String inputFile) {
        try (CSVReader reader = new CSVReader(new FileReader(inputFile))) {
            String[] nextLine;

            // Skip header (if exists)
            if ((nextLine = reader.readNext()) != null) {
                System.out.println("Header: " + String.join(", ", nextLine));
            }

            // Read each row and validate
            while ((nextLine = reader.readNext()) != null) {
                String name = nextLine[0];
                String email = nextLine[1];
                String phone = nextLine[2];

                // Validate email format
                if (!isValidEmail(email)) {
                    System.out.println("Invalid email format: " + email + " for " + name);
                }

                // Validate phone number (must be 10 digits)
                if (!isValidPhoneNumber(phone)) {
                    System.out.println("Invalid phone number: " + phone + " for " + name);
                }
            }
        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }
    }

    // Helper method to validate email format
    private static boolean isValidEmail(String email) {
        Pattern pattern = Pattern.compile(EMAIL_REGEX);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    // Helper method to validate phone number length
    private static boolean isValidPhoneNumber(String phone) {
        return phone != null && phone.length() == 10 && phone.matches("\\d+");
    }
}
