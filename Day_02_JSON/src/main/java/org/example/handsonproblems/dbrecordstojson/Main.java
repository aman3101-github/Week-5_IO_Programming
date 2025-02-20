package org.example.handsonproblems.dbrecordstojson;

import org.json.JSONArray;
import org.json.JSONObject;
import java.sql.*;

public class Main {

    // Method to fetch records and convert to JSON
    public static String generateJsonReport() {
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String user = "root";  // Change username
        String password = "password";  // Change password

        JSONArray jsonArray = new JSONArray();

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT id, name, age, email FROM users")) {

            while (rs.next()) {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("id", rs.getInt("id"));
                jsonObject.put("name", rs.getString("name"));
                jsonObject.put("age", rs.getInt("age"));
                jsonObject.put("email", rs.getString("email"));

                jsonArray.put(jsonObject);
            }

        } catch (SQLException e) {
            return "Database error: " + e.getMessage();
        }

        return jsonArray.toString(4); // Pretty-print JSON
    }

    public static void main(String[] args) {
        // Generate JSON report
        String jsonReport = generateJsonReport();

        // Print JSON report
        System.out.println("Generated JSON Report:\n" + jsonReport);
    }
}
