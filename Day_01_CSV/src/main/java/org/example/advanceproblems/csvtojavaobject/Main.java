package org.example.advanceproblems.csvtojavaobject;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // specify the path to your CSV file
        String csvFile = "src/main/java/org/example/advanceproblems/csvtojavaobject/students.csv";

        List<Student> students = readCSV(csvFile);

        // Print all students
        for (Student student : students) {
            System.out.println(student);
        }
    }

    public static List<Student> readCSV(String filePath) {
        List<Student> studentList = new ArrayList<>();

        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            String[] nextLine;
            // Skip header (if exists)
            if ((nextLine = reader.readNext()) != null) {
                System.out.println("Header: " + String.join(", ", nextLine));
            }

            // Read each row, create a Student object and add it to the list
            while ((nextLine = reader.readNext()) != null) {
                int id = Integer.parseInt(nextLine[0]);  // Convert the first column to an integer (ID)
                String name = nextLine[1];               // Name is in the second column
                int age = Integer.parseInt(nextLine[2]); // Age is in the third column
                double marks = Double.parseDouble(nextLine[3]); // Marks is in the fourth column

                // Create Student object and add it to the list
                Student student = new Student(id, name, age, marks);
                studentList.add(student);
            }

        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }

        return studentList;
    }
}
