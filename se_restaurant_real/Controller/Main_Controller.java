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
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.Pagination;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import static javafx.scene.input.KeyCode.R;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.util.Callback;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import se_restaurant_real.DBConnection;
import se_restaurant_real.LoadCost;
import se_restaurant_real.Main;
import se_restaurant_real.LoadMenuName;
import se_restaurant_real.LoadPicture;
import se_restaurant_real.LoadQuality;

/**
 *
 * @author l3oat
 */
public class Main_Controller {
    
    @FXML private Label text_1;
    @FXML private List<AnchorPane> pagiViewList_1 ;
    @FXML private List<ImageView> imageViewList_1,imageViewList_2 ;    
    @FXML private List<Label> nameViewList_1,nameViewList_2 ;
    @FXML private List<Label> costViewList_1,costViewList_2 ;
    @FXML private AnchorPane A_2_AfterOrdered,A_1_BeforeOrdered,Fried;
    @FXML private Label ordered_1,ordered_2;
    @FXML
    private Pagination reccommendSlide;
    
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
        
       LoadPicture picture=new LoadPicture();
       LoadMenuName name=new LoadMenuName();
       LoadCost cost=new LoadCost();
       LoadQuality quality=new LoadQuality();
//       for(int i=0;i<nameViewList_2.size();i++)
//       {
//           Image image=picture.loadPicture_Catalogue_2().get(i);
//           String mName=name.loadName_2().get(i);
//           Double ccost=cost.loadCost_2().get(i);
//           imageViewList_2.get(i).setImage(image);
//           nameViewList_2.get(i).setText(mName);
//           costViewList_2.get(i).setText(ccost.toString());
//       }  
       for(int i=0;i<pagiViewList_1.size();i++)
       {
           Image image=picture.loadPicture_Catalogue_1().get(i);
           String mName=name.loadName_1().get(i);
           Double ccost=cost.loadCost_1().get(i);
           imageViewList_1.get(i).setImage(image);
           nameViewList_1.get(i).setText(mName);
           nameViewList_1.get(i).setVisible(false);            
           costViewList_1.get(i).setText(ccost.toString());
           costViewList_1.get(i).setVisible(false);
       }
       EntityManagerFactory emf = Persistence.createEntityManagerFactory("restaurant.odb");
       EntityManager em=emf.createEntityManager();
       em.getTransaction().begin();
       TypedQuery<food_menu> q1=em.createQuery("select from food_menu where cName.id=1",food_menu.class);
       reccommendSlide.setPageCount(quality.loadQuality_1());
       reccommendSlide.setPageFactory(new Callback<Integer,Node>() {
           @Override
           public Node call(Integer param){
            nameViewList_1.get(param).setVisible(true);
            costViewList_1.get(param).setVisible(true);
            return pagiViewList_1.get(param);
           }
       });
       
    }
    
     @FXML
    void pid_2_1_Clicked(MouseEvent event) {
           A_1_BeforeOrdered.setVisible(false);
           A_2_AfterOrdered.setVisible(true);
           ordered_1.setText("1111111111111111111111");
           
     
    }
     @FXML
    void pid_2_2_Clicked(MouseEvent event) {
         ordered_2.setText("222222222222222222222");
    }
    @FXML
    void pid_1_1_Clicked(MouseEvent event) {
           A_1_BeforeOrdered.setVisible(false);
           A_2_AfterOrdered.setVisible(true);
           ordered_1.setText("1111111111111111111111");
    }
    @FXML
    void pid_1_2_Clicked(MouseEvent event) {
           A_1_BeforeOrdered.setVisible(false);
           A_2_AfterOrdered.setVisible(true);
           ordered_2.setText("2222222222222222222222");
    }
    
}
