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
    private List<Label> nameViewList;
    private int pid=0;

    public LoadNameOrdered(int pid,List<Label> nameViewList){
        this.nameViewList=nameViewList;
        this.pid=pid;
    }
    public String getName(){
        return nameViewList.get(pid).getText();
    }
    
    
}
