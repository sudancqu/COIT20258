/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cftes.presenter;

import cftes.model.User;
import java.sql.SQLException;
import javafx.event.ActionEvent;

/**
 *
 * @author 
 * Name: Sudan Suwal
 * Student ID: 12199888
 */
public class RegisterModel {
    public interface RegisterModelObservable {
        void onRegisterSuccess(ActionEvent event, User user);
        void onRegisterError(Exception error);
    }
    
    private RegisterModelObservable observable;
    public ActionEvent event;
    private Persister userDb;
    
    public RegisterModel(RegisterModelObservable observable) {
        this.observable = observable;
        this.userDb = new Persister();
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
