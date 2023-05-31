/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package cftes.test;

import cftes.presenter.LoginPresenter;
import cftes.model.User;
import javafx.event.ActionEvent;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Sudan
 */
public class TestClassTest implements LoginPresenter.LoginModelObservable {
    
    LoginPresenter loginModel;
    
    public TestClassTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
        
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
        loginModel = new LoginPresenter(this);
    }
    
    @AfterEach
    public void tearDown() {
    }

    @Test
    public void testSomeMethod() {
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
    public void testLogin() {
       loginModel.login("sudosuwal@gmail.com", "password");
    }

    @Override
    public void onLoginSuccess(ActionEvent event, User user) {
        assertTrue(true);
    }

    @Override
    public void onLoginError(Exception error) {
        assertFalse(true);
    }
    
}
