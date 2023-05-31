/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cftes.presenter;

import cftes.model.SoftwareComponent;
import cftes.model.User;
import cftes.utils.DatabaseUtil;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 
 * Name: Sudan Suwal
 * Student ID: 12199888
 */
public class Persister {
    private final String SELECTUSERQUERY = "SELECT `id`, `fullname`, `email`, `universityId`, `role` FROM `users` WHERE `email`='%s' AND `password`='%s'";
    String REGISTERQUERY = "INSERT INTO `users`(`fullname`, `email`, `universityId`, `password`, `role`) VALUES ('%s','%s','%s','%s','%d')";
     String INSERTCOMPONENTQUERY = "INSERT INTO `software_component` (`name`, `energy`, `emission_factor`, `embodied_emission`, `score`, `user_id`) VALUES ('%s', '%f', '%f', '%f', '%f', '%s')";
    String FETCHCOMPONENTQUERY = "SELECT * FROM `software_component` WHERE user_id='%s'";
            
            
    public void register(String fullname, String email, String universityId, String password, int role) throws SQLException {
        DatabaseUtil db = new DatabaseUtil();
        try {
            db.run_noresult(String.format(REGISTERQUERY, fullname, email, universityId, password, role));
        } catch (SQLException ex) {
            throw new SQLException(ex);
        }
    }
    
    public User login(String username, String password) throws Exception {
        DatabaseUtil db = new DatabaseUtil();
        try {
            ResultSet rs = db.run(String.format(SELECTUSERQUERY, username, password));
            if(rs.next()) {
                String id = rs.getString("id");
                String fullname = rs.getString("fullname");
                String email = rs.getString("email");
                String universityId = rs.getString("universityId");
                int rl = rs.getInt("role");
                return new User(id, fullname, email, universityId, rl);
            } else {
                throw new Exception("No User Found");
            }
        } catch (SQLException ex) {
            throw new SQLException(ex);
        }
    }
    
    public List<SoftwareComponent> fetchComponents(String userId) throws SQLException {
        DatabaseUtil db = new DatabaseUtil();
        try {
            ResultSet rs = db.run(String.format(FETCHCOMPONENTQUERY, userId));
            List<SoftwareComponent> components = new ArrayList();
            while(rs.next()) {
                String id = rs.getString("id");
                String name = rs.getString("name");
                Double energy = rs.getDouble("energy");
                Double emission_factor = rs.getDouble("emission_factor");
                Double embodied_emission = rs.getDouble("embodied_emission");
                Double score = rs.getDouble("score");
                SoftwareComponent component = new SoftwareComponent(name, energy, emission_factor, embodied_emission);
                component.setId(id);
                component.setScore(score);
                components.add(component);
            }
            return components;
        } catch (SQLException ex) {
            throw new SQLException(ex);
        }
    } 
    
    public void saveComponent(SoftwareComponent component, String userId) throws SQLException {
        DatabaseUtil db = new DatabaseUtil();
        try {
            db.run_noresult(String.format(INSERTCOMPONENTQUERY, component.getComponent(), component.getEnergy(), component.getEmissionFactor(), component.getEmbodiedEmissions(),component.getScore(), userId));
        } catch (SQLException ex) {
            throw new SQLException(ex);
        }
    }
    
}
