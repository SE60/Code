/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se_restaurant_real.Controller;

import RestaurantDB.Ordered;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import se_restaurant_real.BeforeShowTableChef;
import se_restaurant_real.DB_Connection;
import se_restaurant_real.Main_Chef;
import static se_restaurant_real.Main_Chef.chefOrderEachTable_Controller;
import static se_restaurant_real.Main_Chef.chefTableOrder_Controller;
import se_restaurant_real.Main_Customer;
import static se_restaurant_real.Main_Customer.cOrder;

/**
 *
 * @author TryAgain
 */
public class ChefTableOrder_Controller {
    
    @FXML
    private TableColumn<BeforeShowTableChef, Integer> order;

    @FXML
    private TableColumn<BeforeShowTableChef, Integer> table;
    
    @FXML
    private TableView<BeforeShowTableChef> orderList;
    
    @FXML
    private Button refreshButton;
    
    @FXML
    protected void initialize(){
        loadOrderedList();
    }
    
    public void loadOrderedList()
    {
        order.setCellValueFactory(new PropertyValueFactory<>("order"));
        table.setCellValueFactory(new PropertyValueFactory<>("table"));
        orderList.setItems(getJoinedPerson());
    }
    
     public ObservableList<BeforeShowTableChef> getJoinedPerson()
    {   
        BeforeShowTableChef beforeShowTableChef;
        ObservableList<BeforeShowTableChef> p = FXCollections.observableArrayList();
        //-------------------get database connection------------------------------//
        DB_Connection conn=new DB_Connection();
        EntityManager em=conn.getConnection();
        //------------------------------------------------------------------------//
        em.getTransaction().begin();
        TypedQuery<Ordered> q1=em.createQuery("select ca from Ordered ca ",Ordered.class); 
        int orderCount = 1;
        for(int i=0;i<q1.getResultList().size();i++){
            if (q1.getResultList().get(i).getStatus() == false){
               beforeShowTableChef =new BeforeShowTableChef(orderCount,q1.getResultList().get(i).getTable());
               p.add(beforeShowTableChef); 
               orderCount++;
            }             
        }
        //------------------close connection-------------------------------------//
        conn.closeConnection();
        //----------------------------------------------------------------------//
        orderList.setRowFactory(tv -> {
            TableRow<BeforeShowTableChef> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                int rowData = row.getItem().getOrder();
                if (event.getClickCount() == 1 && rowData == 1 ) {
                   chefOrderEachTable_Controller.initialize();
                    Main_Chef.mainStage.getScene().setRoot(Main_Chef.root2);
                }
            });
            return row ;
        });
        return p;
    }
     
    @FXML
    void refreshButton_Clicked(MouseEvent event) {
        loadOrderedList();
    }
}

