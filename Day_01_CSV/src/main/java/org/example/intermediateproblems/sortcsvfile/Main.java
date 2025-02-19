package org.example.intermediateproblems.sortcsvfile;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {

    // Method to sort records by salary and print the top 5 highest-paid employees
    public static void sortBySalary(String inputFile) {
        List<Employee> employeeList = new ArrayList<>();

        try (CSVReader reader = new CSVReader(new FileReader(inputFile))) {
            String[] nextLine;
            // Skip header row if present
            if ((nextLine = reader.readNext()) != null) {
                // Read employee records
                while ((nextLine = reader.readNext()) != null) {
                    int id = Integer.parseInt(nextLine[0]);
                    String name = nextLine[1];
                    String department = nextLine[2];
                    double salary = Double.parseDouble(nextLine[3]);
                    employeeList.add(new Employee(id, name, department, salary));
                }
            }

            // Sort by salary in descending order
            employeeList.sort(Comparator.comparingDouble(Employee::getSalary).reversed());

            // Print top 5 highest-paid employees
            System.out.println("Top 5 Highest-Paid Employees:");
            for (int i = 0; i < Math.min(5, employeeList.size()); i++) {
                Employee emp = employeeList.get(i);
                System.out.println(emp.getName() + " | Salary: " + emp.getSalary());
            }

        }
        catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String inputFile = "src/main/java/org/example/intermediateproblems/sortcsvfile/employee.csv";
        sortBySalary(inputFile);
    }
}

