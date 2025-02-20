package org.example.practiceproblems.filterjsonobjects;

// Define Person class
public class Person {
    public String name;
    public int age;

    // Default Constructor
    public Person() {}

    // To display the filtered results
    @Override
    public String toString() {
        return name + " - " + age;
    }
}