package Lesson3.work;

public class Main {
    public static void main(String[] args) {
        Employee employee1 = new Employee("Bat", 800000);
        Employee employee2 = new Employee("Bold", 900000);

        // HRManager үүсгэж байна
        Hrmanager hrManager = new Hrmanager("Munkhbat", 1500000);

        // Ажилтнуудын ажиллах үйлдлийг дуудна
        employee1.work();
        employee2.work();

        // Ажилтнуудын цалинг харуулна
        System.out.println(employee1.getName() + " - Цалин: " + employee1.getSalary());
        System.out.println(employee2.getName() + " - Цалин: " + employee2.getSalary());

        // Ажилтан нэмэх
        hrManager.addEmployee(employee1);
        hrManager.addEmployee(employee2);
        System.out.println(hrManager);
    }
}
