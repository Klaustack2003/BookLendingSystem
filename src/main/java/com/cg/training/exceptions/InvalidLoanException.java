package com.cg.training.exceptions;

/**
 * Exception thrown when an invalid loan operation occurs in the library system.
 * <p>
 * This custom exception is used to signal problems such as unauthorized access,
 * book not being available, role violation, or any issue during the book loan/removal process.
 * </p>
 * 
 * <p>
 * It extends the standard Exception class, allowing it to be used
 * in both checked and custom exception handling flows within the application.
 * </p>
 * 
 * @author Gourav Patra
 */

public class InvalidLoanException extends Exception {

    /**
     * Constructs a new {@code InvalidLoanException} with a detailed message.
     *
     * @param message A descriptive message explaining the reason for the exception.
     */
    public InvalidLoanException(String message) {
        super(message);
    }
}

