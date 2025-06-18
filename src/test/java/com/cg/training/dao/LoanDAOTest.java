package com.cg.training.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

import org.junit.jupiter.api.Test;

import com.cg.training.model.*;

/**
 * Unit test for {@link LoanDAO}. This test validates the contract
 * for loan management, including adding and completing a loan.
 * 
 * The following behaviors are tested:
 * <ul>
 *   <li>A loan can be added to the list of all loans.</li>
 *   <li>The status of a loan is updated correctly when marked as complete.</li>
 * </ul>
 * 
 * A simple in-memory list is used to simulate loan persistence.
 * 
 * @author Supriyo Pal
 */

class LoanDAOTest {

	/**
     * Tests the core contract of the {@link LoanDAO} interface.
     * Validates loan creation, storage, and completion functionality.
     */
	
    @Test void contract() {
        List<Loan> list = new ArrayList<>();
        LoanDAO dao = new LoanDAO() {
            public void addLoan(Loan lo){ list.add(lo); }
            public void completeLoan(Loan lo){ lo.completeLoan(); }
            public List<Loan> getAllLoans(){ return list; }
            public void saveLoansToFile(){/*no‑op*/}
        };
        Loan loan = new Loan(new Member("A","a@a"), new Book("T","A",1));
        dao.addLoan(loan);
        assertEquals(1, dao.getAllLoans().size());
        dao.completeLoan(loan);
        assertEquals("Returned", loan.getStatus());
    }
}
