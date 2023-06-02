/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sci.presenter;

import sci.model.SoftwareComponent;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 
 * Name: Sudan Suwal
 * Student ID: 12199888
 */
public class SCIPresenter {
    public interface SCIPresenterView {
        void onFetched(List<SoftwareComponent> components);
        void onError(Exception error);
    }
    private SCIPresenterView observable;
    private Persister userDb;
    
    public SCIPresenter(SCIPresenterView observable) {
        this.observable = observable;
        userDb = new Persister();
    }
    
    public void fetch(String userId) {
        try {
            List<SoftwareComponent> components = userDb.fetchComponents(userId);
            observable.onFetched(components);
        } catch (SQLException ex) {
            observable.onError(ex);
        }
    }
}
