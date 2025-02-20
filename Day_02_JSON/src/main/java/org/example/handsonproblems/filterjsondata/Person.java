package org.example.handsonproblems.filterjsondata;

// Define Person class
class Person {
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