package practiceproblems.javaobjecttoJSONarray;
import org.example.practiceproblems.javaobjecttoJSONarray.Car;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
public class carListTojsonarrayTest {


    @Test
    void testListToJsonArray() {
        // Creating a list of Car objects
        List<Car> carList = new ArrayList<>();
        carList.add(new Car("Tesla", "Red", 2025));
        carList.add(new Car("Sumo", "White", 2023));
        carList.add(new Car("XUV", "Blue", 2024));

        // Calling the method to convert List<Car> to JSONArray
        JSONArray jsonArray = Car.listToJsonArray(carList);

        // Checking if JSON array size matches car list size
        assertEquals(carList.size(), jsonArray.length(), "JSONArray size mismatch!");

        // Checking the contents of the first object
        JSONObject firstCar = jsonArray.getJSONObject(0);
        assertEquals("Tesla", firstCar.getString("model"), "Model mismatch!");
        assertEquals("Red", firstCar.getString("color"), "Color mismatch!");
        assertEquals(2025, firstCar.getInt("year"), "Year mismatch!");
    }
}
