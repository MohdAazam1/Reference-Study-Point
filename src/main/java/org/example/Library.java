package org.example;
import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books = new ArrayList<>();
    private ArrayList<Staff> staffMembers = new ArrayList<>();

    // --- Book Methods ---
    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added successfully!");
    }

    public void viewBooks() {
        if (books.isEmpty()) {
            System.out.println("No books in the library.");
        } else {
            System.out.println("\n--- List of Books ---");
            for (Book book : books) {
                System.out.println(book);
            }
        }
    }

    public void issueBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                if (!book.isIssued()) {
                    book.issue();
                    System.out.println("Book issued successfully!");
                } else {
                    System.out.println("Book is already issued.");
                }
                return;
            }
        }
        System.out.println("Book not found.");
    }

    public void returnBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                if (book.isIssued()) {
                    book.returnBook();
                    System.out.println("Book returned successfully!");
                } else {
                    System.out.println("This book was not issued.");
                }
                return;
            }
        }
        System.out.println("Book not found.");
    }

    // --- Staff Methods ---
    public void addStaff(Staff staff) {
        staffMembers.add(staff);
        System.out.println("Staff added successfully!");
    }

    public void removeStaff(String name) {
        for (Staff staff : staffMembers) {
            if (staff.getName().equalsIgnoreCase(name)) {
                staffMembers.remove(staff);
                System.out.println("Staff removed successfully!");
                return;
            }
        }
        System.out.println("Staff not found.");
    }

    public void viewStaff() {
        if (staffMembers.isEmpty()) {
            System.out.println("No staff members in the library.");
        } else {
            System.out.println("\n--- List of Staff ---");
            for (Staff staff : staffMembers) {
                System.out.println(staff);
            }
        }
    }

    public void updateStaff(String name, String newRole) {
        for (Staff staff : staffMembers) {
            if (staff.getName().equalsIgnoreCase(name)) {
                staffMembers.set(staffMembers.indexOf(staff), new Staff(name, newRole));
                System.out.println("Staff updated successfully!");
                return;
            }
        }
        System.out.println("Staff not found.");
    }
}

