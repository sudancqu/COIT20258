/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package sci;

import sci.model.SoftwareComponent;
import sci.model.User;
import sci.presenter.SCIPresenter;
import sci.presenter.SCIPresenter.SCIPresenterView;
import sci.utils.AlertHelper;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;

/**
 *
 * @author 
 * Name: Sudan Suwal
 * Student ID: 12199888
 */
public class SCIReportController implements Initializable, SCIPresenterView {
    
    User user;
    SCIPresenter presenter = new SCIPresenter(this);
    
    @FXML
    TextArea txtArea;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        txtArea.setText("Loading...");
        new java.util.Timer().schedule( 
        new java.util.TimerTask() {
            @Override
            public void run() {
                presenter.fetch(user.getId());
            }
        }, 
        500 
);

    }    

    @Override
    public void onFetched(List<SoftwareComponent> components) {
        txtArea.setText("");
        double total = 0;
        for(SoftwareComponent c: components) {
            txtArea.setText(txtArea.getText() + c.toString());
            total += c.getScore();
        }
        txtArea.setText(txtArea.getText() + "\n\n" + "Overall Score: " + total);
    }

    @Override
    public void onError(Exception error) {
        AlertHelper.showError("Error", error.getLocalizedMessage());
    }
    
    
}
