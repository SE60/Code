/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se_restaurant_real.Controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import se_restaurant_real.Main_Customer;
import static se_restaurant_real.Main_Customer.cOrder;

/**
 *
 * @author l3oat
 */
public class CustomerToChef_Controller {
    @FXML
        private Label tableNumber;
    
    @FXML
    protected void initialize(){
        tableNumber.setText(Integer.toString(SelectTable_Controller.tableInt));
    }
    
    @FXML
    void BackToMenu(MouseEvent event) {
        Main_Customer.mainStage.getScene().setRoot(Main_Customer.root2);
    }

    @FXML
    void goToBill(MouseEvent event) {
        try {
            FXMLLoader loader;
            loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/GUI/src/sample/CustomerTableOrder.fxml"));
            cOrder = loader.load();
            // ---------------------------------------------------------------------------------------
            } catch (IOException ex) {
                Logger.getLogger(Main_Customer.class.getName()).log(Level.SEVERE, null, ex);
            }
            Main_Customer.mainStage.getScene().setRoot(Main_Customer.cOrder);
    }
}
