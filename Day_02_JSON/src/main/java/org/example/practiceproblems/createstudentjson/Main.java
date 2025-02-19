package org.example.practiceproblems.createstudentjson;
import org.json.JSONObject;
import org.json.JSONArray;

public class Main {
    public static void main(String[] args) {
        // Method call to create Student JSON object
        JSONObject studentJSON = Student.studentJSON();
        System.out.println(studentJSON.toString(4));

    }
}
