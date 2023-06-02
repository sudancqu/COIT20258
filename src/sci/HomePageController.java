/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package sci;

//import cftes.presenter.EmissionModel;
import sci.model.SoftwareComponent;
import sci.presenter.EquipmentEnums;
import sci.model.User;
import sci.presenter.ComponentPresenter;
import sci.utils.AlertHelper;
import sci.utils.AlertHelper.AlertHelperInterface;
import sci.utils.Page;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author 
 * Name: Sudan Suwal
 * Student ID: 12199888
 */
public class HomePageController implements Initializable, ComponentPresenter.ComponentView {
    
    User user;
//    
//    @FXML
//    ChoiceBox equipmentChoice, featureChoice;
//    
//    @FXML
//    TextField emissionField;
//    
//    List<SoftwareComponent> features;
//    List<SoftwareComponent> equipments;
    
    @FXML
    TextField softwareComponentTxtField, energyTxtField, emissionFactorTxtField, embodiedEmissionTxtField; 
    ComponentPresenter presenter = new ComponentPresenter(this);
//    EmissionModel model = new EmissionModel(this);
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
//        model.fetchEquipmentLists();
//        model.fetchFeatureLists();
    }    
    
    @FXML
    private void onLogout(ActionEvent event) {
        Page.redirect(event, getClass().getResource("LoginPage.fxml"));
    }
    
    @FXML
    private void onSave(ActionEvent event) {
        try {
            String component = softwareComponentTxtField.getText();
            double energy = Double.parseDouble(energyTxtField.getText());
            double eFactor = Double.parseDouble(emissionFactorTxtField.getText());
            double embodiedEmission = Double.parseDouble(embodiedEmissionTxtField.getText());
            presenter.save(new SoftwareComponent(component, energy, eFactor,embodiedEmission), user.getId());
        } catch (NumberFormatException ex) {
            onError(ex);
        }

    }
    
    
    void clear() {
        softwareComponentTxtField.clear();
        energyTxtField.clear();
        emissionFactorTxtField.clear();
        embodiedEmissionTxtField.clear();
    }
    
    @Override
    public void onSaved() {
        clear();
        AlertHelper.showSuccess("Success", "Data Added!", new AlertHelperInterface() {
                    @Override
                    public void onOkay() {
                    }  
                });
    }

    @Override
    public void onError(Exception error) {
        AlertHelper.showError("Error", error.getLocalizedMessage());
    }
    
    @FXML
    private void onView(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("SCIReport.fxml"));
            Parent root1 = fxmlLoader.load();
            System.out.println(fxmlLoader.getController().getClass());
            SCIReportController controller = fxmlLoader.<SCIReportController>getController();
            controller.user = user;
            Stage stage = new Stage();
//            stage.initModality(Modality.APPLICATION_MODAL);
//            stage.initStyle(StageStyle.UNDECORATED);
            stage.setTitle("Report");
            stage.setScene(new Scene(root1));  
            stage.show();
        } catch(IOException e) {
            System.out.println(e.getLocalizedMessage());
            onError(e);
        }
    }
    
}