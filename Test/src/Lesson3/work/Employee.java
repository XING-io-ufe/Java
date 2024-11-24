package Lesson3.work;

public class Employee {

    private String name;
    private double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }


    public String getName() {
        return name;
    }


    public void work() {
        System.out.println(name + " ажилтай байна.");
    }

    public double getSalary() {
        return salary;
    }
}
