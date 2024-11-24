package Lesson2.Homework;
import java.util.Scanner;

public class Book {

    private String title;
    private String author;
    private int years;

    Scanner sc = new Scanner(System.in);

    public Book(String title, String author, int years) {
        this.title = title;
        this.author = author;
        this.years = years;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYears() {
        return years;
    }

    public void setYears(Integer years) {
        this.years = years;
    }

    public void insertBook(){
        System.out.print("Enter the Book title: ");
        title = sc.nextLine();
        System.out.print("Enter the author: ");
        author = sc.nextLine();
        System.out.print("Enter the years: ");
        years = sc.nextInt();


        new Book(title, author, years);
        System.out.println("new book uuslee");

    }
    public void deleteBook(){

        setTitle(null);

        setAuthor(null);

        setYears(null);

        System.out.println("tani medeeleel update hiile");
    }
}
