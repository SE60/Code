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
import javafx.scene.input.MouseEvent;
import se_restaurant_real.Main;
import static se_restaurant_real.Main.cOrder;

/**
 *
 * @author l3oat
 */
public class CustomerToChef_Controller {
    @FXML
    void BackToMenu(MouseEvent event) {
        Main.mainStage.getScene().setRoot(Main.root1);
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
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
            Main.mainStage.getScene().setRoot(Main.cOrder);
    }
}
