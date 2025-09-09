package org.example;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();

        // default admin account
        Admin admin = new Admin("admin", "1234");

        System.out.println("====== Library Management System ======");
        System.out.println("1. Admin Login");
        System.out.println("2. User Login");
        System.out.print("Enter choice: ");
        int loginChoice = scanner.nextInt();
        scanner.nextLine(); // consume newline

        if (loginChoice == 1) {
            // Admin login
            System.out.print("Enter admin username: ");
            String user = scanner.nextLine();
            System.out.print("Enter admin password: ");
            String pass = scanner.nextLine();

            if (!admin.login(user, pass)) {
                System.out.println("Invalid credentials. Exiting system.");
                scanner.close();
                return;
            }

            System.out.println("Login successful! Welcome, Admin.");

            while (true) {
                System.out.println("\n====== Admin Panel ======");
                System.out.println("1. Add Book");
                System.out.println("2. View All Books");
                System.out.println("3. Issue Book");
                System.out.println("4. Return Book");
                System.out.println("5. Add Staff");
                System.out.println("6. Remove Staff");
                System.out.println("7. View Staff");
                System.out.println("8. Update Staff");
                System.out.println("9. Exit");
                System.out.print("Enter your choice: ");

                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        System.out.print("Enter book title: ");
                        String title = scanner.nextLine();
                        System.out.print("Enter author name: ");
                        String author = scanner.nextLine();
                        Book book = new Book(title, author);
                        library.addBook(book);
                        break;

                    case 2:
                        library.viewBooks();
                        break;

                    case 3:
                        System.out.print("Enter book title to issue: ");
                        String issueTitle = scanner.nextLine();
                        library.issueBook(issueTitle);
                        break;

                    case 4:
                        System.out.print("Enter book title to return: ");
                        String returnTitle = scanner.nextLine();
                        library.returnBook(returnTitle);
                        break;

                    case 5:
                        System.out.print("Enter staff name: ");
                        String staffName = scanner.nextLine();
                        System.out.print("Enter staff role: ");
                        String staffRole = scanner.nextLine();
                        Staff staff = new Staff(staffName, staffRole);
                        library.addStaff(staff);
                        break;

                    case 6:
                        System.out.print("Enter staff name to remove: ");
                        String removeName = scanner.nextLine();
                        library.removeStaff(removeName);
                        break;

                    case 7:
                        library.viewStaff();
                        break;

                    case 8:
                        System.out.print("Enter staff name to update: ");
                        String updateName = scanner.nextLine();
                        System.out.print("Enter new role: ");
                        String newRole = scanner.nextLine();
                        library.updateStaff(updateName, newRole);
                        break;

                    case 9:
                        System.out.println("Exiting system. Goodbye!");
                        scanner.close();
                        return;

                    default:
                        System.out.println("Invalid choice! Try again.");
                }
            }

        } else if (loginChoice == 2) {
            // User login
            System.out.print("Enter your name: ");
            String username = scanner.nextLine();
            User user = new User(username);
            System.out.println("Welcome, " + user.getUsername() + "!");

            while (true) {
                System.out.println("\n====== User Panel ======");
                System.out.println("1. View All Books");
                System.out.println("2. Issue Book");
                System.out.println("3. Return Book");
                System.out.println("4. Exit");
                System.out.print("Enter your choice: ");

                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        library.viewBooks();
                        break;

                    case 2:
                        System.out.print("Enter book title to issue: ");
                        String issueTitle = scanner.nextLine();
                        library.issueBook(issueTitle);
                        break;

                    case 3:
                        System.out.print("Enter book title to return: ");
                        String returnTitle = scanner.nextLine();
                        library.returnBook(returnTitle);
                        break;

                    case 4:
                        System.out.println("Goodbye, " + user.getUsername() + "!");
                        scanner.close();
                        return;

                    default:
                        System.out.println("Invalid choice! Try again.");
                }
            }
        } else {
            System.out.println("Invalid option. Exiting.");
        }
    }
}
