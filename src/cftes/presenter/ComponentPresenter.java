/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cftes.presenter;

import cftes.model.SoftwareComponent;
import cftes.model.User;
import java.sql.SQLException;

/**
 *
 * @author 
 * Name: Sudan Suwal
 * Student ID: 12199888
 */
public class ComponentPresenter {
    
    public interface ComponentPresenterView {
        void onSaved();
        void onError(Exception error);
    }
    private ComponentPresenterView observable;
    private Persister userDb;
    
    public ComponentPresenter(ComponentPresenterView observable) {
        this.observable = observable;
        userDb = new Persister();
    }
    
    public void save(SoftwareComponent component, String userId) {
        try {
            userDb.saveComponent(component, userId);
            observable.onSaved();
        } catch (SQLException ex) {
            observable.onError(ex);
        } catch (Exception ex) {
            observable.onError(ex);
        }
    }
}
