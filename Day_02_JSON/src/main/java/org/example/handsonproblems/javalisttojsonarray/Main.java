package org.example.handsonproblems.javalisttojsonarray;

import org.example.practiceproblems.javaobjecttoJSONarray.Car;
import org.json.JSONArray;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // Creating the Array List to store car Java object
        List<org.example.practiceproblems.javaobjecttoJSONarray.Car> carList = new ArrayList<>();

        // Creating the Java object of the Car class
        org.example.practiceproblems.javaobjecttoJSONarray.Car car1 = new org.example.practiceproblems.javaobjecttoJSONarray.Car("Tesla", "Red", 2025);
        org.example.practiceproblems.javaobjecttoJSONarray.Car car2 = new org.example.practiceproblems.javaobjecttoJSONarray.Car("Sumo", "White", 2023);
        org.example.practiceproblems.javaobjecttoJSONarray.Car car3 = new org.example.practiceproblems.javaobjecttoJSONarray.Car("XUV", "Blue", 2024);

        // Adding the Java Object to the list
        carList.add(car1);
        carList.add(car2);
        carList.add(car3);

        // Method call to convert the Array List to JSON Array
        JSONArray jsonArray = Car.listToJsonArray(carList);

        // Printing the JSON Array
        System.out.println(jsonArray.toString(4));
    }
}