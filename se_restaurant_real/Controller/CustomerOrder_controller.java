/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se_restaurant_real.Controller;

import RestaurantDB.Ordered;
import RestaurantDB.food_menu;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import se_restaurant_real.BeforeShowTable;
import se_restaurant_real.Main;

/**
 *
 * @author palaloyploy
 */
public class CustomerOrder_controller {
    @FXML
    private TableColumn<BeforeShowTable, Integer> order;

    @FXML
    private TableColumn<BeforeShowTable, String> menu;

    @FXML
    private TableColumn<BeforeShowTable, Integer> quality;

    @FXML
    private TableColumn<BeforeShowTable, Double> price;
    
    @FXML
    private TableView<BeforeShowTable> orderList;
    
    @FXML
    protected void initialize(){
        loadOrderedList();
    }
    
    public void loadOrderedList()
    {
        order.setCellValueFactory(new PropertyValueFactory<>("order"));
        menu.setCellValueFactory(new PropertyValueFactory<>("name"));

        quality.setCellValueFactory(new PropertyValueFactory<>("quality"));
        price.setCellValueFactory(new PropertyValueFactory<>("price"));
        orderList.setItems(getJoinedPerson());
    }

    public ObservableList<BeforeShowTable> getJoinedPerson()
    {   
        int table=1;
        BeforeShowTable beforeShowTable;
        ObservableList<BeforeShowTable> p = FXCollections.observableArrayList();
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("restaurant.odb");
        EntityManager em=emf.createEntityManager();
        TypedQuery<Ordered> q1=em.createQuery("select ca from Ordered ca where ca.table="+Integer.toString(table),Ordered.class); 
        for(int i=0;i<q1.getResultList().size();i++){
           for(int j=0;j<q1.getResultList().get(i).getPrice().size();j++) 
           {
               beforeShowTable=new BeforeShowTable(i+1,q1.getResultList().get(i).getName().get(j),q1.getResultList().get(i).getQuality().get(j),q1.getResultList().get(i).getPrice().get(j));
               p.add(beforeShowTable);
           }          
        }
        em.close();
        return p;
    }
    
    @FXML
    void BackToMenu(MouseEvent event) {
        Main.mainStage.getScene().setRoot(Main.root1);
        

    }
}
