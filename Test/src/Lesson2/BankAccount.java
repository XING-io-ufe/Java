package Lesson2;

public class BankAccount {
    public BankAccount() {

    }
    public int deposit( int d, int balance){
        return d + balance ;
    }
    public int withdraw( int w, int balance){
        return balance - w ;
    }

}
