/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se_restaurant_real.Controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import se_restaurant_real.DB_Connection;
import se_restaurant_real.Main_Customer;
import static se_restaurant_real.Main_Customer.cOrder;

/**
 *
 * @author l3oat
 */
public class SelectTable_Controller {

    public static int tableInt;    
    
    @FXML
    private TextField table;

    @FXML
    void confirmTable(ActionEvent event) {
        try{
            
            tableInt= Integer.parseInt(table.getText());
            if(tableInt<0){
                //------------------if table number <0------------------------------//
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Dialog");
                alert.setHeaderText("Invalid number");
                alert.setContentText("Please input number greater than zero");
                alert.showAndWait();
                throw new IllegalArgumentException("Table number must be greater than");
                
            }
            
            System.out.println("Table : "+tableInt);
                           
            
            Main_Customer.main_Controller.tableNumber.setText(Integer.toString(tableInt));
            //-----------------------------------------Clearing Ordered database -----------------------------------//
            //-------------------get database connection------------------------------//
            DB_Connection conn=new DB_Connection();
            EntityManager em=conn.getConnection();
            //------------------------------------------------------------------------//
            em.getTransaction().begin();
            int del=em.createQuery("delete from Ordered where table="+Integer.toString(SelectTable_Controller.tableInt)).executeUpdate();
            em.getTransaction().commit();
            //-------------------close database connection------------------------------//
            conn.closeConnection();
            //------------------------------------------------------------------------//
            
            Main_Customer.mainStage.getScene().setRoot(Main_Customer.root2);
            
            
        }catch(NumberFormatException e){
            //---------------------if table number not a number---------------------//
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setHeaderText("Invalid number");
            alert.setContentText("Please input only number");
            alert.showAndWait();
        }
            
    }

}

