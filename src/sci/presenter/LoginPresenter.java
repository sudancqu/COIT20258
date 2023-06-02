/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sci.presenter;

import sci.model.User;
import sci.utils.DatabaseUtil;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;

/**
 *
 * @author 
 * Name: Sudan Suwal
 * Student ID: 12199888
 */
public class LoginPresenter {
    
    public interface LoginView {
        void onLoginSuccess(ActionEvent event, User user);
        void onLoginError(Exception error);
    }
    
    private final String SELECTUSERQUERY = "SELECT `id`, `fullname`, `email`, `universityId`, `role` FROM `users` WHERE `email`='%s' AND `password`='%s'";
    private LoginView observable;
    public ActionEvent event;
    private Persister userDb;
    
    public LoginPresenter(LoginView observable) {
        this.observable = observable;
        this.userDb = new Persister();
    }
    
    
    public void login(String username, String password) {
        if(username.equals("") || password.equals("")) {
            observable.onLoginError(new Exception("Username and Password cannot be empty"));
            return;
        }
        try {
            User user = userDb.login(username, password);
            observable.onLoginSuccess(event,user);
        } catch (SQLException ex) {
            observable.onLoginError(ex);
        } catch (Exception ex) {
            observable.onLoginError(new Exception("No User Found"));
        }
        
    }
    
}
