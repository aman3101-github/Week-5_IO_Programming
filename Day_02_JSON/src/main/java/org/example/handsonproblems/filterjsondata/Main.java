
package org.example.handsonproblems.filterjsondata;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;


public class Main {
    public static void main(String[] args) {
        // JSON String (Input)
        String json = "[{\"name\": \"Aman\", \"age\": 28}, {\"name\": \"Adarsh\", \"age\": 26}, {\"name\": \"Bhagwan\", \"age\": 24}]";


        // Step 3: Create ObjectMapper
        ObjectMapper objectMapper = new ObjectMapper();


        try {
            // Convert JSON string to List of Person objects
            List<Person> people = objectMapper.readValue(json, new TypeReference<List<Person>>() {});




            //  Filter records where age > 25
            List<Person> filteredPeople = people.stream()
                    .filter(person -> person.age > 25)
                    .collect(Collectors.toList());


            // Print the filtered results
            filteredPeople.forEach(System.out::println);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
