package org.example.writecsvfile;
import com.opencsv.CSVWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void writeCSVFile(){
        // Method to write the CSV file
        try(CSVWriter writer = new CSVWriter(new FileWriter("employee.csv"))){

            String [] header = {"ID", "Name", "Department", "Salary"};
            String[] emp1 = {"100", "Aman", "Finance", "62000"};
            String[] emp2 = {"102", "Adarsh", "Sales", "58000"};
            String[] emp3 = {"103", "Sahil", "HR", "61000"};
            String[] emp4 = {"104", "Ankush", "DevOps", "55000"};
            String[] emp5 = {"105", "Rahul", "TeamH Lead", "50000"};

            writer.writeNext(header);
            writer.writeNext(emp1);
            writer.writeNext(emp2);
            writer.writeNext(emp3);
            writer.writeNext(emp4);
            writer.writeNext(emp5);

            System.out.println("employee.csv, successfully written.");
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        writeCSVFile();
    }
}
