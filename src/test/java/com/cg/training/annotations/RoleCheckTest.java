package com.cg.training.annotations;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.annotation.Annotation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Dummy class annotated with RoleCheck specifying role as "Tester".
 * 
 * @author Supriyo Pal
 */
@RoleCheck(role = "Tester")
class Dummy {}

/**
 * Unit test class for testing the RoleCheck annotation.
 * <p>
 * Tests presence of the annotation on Dummy class,
 * verifies explicit role value and default role value defined in annotation interface.
 * </p>
 */
class RoleCheckTest {

    @Test
    @DisplayName("Annotation present with default and explicit role")
    void roleCheckWorks() throws NoSuchMethodException, SecurityException {
        // Retrieve RoleCheck annotation from Dummy class
        Annotation ann = Dummy.class.getAnnotation(RoleCheck.class);
        assertNotNull(ann, "RoleCheck annotation should be present");

        // Cast annotation and verify explicit role value
        RoleCheck rc = (RoleCheck) ann;
        assertEquals("Tester", rc.role(), "Role value should be 'Tester'");

        // Verify the default value of the role attribute in RoleCheck annotation
        
            assertEquals("Admin", RoleCheck.class.getMethod("role").getDefaultValue(),
                "Default role value should be 'Admin'");
       
    }
    
    @Test
    @DisplayName("Annotation present with default and explicit role")
    void roleCheckWorks1() throws NoSuchMethodException, SecurityException {
        // Retrieve RoleCheck annotation from Dummy class
        Annotation ann = Dummy.class.getAnnotation(RoleCheck.class);
        assertNotNull(ann, "RoleCheck annotation should be present");

        // Cast annotation and verify explicit role value
        RoleCheck rc = (RoleCheck) ann;
        assertEquals("Tester", rc.role(), "Role value should be 'Tester'");

        // Verify the default value of the role attribute in RoleCheck annotation
        
            assertNotEquals("User", RoleCheck.class.getMethod("role").getDefaultValue(),
                "Default role value should be 'Admin'");
        
    }
    
    @Test
    @DisplayName("Annotation present with default and explicit role")
    void roleCheckWorks2() throws NoSuchMethodException, SecurityException {
        // Retrieve RoleCheck annotation from Dummy class
        Annotation ann = Dummy.class.getAnnotation(RoleCheck.class);
        assertNotNull(ann, "RoleCheck annotation should be present");

        // Cast annotation and verify explicit role value
        RoleCheck rc = (RoleCheck) ann;
        assertEquals("Tester", rc.role(), "Role value should be 'Tester'");

        // Verify the default value of the role attribute in RoleCheck annotation
       
            assertNotEquals("Librarian", RoleCheck.class.getMethod("role").getDefaultValue(),
                "Default role value should be 'Admin'");
        
    }
    
    @Test
    @DisplayName("Annotation present with default and explicit role")
    void roleCheckWorks3() throws NoSuchMethodException, SecurityException {
        // Retrieve RoleCheck annotation from Dummy class
        Annotation ann = Dummy.class.getAnnotation(RoleCheck.class);
        assertNotNull(ann, "RoleCheck annotation should be present");

        // Cast annotation and verify explicit role value
        RoleCheck rc = (RoleCheck) ann;
        assertEquals("Tester", rc.role(), "Role value should be 'Tester'");

        // Verify the default value of the role attribute in RoleCheck annotation
        
            assertNotEquals("Member", RoleCheck.class.getMethod("role").getDefaultValue(),
                "Default role value should be 'Admin'");
        
    }
}
