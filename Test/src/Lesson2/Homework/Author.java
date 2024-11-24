package Lesson2.Homework;


import java.util.Scanner;

public class Author {
    Scanner sc = new Scanner(System.in);

    private String firstName;
    private String lastName;
    private int age;
    private String gender;
    private String about;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public Author(String firstName, String lastName, int age, String gender, String about) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
        this.about = about;
    }


    public void insertAuthor(){
        System.out.print("Enter the first name: ");
        firstName = sc.nextLine();
        System.out.print("Enter the last name: ");
        lastName = sc.nextLine();
        System.out.print("Enter the age: ");
        age = sc.nextInt();
        System.out.print("Enter the gender: ");
        gender = sc.nextLine();
        System.out.print("Enter the about: ");
        about = sc.nextLine();

        new Author(firstName, lastName, age, gender, about);
        System.out.println("new author uuslee");

    }
    public void editAuthor(){
        System.out.print("Enter the first name: ");
        firstName = sc.nextLine();
        setFirstName(firstName);
        System.out.print("Enter the last name: ");
        lastName = sc.nextLine();
        setLastName(lastName);
        System.out.print("Enter the age: ");
        age = sc.nextInt();
        setAge(age);
        System.out.print("Enter the gender: ");
        gender = sc.nextLine();
        setGender(gender);
        System.out.print("Enter the about: ");
        about = sc.nextLine();
        setAbout(about);
        System.out.println("tani medeeleel update hiile");
    }

    public void viewAuthor(){
        System.out.println("First Name: " + firstName);
        System.out.println("Last Name: " + lastName);
        System.out.println("Age: " + age);
        System.out.println("Gender: " + gender);
        System.out.println("About: " + about);
    }

}
