/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cftes.model;

/**
 *
 * @author 
 * Name: Sudan Suwal
 * Student ID: 12199888
 */
public class User {

    private String id, fullname, email, uniId;
    private int role;

    public User(String id, String fullname, String email, String uniId, int role) {
        this.fullname = fullname;
        this.id = id;
        this.email = email;
        this.uniId = uniId;
        this.role = role;
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

    public int getRole() {
        return role;
    }
    
    
    
}
