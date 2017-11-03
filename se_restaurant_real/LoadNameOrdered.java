/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se_restaurant_real;

import java.util.ArrayList;
import java.util.List;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

/**
 *
 * @author l3oat
 */
public class LoadNameOrdered {
    @FXML private List<Label> orderedViewList;
    ArrayList<String> aName=new ArrayList<String>();
    int i=0;
    public LoadNameOrdered(List<Label> orderedViewList) {
        this.orderedViewList = orderedViewList;
    }
    
    public ArrayList<String> loadName(){
        for(int i=0;i<14;i++){           
            if(orderedViewList.get(i).getText()!=""){          
                aName.add(orderedViewList.get(i).getText());
                System.out.println("Add : "+aName.get(i));
            }      
        }
        return aName;     
    }
}
