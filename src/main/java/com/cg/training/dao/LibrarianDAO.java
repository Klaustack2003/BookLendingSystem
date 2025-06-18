package com.cg.training.dao;

import com.cg.training.model.Librarian;

import java.util.List;

/**
 * LibrarianDAO is a Data Access Object interface for managing operations 
 * related to Librarian entities, such as adding a new librarian and 
 * retrieving all librarians from the data source.
 * <p>
 * Implementations of this interface will provide the actual logic to 
 * persist and access Librarian data.
 * </p>
 * 
 * @author Jayashree Roy
 */
public interface LibrarianDAO {

    /**
     * Adds a new Librarian to the data source.
     *
     * @param librarian the Librarian object to be added; must not be null
     * @throws IllegalArgumentException if the librarian is null or contains invalid data
     */
    void addLibrarian(Librarian librarian);

    /**
     * Retrieves a list of all Librarians from the data source.
     *
     * @return a List of Librarian objects; may be empty if no librarians are found
     */
    List<Librarian> getAllLibrarians();
}
