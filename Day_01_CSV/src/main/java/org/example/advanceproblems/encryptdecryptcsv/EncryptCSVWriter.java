package org.example.advanceproblems.encryptdecryptcsv;

import com.opencsv.CSVWriter;
import java.io.FileWriter;
import java.io.IOException;

public class EncryptCSVWriter {
    public static void main(String[] args) {
        String csvFile = "employees_encrypted.csv";

        try (CSVWriter writer = new CSVWriter(new FileWriter(csvFile))) {
            // Writing header
            String[] header = {"Employee ID", "Name", "Department", "Salary", "Email"};
            writer.writeNext(header);

            // Encrypt Salary and Email fields before writing
            String[] employee1 = {"101", "Alice Johnson", "HR", AESUtil.encrypt("75000"), AESUtil.encrypt("alice@example.com")};
            String[] employee2 = {"102", "Bob Smith", "IT", AESUtil.encrypt("90000"), AESUtil.encrypt("bob@example.com")};

            writer.writeNext(employee1);
            writer.writeNext(employee2);

            System.out.println("Encrypted data successfully written to CSV file.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
