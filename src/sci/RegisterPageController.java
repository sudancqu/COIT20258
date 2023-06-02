/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package sci;

import sci.presenter.RegisterPresenter;
import sci.model.User;
import sci.utils.AlertHelper;
import sci.utils.AlertHelper.AlertHelperInterface;
import sci.utils.Page;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Pattern;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 *
 * @author 
 * Name: Sudan Suwal
 * Student ID: 12199888
 */
public class RegisterPageController implements Initializable, RegisterPresenter.RegisterView {
       
    @FXML
    ChoiceBox roleField;
    
    @FXML
    TextField fullnameField, uniIdField, emailField;
    
    @FXML
    PasswordField passwordField;
    
    
    RegisterPresenter model = new RegisterPresenter(this);
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        roleField.getItems().add("Student/Staff");
        roleField.getItems().add("Manager");
        roleField.valueProperty().set("Student/Staff");
    }    
    
    @FXML
    private void onBack(ActionEvent event) {
        System.out.println("Back Pressed");
        Page.redirect(event, getClass().getResource("LoginPage.fxml"));
    }
    @FXML
    private void onRegister(ActionEvent event) {
        model.event = event;
        String password = passwordField.getText(), email = emailField.getText(), uniId = uniIdField.getText(), fullname = fullnameField.getText();
        model.register(fullname, email, uniId, password, roleField.valueProperty().getValue().toString().equals("Manager") ? 1 : 0);
    }

    @Override
    public void onRegisterSuccess(ActionEvent event, User user) {
        System.out.println("Success");
        AlertHelper.showSuccess("Success", "User Registered", new AlertHelperInterface() {
            @Override
            public void onOkay() {
                Page.redirect(event, getClass().getResource("LoginPage.fxml"));
            }  
        });
    }

    @Override
    public void onRegisterError(Exception error) {
        AlertHelper.showError("Error", error.getLocalizedMessage());
    }
    
    
}
