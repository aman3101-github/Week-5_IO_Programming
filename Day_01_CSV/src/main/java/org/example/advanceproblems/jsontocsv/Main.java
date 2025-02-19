package org.example.advanceproblems.jsontocsv;
import com.opencsv.CSVWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import com.opencsv.CSVReader;

public class Main {

    public static void main(String[] args) {
        // File paths
        String jsonFile = "src/main/java/org/example/advanceproblems/jsontocsv/students.json";
        String csvFile = "src/main/java/org/example/advanceproblems/jsontocsv/students_file.csv";

        // Convert JSON to CSV
        convertJsonToCsv(jsonFile, csvFile);

        // Convert CSV back to JSON
        convertCsvToJson(csvFile);
    }

    // Convert JSON to CSV
    public static void convertJsonToCsv(String jsonFile, String csvFile) {
        try {
            // Read JSON file into List of Students
            ObjectMapper objectMapper = new ObjectMapper();
            List<Student> students = objectMapper.readValue(new FileReader(jsonFile), new TypeReference<List<Student>>(){});

            // Initialize CSVWriter
            CSVWriter writer = new CSVWriter(new FileWriter(csvFile));

            // Write CSV Header
            writer.writeNext(new String[]{"ID", "Name", "Age", "Grade"});

            // Write student data to CSV
            for (Student student : students) {
                String[] studentData = {
                        String.valueOf(student.getId()),
                        student.getName(),
                        String.valueOf(student.getAge()),
                        student.getGrade()
                };
                writer.writeNext(studentData);
            }

            writer.close();
            System.out.println("CSV file generated successfully from JSON.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Convert CSV back to JSON
    public static void convertCsvToJson(String csvFile) {
        try {
            // Initialize CSVReader
            CSVReader reader = new CSVReader(new FileReader(csvFile));

            // Skip header row
            reader.readNext();

            // Read CSV data and convert to JSON
            String[] nextLine;
            List<Student> students = new java.util.ArrayList<>();

            while ((nextLine = reader.readNext()) != null) {
                Student student = new Student(
                        Integer.parseInt(nextLine[0]),
                        nextLine[1],
                        Integer.parseInt(nextLine[2]),
                        nextLine[3]
                );
                students.add(student);
            }

            // Convert List of Students to JSON
            ObjectMapper objectMapper = new ObjectMapper();
            String json = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(students);

            // Print JSON data
            System.out.println("Converted JSON:");
            System.out.println(json);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

// Student class to represent student data
class Student {
    private int id;
    private String name;
    private int age;
    private String grade;

    public Student() {}

    public Student(int id, String name, int age, String grade) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}
