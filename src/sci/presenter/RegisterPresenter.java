/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sci.presenter;

import sci.model.User;
import java.sql.SQLException;
import java.util.regex.Pattern;
import javafx.event.ActionEvent;

/**
 *
 * @author 
 * Name: Sudan Suwal
 * Student ID: 12199888
 */
public class RegisterPresenter {
    public interface RegisterView {
        void onRegisterSuccess(ActionEvent event, User user);
        void onRegisterError(Exception error);
    }
    
    private RegisterView observable;
    public ActionEvent event;
    private Persister userDb;
    
    public RegisterPresenter(RegisterView observable) {
        this.observable = observable;
        this.userDb = new Persister();
    }
    
    public boolean validatePassword(String password) {
        Pattern pattern = Pattern.compile("^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$");
        return pattern.matcher(password).matches();
    }
    
    public boolean validateEmail(String email) {
        Pattern pattern = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
        return pattern.matcher(email).matches();
    }
    
    public void register(String fullname, String email, String universityId, String password, int role) {
        
        if(fullname.equals("")) {
            observable.onRegisterError(new Exception("Fullname cannot be empty"));
            return;
        }
        if(email.equals("")) {
            observable.onRegisterError(new Exception("Email cannot be empty"));
            return;
        }
        if(!validatePassword(password)) {
            observable.onRegisterError(new Exception("Password must contain minimum 8 characters, at least one letter and one number"));
            return;
        }
        if(!validateEmail(email)) {
            observable.onRegisterError(new Exception("Invalid email format"));
            return;
        }
        if(universityId.equals("")) {
            observable.onRegisterError(new Exception("University Id cannot be empty"));
            return;
        }
        if(password.equals("")) {
            observable.onRegisterError(new Exception("Password cannot be empty"));
            return;
        }
        
        try {
            userDb.register(fullname, email, universityId, password, role);
            observable.onRegisterSuccess(event, new User());
        } catch (SQLException ex) {
            observable.onRegisterError(ex);
        }
        
    }
}
