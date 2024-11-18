package Lesson3;

interface printable {
    void print();
}
public class Lesson implements printable{
    @Override
    public void print() {
        System.out.println("Hello Students");
    }

    public static void main(String[] args) {
        Student student = new Student();
        student.setFirstname("Bat");
        student.setLastname("Bold");
        student.setStudentCode("IO-1003");
        student.setAge(20);

        System.out.println("Овог: " + student.getFirstname());
        System.out.println("Нэр: " + student.getLastname());
        System.out.println("Оюутны код: " + student.getStudentCode());
        System.out.println("Нас: " + student.getAge());
        student.setGrade(85);

            double grade = student.calculate();
            student.info();
        System.out.println(grade);

        Lesson lesson = new Lesson();
        lesson.print();
    }
}
