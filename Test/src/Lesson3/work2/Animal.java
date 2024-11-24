package Lesson3.work2;


abstract class Animal {
    abstract void eat();
    void sleep(){
        System.out.println("Zzz");
    }
}

class Dog extends Animal {
    void eat() {
        System.out.println("Нохой иддэг.");
    }

    @Override
    void sleep() {
        super.sleep();
    }
}


class Lion extends Animal {

    void eat() {
        System.out.println("Арслан иддэг.");
    }
    @Override
    void sleep() {
        super.sleep();
    }
}


class Deer extends Animal {


    void eat() {
        System.out.println("Буга иддэг.");
    }

    @Override
    void sleep() {
        super.sleep();
    }

}