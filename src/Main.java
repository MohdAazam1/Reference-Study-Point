import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Represents a book with a title, author, and a boolean status for availability.
 */
class Book {
    private String title;
    private String author;
    private boolean isAvailable;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isAvailable = true; // New books are available by default
    }

    // Getters
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    // Setter for availability
    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    @Override
    public String toString() {
        return "Title: " + title + ", Author: " + author + ", Available: " + (isAvailable ? "Yes" : "No");
    }
}

/**
 * Manages the collection of books and provides methods for adding, removing, searching, and displaying books.
 */
class Library {
    private List<Book> books;

    public Library() {
        this.books = new ArrayList<>();
    }

    /**
     * Adds a new book to the library collection.
     * @param book The book object to add.
     */
    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added successfully: " + book.getTitle());
    }

    /**
     * Removes a book from the library by its title.
     * @param title The title of the book to remove.
     */
    public void removeBook(String title) {
        Book bookToRemove = findBookByTitle(title);
        if (bookToRemove != null) {
            books.remove(bookToRemove);
            System.out.println("Book removed successfully: " + title);
        } else {
            System.out.println("Error: Book not found with title '" + title + "'.");
        }
    }

    /**
     * Finds a book in the library by its title.
     * @param title The title of the book to find.
     * @return The Book object if found, otherwise null.
     */
    public Book findBookByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    /**
     * Displays all books currently in the library.
     */
    public void displayAllBooks() {
        if (books.isEmpty()) {
            System.out.println("The library is currently empty.");
        } else {
            System.out.println("\n--- All Books in the Library ---");
            for (Book book : books) {
                System.out.println(book);
            }
            System.out.println("----------------------------------");
        }
    }

    /**
     * Loans a book by setting its availability to false.
     * @param title The title of the book to loan.
     */
    public void loanBook(String title) {
        Book book = findBookByTitle(title);
        if (book != null) {
            if (book.isAvailable()) {
                book.setAvailable(false);
                System.out.println("Book loaned successfully: " + title);
            } else {
                System.out.println("Error: The book '" + title + "' is already on loan.");
            }
        } else {
            System.out.println("Error: Book not found with title '" + title + "'.");
        }
    }

    /**
     * Returns a book by setting its availability to true.
     * @param title The title of the book to return.
     */
    public void returnBook(String title) {
        Book book = findBookByTitle(title);
        if (book != null) {
            if (!book.isAvailable()) {
                book.setAvailable(true);
                System.out.println("Book returned successfully: " + title);
            } else {
                System.out.println("Error: The book '" + title + "' was not on loan.");
            }
        } else {
            System.out.println("Error: Book not found with title '" + title + "'.");
        }
    }
}

/**
 * Main class to run the Library Management System.
 * This class contains the main method and a simple command-line interface.
 */
public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Library Management System Menu ---");
            System.out.println("1. Add a new book");
            System.out.println("2. Remove a book");
            System.out.println("3. Search for a book");
            System.out.println("4. Display all books");
            System.out.println("5. Loan a book");
            System.out.println("6. Return a book");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                choice = -1; // Set to an invalid choice to trigger the default case
            }

            switch (choice) {
                case 1:
                    System.out.print("Enter title: ");
                    String addTitle = scanner.nextLine();
                    System.out.print("Enter author: ");
                    String addAuthor = scanner.nextLine();
                    library.addBook(new Book(addTitle, addAuthor));
                    break;
                case 2:
                    System.out.print("Enter title of book to remove: ");
                    String removeTitle = scanner.nextLine();
                    library.removeBook(removeTitle);
                    break;
                case 3:
                    System.out.print("Enter title of book to search: ");
                    String searchTitle = scanner.nextLine();
                    Book foundBook = library.findBookByTitle(searchTitle);
                    if (foundBook != null) {
                        System.out.println("Book found: " + foundBook);
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;
                case 4:
                    library.displayAllBooks();
                    break;
                case 5:
                    System.out.print("Enter title of book to loan: ");
                    String loanTitle = scanner.nextLine();
                    library.loanBook(loanTitle);
                    break;
                case 6:
                    System.out.print("Enter title of book to return: ");
                    String returnTitle = scanner.nextLine();
                    library.returnBook(returnTitle);
                    break;
                case 7:
                    System.out.println("Exiting the application. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 7.");
            }
        } while (choice != 7);

        scanner.close();
    }
}
