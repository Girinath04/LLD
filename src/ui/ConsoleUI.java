package ui;

import model.Books;
import service.LibraryService;

import java.util.Scanner;

public class ConsoleUI {
    private final Scanner scanner = new Scanner(System.in);
    private final LibraryService service = new LibraryService();

    public void start(){
        int choice;

        do {
            printMenu();
            choice = scanner.nextInt();

            switch (choice) {
                case 1 -> add();
                case 2 -> viewAll();
                case 3 -> search();
                case 4 -> update();
                case 5 -> updateDueDate();
                case 6 -> updateTitle();
                case 7 -> delete();
                case 0 -> System.out.println("Exiting... Thank you!");
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }while ( choice != 0);

    }

    private void printMenu(){
        System.out.println("Menu (Enter num for operation!");
        System.out.println("1 - Add book to library");
        System.out.println("2 - View All books");
        System.out.println("3 - Search particular book");
        System.out.println("4 - Update information");
        System.out.println("5 - Update dueDate");
        System.out.println("6 - Update book Title");
        System.out.println("7 - delete Book from library");
        System.out.println("0 - Exit!");
        System.out.println("Please enter your choice");
    }

    private void add() {
        System.out.println("Enter the Book Id:");
        int bookId = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter Book Name:");
        String bookName = scanner.nextLine();
        System.out.println("Enter Book Author Name:");
        String bookAuthor = scanner.nextLine();

        boolean added = service.addBooks(new Books(
                bookId,
                bookName,
                bookAuthor,
                true,
                "DD-MM-YYYY"
        ));

        if(added){
            System.out.println("Book added to the Library Successfully!");
        }
        else{
            System.out.println("A Book with same Id is already Exist!");
        }

    }

    private void viewAll() {
        var library = service.getBooksMap();
        if(library.isEmpty()){
            System.out.println("No Books Found!");
        }
        else{
            library.forEach(System.out::println);
        }
    }

    private void search(){
        System.out.println("Enter Book Id:");
        int bookId = scanner.nextInt();
        scanner.nextLine();
        Books book =  service.getBookId(bookId);
        if(book != null){
            System.out.println(book.toString());
        }
        else{
            System.out.println("Books not found!");
        }

    }

    private void update() {
        System.out.println("Enter Book Id:");
        int bookId = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter Book Name:");
        String bookName = scanner.nextLine();
        System.out.println("Enter Book Author Name:");
        String bookAuthor = scanner.nextLine();
        System.out.println("Whether book is available (true or false):");
        boolean status = scanner.nextBoolean();

        boolean updated = service.updateLibrary(bookId,bookName,bookAuthor,status);

        if(updated) System.out.println("Book details updated!");
        else System.out.println("Book not Found");
    }

    private void delete() {
        System.out.println("Enter Book Id:");
        int bookId = scanner.nextInt();
        scanner.nextLine();
        boolean deleted = service.deleteBook(bookId);
        if(deleted) System.out.println("Book deleted!");
        else System.out.println("Book Not Found!");
    }

    private void updateDueDate(){
        System.out.println("enter Book Id:");
        int bookId = scanner.nextInt();
        scanner.nextLine();
        System.out.println("enter DueDate(DD-MM-YYYY):");
        String DueDate = scanner.nextLine();

        boolean updated = service.updateDueDate(bookId,DueDate,false);
        if(updated) System.out.println("Due Date update!");
        else System.out.println("Book Not found!");
    }

    private void updateTitle(){
        System.out.println("enter Book Id:");
        int bookId = scanner.nextInt();
        scanner.nextLine();
        System.out.println("enter New Name:");
        String bookName = scanner.nextLine();

        boolean updated = service.updateBookTitle(bookId,bookName);
        if(updated) System.out.println("Book name update!");
        else System.out.println("Book not found!");

    }



}
