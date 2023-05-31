/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cftes.utils;

import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

/**
 *
 * @author Sudan
 */
public class AlertHelper {
    
    public static interface AlertHelperInterface {
        public void onOkay();
    }
    
    // Show Error message
    public static void showError(String title, String errorMessage) {
        Alert a = new Alert(Alert.AlertType.ERROR);
        a.setTitle(title);
        a.setContentText(errorMessage);
        a.showAndWait();
        
    }
    
    // Show Success message
    public static void showSuccess(String title, String successMessage, AlertHelperInterface handler) {
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setTitle(title);
        a.setContentText(successMessage);
        Optional<ButtonType> result = a.showAndWait();
        if(!result.isPresent())
           Logger.getLogger(AlertHelper.class.getName()).log(Level.SEVERE, "Cancelled");
        else if(result.get() == ButtonType.OK)
            handler.onOkay();
    // cancel button is pressed
    }
}
