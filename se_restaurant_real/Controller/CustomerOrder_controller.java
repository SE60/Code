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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import se_restaurant_real.BeforeShowTable;
import se_restaurant_real.Main_Customer;

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
    private TableColumn<BeforeShowTable,Double> eachFoodPrice;
    
    @FXML
    private TableView<BeforeShowTable> orderList;
    
    @FXML
    private Label totalPrice;
    
    @FXML
        private Label tableNumber;
    
    @FXML
    protected void initialize(){
        tableNumber.setText(Integer.toString(SelectTable_Controller.tableInt));
        loadOrderedList();   
    }
    
    public void loadOrderedList()
    {
        order.setCellValueFactory(new PropertyValueFactory<>("order"));
        menu.setCellValueFactory(new PropertyValueFactory<>("name"));

        quality.setCellValueFactory(new PropertyValueFactory<>("quality"));
        price.setCellValueFactory(new PropertyValueFactory<>("price"));
        eachFoodPrice.setCellValueFactory(new PropertyValueFactory<>("eachFoodPrice"));
        orderList.setItems(getJoinedPerson());
    }

    public ObservableList<BeforeShowTable> getJoinedPerson()
    {   
        int totalPriceInt=0;
        BeforeShowTable beforeShowTable;
        ObservableList<BeforeShowTable> p = FXCollections.observableArrayList();
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("$objectdb/restaurant.odb");
        EntityManager em=emf.createEntityManager();
        TypedQuery<Ordered> q1=em.createQuery("select ca from Ordered ca where ca.table="+Integer.toString(SelectTable_Controller.tableInt),Ordered.class); 
        for(int i=0;i<q1.getResultList().size();i++){
           for(int j=0;j<q1.getResultList().get(i).getPrice().size();j++) 
           {
               double eachFoodPrice=q1.getResultList().get(i).getQuality().get(j)*q1.getResultList().get(i).getPrice().get(j);
               totalPriceInt+=eachFoodPrice;
               beforeShowTable=new BeforeShowTable(i+1,q1.getResultList().get(i).getName().get(j),q1.getResultList().get(i).getQuality().get(j),q1.getResultList().get(i).getPrice().get(j),eachFoodPrice);
               p.add(beforeShowTable);
           }          
        }
        totalPrice.setText(Integer.toString(totalPriceInt));
        em.close();
        return p;
    }
    
    
    @FXML
    void BackToMenu(MouseEvent event) {
        Main_Customer.mainStage.getScene().setRoot(Main_Customer.root2);
        
    }
}
