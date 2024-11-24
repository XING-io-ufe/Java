package Lesson1;
import java.util.Scanner;
public class Daalgavar2 {


        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int n;
            long product = 1;

            System.out.print("4 оронтой тоо оруулна уу: ");
            n = scanner.nextInt();


            if (n >= 1000 && n <= 9999) {

                while (n > 0) {
                    int digit = n % 10;
                    product *= digit;
                    n /= 10;
                }
                System.out.println("4 тооны цифрүүдийн үржвэр: " + product);
            } else {
                System.out.println("Та 4 оронтой тоо оруулах ёстой.");
            }

            scanner.close();
        }
}
