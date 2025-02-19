package org.example.practiceproblems.extractJSONfields;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        // Declare the filepath
        String filePath = "src/main/java/org/example/practiceproblems/extractJSONfields/data.json";

        // Creating the instance of the JsonReader Class
        JsonReader jsonReader = new JsonReader();
        jsonReader.extractFields(filePath);
    }
}