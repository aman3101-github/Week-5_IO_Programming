package org.example.advanceproblems.mergecsvfiles;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        // Specify the file paths for the two CSV files
        String students1File = "src/main/java/org/example/advanceproblems/mergecsvfiles/students1.csv";
        String students2File = "src/main/java/org/example/advanceproblems/mergecsvfiles/students2.csv";
        String outputFile = "src/main/java/org/example/advanceproblems/mergecsvfiles/merged_students.csv";

        // Merge the CSV files and write to the output file
        mergeCSVFiles(students1File, students2File, outputFile);
    }

    public static void mergeCSVFiles(String students1File, String students2File, String outputFile) {
        // Maps to store student data based on ID
        Map<Integer, String[]> students1Map = new HashMap<>();
        Map<Integer, String[]> students2Map = new HashMap<>();

        try (CSVReader reader1 = new CSVReader(new FileReader(students1File));
             CSVReader reader2 = new CSVReader(new FileReader(students2File))) {

            // Read the first CSV file (students1.csv)
            String[] nextLine;
            reader1.readNext(); // Skip the header
            while ((nextLine = reader1.readNext()) != null) {
                int id = Integer.parseInt(nextLine[0]);
                students1Map.put(id, nextLine); // Store the student data by ID
            }

            // Print the content of students1Map to check
            System.out.println("students1Map: " + students1Map);

            // Read the second CSV file (students2.csv)
            reader2.readNext(); // Skip the header
            while ((nextLine = reader2.readNext()) != null) {
                int id = Integer.parseInt(nextLine[0]);
                students2Map.put(id, nextLine); // Store the student data by ID
            }

            // Print the content of students2Map to check
            System.out.println("students2Map: " + students2Map);

            // Create a CSVWriter to write the merged data
            try (CSVWriter writer = new CSVWriter(new FileWriter(outputFile))) {
                // Write header to the output file
                writer.writeNext(new String[]{"ID", "Name", "Age", "Marks", "Grade"});

                // Merge data from both maps and write to the new CSV file
                for (Map.Entry<Integer, String[]> entry : students1Map.entrySet()) {
                    int id = entry.getKey();
                    String[] student1Data = entry.getValue();
                    String[] student2Data = students2Map.get(id);

                    if (student2Data != null) {
                        // Combine the data from both files and write it to the output file
                        String[] mergedData = new String[]{
                                student1Data[0], // ID
                                student1Data[1], // Name
                                student1Data[2], // Age
                                student2Data[1], // Marks
                                student2Data[2]  // Grade
                        };
                        writer.writeNext(mergedData);
                    }
                }

            }
        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }
    }
}
