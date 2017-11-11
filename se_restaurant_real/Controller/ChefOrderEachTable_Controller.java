/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se_restaurant_real.Controller;

import RestaurantDB.Ordered;
import java.util.List;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.cell.PropertyValueFactory;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
/**
 *
 * @author TryAgain
 */
public class ChefOrderEachTable_Controller {
    
    @FXML
    private Label table;
    @FXML
    private List<Label> menuViewList;
    @FXML
    private List<CheckBox> checkViewList;
    
    @FXML
    protected void initialize(){
        setMenuText();
    }
    
    public void setMenuText (){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("restaurant.odb");
        EntityManager em=emf.createEntityManager();
        TypedQuery<Ordered> q1=em.createQuery("select ca from Ordered ca",Ordered.class);
        for (int i=0; i<q1.getResultList().get(0).getPrice().size(); i++){
            menuViewList.get(i).setVisible(true);
            checkViewList.get(i).setVisible(true);
            menuViewList.get(i).setText(q1.getResultList().get(0).getName().get(i));
        } 
    }
}
