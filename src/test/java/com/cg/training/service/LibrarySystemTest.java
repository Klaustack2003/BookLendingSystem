package com.cg.training.service;

import com.cg.training.daoImplementation.*;
import com.cg.training.model.*;
import org.junit.jupiter.api.*;

import java.io.File;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for {@link LibrarySystem}, validating its core functionality such as:
 * adding books, managing users (members & librarians), issuing and returning books,
 * and retrieving system records.
 *
 * This test ensures data persistence and business logic integrity via DAO implementations.
 * Files used for persistence are cleared before each test to maintain isolation.
 * 
 * @author Supriyo Pal
 */

public class LibrarySystemTest {

    private LibrarySystem librarySystem;
    private final String BOOK_FILE = "resources/books.txt";
    private final String LOAN_FILE = "resources/loans.txt";

    /**
     * Initializes the test environment by clearing persistence files and
     * instantiating fresh DAO implementations.
     */
    
    @BeforeEach
    public void setup() {
        clearFile(BOOK_FILE);
        clearFile(LOAN_FILE);

        BookDAOImplementation bookDAO = new BookDAOImplementation();
        MemberDAOImplementation memberDAO = new MemberDAOImplementation();
        LoanDAOImplementation loanDAO = new LoanDAOImplementation();
        LibrarianDAOImplementation librarianDAO = new LibrarianDAOImplementation();

        librarySystem = new LibrarySystem(bookDAO, memberDAO, loanDAO, librarianDAO);
    }

    /**
     * Deletes the specified file if it exists, ensuring clean state between tests.
     *
     * @param path the path to the file
     */
    
    private void clearFile(String path) {
        File file = new File(path);
        if (file.exists()) {
            file.delete();
        }
    }

    /**
     * Tests that a book can be added and successfully searched by title.
     */
    
    @Test
    public void testAddBookAndSearch() {
        librarySystem.addBook("Effective Java", "Joshua Bloch", 3);

        Optional<Book> book = librarySystem.searchBook("Effective Java");
        assertTrue(book.isPresent());
        assertEquals("Joshua Bloch", book.get().getAuthor());
        assertEquals(3, book.get().getCount());
    }

    /**
     * Tests that a member can be registered and listed among all members.
     */
    
    @Test
    public void testRegisterMemberAndList() {
        librarySystem.registerMember("Alice", "alice@example.com");

        List<Member> members = librarySystem.listAllMembers();
        assertEquals(1, members.size());
        }

    /**
     * Tests that a librarian can be registered and listed among all librarians.
     */
    
    @Test
    public void testRegisterLibrarianAndList() {
        librarySystem.registerLibrarian("Bob", "bob@example.com");

        List<Librarian> librarians = librarySystem.listAllLibrarians();
        assertEquals(1, librarians.size());
        }

    /**
     * Tests issuing a book to a member and verifies loan creation and book availability.
     */
    
    @Test
    public void testIssueBook() {
        librarySystem.registerMember("Alice", "alice@example.com");
        librarySystem.registerLibrarian("Bob", "bob@example.com");
        librarySystem.addBook("Java", "Author", 2);

        List<Member> members = librarySystem.listAllMembers();
        String memberId = members.get(0).getMemberId();

        librarySystem.issueBook(memberId, "Java");

        List<Loan> loans = librarySystem.listAllLoans();
        assertEquals(1, loans.size());
        assertEquals("Borrowed", loans.get(0).getStatus());
        assertEquals("Java", loans.get(0).getBook().getTitle());
    }

    /**
     * Tests returning a previously issued book and verifies loan status is updated.
     */
    
    @Test
    public void testReturnBook() {
        librarySystem.registerMember("Alice", "alice@example.com");
        librarySystem.registerLibrarian("Bob", "bob@example.com");
        librarySystem.addBook("C++", "Bjarne", 1);

        List<Member> members = librarySystem.listAllMembers();
        String memberId = members.get(0).getMemberId();

        librarySystem.issueBook(memberId, "C++");
        librarySystem.returnBook(memberId, "C++");

        List<Loan> loans = librarySystem.listAllLoans();
        assertEquals(1, loans.size());
        assertEquals("Returned", loans.get(0).getStatus());
    }

    /**
     * Tests that multiple books added are returned via {@code listAllBooks()}.
     */
    
    @Test
    public void testListAllBooks() {
        librarySystem.addBook("Book A", "Author A", 1);
        librarySystem.addBook("Book B", "Author B", 2);

        List<Book> books = librarySystem.listAllBooks();
        assertEquals(2, books.size());
    }
}
