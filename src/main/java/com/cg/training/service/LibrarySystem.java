package com.cg.training.service;

import com.cg.training.dao.*;
import com.cg.training.model.*;

import java.util.List;
import java.util.Optional;

/**
 * Service class representing the core library system operations.
 * <p>
 * Provides methods to manage books, members, librarians, and loans by
 * interacting with respective DAO interfaces.
 * </p>
 * 
 * @author Prantik Roychowdhury
 * @version 2.0
 */
public class LibrarySystem {

	private final BookDAO bookDAO;
	private final MemberDAO memberDAO;
	private final LoanDAO loanDAO;
	private final LibrarianDAO librarianDAO;

	/**
	 * Constructs the LibrarySystem with required DAO implementations.
	 * 
	 * @param bookDAO      DAO for book operations
	 * @param memberDAO    DAO for member operations
	 * @param loanDAO      DAO for loan operations
	 * @param librarianDAO DAO for librarian operations
	 */
	public LibrarySystem(BookDAO bookDAO, MemberDAO memberDAO, LoanDAO loanDAO, LibrarianDAO librarianDAO) {
		this.bookDAO = bookDAO;
		this.memberDAO = memberDAO;
		this.loanDAO = loanDAO;
		this.librarianDAO = librarianDAO;
	}

	/**
	 * Adds a new book to the library.
	 * 
	 * @param title  the book's title
	 * @param author the book's author
	 * @param count  the number of copies to add
	 */
	public void addBook(String title, String author, int count) {
		bookDAO.addBook(new Book(title, author, count));
	}

	/**
	 * Removes the specified number of copies of a book by title. If the count
	 * reaches zero, marks the book as unavailable.
	 * 
	 * @param title         the title of the book to remove
	 * @param countToRemove number of copies to remove
	 */
	public void removeBook(String title, int countToRemove) {
		Optional<Book> optionalBook = bookDAO.findBookByTitle(title);
		if (optionalBook.isPresent()) {
			Book book = optionalBook.get();
			for (int i = 0; i < countToRemove; i++) {
				book.decrementCount();
			}
			if (book.getCount() <= 0) {
				book.setAvailable(false);
			}
			bookDAO.saveBooksToFile();
		} else {
			System.out.println("Book not found.");
		}
	}

	/**
	 * Searches for a book by its title.
	 * 
	 * @param title the title to search
	 * @return an Optional containing the book if found, else empty
	 */
	public Optional<Book> searchBook(String title) {
		return bookDAO.findBookByTitle(title);
	}

	/**
	 * Lists all books currently in the library.
	 * 
	 * @return list of all books
	 */
	public List<Book> listAllBooks() {
		return bookDAO.getAllBooks();
	}

	/**
	 * Registers a new member with the given name and email.
	 * 
	 * @param name  the member's name
	 * @param email the member's email
	 */
	public void registerMember(String name, String email) {
		memberDAO.addMember(new Member(name, email));
	}

	/**
	 * Registers a new librarian with the given name and email.
	 * 
	 * @param name  the librarian's name
	 * @param email the librarian's email
	 */
	public void registerLibrarian(String name, String email) {
		librarianDAO.addLibrarian(new Librarian(name, email));
	}

	/**
	 * Returns a list of all registered members.
	 * 
	 * @return list of members
	 */
	public List<Member> listAllMembers() {
		return memberDAO.getAllMembers();
	}

	/**
	 * Returns a list of all registered librarians.
	 * 
	 * @return list of librarians
	 */
	public List<Librarian> listAllLibrarians() {
		return librarianDAO.getAllLibrarians();
	}

	/**
	 * Issues a book to a member if the book is available.
	 * 
	 * @param memberId the ID of the member borrowing the book
	 * @param title    the title of the book to issue
	 */
	public void issueBook(String memberId, String title) {
		Optional<Member> memberOpt = memberDAO.findMemberById(memberId);
		Optional<Book> bookOpt = bookDAO.findBookByTitle(title);

		if (memberOpt.isPresent() && bookOpt.isPresent()) {
			Book book = bookOpt.get();
			if (book.isAvailable()) {
				loanDAO.addLoan(new Loan(memberOpt.get(), book));
				book.decrementCount();
				loanDAO.saveLoansToFile();
				bookDAO.saveBooksToFile();
				System.out.println("Book issued.");
			} else {
				System.out.println("Book not available.");
			}
		} else {
			System.out.println("Member or book not found.");
		}
	}

	/**
     * Processes the return of a borrowed book by a member.
     * 
     * @param memberId the ID of the member returning the book
     * @param title    the title of the book being returned
     */
    public void returnBook(String memberId, String title) {
        Optional<Loan> loanOpt = loanDAO.getAllLoans().stream()
            .filter(loan -> loan.getMember().getMemberId().equalsIgnoreCase(memberId))
            .filter(loan -> loan.getBook().getTitle().equalsIgnoreCase(title))
            .filter(loan -> loan.getStatus().equals("Borrowed"))
            .findFirst();
        
        if (loanOpt.isPresent()) {
        	Loan loan = loanOpt.get();
        	loanDAO.completeLoan(loan);
        	loan.getBook().incrementCount();
        	loanDAO.saveLoansToFile();
        	bookDAO.saveBooksToFile();
        	System.out.println("Book returned.");
        } else {        	
        	System.out.println("Active loan not found for this book/member.");
        }

	}

	/**
	 * Lists all loans in the system.
	 * 
	 * @return list of all loans
	 */
	public List<Loan> listAllLoans() {
		return loanDAO.getAllLoans();
	}

	/**
	 * Saves all persistent data related to books and loans.
	 */
	public void saveAllData() {
		bookDAO.saveBooksToFile();
		loanDAO.saveLoansToFile();
	}
}
