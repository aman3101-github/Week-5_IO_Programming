package org.example.basicproblems.countrows;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        // Call the method
        readCSV();
    }

    // Method to read the CSV file and count rows
    public static void readCSV() {

        // Specify the CSV file path
        String filePath = "src/main/java/org/example/countrows/employee.csv";
        // Counter for rows
        int rowCount = 0;

        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            String[] nextLine;

            // Read the header row first (if exists)
            if ((nextLine = reader.readNext()) != null) {
                System.out.println("Header: " + String.join(", ", nextLine));
            }

            // Read and count each row
            while ((nextLine = reader.readNext()) != null) {
                rowCount++;
                System.out.println("ID: " + nextLine[0] + ", Name: " + nextLine[1]);
            }

            // Display total row count
            System.out.println("\nTotal Rows (excluding header): " + rowCount);

        }

        catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }
    }
}
