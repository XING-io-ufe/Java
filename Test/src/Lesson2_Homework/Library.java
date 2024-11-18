package Lesson2_Homework;
import java.util.Scanner;

class Library {
    private Book[] books;
    private int bookCount;

    public Library(int capacity) {
        books = new Book[capacity];
        bookCount = 0;
    }

    public void addBook(Book book) {
        if (bookCount < books.length) {
            books[bookCount] = book;
            bookCount++;
            System.out.println("ном нэмэх: " + book.getTitle());
        } else {
            System.out.println("ном дүүрсэн багтаамж.");
        }
    }

    public void removeBook(Book book) {
        for (int i = 0; i < bookCount; i++) {
            if (books[i].equals(book)) {
                books[i] = books[bookCount - 1];
                books[bookCount - 1] = null;
                bookCount--;
                System.out.println("арилгасан ном: " + book.getTitle());
                return;
            }
        }
        System.out.println("ном олдсонгүй: " + book.getTitle());
    }

    public void displayBooks() {
        if (bookCount == 0) {
            System.out.println("No books in the library.");
        } else {
            for (int i = 0; i < bookCount; i++) {
                books[i].displayInfo();
                System.out.println();
            }
        }
    }
    public static void main(String[] args) {
        Library library = new Library(10); 
        Scanner scanner = new Scanner(System.in);

        // Зохиогчийн мэдээлэл оруулах
        System.out.print("Enter author name: ");
        String authorName = scanner.nextLine();
        System.out.print("Enter author biography: ");
        String authorBio = scanner.nextLine();

        Author author = new Author(authorName, authorBio);

        // Номын мэдээлэл оруулах
        System.out.print("Enter book title: ");
        String bookTitle = scanner.nextLine();
        System.out.print("Enter book year: ");
        int bookYear = scanner.nextInt();

        Book book = new Book(author, bookTitle, bookYear);

        // Номыг номын санд нэмэх
        library.addBook(book);

        // Номын сангийн номыг харуулах
        System.out.println("\nBooks in the library:");
        library.displayBooks();

        // Номыг хасах
        library.removeBook(book);

        // Номын сангийн номыг дахин харуулах
        System.out.println("\nBooks in the library after removal:");
        library.displayBooks();

        scanner.close();
    }
}