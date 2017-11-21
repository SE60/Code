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
import javafx.scene.control.Spinner;

/**
 *
 * @author l3oat
 */
public class DupicateOrdered {
    
    private List<Label> orderedViewList;
    private String justOrder;
    private List<Spinner<Integer>> increaseViewList;

    public DupicateOrdered(List<Label> orderedViewList, String justOrder ,List<Spinner<Integer>> increaseViewList) {
        this.orderedViewList = orderedViewList;
        this.justOrder = justOrder;
        this.increaseViewList=increaseViewList;
    }

    
    public boolean isDupicate(){
        for(int i=0;i<orderedViewList.size();i++){
            if(orderedViewList.get(i).getText().equals(justOrder)){
                if(increaseViewList.get(i).getValue()< 10)   
                {
                    increaseViewList.get(i).getValueFactory().increment(1);    
                }                 
                else{
                   Alert alert = new Alert(AlertType.INFORMATION);
                   alert.setTitle("Information Dialog");
                   alert.setHeaderText("Your order quality is over 10");
                   alert.setContentText("Please order first then you can order this menu again");
                   alert.showAndWait();  
                }
                return true;
            }
        }
        return false;
    }
    
    public boolean isOver14(){
        int ordered=0;
        for(int i=0;i<orderedViewList.size();i++){          
            if(orderedViewList.get(i).getText()!="") ordered++;
        }
        if(ordered>=14){
             Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Dialog");
                alert.setHeaderText("You order is over 14 list");
                alert.setContentText("Please delete your order before order again");
                alert.showAndWait();
                return true;
        }
        return false;
    }
    
}
