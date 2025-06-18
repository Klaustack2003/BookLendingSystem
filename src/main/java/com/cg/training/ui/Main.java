package com.cg.training.ui;

import com.cg.training.daoImplementation.*;
import com.cg.training.service.LibrarySystem;
import com.cg.training.util.ValidationUtility;

import java.util.Scanner;

/**
 * Main entry point for the Library Management System.
 * <p>
 * Provides a console-based user interface for interacting with the library system,
 * including member and librarian registration, book management, issuing books, and viewing records.
 * Input validation is handled via ValidationUtility.
 * </p>
 * 
 * Usage:
 * Run the main method to start the interactive menu-driven program.
 * 
 * @author Manideep Singh
 */
public class Main {
    /**
     * Starts the Library Management System UI and processes user input.
     * 
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LibrarySystem system = new LibrarySystem(
                new BookDAOImplementation(),
                new MemberDAOImplementation(),
                new LoanDAOImplementation(),
                new LibrarianDAOImplementation()
        );

        System.out.println(" Welcome to the Library Management System");

        boolean running = true;
        while (running) {
            printMenu();
            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1": // Register Member
                    String mName = promptValidName(scanner);
                    String mEmail = promptValidEmail(scanner);
                    system.registerMember(mName, mEmail);
                    System.out.println("Member registered.");
                    break;

                case "2": // Register Librarian
                    String lName = promptValidName(scanner);
                    String lEmail = promptValidEmail(scanner);
                    system.registerLibrarian(lName, lEmail);
                    System.out.println("Librarian registered.");
                    break;

                case "3": // Add Book
                    String title = promptValidTitle(scanner);
                    String author = promptValidAuthor(scanner);
                    int count = promptValidCount(scanner);
                    system.addBook(title, author, count);
                    System.out.println("Book added.");
                    break;

                case "4": // Issue Book
                    System.out.print("Enter member ID: ");
                    String memId = scanner.nextLine().trim();
                    String bookTitle = promptValidTitle(scanner);
                    system.issueBook(memId, bookTitle);
                    break;

                case "5": // Show All Books (Admin)
                    system.listAllBooks()
                            .forEach(book -> System.out.println(book.bookDetails()));
                    break;

                case "6": // Show All Members (Admin)
                    system.listAllMembers()
                            .forEach(member -> System.out.println(member.adminDetails()));
                    break;

                case "7": // Show All Librarians (Admin)
                    system.listAllLibrarians()
                            .forEach(librarian -> System.out.println(librarian.adminDetails()));
                    break;

                case "8": // Remove Book Copy
                    String remTitle = promptValidTitle(scanner);
                    int remCount = promptValidCount(scanner);
                    system.removeBook(remTitle, remCount);
                    System.out.println("Book updated.");
                    break;

                case "9": // Exit
                    system.saveAllData();
                    running = false;
                    System.out.println("Exiting system. All data saved.");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }

            System.out.println();
        }

        scanner.close();
    }

    /**
     * Prints the main menu options to the console.
     */
    private static void printMenu() {
        System.out.println("------------------------------------------------");
        System.out.println("Library Management System");
        System.out.println("1. Register Member");
        System.out.println("2. Register Librarian");
        System.out.println("3. Add Book");
        System.out.println("4. Issue Book");
        System.out.println("5. Show All Books(Admin)");
        System.out.println("6. Show All Members(Admin)");
        System.out.println("7. Show All Librarians(Admin)");
        System.out.println("8. Remove Book Copy(Admin)");
        System.out.println("9. Exit");
        System.out.print("Enter your choice: ");
    }

    /**
     * Prompts user to enter a valid name, retrying until valid.
     * 
     * @param scanner Scanner instance for input
     * @return validated name string
     */
    private static String promptValidName(Scanner scanner) {
        String name;
        while (true) {
            System.out.print("Enter name: ");
            name = scanner.nextLine().trim();
            if (ValidationUtility.isValidName(name)) break;
            System.out.println("Invalid name. Only letters and spaces allowed.");
        }
        return name;
    }

    /**
     * Prompts user to enter a valid email, retrying until valid.
     * 
     * @param scanner Scanner instance for input
     * @return validated email string
     */
    private static String promptValidEmail(Scanner scanner) {
        String email;
        while (true) {
            System.out.print("Enter email: ");
            email = scanner.nextLine().trim();
            if (ValidationUtility.isValidEmail(email)) break;
            System.out.println("Invalid email format.");
        }
        return email;
    }

    /**
     * Prompts user to enter a valid book title, retrying until valid.
     * 
     * @param scanner Scanner instance for input
     * @return validated book title string
     */
    private static String promptValidTitle(Scanner scanner) {
        String title;
        while (true) {
            System.out.print("Enter book title: ");
            title = scanner.nextLine().trim();
            if (ValidationUtility.isValidTitle(title)) break;
            System.out.println("Invalid title.");
        }
        return title;
    }

    /**
     * Prompts user to enter a valid author name, retrying until valid.
     * 
     * @param scanner Scanner instance for input
     * @return validated author name string
     */
    private static String promptValidAuthor(Scanner scanner) {
        String author;
        while (true) {
            System.out.print("Enter author: ");
            author = scanner.nextLine().trim();
            if (ValidationUtility.isValidAuthor(author)) break;
            System.out.println("Invalid author name.");
        }
        return author;
    }

    /**
     * Prompts user to enter a valid positive count number, retrying until valid.
     * 
     * @param scanner Scanner instance for input
     * @return validated positive count integer
     */
    private static int promptValidCount(Scanner scanner) {
        int count;
        while (true) {
            System.out.print("Enter count: ");
            try {
                count = Integer.parseInt(scanner.nextLine().trim());
                if (count > 0) break;
            } catch (NumberFormatException ignored) {}
            System.out.println("Invalid count. Must be a positive number.");
        }
        return count;
    }
}
