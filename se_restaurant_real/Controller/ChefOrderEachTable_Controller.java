/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se_restaurant_real.Controller;

import RestaurantDB.Ordered;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import se_restaurant_real.DB_Connection;
import se_restaurant_real.Main_Chef;
import static se_restaurant_real.Main_Chef.chefTableOrder_Controller;
import se_restaurant_real.Main_Customer;
import static se_restaurant_real.Main_Customer.cOrder;
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
    private List<Label> qualityViewList;
    @FXML
    private Button confirmButton;
    @FXML
    private Button cancleButton;
    
    @FXML
    protected void initialize(){
        setMenuText();
    }
    
    public void setMenuText (){
        for (int i=0; i<menuViewList.size(); i++){
            menuViewList.get(i).setVisible(false);
            checkViewList.get(i).setVisible(false);
            qualityViewList.get(i).setVisible(false);
            checkViewList.get(i).setSelected(false);
        }
        DB_Connection conn=new DB_Connection();
        EntityManager em=conn.getConnection();
        TypedQuery<Ordered> q1=em.createQuery("select ca from Ordered ca",Ordered.class);
        if(!q1.getResultList().isEmpty()){
            table.setText(Integer.toString(q1.getResultList().get(0).getTable()));
            for (int i=0; i<q1.getResultList().size();i++){
                if (q1.getResultList().get(i).getStatus() == false){
                    for (int j=0; j<q1.getResultList().get(i).getPrice().size(); j++){
                            menuViewList.get(j).setVisible(true);
                            checkViewList.get(j).setVisible(true);
                            qualityViewList.get(j).setVisible(true);
                            menuViewList.get(j).setText(q1.getResultList().get(i).getName().get(j));
                            qualityViewList.get(j).setText(Integer.toString(q1.getResultList().get(i).getQuality().get(j)));
                    }
                    break;
                }
            }
        }
        conn.closeConnection();
        
    }
    
    @FXML
    void cancleButton_Clicked(MouseEvent event) {
        chefTableOrder_Controller.initialize();
        Main_Chef.mainStage.getScene().setRoot(Main_Chef.root1);
    }

    @FXML
    void confirmButton_Clicked(MouseEvent event) {
        DB_Connection conn=new DB_Connection();
        EntityManager em=conn.getConnection();
        TypedQuery<Ordered> q1=em.createQuery("select ca from Ordered ca",Ordered.class);
        int selectedCount =0;
        int i =0;
        for (i=0; i<checkViewList.size();i++){
            if (checkViewList.get(i).isVisible()){
                if (checkViewList.get(i).isSelected()){
                    selectedCount++;
                }
            }
            else{
                break;
            }
        }
        if (selectedCount == i){
//            em.getTransaction().begin();
//            int delete = em.createQuery(
//                "DELETE FROM Ordered c WHERE c.id ="+q1.getResultList().get(0).getId()).executeUpdate();
//            em.getTransaction().commit();
            em.getTransaction().begin();
            for (int j=0; j<q1.getResultList().size();j++){
                if (q1.getResultList().get(j).getStatus() == false){
                    q1.getResultList().get(j).setStatus(true);
                    break;
                }
            }
            em.getTransaction().commit();
            chefTableOrder_Controller.initialize();
            Main_Chef.mainStage.getScene().setRoot(Main_Chef.root1);
            
        }
        else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setHeaderText("Cannot Confirm Yet!");
            alert.setContentText("Please selected every menu");
            alert.showAndWait();
        }
        conn.closeConnection();
    }
}
