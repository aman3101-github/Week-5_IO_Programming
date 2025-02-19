package org.example.practiceproblems.javaobjecttojson;

import org.json.JSONObject;

public class Main {
    public static void main(String[] args) {
        // Creating the object of the Car class
        Car car = new Car("XUV", "Grey", 2025);

        // Method call to convert java object to JSON object
        JSONObject carJSON = car.carJSONObject();

        System.out.println(carJSON.toString(4));
    }
}
