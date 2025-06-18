package com.cg.training.util;

import java.util.function.Predicate;
import java.util.regex.Pattern;

/**
 * Utility class for validating input strings such as names, emails, book titles, and authors.
 * <p>
 * Provides static methods to validate:
 * <ul>
 *   <li>Name: Letters and spaces, 2 to 50 characters</li>
 *   <li>Email: Standard email format with domain rules</li>
 *   <li>Title: Letters, digits, whitespace, and common punctuation (2 to 100 characters)</li>
 *   <li>Author: Same pattern as name validation</li>
 * </ul>
 * </p>
 * 
 * @author Manideep Singh
 */
public class ValidationUtility {

    //Validation pattern
    private static final Pattern EMAIL_PATTERN = 
        Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$");
    // ✅ Name: Only letters and spaces, 2–50 characters
    private static final Predicate<String> NAME_VALIDATOR =
            Pattern.compile("^[A-Za-z ]{2,50}$").asPredicate();

    // ✅ Email: Standard email pattern with domain rules
    private static final Predicate<String> EMAIL_VALIDATOR =
            Pattern.compile("^[\\w.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$").asPredicate();

    // ✅ Title: Letters, digits, punctuation
    private static final Predicate<String> TITLE_VALIDATOR =
            Pattern.compile("^[\\w\\s.,!?()'\"-]{2,100}$").asPredicate();

    // ✅ Author: Same as name
    private static final Predicate<String> AUTHOR_VALIDATOR =
            Pattern.compile("^[A-Za-z ]{2,50}$").asPredicate();

    /**
     * Checks if the given name is valid according to the defined pattern.
     *
     * @param name the name string to validate
     * @return true if valid, false otherwise
     */
    public static boolean isValidName(String name) {
        return name != null && NAME_VALIDATOR.test(name);
    }

    /**
     * Checks if the given email is valid according to the defined pattern.
     *
     * @param email the email string to validate
     * @return true if valid, false otherwise
     */
    public static boolean isValidEmail(String email) {
        return email != null && EMAIL_VALIDATOR.test(email);
    }

    /**
     * Checks if the given book title is valid according to the defined pattern.
     *
     * @param title the title string to validate
     * @return true if valid, false otherwise
     */
    public static boolean isValidTitle(String title) {
        return title != null && TITLE_VALIDATOR.test(title);
    }

    /**
     * Checks if the given author name is valid according to the defined pattern.
     *
     * @param author the author string to validate
     * @return true if valid, false otherwise
     */
    public static boolean isValidAuthor(String author) {
        return author != null && AUTHOR_VALIDATOR.test(author);
    }
}
