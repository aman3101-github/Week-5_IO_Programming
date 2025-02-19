package org.example.intermediateproblems.filterrecords;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Specifying the file path
        String filePath = "src/main/java/org/example/intermediateproblems/filterrecords/students.csv";
        List<Student> studentList = readAndFilterStudents(filePath, 80.0);

        System.out.println("\nStudents with marks greater than 80:");
        for (Student student : studentList) {
            student.displayDetails();
        }
    }

    public static List<Student> readAndFilterStudents(String filePath, double minMarks) {
        List<Student> filteredStudents = new ArrayList<>();

        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            String[] nextLine;

            // Read the header row (if exists)
            if ((nextLine = reader.readNext()) != null) {
                System.out.println("Header: " + String.join(", ", nextLine));
            }

            // Read student records
            while ((nextLine = reader.readNext()) != null) {
                int id = Integer.parseInt(nextLine[0]);
                String name = nextLine[1];
                int age = Integer.parseInt(nextLine[2]);
                double marks = Double.parseDouble(nextLine[3]);

                // Filter students with marks > minMarks
                if (marks > minMarks) {
                    filteredStudents.add(new Student(id, name, age, marks));
                }
            }
        } catch (IOException | CsvValidationException e) {
            e.printStackTrace(); // Print error details
        }

        return filteredStudents;
    }
}

