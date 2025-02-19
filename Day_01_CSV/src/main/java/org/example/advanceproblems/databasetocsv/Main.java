package org.example.advanceproblems.databasetocsv;
import com.opencsv.CSVWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Main {

    public static void main(String[] args) {
        // Database connection details
        // Update with your DB connection string
        String url = "jdbc:postgresql://localhost:5432/mydb";
        // Replace with your DB username
        String user = "username";
        // Replace with your DB password
        String password = "password";

        // CSV file path
        String csvFile = "employee_report.csv";

        // Fetch employee records and generate CSV report
        fetchAndGenerateCSV(url, user, password, csvFile);
    }

    public static void fetchAndGenerateCSV(String dbUrl, String dbUser, String dbPassword, String csvFile) {
        String query = "SELECT employee_id, name, department, salary FROM employees"; // Adjust query as needed

        try (Connection connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery();
             CSVWriter writer = new CSVWriter(new FileWriter(csvFile))) {

            // Write CSV header
            writer.writeNext(new String[]{"Employee ID", "Name", "Department", "Salary"});

            // Write employee records to CSV
            while (resultSet.next()) {
                String[] employeeData = {
                        String.valueOf(resultSet.getInt("employee_id")),
                        resultSet.getString("name"),
                        resultSet.getString("department"),
                        String.valueOf(resultSet.getDouble("salary"))
                };
                writer.writeNext(employeeData);
            }

            System.out.println("CSV report generated successfully.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
