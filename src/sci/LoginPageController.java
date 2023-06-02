/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package sci;

import sci.presenter.LoginPresenter;
import sci.model.User;
import sci.utils.AlertHelper;
import sci.utils.DatabaseUtil;
import sci.utils.Page;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 *
 * @author 
 * Name: Sudan Suwal
 * Student ID: 12199888
 */
public class LoginPageController implements Initializable, LoginPresenter.LoginView {
    
    
    @FXML
    TextField userField;
    
    @FXML
    PasswordField passwordField;
            
            
    LoginPresenter model = new LoginPresenter(this);
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        DatabaseUtil db = new DatabaseUtil();
        try {
            db.createDatabase();
            
        } catch (SQLException ex) {
            Logger.getLogger(LoginPageController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            db.createTables();
        } catch (SQLException ex) {
            Logger.getLogger(LoginPageController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }  
    
    @FXML
    private void onRegister(ActionEvent event) {
        System.out.println("Register");
        Page.redirect(event, getClass().getResource("RegisterPage.fxml"));
    }
    
    @FXML
    private void onLogin(ActionEvent event) {
        model.event = event;
        String email = userField.getText(), password = passwordField.getText();
        model.login(email, password);
    }
    
    //// Login Model
    @Override
    public void onLoginSuccess(ActionEvent event, User user) {
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("HomePage.fxml"));
            Parent root = fxmlLoader.load();
            HomePageController homePage = fxmlLoader.<HomePageController>getController();
            homePage.user = user;
            Scene scene = new Scene(root);
            stage.setScene(scene);
            
        } catch (IOException ex) {
            Logger.getLogger(LoginPageController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void onLoginError(Exception error) {
        AlertHelper.showError("Error", error.getLocalizedMessage());
    }
}
