package org.example.advanceproblems.detectduplicatescsv;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        // Specify the file path for the CSV file
        String csvFile = "src/main/java/org/example/advanceproblems/detectduplicatescsv/file.csv";

        // Detect and print duplicate entries based on the ID column
        detectDuplicates(csvFile);
    }

    public static void detectDuplicates(String csvFile) {
        Set<String> seenIds = new HashSet<>();
        try (CSVReader reader = new CSVReader(new FileReader(csvFile))) {
            String[] nextLine;

            // Read the CSV file and skip the header
            reader.readNext(); // Skip header row

            while ((nextLine = reader.readNext()) != null) {
                String id = nextLine[0]; // Assuming ID is in the first column

                // Check if the ID has already been seen
                if (seenIds.contains(id)) {
                    // If duplicate, print the record
                    System.out.println("Duplicate found: " + String.join(",", nextLine));
                } else {
                    // Otherwise, add the ID to the seen set
                    seenIds.add(id);
                }
            }
        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }
    }
}
