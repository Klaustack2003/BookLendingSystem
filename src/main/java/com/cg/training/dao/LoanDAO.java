package com.cg.training.dao;

import com.cg.training.model.Loan;

import java.util.List;

/**
 * LoanDAO is a Data Access Object interface for handling operations 
 * related to Loan entities. It allows adding new loans, marking loans 
 * as complete, retrieving all loans, and saving loan data to a file.
 * <p>
 * Implementations of this interface provide persistence logic for 
 * loan management in a library system.
 * </p>
 * 
 * @author Debangshu Mandal
 */
public interface LoanDAO {

    /**
     * Adds a new Loan to the data source.
     *
     * @param loan the Loan object to be added; must not be null
     * @throws IllegalArgumentException if the loan is null or contains invalid data
     */
    void addLoan(Loan loan);

    /**
     * Marks an existing Loan as completed in the data source.
     *
     * @param loan the Loan object to be marked as complete; must not be null
     * @throws IllegalArgumentException if the loan is null or not found
     */
    void completeLoan(Loan loan);

    /**
     * Retrieves all Loan records from the data source.
     *
     * @return a List of Loan objects; may be empty if no loans are found
     */
    List<Loan> getAllLoans();

    /**
     * Saves the current list of loans to a file.
     *
     * @throws RuntimeException if an I/O error occurs while saving the loans
     */
    void saveLoansToFile();
}
