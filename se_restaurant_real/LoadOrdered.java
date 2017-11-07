/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se_restaurant_real;

import java.util.List;
import javafx.scene.control.Label;

/**
 *
 * @author l3oat
 */
public class LoadOrdered {
    private List<Label> nameViewList;
    private List<Label> costViewList;
    private int pid=0;

    public LoadOrdered(int pid,List<Label> nameViewList,List<Label> costViewList) {
        this.nameViewList = nameViewList;
        this.costViewList=costViewList;
        this.pid=pid;
    }   
    public String getName(){
        return nameViewList.get(pid).getText();
    }
    public double getCost(){
        return Double.parseDouble(costViewList.get(pid).getText());
    }
    
    
}
