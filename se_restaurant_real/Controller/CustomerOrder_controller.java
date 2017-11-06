/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se_restaurant_real.Controller;

import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import se_restaurant_real.Main;

/**
 *
 * @author palaloyploy
 */
public class CustomerOrder_controller {
    @FXML
    void BackToMenu(MouseEvent event) {
        Main.mainStage.getScene().setRoot(Main.root1);

    }
}
