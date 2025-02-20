package practiceproblems.filterjsonobjects;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.practiceproblems.filterjsonobjects.Person;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import static org.junit.jupiter.api.Assertions.*;

class JsonFilterTest {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void testJsonParsing() throws IOException {
        // Sample JSON Input
        String json = "[{\"name\": \"Aman\", \"age\": 30}, {\"name\": \"Adarsh\", \"age\": 22}, {\"name\": \"Bhagwan\", \"age\": 28}]";

        // Convert JSON to List of Person objects
        List<Person> people = objectMapper.readValue(json, new TypeReference<List<Person>>() {});

        // Assertions
        assertNotNull(people);
        assertEquals(3, people.size());  // JSON contains 3 records
        assertEquals("Aman", people.get(0).name); // First person's name should be John
        assertEquals(30, people.get(0).age); // First person's age should be 30
    }

    @Test
    void testFilteringLogic() throws IOException {
        // Sample JSON Input
        String json = "[{\"name\": \"Aman\", \"age\": 30}, {\"name\": \"Adarsh\", \"age\": 22}, {\"name\": \"Bhagwan\", \"age\": 28}]";

        // Convert JSON to List of Person objects
        List<Person> people = objectMapper.readValue(json, new TypeReference<List<Person>>() {});

        // Filter only persons with age > 25
        List<Person> filteredPeople = people.stream()
                .filter(person -> person.age > 25)
                .collect(Collectors.toList());

        // Assertions
        assertEquals(2, filteredPeople.size());  // Only 2 persons should be present
        assertEquals("Aman", filteredPeople.get(0).name);
        assertEquals("Bhagwan", filteredPeople.get(1).name);
    }
}
