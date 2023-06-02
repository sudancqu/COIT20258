package sci.presenter;

///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package cftes.presenter;
//
//import cftes.model.SoftwareComponent;
//import cftes.utils.DatabaseUtil;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//import javafx.event.ActionEvent;
//
///**
// *
// * @author Sudan
// */
//public class EmissionModel {
//    public interface EmissionModelObservable {
//        void onSaveSuccess(ActionEvent event, String message);
//        void onError(Exception error);
//        void onFetchedEquipment(List<SoftwareComponent> e);
//        void onFetchedFeature(List<SoftwareComponent> e);
//    }
//    private EmissionModelObservable observable;
//    public ActionEvent event;
//    
//    private final String INSERTQUERY = "INSERT INTO `report`(`user_id`, `value`) VALUES ('%s','%f')";
//    private final String GETEQUIPQUERY = "SELECT `id`, `equipment_name`, `value`, `isFeature` FROM `emission_values` WHERE `isFeature`=0";
//    private final String GETFEATQUERY = "SELECT `id`, `equipment_name`, `value`, `isFeature` FROM `emission_values` WHERE `isFeature`=1";
//
//    
//    public EmissionModel(EmissionModelObservable observable) {
//        this.observable = observable;
//    }
//    
//    public void save(String userId, double value) {
//        DatabaseUtil db = new DatabaseUtil();
//        try {
//            db.run_noresult(String.format(INSERTQUERY, userId, value));
//            observable.onSaveSuccess(event, "You CF value is " + value);
//        } catch (SQLException ex) {
//            observable.onError(ex);
//        }
//    }
//    
//    public void fetchEquipmentLists() {
//        DatabaseUtil db = new DatabaseUtil();
//        try {
//            ResultSet rs = db.run(GETEQUIPQUERY);
//            List<SoftwareComponent> emissions = new ArrayList();
//            while(rs.next()) {
//                int id = rs.getInt("id");
//                String name = rs.getString("equipment_name");
//                double value = rs.getDouble("value");
//                emissions.add(new SoftwareComponent(name, id, value));
//            }
//            observable.onFetchedEquipment(emissions);
//        } catch (SQLException ex) {
//            observable.onError(ex);
//        }
//    }
//    
//    public void fetchFeatureLists() {
//        DatabaseUtil db = new DatabaseUtil();
//        try {
//            ResultSet rs = db.run(GETFEATQUERY);
//            List<SoftwareComponent> emissions = new ArrayList();
//            while(rs.next()) {
//                int id = rs.getInt("id");
//                String name = rs.getString("equipment_name");
//                double value = rs.getDouble("value");
//                emissions.add(new SoftwareComponent(name, id, value));
//            }
//            observable.onFetchedFeature(emissions);
//        } catch (SQLException ex) {
//            observable.onError(ex);
//        }
//    }
//}
