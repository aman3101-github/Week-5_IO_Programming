package org.example.intermediateproblems.updatecsv;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;

import java.io.*;
        import java.util.ArrayList;
import java.util.List;

public class ModifyCSVFile {
    public static void main(String[] args) {
        String inputFile = "src/main/java/org/example/intermediateproblems/updatecsv/employee.csv";
        String outputFile = "updated_employees.csv";
        updateSalaries(inputFile, outputFile);
    }

    public static void updateSalaries(String inputFile, String outputFile) {
        List<String[]> data = new ArrayList<>();

        try (CSVReader reader = new CSVReader(new FileReader(inputFile))) {
            String[] header = reader.readNext(); // Read header
            if (header != null) {
                data.add(header);
            }

            String[] row;
            while ((row = reader.readNext()) != null) {
                if (row[2].equalsIgnoreCase("IT")) { // Check if department is IT
                    double salary = Double.parseDouble(row[3]); // Convert salary to double
                    salary *= 1.10; // Increase by 10%
                    row[3] = String.format("%.2f", salary); // Format and update salary
                }
                data.add(row);
            }
        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }

        // Write updated data to new CSV file
        try (CSVWriter writer = new CSVWriter(new FileWriter(outputFile))) {
            writer.writeAll(data);
            System.out.println("Updated file saved as: " + outputFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
