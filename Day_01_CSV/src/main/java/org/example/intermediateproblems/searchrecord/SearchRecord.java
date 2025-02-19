package org.example.intermediateproblems.searchrecord;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class SearchRecord {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter an employee name
        System.out.print("Enter Employee Name to Search: ");
        String searchName = scanner.nextLine().trim();

        // Call the method to search for the employee
        searchEmployee(searchName);
    }

    public static void searchEmployee(String name) {
        String filePath = "src/main/java/org/example/intermediateproblems/searchrecord/employee.csv";


        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            String[] nextLine;

            // Read the header row (if exists)
            if ((nextLine = reader.readNext()) != null) {
                System.out.println("CSV Header: " + String.join(", ", nextLine));
            }

            boolean found = false;

            // Read the file line by line
            while ((nextLine = reader.readNext()) != null) {
                String empName = nextLine[1].trim(); // Employee Name
                if (empName.equalsIgnoreCase(name)) {
                    System.out.println("\nEmployee Found:");
                    System.out.println("Department: " + nextLine[2]);
                    System.out.println("Salary: $" + nextLine[3]);
                    found = true;
                    break; // Stop searching after finding the first match
                }
            }

            if (!found) {
                System.out.println("Employee not found!");
            }

        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }
    }
}
