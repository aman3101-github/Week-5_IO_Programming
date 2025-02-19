package org.example.advanceproblems.encryptdecryptcsv;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;

public class DecryptCSVReader {
    public static void main(String[] args) {
        String csvFile = "employees_encrypted.csv";

        try (CSVReader reader = new CSVReader(new FileReader(csvFile))) {
            String[] nextLine;

            // Read the header row
            reader.readNext();

            // Read and decrypt records
            while ((nextLine = reader.readNext()) != null) {
                String employeeID = nextLine[0];
                String name = nextLine[1];
                String department = nextLine[2];
                String salary = AESUtil.decrypt(nextLine[3]);
                String email = AESUtil.decrypt(nextLine[4]);

                System.out.println("Employee ID: " + employeeID + ", Name: " + name + ", Department: " + department
                        + ", Salary: " + salary + ", Email: " + email);
            }
        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }
    }
}
