package com.cg.training.model;

import java.util.Objects;

/**
 * Represents a book with a title, author, count, and availability status.
 * <p>
 * The availability is determined by the count of books in stock.
 * </p>
 * 
 * @author Deeptangshu Saha
 */
public class Book {
    private final String title;
    private final String author;
    private int count;
    private boolean available;

    /**
     * Constructs a Book with the specified title, author, and initial count.
     * Availability is set based on the count being greater than zero.
     * 
     * @param title  the title of the book
     * @param author the author of the book
     * @param count  the initial number of copies available
     */
    public Book(String title, String author, int count) {
        this.title = title;
        this.author = author;
        this.count = count;
        this.available = count > 0;
    }

    /**
     * Returns the title of the book.
     * 
     * @return the book's title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Returns the author of the book.
     * 
     * @return the book's author
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Returns the current count of copies available for this book.
     * 
     * @return the number of copies available
     */
    public int getCount() {
        return count;
    }

    /**
     * Checks if the book is available for lending.
     * Availability requires both the internal flag and count > 0.
     * 
     * @return true if the book is available, false otherwise
     */
    public boolean isAvailable() {
        return available && count > 0;
    }

    /**
     * Sets the availability flag of the book.
     * 
     * @param available true to mark the book available, false otherwise
     */
    public void setAvailable(boolean available) {
        this.available = available;
    }

    /**
     * Increments the count of available copies by one and sets availability to true.
     */
    public void incrementCount() {
        count++;
        available = true;
    }

    /**
     * Decrements the count of available copies by one if count is greater than zero.
     * Updates availability accordingly.
     */
    public void decrementCount() {
        if (count > 0) count--;
        available = count > 0;
    }

    /**
     * Returns a formatted string containing details about the book.
     * 
     * @return formatted book details
     */
    public String bookDetails() {
        return String.format("Title: %s | Author: %s | Count: %d | Available: %b",
                title, author, count, isAvailable());
    }

    /**
     * Checks equality based on title and author.
     * 
     * @param o the object to compare with
     * @return true if both have the same title and author, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        return o instanceof Book &&
                Objects.equals(title, ((Book) o).title) &&
                Objects.equals(author, ((Book) o).author);
    }

    /**
     * Generates a hash code based on title and author.
     * 
     * @return hash code of the book
     */
    @Override
    public int hashCode() {
        return Objects.hash(title, author);
    }
}
