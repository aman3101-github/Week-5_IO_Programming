package org.example.advanceproblems.readlargecsv;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // Specify the path to the large CSV file
        String csvFile = "src/main/java/org/example/advanceproblems/largecsvfiles/large_file.csv";

        // Process the large CSV file in chunks of 100 lines
        processCSVFileInChunks(csvFile, 100);
    }

    public static void processCSVFileInChunks(String csvFile, int chunkSize) {
        int recordCount = 0;

        try (CSVReader reader = new CSVReader(new FileReader(csvFile))) {
            // Skip header if present
            reader.readNext();

            String[] nextLine;
            int linesProcessed = 0;

            while ((nextLine = reader.readNext()) != null) {
                linesProcessed++;

                if (linesProcessed == chunkSize) {
                    // After processing 100 lines, print the count and reset
                    recordCount += chunkSize;
                    System.out.println("Processed " + recordCount + " records so far...");
                    linesProcessed = 0;
                }
            }

            // Process any remaining lines if they're fewer than the chunk size
            if (linesProcessed > 0) {
                recordCount += linesProcessed;
                System.out.println("Processed " + recordCount + " records in total.");
            }

        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }
    }
}
