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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import se_restaurant_real.BeforeShowTableChef;
import se_restaurant_real.Main;
import static se_restaurant_real.Main.cOrder;

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
        int table=1;
        BeforeShowTableChef beforeShowTableChef;
        ObservableList<BeforeShowTableChef> p = FXCollections.observableArrayList();
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("$objectdb/restaurant.odb");
        EntityManager em=emf.createEntityManager();
        TypedQuery<Ordered> q1=em.createQuery("select ca from Ordered ca where ca.table="+Integer.toString(table),Ordered.class); 
        for(int i=0;i<q1.getResultList().size();i++){
               beforeShowTableChef =new BeforeShowTableChef(i+1,q1.getResultList().get(i).getTable());
               p.add(beforeShowTableChef);        
        }
        orderList.setRowFactory( tv -> {
            TableRow<BeforeShowTableChef> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                int rowData = row.getItem().getOrder();
                if (event.getClickCount() == 1 && rowData == 1 ) {
                    try {
                        FXMLLoader loader;
                        loader = new FXMLLoader();
                        loader.setLocation(getClass().getResource("/GUI/src/sample/ChefOrderEachTable.fxml"));
                        cOrder = loader.load();
                        // ---------------------------------------------------------------------------------------
                    } catch (IOException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    Main.mainStage.getScene().setRoot(Main.cOrder);
                }
            });
        return row ;
        });
        return p;
    }
}

