package org.example.practiceproblems.javaobjecttoJSONarray;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.List;

public class Car {
    // Encapsulated attributes of the Car class
    private String model;
    private String color;
    private int year;

    // Constructor of the class
    public Car(String model, String color, int year){
        this.model = model;
        this.color = color;
        this.year = year;
    }
    // Getter methods
    public String getModel(){
        return model;
    }
    public String getColor(){
        return color;
    }
    public int getYear(){
        return year;
    }

    // Method to convert the Java Array list to JSON Array
    public static JSONArray listToJsonArray(List<Car> carList){
        // Creating the JSON Array
        JSONArray carDetails = new JSONArray();

        // Iterating over all the Java car objects in the list
        for(Car car : carList){
            // JSON object to store car objects from list into JSON objects for compatible DT
            JSONObject carJson = new JSONObject();
            carJson.put("model", car.getModel());
            carJson.put("color", car.getColor());
            carJson.put("year", car.getYear());

            // Adding JSON car Object to the JSON Array
            carDetails.put(carJson);
        }

        // Return the JSON Array for the Java list
        return carDetails;

    }

}