package Lesson2_Homework;

class Book {
    private Author author;
    private String title;
    private int year;

    public Book(Author author, String title, int year) {
        this.author = author;
        this.title = title;
        this.year = year;
    }

    public Author getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public void displayInfo() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author.getName());
        System.out.println("Year: " + year);
    }
}