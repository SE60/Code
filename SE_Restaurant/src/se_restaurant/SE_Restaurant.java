/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se_restaurant;

import java.sql.SQLException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.apache.derby.shared.common.error.DerbySQLIntegrityConstraintViolationException;

/**
 *
 * @author l3oat
 */
public class SE_Restaurant extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("GUI.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        //stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        DBConnection db=new DBConnection();
//        db.createTable();
       // db.insertIntoTable(58010860,"John",25,'M');
             db.insertIntoTable(58010870,"Florence",23,'F');
             db.printAll();
      
        
        //launch(args);
    }
    
}
