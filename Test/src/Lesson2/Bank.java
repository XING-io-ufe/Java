package Lesson2;
import java.util.Scanner;

public class  Bank {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("үйлчилгээгээ сонгоно уу: \n 1. Дансны мэдээлэл авах\n 2. орлого хийх \n 3. зарлага хийх \n 4. үлдэгдэл шалгах ");
        int uildel = s.nextInt();
        int account = 553023032;
        int balance = 4390;
        BankAccount passport = new BankAccount();
        switch (uildel) {
            case 1:
                System.out.println("Таны дансны мэдээлэл: " + account);
                break;
            case 2:
                System.out.println("Та орлого хийх дүнгээ бичнэ үү: ");
                int d = s.nextInt();
                int depositResult  = passport.deposit(d, balance);
                System.out.println("Таны дансанд орлого хийгдлээ: " + depositResult);
                break;
            case 3:
                System.out.println("Та зарлага хийх дүнгээ бичнэ үү: ");
                int w = s.nextInt();
                int withdrawResult = passport.withdraw(w, balance);
                System.out.println("Таны данснаас зарлага гарлаа: " + withdrawResult);
                break;
            case 4:
                System.out.println("Таны дансны үлдэгдэл: " + balance);
                break;
        }

    }


}
