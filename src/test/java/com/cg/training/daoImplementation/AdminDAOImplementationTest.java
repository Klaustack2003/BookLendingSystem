// src/test/java/com/cg/training/daoImplementation/AdminDAOImplementationTest.java
package com.cg.training.daoImplementation;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.cg.training.model.Admin;

/**
 * Unit test for {@link AdminDAOImplementation}. 
 * 
 * This test verifies the functionality of adding and retrieving admins 
 * from the DAO implementation.
 * 
 * Tested contract:
 * <ul>
 *   <li>An admin can be added using {@code addAdmin}.</li>
 *   <li>All added admins can be retrieved using {@code getAllAdmins}.</li>
 * </ul>
 * 
 * This test ensures that the internal storage reflects the correct list
 * of admins after insertion.
 * 
 * @author Subhadip Das
 */

class AdminDAOImplementationTest {

	 /**
     * Tests the addition and retrieval of an admin from the DAO implementation.
     */
	
    @Test void addGet() {
        AdminDAOImplementation dao = new AdminDAOImplementation();
        Admin a = new Admin("Ad", "ad@x.com");
        dao.addAdmin(a);
        assertEquals(Arrays.asList(a), dao.getAllAdmins());
    }
}
