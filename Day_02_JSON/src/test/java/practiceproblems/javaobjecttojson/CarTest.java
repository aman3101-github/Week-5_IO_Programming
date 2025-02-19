package practiceproblems.javaobjecttojson;
import org.example.practiceproblems.javaobjecttojson.Car;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CarTest {

    @Test
    void testCarJSONObject(){
        // Create a car java object
        Car car = new Car("XUV", "grey", 2023);

        // Convert the java car object to the JSON object
        JSONObject carJSON = car.carJSONObject();

        // Assert (verify) the JSON structure
        assertEquals("XUV", carJSON.getString("model"));
        assertEquals("grey", carJSON.getString("color"));
        assertEquals(2023, carJSON.getInt("builtYear"));
    }
}
