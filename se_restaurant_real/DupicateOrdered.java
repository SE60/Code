/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se_restaurant_real;

import java.util.List;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;

/**
 *
 * @author l3oat
 */
public class DupicateOrdered {
    
    private List<Label> orderedViewList;
    private String justOrder;

    public DupicateOrdered(List<Label> orderedViewList, String justOrder) {
        this.orderedViewList = orderedViewList;
        this.justOrder = justOrder;
    }

    
    public boolean isDupicate(){
        for(int i=0;i<orderedViewList.size();i++){
            if(orderedViewList.get(i).getText()==justOrder){
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Information Dialog");
                alert.setHeaderText("You have already ordered");
                alert.setContentText("Please increase quality by spinner on right side");
                alert.showAndWait();
                return true;
            }
        }
        return false;
    }
    
}
