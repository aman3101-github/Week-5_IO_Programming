package org.example.practiceproblems.javaobjecttojson;
import org.json.JSONObject;

public class Car {

    // Attributes of the Car class
    private String model;
    private String color;
    private int builtYear;

    // Constructor of the class
    public Car(String model, String color, int builtYear){
        this.model = model;
        this.color = color;
        this.builtYear = builtYear;
    }

    // Method to convert the Java Object Car to JSON object
        public JSONObject carJSONObject(){

        // Creating the JSON object for the car java object
            JSONObject carJSON = new JSONObject();

            // Converting the Java object to the JSON object
            carJSON.put("model", model);
            carJSON.put("color", color);
            carJSON.put("builtYear", builtYear);

            // return the converted JSON object
            return carJSON;
        }
}
