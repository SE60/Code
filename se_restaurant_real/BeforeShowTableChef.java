/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se_restaurant_real;

/**
 *
 * @author TryAgain
 */
public class BeforeShowTableChef {
    
    private int order;
    private int table;
    
    public BeforeShowTableChef(int order, int table) {
        this.order = order;
        this.table = table;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public int getTable() {
        return table;
    }

    public void setTable(int table) {
        this.table = table;
    }
}
