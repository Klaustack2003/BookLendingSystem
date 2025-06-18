package com.cg.training.dao;

import com.cg.training.model.Book;

import java.util.List;
import java.util.Optional;

/**
 * BookDAO is a Data Access Object interface for managing operations related 
 * to Book entities such as adding, removing, retrieving, and saving books.
 * <p>
 * Implementations of this interface handle the persistence and retrieval 
 * logic for Book objects.
 * </p>
 * 
 * @author Debangshu Mandal
 */
public interface BookDAO {

    /**
     * Adds a new Book to the data source.
     *
     * @param book the Book object to be added; must not be null
     * @throws IllegalArgumentException if the book is null or contains invalid data
     */
    void addBook(Book book);

    /**
     * Removes a Book from the data source based on its title.
     *
     * @param title the title of the book to be removed; must not be null or empty
     * @throws IllegalArgumentException if the title is null or empty
     */
    void removeBook(String title);

    /**
     * Finds and retrieves a Book from the data source by its title.
     *
     * @param title the title of the book to search for; must not be null or empty
     * @return an Optional containing the found Book, or empty if no book with the given title is found
     * @throws IllegalArgumentException if the title is null or empty
     */
    Optional<Book> findBookByTitle(String title);

    /**
     * Retrieves all Books from the data source.
     *
     * @return a List of all Book objects; may be empty if no books are found
     */
    List<Book> getAllBooks();

    /**
     * Saves the current list of books to a file.
     *
     * @throws RuntimeException if an I/O error occurs while saving the books
     */
    void saveBooksToFile();
}
