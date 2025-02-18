package org.example.readcsvfile;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        readCSV(); // Call the method
    }

    // Method to read the CSV file
    public static void readCSV() {
        String filePath = "src/main/java/org/example/readcsvfile/student.csv";

        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            String[] nextLine;
            while ((nextLine = reader.readNext()) != null) {
                System.out.println("ID: " + nextLine[0] + ", Name: " + nextLine[1] + ", Age: " + nextLine[2] + ", Marks: " + nextLine[3]);
            }
        } catch (IOException | CsvValidationException e) {
            throw new RuntimeException(e);
        }
    }
}
