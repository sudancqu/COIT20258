/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package sci;

import sci.presenter.AdminPresenter;
import sci.presenter.AdminPresenter.AdminModelObservable;
import sci.model.User;
import sci.utils.AlertHelper;
import sci.utils.Page;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 *
 * @author 
 * Name: Sudan Suwal
 * Student ID: 12199888
 */
public class AdminPageController implements Initializable, AdminModelObservable {
    
    User user;
    
    @FXML
    TextField searchField;
    
    @FXML
    TextArea message;
    
    AdminPresenter model = new AdminPresenter(this);
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    
    @FXML
    private void onSearch(ActionEvent event) {
        model.search(searchField.getText());
    }

    @Override
    public void onSearchSuccess(String message) {
        this.message.setText(message);
    }

    @Override
    public void onError(Exception error) {
        AlertHelper.showError("Error", error.getLocalizedMessage());
    }
    
    @FXML
    private void onLogout(ActionEvent event) {
        Page.redirect(event, getClass().getResource("LoginPage.fxml"));
    }
}
