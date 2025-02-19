package org.example.intermediateproblems.filterrecords;

public class Student {
    // Encapsulated Attributes of the class
    private int id;
    private String name;
    private int age;
    private double marks;

    // Constructor
    public Student(int id, String name, int age, double marks) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.marks = marks;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getMarks() {
        return marks;
    }

    // Display student details
    public void displayDetails() {
        System.out.println("ID: " + id + ", Name: " + name + ", Age: " + age + ", Marks: " + marks);
    }
}
