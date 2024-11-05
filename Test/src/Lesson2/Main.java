package Lesson2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        System.out.println("Та эхний тоогоо оруулна уу: ");
        int a = s.nextInt();

        System.out.print("Та дараагийн тоогоо рруулна уу: ");
        int b = s.nextInt();

        System.out.println("та математик тэмдэгтээ оруулна уу: ");
        String c = s.next();

        Calculator calc = new Calculator();
        switch (c) {
            case "+":
                int addResult = calc.add(a, b);
                System.out.println("Таны хариу: " + addResult);
                break;
            case "-":
                int subtractResult  = calc.subtract(a, b);
                System.out.println("Таны хариу: " + subtractResult);
                break;
            case "*":
                int multiplyResult = calc.multiply(a, b);
                System.out.println("Таны хариу: " + multiplyResult);
                break;
            case "/":
                double divideResult = calc.divide(a, b);
                System.out.println("Таны хариу: " + divideResult);
                break;
        }
    }
}
