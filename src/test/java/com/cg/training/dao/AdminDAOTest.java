package com.cg.training.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

import org.junit.jupiter.api.Test;

import com.cg.training.model.Admin;

/**
 * Test class for AdminDAO interface implementation.
 * Contains unit tests to verify the contract of AdminDAO.
 * 
 * @author Subhadip Das
 */
class AdminDAOTest {
    
    /**
     * Tests the basic contract of the AdminDAO interface.
     * Verifies that adding an admin and retrieving all admins works as expected.
     * 
     * @implNote Creates an anonymous implementation of AdminDAO for testing purposes
     */
    @Test 
    void contract() {
        // Create a list to simulate the data store
        List<Admin> list = new ArrayList<>();
        
        // Create an anonymous implementation of AdminDAO for testing
        AdminDAO dao = new AdminDAO() {
            /**
             * Adds an admin to the test list
             * @param a the Admin object to add
             */
            public void addAdmin(Admin a) { 
                list.add(a); 
            }
            
            /**
             * Retrieves all admins from the test list
             * @return List of all Admin objects
             */
            public List<Admin> getAllAdmins() { 
                return list; 
            }
        };
        
        // Create a test admin
        Admin a = new Admin("n","e");
        
        // Add the admin through the DAO
        dao.addAdmin(a);
        
        // Verify the admin was added and can be retrieved
        assertEquals(Arrays.asList(a), dao.getAllAdmins());
    }
}