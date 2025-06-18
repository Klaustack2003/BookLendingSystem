package com.cg.training.daoImplementation;

import com.cg.training.dao.LibrarianDAO;
import com.cg.training.model.Librarian;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * LibrarianDAOImplementation provides an in-memory implementation of the 
 * {@link LibrarianDAO} interface for managing librarian data.
 * <p>
 * This implementation stores librarian records in a list without persistence.
 * </p>
 * 
 * @author Jayashree Roy
 */
public class LibrarianDAOImplementation implements LibrarianDAO {

    /**
     * Internal list to store librarian records.
     */
    private final List<Librarian> librarians = new ArrayList<>();

    /**
     * Adds a new Librarian to the internal list.
     *
     * @param librarian the Librarian object to be added; must not be null
     * @throws IllegalArgumentException if the librarian is null
     */
    @Override
    public void addLibrarian(Librarian librarian) {
        if (librarian == null) {
            throw new IllegalArgumentException("Librarian cannot be null");
        }
        librarians.add(librarian);
    }

    /**
     * Retrieves all librarians in the system.
     *
     * @return an unmodifiable List of Librarian objects; may be empty if no librarians exist
     */
    @Override
    public List<Librarian> getAllLibrarians() {
        return Collections.unmodifiableList(librarians);
    }
}
