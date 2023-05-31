/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cftes.presenter;

import cftes.model.SoftwareComponent;
import cftes.utils.DatabaseUtil;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javafx.event.ActionEvent;

/**
 *
 * @author 
 * Name: Sudan Suwal
 * Student ID: 12199888
 */
public class AdminPresenter {
    public interface AdminModelObservable {
        void onSearchSuccess(String message);
        void onError(Exception error);
    }
    private AdminModelObservable observable;
    String SEARCHQUERY = "SELECT users.id as id, users.fullname as fullname, users.email as email, users.universityId as universityId, report.value as value FROM users, `report`where users.email='%s' AND users.id=report.user_id";
    
    public AdminPresenter(AdminModelObservable observable) {
        this.observable = observable;
    }
    
    public void search(String query) {
        DatabaseUtil db = new DatabaseUtil();
        try {
            ResultSet rs = db.run(String.format(SEARCHQUERY, query));
            List<SoftwareComponent> emissions = new ArrayList();
            StringBuilder sb = new StringBuilder();
            while(rs.next()) {
                String id = rs.getString("id");
                String name = rs.getString("fullname");
                String email = rs.getString("email");
                String universityId = rs.getString("universityId");
                double value = rs.getDouble("value");
                sb.append("ID: " + id + "\nFullname: " + name + "\nEmail: " + email + "\nUniversity Id: " + universityId + "\nTOTAL CARBON FOOTPRINT: " + value + "kg\n\n");
            }
            observable.onSearchSuccess(sb.toString());
        } catch (SQLException ex) {
            observable.onError(ex);
        }
    }
}
