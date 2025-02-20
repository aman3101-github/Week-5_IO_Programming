package org.example.handsonproblems.csvtojson;

import org.json.JSONArray;
import org.json.JSONObject;
import java.util.Arrays;
import java.util.List;

public class Main {

    // Convert CSV string to JSON
    public static String convertCsvToJson(String csvString) {
        JSONArray jsonArray = new JSONArray();
        String[] lines = csvString.split("\n");

        if (lines.length < 2) {
            return "Error: CSV string is empty or has no data!";
        }

        // Extract headers
        List<String> headers = Arrays.asList(lines[0].split(","));

        for (int i = 1; i < lines.length; i++) {
            String[] values = lines[i].split(",");
            JSONObject jsonObject = new JSONObject();

            for (int j = 0; j < headers.size(); j++) {
                // Map headers to values
                jsonObject.put(headers.get(j).trim(), values[j].trim());
            }
            jsonArray.put(jsonObject);
        }

        // Pretty-print JSON
        return jsonArray.toString(4);
    }

    public static void main(String[] args) {
        // Sample CSV data as String
        String csvData = "name,age,email\nAman,25,aman@example.com\nJohn,30,john@example.com\nSara,22,sara@example.com";

        // Convert CSV to JSON
        String jsonOutput = convertCsvToJson(csvData);

        // Print JSON output
        System.out.println("Converted JSON:\n" + jsonOutput);
    }
}
