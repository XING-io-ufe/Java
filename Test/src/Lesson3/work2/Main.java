package Lesson3.work2;

public class Main {
    public static void main(String[] args) {

        Animal dog = new Dog();
        Animal lion = new Lion();
        Animal deer = new Deer();

        dog.eat();
        dog.sleep();

        lion.eat();
        lion.sleep();

        deer.eat();
        deer.sleep();
    }
}
