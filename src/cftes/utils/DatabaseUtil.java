/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cftes.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sudan
 */
public class DatabaseUtil {
   Connection connection;
   
   static final String DB_URL = "jdbc:mysql://localhost:3306/";
   static final String USER = "root";
   static final String PASS = "";
   static final String DB = "CFTES";
   
//   final String createReportTBL = "CREATE TABLE `CFTES`.`report` (`id` INT NOT NULL AUTO_INCREMENT , `user_id` INT NOT NULL , `value` DOUBLE NOT NULL , PRIMARY KEY (`id`)) ENGINE = InnoDB";
   final String createUserTBL = "CREATE TABLE `CFTES`.`users` (`id` INT NOT NULL AUTO_INCREMENT , `fullname` VARCHAR(500) NOT NULL , `email` VARCHAR(500) NOT NULL , `universityId` VARCHAR(100) NOT NULL , `password` VARCHAR(100) NOT NULL , `role` INT NOT NULL , PRIMARY KEY (`id`)) ENGINE = InnoDB;";
//   final String createEmissionVALTBL = "CREATE TABLE `CFTES`.`emission_values` (`id` INT NOT NULL AUTO_INCREMENT , `equipment_name` VARCHAR(300) NOT NULL , `value` DOUBLE NOT NULL , `isFeature` BOOLEAN NOT NULL, PRIMARY KEY (`id`)) ENGINE = InnoDB;";
//   final String INSERTTBL = "INSERT INTO `emission_values` (`id`, `equipment_name`, `value`, `isFeature`) VALUES (NULL, 'Desktop* + screen', '621', '0'), (NULL, 'Laptop + screen', '691', '0'), (NULL, 'Desktop + 2 screens ', '903', '0'), (NULL, 'Laptop* + screen at office + screen at home', '928', '0'), (NULL, 'Desktop + screen + laptop', '1030', '0'), (NULL, 'Sample PC kept \\'active\\' continuously', '73', '1'), (NULL, 'With default power saving features', '37', '1'), (NULL, 'Shutdown when not in use', '17.6', '1'), (NULL, 'Turned off at wall when not in use ', '14.7', '1')";
   final String createSoftwareComponentTbl = "CREATE TABLE `CFTES`.`software_component` (`id` INT NOT NULL AUTO_INCREMENT ,`name` VARCHAR(100) NOT NULL, `energy` DOUBLE NOT NULL , `emission_factor` DOUBLE NOT NULL , `embodied_emission` DOUBLE NOT NULL , `score` DOUBLE NOT NULL, `user_id` INT NOT NULL , PRIMARY KEY (`id`)) ENGINE = InnoDB;";
   
   public void createDatabase()   throws SQLException {
   Connection conn;
      conn = DriverManager.getConnection(DB_URL, USER, PASS);
        Statement stmt = conn.createStatement();
        String sql = "CREATE DATABASE " + DB;
        stmt.executeUpdate(sql);
        System.out.println("Database created successfully..."); 
        conn.close();   
    }
   
   public void createTables() throws SQLException {
       run_noresult(createUserTBL);
       run_noresult(createSoftwareComponentTbl);
   }
   
    
    
    public void dropDatabase() {
        try {
            run_noresult("DROP DATABASE " + DB);
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseUtil.class.getName()).log(Level.SEVERE, null, ex);
        } catch(Exception ex) {
            Logger.getLogger(DatabaseUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void initialize() {
        try {
            connection = DriverManager.getConnection(  
DB_URL+ DB,USER,PASS); 
            System.out.println("Connected");
        } catch (Exception exception) {
            System.out.println(exception);
        }
    }
    
    
    public ResultSet run(String sql) throws SQLException {
        initialize();
        Statement stmt = connection.createStatement();
        ResultSet result = stmt.executeQuery(sql);
        return result;
    }
    
    public void run_noresult(String sql) throws SQLException {
        initialize();
//        Statement stmt = connection.createStatement();
//        stmt.execute(sql);
        PreparedStatement myStmt
            = connection.prepareStatement(sql);
        myStmt.executeUpdate();
        close();
    }
    
    public void close() {
        try {
            connection.close();
        } catch (SQLException ex) {
        }
    }
}
