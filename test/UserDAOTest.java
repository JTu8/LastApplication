/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author htmjs
 */
public class UserDAOTest {
    
    public UserDAOTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getUsers method, of class UserDAO.
     */
    @Test
    public void testGetUsers() {
        System.out.println("getUsers");
        UserDAO instance = new UserDAO();
        Users expResult = null;
        Users result = instance.getUsers();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        instance.getUsers();
    }

    /**
     * Test of getUser method, of class UserDAO.
     */
    @Test
    public void testGetUser() {
        System.out.println("getUser");
        String nimi = "";
        String salasana = "";
        UserDAO instance = new UserDAO();
        User expResult = null;
        User result = instance.getUser(nimi, salasana);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        instance.getUser("Testi", "sala");
    }

    /**
     * Test of addUser method, of class UserDAO.
     */
    @Test
    public void testAddUser() {
        System.out.println("addUser");
        String nimi = "";
        String salasana = "";
        String kuvaus = "";
        UserDAO instance = new UserDAO();
        Users expResult = null;
        Users result = instance.addUser(nimi, salasana, kuvaus);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteUser method, of class UserDAO.
     */
    @Test
    public void testDeleteUser() {
        System.out.println("deleteUser");
        String nimi = "";
        UserDAO instance = new UserDAO();
        instance.deleteUser(nimi);
        // TODO review the generated test code and remove the default call to fail.
        instance.deleteUser("Testi");
    }
    
}
