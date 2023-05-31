/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package cftes;

//import cftes.presenter.EmissionModel;
import cftes.model.SoftwareComponent;
import cftes.presenter.EquipmentEnums;
import cftes.model.User;
import cftes.presenter.ComponentPresenter;
import cftes.utils.AlertHelper;
import cftes.utils.AlertHelper.AlertHelperInterface;
import cftes.utils.Page;
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
public class HomePageController implements Initializable, ComponentPresenter.ComponentPresenterView {
    
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
        
        String component = softwareComponentTxtField.getText();
        double energy = Double.parseDouble(energyTxtField.getText());
        double eFactor = Double.parseDouble(emissionFactorTxtField.getText());
        double embodiedEmission = Double.parseDouble(embodiedEmissionTxtField.getText());
        presenter.save(new SoftwareComponent(component, energy, eFactor,embodiedEmission), user.getId());
        
        
        
//        String eq = equipmentChoice.valueProperty().getValue().toString();
//        String feat = featureChoice.valueProperty().getValue().toString();
//        List<SoftwareComponent> equips = equipments.stream().filter(e -> e.getEquipmentName().equals(eq)).collect(Collectors.toList());
//        List<SoftwareComponent> feats = features.stream().filter(e -> e.getEquipmentName().equals(feat)).collect(Collectors.toList());
////        model.save(user.getId(), equipmentChoice.getValue().toString(), emissionValue);     
//        if(equips.size() > 0 && feats.size() > 0) {
//            double val1 = equips.get(0).getValue();
//            double val2 = feats.get(0).getValue();
//            double result = val1 - val1* 0.15 + val2;
//            model.save(user.getId(), result);
//        }
    }

//    @Override
//    public void onSaveSuccess(ActionEvent event, String message) {
//        AlertHelper.showSuccess("Success", message, new AlertHelperInterface() {
//            @Override
//            public void onOkay() {
//            }  
//        });
//    }
//
//    @Override
//    public void onError(Exception error) {
//        AlertHelper.showError("Error", error.getLocalizedMessage());
//    }

//    @Override
//    public void onFetchedEquipment(List<SoftwareComponent> e) {
//        equipments = e;
//        for(SoftwareComponent eq: e) {
//            equipmentChoice.getItems().add(eq);
//        }
//        equipmentChoice.valueProperty().set(e.get(0));
//    }
//
//    @Override
//    public void onFetchedFeature(List<SoftwareComponent> e) {
//        features = e;
//        for(SoftwareComponent eq: e) {
//            featureChoice.getItems().add(eq);
//        }
//        featureChoice.valueProperty().set(e.get(0));
//    }
    
    
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
