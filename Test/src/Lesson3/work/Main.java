package Lesson3.work;

public class Main {
    public static void main(String[] args) {
        Employee employee1 = new Employee("Bat", 800000);
        Employee employee2 = new Employee("Bold", 900000);

        Hrmanager hrManager = new Hrmanager("Munkhbat", 1500000);

        employee1.work();
        employee2.work();



        hrManager.addEmployee(employee1);
        hrManager.addEmployee(employee2);
        System.out.println(" менежерийн ажилтны нэр: " + hrManager.getName() + "авдаг цалин: " + hrManager.getSalary());
        System.out.println(" ажилтны нэр " + employee1.getName() + " - ажилтны цалин: " + employee1.getSalary());
        System.out.println(" ажилтны нэр " + employee2.getName() + " - ажилтны цалин: " + employee2.getSalary());
    }
}
