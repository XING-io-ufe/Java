package Lesson3.work;

public class Hrmanager extends Employee{
    public Hrmanager(String name, double salary) {
        super(name, salary);
    }
    public void addEmployee(Employee employee) {
        System.out.println("Ажилтан нэмэгдлээ: " + employee.getName());
    }
}
