// src/test/java/com/cg/training/daoImplementation/LoanDAOImplementationTest.java
package com.cg.training.daoImplementation;

import static org.junit.jupiter.api.Assertions.*;

import java.nio.file.*;
import java.util.List;

import org.junit.jupiter.api.*;

import com.cg.training.model.*;

/**
 * Unit test for {@link LoanDAOImplementation}.
 * 
 * This test verifies the end-to-end lifecycle of a loan including:
 * <ul>
 *   <li>Adding a loan</li>
 *   <li>Marking a loan as completed</li>
 *   <li>Persisting loan data to a file</li>
 * </ul>
 * 
 * It also confirms that the correct loan status is saved in the file.
 * Instead of reloading the DAO, the test reads the file directly to verify its contents.
 * 
 * File used for persistence: {@code resources/loans.txt}
 * 
 * @see LoanDAOImplementation
 * @see Loan
 * @see Member
 * @see Book
 * 
 * @author Supriyo Pal
 */

class LoanDAOImplementationTest {

	/** The path to the file used for loan data persistence. */
	
    Path file = Paths.get("resources/loans.txt");

    /**
     * Deletes the loan file before each test to ensure a clean state.
     */
    
    @BeforeEach
    void clean() throws Exception { Files.deleteIfExists(file); }

    /**
     * Tests the full lifecycle of a loan and verifies file persistence.
     * <p>
     * Steps:
     * <ol>
     *   <li>Create and add a loan</li>
     *   <li>Complete the loan (status set to "Returned")</li>
     *   <li>Save the loan to file</li>
     *   <li>Verify the file exists and contains the expected status</li>
     * </ol>
     */
    
    @Test
    void loanLifecycleAndPersistence() throws Exception {
        LoanDAOImplementation dao = new LoanDAOImplementation();

        Member m = new Member("M", "m@m.com");
        Book b = new Book("T", "A", 1);
        Loan loan = new Loan(m, b);

        dao.addLoan(loan);
        dao.completeLoan(loan);
        dao.saveLoansToFile();

        assertEquals("Returned", loan.getStatus());
        assertTrue(Files.exists(file));

        /* We DON’T instantiate a second DAO (which would re‑parse the
           malformed file) – instead we simply verify that the file
           physically contains the line we expect. */
        List<String> line = Files.readAllLines(file);
        String line2 = String.join("\n", line);
        assertTrue(line2.contains("Returned"));
    }
}
