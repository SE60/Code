/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se_restaurant_real;

import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author l3oat
 */
public class SetPageOrdered {
    @FXML private AnchorPane A_2_AfterOrdered,A_1_BeforeOrdered;

    public SetPageOrdered(AnchorPane A_2_AfterOrdered, AnchorPane A_1_BeforeOrdered) {
        this.A_2_AfterOrdered = A_2_AfterOrdered;
        this.A_1_BeforeOrdered = A_1_BeforeOrdered;
        setPageVisible();
    }

    public AnchorPane getA_2_AfterOrdered() {
        return A_2_AfterOrdered;
    }

    public void setA_2_AfterOrdered(AnchorPane A_2_AfterOrdered) {
        this.A_2_AfterOrdered = A_2_AfterOrdered;
    }

    public AnchorPane getA_1_BeforeOrdered() {
        return A_1_BeforeOrdered;
    }

    public void setA_1_BeforeOrdered(AnchorPane A_1_BeforeOrdered) {
        this.A_1_BeforeOrdered = A_1_BeforeOrdered;
    }
        
    
    public void setPageVisible(){
        if(A_1_BeforeOrdered.visibleProperty().getValue()==true)
        {
            A_1_BeforeOrdered.setVisible(false);
            A_2_AfterOrdered.setVisible(true);
        }
    }        
    
}
    

