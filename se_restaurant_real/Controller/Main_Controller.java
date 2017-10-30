/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se_restaurant_real.Controller;

import RestaurantDB.food_Catalogue;
import RestaurantDB.food_menu;
import com.jfoenix.controls.JFXButton;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import static javafx.scene.input.KeyCode.R;
import javafx.scene.input.MouseEvent;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import se_restaurant_real.DBConnection;
import se_restaurant_real.Main;
import se_restaurant_real.loadPicture;

/**
 *
 * @author l3oat
 */
public class Main_Controller {
    
    @FXML
    private Label text_1;
    
    @FXML
    private ImageView cid_1_1;
    
    @FXML
    private ImageView cid_1_2;

    @FXML
    private ImageView cid_1_3;

    @FXML
    private ImageView cid_1_4;
    
    @FXML
    private List<ImageView> imageViewList ;    
    
    @FXML
    void choose_1(MouseEvent event) {
        cid_1_1.setVisible(false);
    }
    @FXML
    protected void initialize()
    {
        
//        try{
//        Statement st = DBConnection.conn.createStatement();
//        String sql = ("SELECT picture FROM food_menu");
//        ResultSet rs = st.executeQuery(sql);
//            while(rs.next()){
//                java.sql.Blob blob = rs.getBlob("picture");
//                InputStream in = blob.getBinaryStream(); 
//                Image image=new Image(in);
//                cid_1_1.setImage(image);
//                System.out.println(blob);
//            }    
//        }catch(SQLException ex)
//        {
//            ex.printStackTrace();
//        }
        
        
        loadPicture a=new loadPicture();
       for(int i=0;i<imageViewList.size();i++)
       {
           Image image=a.LoadPicture_Catalogue_8().get(i);
           imageViewList.get(i).setImage(image);
       }

          
    }
    
    public void test() {
        System.out.println("skadpaodkwpofkp");
    }
}
