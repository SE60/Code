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
import javafx.scene.control.Alert;
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
import se_restaurant_real.DB_Connection;
import se_restaurant_real.Main_Customer;

/**
 *
 * @author palaloyploy
 */
public class CustomerTableOrder_Controller {
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
        //-------------------get database connection------------------------------//
        DB_Connection conn=new DB_Connection();
        EntityManager em=conn.getConnection();
        //------------------------------------------------------------------------//
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
        //-------------------close database connection------------------------------//
        conn.closeConnection();
        //------------------------------------------------------------------------//
        return p;
    }
    
    
    @FXML
    void BackToMenu(MouseEvent event) {
        Main_Customer.mainStage.getScene().setRoot(Main_Customer.root2);      
    }
    
    @FXML
    void call_Service(MouseEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText("Please wait");
        alert.setContentText("Please wait waiter/waitress");
        alert.showAndWait();
    }
}
