package org.example.readcsvfile;

public class Student {

    // Attributes of the class
    private int id;
    private String name;
    private int age;
    private double marks;

    // Constructor of the class
    public Student(int id, String name, int age, double marks){
        this.id = id;
        this.name = name;
        this.age = age;
        this.marks = marks;
    }

    // Getter methods
    public String getName(){
        return name;
    }
    public int getAge(){
        return age;
    }
    public int getId(){
        return id;
    }
    public double getMarks(){
        return marks;
    }

    // Method to display details
    public void displayDetails(){
        System.out.println("Student Id: " + id);
        System.out.println("Student's Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Marks: " + marks);
    }

}
