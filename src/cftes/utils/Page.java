/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cftes.utils;

import java.io.IOException;
import java.net.URL;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Sudan
 */
public class Page {
    
    
    public static void redirect(ActionEvent event, URL url) {
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(url);
            Parent root = fxmlLoader.load();
//            PatientHomePage homePage = fxmlLoader.<PatientHomePage>getController();
//            homePage.setPatientId(patientId, false);
            Scene scene = new Scene(root);
            stage.setScene(scene);    
        } catch (IOException ex) {
//            Logger.getLogger(LoginPage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
