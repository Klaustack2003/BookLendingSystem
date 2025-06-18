package com.cg.training.model;

/**
 * Represents a loan of a book to a member.
 * <p>
 * Contains references to the member and book involved in the loan, along with
 * the current status of the loan ("Borrowed" or "Returned").
 * </p>
 * 
 * @author Deeptangshu Saha
 */
public class Loan {
    private final Member member;
    private final Book book;
    private String status;

    /**
     * Constructs a Loan instance for a given member and book.
     * The status is initially set to "Borrowed" and the book is marked as unavailable.
     * 
     * @param member the member borrowing the book
     * @param book   the book being loaned
     */
    public Loan(Member member, Book book) {
        this.member = member;
        this.book = book;
        this.status = "Borrowed";
        book.setAvailable(false);
    }

    /**
     * Returns the member involved in this loan.
     * 
     * @return the member who borrowed the book
     */
    public Member getMember() {
        return member;
    }

    /**
     * Returns the book involved in this loan.
     * 
     * @return the book being loaned
     */
    public Book getBook() {
        return book;
    }

    /**
     * Returns the current status of the loan.
     * 
     * @return the loan status, e.g., "Borrowed" or "Returned"
     */
    public String getStatus() {
        return status;
    }

    /**
     * Marks the loan as complete by setting the status to "Returned"
     * and marking the book as available.
     */
    public void completeLoan() {
        this.status = "Returned";
        book.setAvailable(true);
    }

    /**
     * Returns a formatted string containing details of the loan,
     * including member details, book details, and loan status.
     * 
     * @return formatted loan details string
     */
    public String loanDetails() {
        return String.format("%s | %s | Status: %s",
                member.userDetails(), book.bookDetails(), status);
    }
}
