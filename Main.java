import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        boolean running = true;
        while (running) {
            System.out.println("Library Management System");
            System.out.println("-------------------------");
            System.out.println("1. Add a Book");
            System.out.println("2. Lend a Book");
            System.out.println("3. Return a Book");
            System.out.println("4. View All Books");
            System.out.println();
            System.out.print("Enter your choice: ");

            String select = scan.nextLine();

            if (select.equalsIgnoreCase("add a book")) {

                System.out.println("Choose the type of book to add: ");
                System.out.println("a. Add a Physical Book");
                System.out.println("b. Add a Digital Book");
                System.out.print("Select: ");
                String opt = scan.nextLine();

                if (opt.equalsIgnoreCase("Add a Physical book")) {
                    System.out.print("Enter the book's title: ");
                    String title = scan.nextLine();
                    System.out.print("Enter the book's author: ");
                    String author = scan.nextLine();
                    System.out.print("Enter the book's ISBN: ");
                    String isbn = scan.nextLine();
                    System.out.print("Enter the weight: ");
                    double weight = scan.nextDouble();

                    Library.addPhysicalBook(title, author, isbn, weight);
                } else if (opt.equalsIgnoreCase("Add a Digital book")) {
                    System.out.print("Enter the book's title: ");
                    String title = scan.nextLine();
                    System.out.print("Enter the book's author: ");
                    String author = scan.nextLine();
                    System.out.print("Enter the book's ISBN: ");
                    String isbn = scan.nextLine();
                    System.out.print("Enter the download link: ");
                    String downloadLink = scan.nextLine();
                
                    Library.addDigitalBook(title, author, isbn, downloadLink);
                } 
                
            } else if (select.equalsIgnoreCase("lend a book")) {
                System.out.print("Enter the book's tilte or ISBN to lend out: ");
                String identifierLend = scan.nextLine();
                Library.lendBook(identifierLend);
            }else if (select.equalsIgnoreCase("return a book")) {
                System.out.print("Enter the book title or ISBN to return: ");
                String identifierReturn = scan.nextLine();
                Library.returnBook(identifierReturn);
            }else if (select.equalsIgnoreCase("view all books")) {
                Library.viewAllBooks();
            }else {
                Library.saveBooks();
                running = false;
            }
        }

        scan.close();
    }

    
}
