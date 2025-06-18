package com.cg.training.daoImplementation;

import com.cg.training.dao.LoanDAO;
import com.cg.training.model.Book;
import com.cg.training.model.Loan;
import com.cg.training.model.Member;

import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * LoanDAOImplementation provides an in-memory and file-based implementation 
 * of the {@link LoanDAO} interface. It supports adding, completing, retrieving, 
 * and persisting loan records.
 * <p>
 * Loans are saved and loaded from the file located at <code>resources/loans.txt</code>.
 * </p>
 * 
 * @author Debangshu Mandal
 */
public class LoanDAOImplementation implements LoanDAO {

    /**
     * Internal list to store loan records.
     */
    private final List<Loan> loans = new ArrayList<>();

    /**
     * Path to the file used for loan persistence.
     */
    private static final String LOAN_FILE = "resources/loans.txt";

    /**
     * Constructs a new LoanDAOImplementation and loads existing loans from file.
     */
    public LoanDAOImplementation() {
        loadLoansFromFile();
    }

    /**
     * Adds a new loan to the system.
     *
     * @param loan the Loan object to be added; must not be null
     * @throws IllegalArgumentException if the loan is null
     */
    @Override
    public void addLoan(Loan loan) {
        if (loan == null) {
            throw new IllegalArgumentException("Loan cannot be null");
        }
        loans.add(loan);
    }

    /**
     * Marks the specified loan as completed.
     *
     * @param loan the Loan to be completed; must not be null
     * @throws IllegalArgumentException if the loan is null
     */
    @Override
    public void completeLoan(Loan loan) {
        if (loan == null) {
            throw new IllegalArgumentException("Loan cannot be null");
        }
        loan.completeLoan();
    }

    /**
     * Retrieves all loan records.
     *
     * @return an unmodifiable List of Loan objects; may be empty if no loans exist
     */
    @Override
    public List<Loan> getAllLoans() {
        return Collections.unmodifiableList(loans);
    }

    /**
     * Saves all current loans to a file for persistence.
     * <p>
     * Each loan is serialized as a line in the format:
     * memberId;memberName;memberEmail;bookTitle;bookAuthor;bookCount;loanStatus
     * </p>
     *
     * @throws RuntimeException if an I/O error occurs during saving
     */
    @Override
    public void saveLoansToFile() {
        try {
            Path filePath = Paths.get(LOAN_FILE);
            Files.createDirectories(filePath.getParent()); // Ensure 'resources/' exists

            try (BufferedWriter writer = Files.newBufferedWriter(filePath)) {
                for (Loan loan : loans) {
                    writer.write(String.join(";", loan.getMember().getMemberId(),
                            loan.getMember().userDetails(), loan.getBook().getTitle(),
                            loan.getBook().getAuthor(), String.valueOf(loan.getBook().getCount()),
                            loan.getStatus()));
                    writer.newLine();
                }
            }
        } catch (IOException e) {
            System.err.println("Error saving loans: " + e.getMessage());
        }
    }

    /**
     * Loads loan records from the file and populates the internal list.
     * <p>
     * Each line in the file must contain at least 6 semicolon-separated fields.
     * </p>
     */
    private void loadLoansFromFile() {
        Path path = Paths.get(LOAN_FILE);
        if (!Files.exists(path)) return;

        try (Stream<String> lines = Files.lines(path)) {
            lines.map(line -> line.split(";"))
                 .filter(parts -> parts.length >= 6)
                 .map(parts -> new Loan(
                     new Member(parts[1], parts[2]), // name, email
                     new Book(parts[2], parts[3], Integer.parseInt(parts[4]))
                 ))
                 .forEach(loans::add);
        } catch (IOException e) {
            System.err.println("Error loading loans: " + e.getMessage());
        }
    }
}
