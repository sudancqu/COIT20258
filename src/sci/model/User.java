/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sci.model;

/**
 *
 * @author 
 * Name: Sudan Suwal
 * Student ID: 12199888
 */
public class User {

    private String id, fullname, email, uniId;

    public User(String id, String fullname, String email, String uniId) {
        this.fullname = fullname;
        this.id = id;
        this.email = email;
        this.uniId = uniId;
    }

    public User() {
        
    }

    public String getId() {
        return id;
    }

    public String getFullname() {
        return fullname;
    }

    public String getEmail() {
        return email;
    }

    public String getUniId() {
        return uniId;
    }

    
}
