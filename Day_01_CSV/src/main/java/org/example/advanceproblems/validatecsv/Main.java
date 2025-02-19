package org.example.advanceproblems.validatecsv;

public class Main {

    public static void main(String[] args) {
        // Specify the path to the CSV file
        String inputFile = "src/main/java/org/example/advanceproblems/validatecsv/phonenumber.csv";

        // Call the method to validate the CSV file
        CSVValidator.validateCSV(inputFile);
    }
}
