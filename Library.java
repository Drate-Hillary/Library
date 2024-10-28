import java.io.*;
import java.util.*;

public class Library {
    
    private static ArrayList<Book> books;

    static{
        books = new ArrayList<>();
    }
    Library(){
        loadBooks();
    }

    public static void addDigitalBook(String title, String author, String ISBN, String downloadLink){
        books.add(new DigitalBook(title, author, ISBN, downloadLink));
        saveBooks();
        System.out.println("Book sucessfully added!");
    }

    public static void addPhysicalBook(String title, String author, String ISBN, double weight){
        books.add(new PhysicalBook(title, author, ISBN, weight));
        saveBooks();
        System.out.println("Book sucessfully added!");
    }

    //lending out the book
    public static void lendBook(String identifier){

        for (Book book : books) {
            if ((book.getTitle().equalsIgnoreCase(identifier) || book.getISBN().equals(identifier))) {
                if (!book.isLent()) {
                    book.setLent(true);
                    saveBooks();
                    System.out.println("Book lent out successfully");
                } else {
                    System.out.println("Book is already lent out");
                }
                return;
            }
        }

        System.out.println("Book is not found in the library");
    }

    // Returning the book
    public static void returnBook(String identifier){
        for (Book book : books) {
            if ((book.getTitle().equalsIgnoreCase(identifier) || book.getISBN().equals(identifier))) {
               if (book.isLent()) {
                book.setLent(false);
                saveBooks();
                System.out.println("Book returned");
               } else {
                System.out.println("Book was not lent out");
               }
               return;
            }
        }
        System.out.println("Book is not found in the library");
    }

    public static void viewAllBooks(){
        loadBooks();
        for (Book book : books) {
            System.out.println(book);
        }
    }

    public static void saveBooks(){
        try (FileOutputStream fileOut = new FileOutputStream("books.txt");
            ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(books);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings ({ "unchecked" })
    private static void loadBooks(){
        File file = new File("books.txt");
        if (!file.exists()) {
            books = new ArrayList<>();
            System.out.println("No previous book data found. Starting with an empty library.");
            return;
        }

        try (FileInputStream fileIn = new FileInputStream(file);
            ObjectInputStream in = new ObjectInputStream(fileIn)) {
                Object obj = in.readObject();
                if (obj instanceof ArrayList<?>) {
                    books = (ArrayList<Book>) obj;
                    System.out.println("Books loaded successfully.");
                } else {
                    books = new ArrayList<>();
                    System.out.println("File content is not in the expected format. Starting with an empty library.");
                }
        } catch (IOException | ClassNotFoundException e) {
            books = new ArrayList<>();
            System.out.println("Error caught at " + e.getMessage());
        }
    }

}
