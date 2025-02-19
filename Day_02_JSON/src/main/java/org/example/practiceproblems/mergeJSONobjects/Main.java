package org.example.practiceproblems.mergeJSONobjects;
import org.json.JSONObject;

public class Main {
    public static void main(String[] args) {
        // Creating the first JSON object
        JSONObject firstJSON = new JSONObject();
        firstJSON.put("Name", "Aman");
        firstJSON.put("Email", "aman.example@gmail.com");

        // Creating the second JSON object
        JSONObject secondJSON = new JSONObject();
        secondJSON.put("City", "Bhopal");
        secondJSON.put("Zip", 462022);

        // Merging both the objects
        for (String key : secondJSON.keySet()){
            firstJSON.put(key, secondJSON.get(key));
        }

        // Printing the merged objects
        System.out.println(firstJSON.toString(4));
    }
}
