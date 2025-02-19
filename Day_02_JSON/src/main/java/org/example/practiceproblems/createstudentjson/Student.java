package org.example.practiceproblems.createstudentjson;
import org.json.JSONObject;
import org.json.JSONArray;

public class Student {
    // Method to create the JSON object
    public static JSONObject studentJSON(){
        // Create the JSON object
        JSONObject student = new JSONObject();

        // Adding fields to the JSON
        student.put("Name", "Aman");
        student.put("Age", 23);

        // Creating the JSON array to store subjects
        JSONArray subjects = new JSONArray();
        subjects.put("Maths");
        subjects.put("Physics");
        subjects.put("Chemistry");

        // Adding subjects array to the Student JSON object
        student.put("Subjects", subjects);

        // return the student JSON object
        return student;
    }
}
