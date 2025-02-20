package org.example.practiceproblems.javaobjecttoJSONarray;
import org.json.JSONArray   ;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // Creating the Array List to store car Java object
        List<Car> carList = new ArrayList<>();

        // Creating the Java object of the Car class
        Car car1 = new Car("Tesla", "Red", 2025);
        Car car2 = new Car("Sumo", "White", 2023);
        Car car3 = new Car("XUV", "Blue", 2024);

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