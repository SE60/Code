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
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;

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
    @FXML private Label ordered_1,ordered_2,ordered_3,ordered_4,ordered_5,ordered_6,ordered_7,ordered_8,ordered_9,ordered_10,ordered_11,ordered_12,ordered_13,ordered_14;
    @FXML private Pagination reccommendSlide;
    @FXML private Spinner<Integer> inc_1,inc_2,inc_3,inc_4,inc_5,inc_6,inc_7,inc_8,inc_9,inc_10,inc_11,inc_12,inc_13,inc_14;
    @FXML private ImageView del_1,del_2,del_3,del_4,del_5,del_6,del_7,del_8,del_9,del_10,del_11,del_12,del_13,del_14;
    
    SpinnerValueFactory<Integer> spinValue1 = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 10, 1);
    SpinnerValueFactory<Integer> spinValue2 = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 10, 1);
    SpinnerValueFactory<Integer> spinValue3 = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 10, 1);
    SpinnerValueFactory<Integer> spinValue4 = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 10, 1);
    SpinnerValueFactory<Integer> spinValue5 = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 10, 1);
    SpinnerValueFactory<Integer> spinValue6 = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 10, 1);
    SpinnerValueFactory<Integer> spinValue7 = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 10, 1);
    SpinnerValueFactory<Integer> spinValue8 = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 10, 1);
    SpinnerValueFactory<Integer> spinValue9 = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 10, 1);
    SpinnerValueFactory<Integer> spinValue10 = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 10, 1);
    SpinnerValueFactory<Integer> spinValue11 = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 10, 1);
    SpinnerValueFactory<Integer> spinValue12 = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 10, 1);
    SpinnerValueFactory<Integer> spinValue13 = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 10, 1);
    SpinnerValueFactory<Integer> spinValue14 = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 10, 1);
    
    
    
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
    void pid_1_1_Clicked(MouseEvent event) {
        A_1_BeforeOrdered.setVisible(false);
        A_2_AfterOrdered.setVisible(true);
        ordered_1.setText("1111111111111111111111");
        inc_1.setVisible(true);
        inc_1.setValueFactory(spinValue1);
        del_1.setVisible(true);
        
    }

    @FXML
    void pid_1_2_Clicked(MouseEvent event) {
        A_1_BeforeOrdered.setVisible(false);
        A_2_AfterOrdered.setVisible(true);
        ordered_2.setText("2222222222222222222222");
        inc_2.setVisible(true);
        inc_2.setValueFactory(spinValue2);
        del_2.setVisible(true);
    }
    
    @FXML
    void pid_1_3_Clicked(MouseEvent event) {
        A_1_BeforeOrdered.setVisible(false);
        A_2_AfterOrdered.setVisible(true);
        ordered_3.setText("3333333333333333333333");
        inc_3.setVisible(true);
        inc_3.setValueFactory(spinValue3);
        del_3.setVisible(true);
    }
    
    @FXML
    void pid_1_4_Clicked(MouseEvent event) {
        A_1_BeforeOrdered.setVisible(false);
        A_2_AfterOrdered.setVisible(true);
        ordered_4.setText("44444444444444444444444");
        inc_4.setVisible(true);
        inc_4.setValueFactory(spinValue4);
        del_4.setVisible(true);
    }
    
    @FXML
    void pid_1_5_Clicked(MouseEvent event) {
        A_1_BeforeOrdered.setVisible(false);
        A_2_AfterOrdered.setVisible(true);
        ordered_5.setText("55555555555555555555555");
        inc_5.setVisible(true);
        inc_5.setValueFactory(spinValue5);
        del_5.setVisible(true);
    }
    
    @FXML
    void pid_1_6_Clicked(MouseEvent event) {
        A_1_BeforeOrdered.setVisible(false);
        A_2_AfterOrdered.setVisible(true);
        ordered_6.setText("6666666666666666666666");
        inc_6.setVisible(true);
        inc_6.setValueFactory(spinValue6);
        del_6.setVisible(true);
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
    void pid_2_3_Clicked(MouseEvent event) {

    }

    @FXML
    void pid_2_4_Clicked(MouseEvent event) {

    }

    @FXML
    void pid_2_5_Clicked(MouseEvent event) {

    }

    @FXML
    void pid_2_6_Clicked(MouseEvent event) {

    }

    @FXML
    void pid_2_7_Clicked(MouseEvent event) {

    }

    @FXML
    void pid_2_8_Clicked(MouseEvent event) {

    }

    @FXML
    void pid_2_9_Clicked(MouseEvent event) {

    }
    
    @FXML
    void pid_2_10_Clicked(MouseEvent event) {

    }

    @FXML
    void pid_3_1_Clicked(MouseEvent event) {

    }

    @FXML
    void pid_3_2_Clicked(MouseEvent event) {

    }

    @FXML
    void pid_3_3_Clicked(MouseEvent event) {

    }

    @FXML
    void pid_3_4_Clicked(MouseEvent event) {

    }

    @FXML
    void pid_3_5_Clicked(MouseEvent event) {

    }

    @FXML
    void pid_3_6_Clicked(MouseEvent event) {

    }

    @FXML
    void pid_3_7_Clicked(MouseEvent event) {

    }

    @FXML
    void pid_3_8_Clicked(MouseEvent event) {

    }

    @FXML
    void pid_3_9_Clicked(MouseEvent event) {

    }
    
    @FXML
    void pid_3_10_Clicked(MouseEvent event) {

    }   

    @FXML
    void pid_4_1_Clicked(MouseEvent event) {

    }

    @FXML
    void pid_4_2_Clicked(MouseEvent event) {

    }

    @FXML
    void pid_4_3_Clicked(MouseEvent event) {

    }

    @FXML
    void pid_4_4_Clicked(MouseEvent event) {

    }

    @FXML
    void pid_4_5_Clicked(MouseEvent event) {

    }

    @FXML
    void pid_4_6_Clicked(MouseEvent event) {

    }

    @FXML
    void pid_4_7_Clicked(MouseEvent event) {

    }

    @FXML
    void pid_4_8_Clicked(MouseEvent event) {

    }

    @FXML
    void pid_4_9_Clicked(MouseEvent event) {

    }
    
    @FXML
    void pid_4_10_Clicked(MouseEvent event) {

    }

    @FXML
    void pid_5_1_Clicked(MouseEvent event) {

    }

    @FXML
    void pid_5_2_Clicked(MouseEvent event) {

    }

    @FXML
    void pid_5_3_Clicked(MouseEvent event) {

    }

    @FXML
    void pid_5_4_Clicked(MouseEvent event) {

    }

    @FXML
    void pid_5_5_Clicked(MouseEvent event) {

    }

    @FXML
    void pid_5_6_Clicked(MouseEvent event) {

    }

    @FXML
    void pid_5_7_Clicked(MouseEvent event) {

    }

    @FXML
    void pid_5_8_Clicked(MouseEvent event) {

    }

    @FXML
    void pid_5_9_Clicked(MouseEvent event) {

    }
    
    @FXML
    void pid_5_10_Clicked(MouseEvent event) {

    }

    @FXML
    void pid_6_1_Clicked(MouseEvent event) {

    }

    @FXML
    void pid_6_2_Clicked(MouseEvent event) {

    }

    @FXML
    void pid_6_3_Clicked(MouseEvent event) {

    }

    @FXML
    void pid_6_4_Clicked(MouseEvent event) {

    }

    @FXML
    void pid_6_5_Clicked(MouseEvent event) {

    }

    @FXML
    void pid_6_6_Clicked(MouseEvent event) {

    }

    @FXML
    void pid_6_7_Clicked(MouseEvent event) {

    }

    @FXML
    void pid_6_8_Clicked(MouseEvent event) {

    }

    @FXML
    void pid_6_9_Clicked(MouseEvent event) {

    }

    @FXML
    void pid_6_10_Clicked(MouseEvent event) {

    }

    @FXML
    void pid_7_1_Clicked(MouseEvent event) {

    }

    @FXML
    void pid_7_2_Clicked(MouseEvent event) {

    }

    @FXML
    void pid_7_3_Clicked(MouseEvent event) {

    }

    @FXML
    void pid_7_4_Clicked(MouseEvent event) {

    }

    @FXML
    void pid_7_5_Clicked(MouseEvent event) {

    }

    @FXML
    void pid_7_6_Clicked(MouseEvent event) {

    }

    @FXML
    void pid_7_7_Clicked(MouseEvent event) {

    }

    @FXML
    void pid_7_8_Clicked(MouseEvent event) {

    }

    @FXML
    void pid_7_9_Clicked(MouseEvent event) {

    }
    
    @FXML
    void pid_7_10_Clicked(MouseEvent event) {

    }

    @FXML
    void pid_8_1_Clicked(MouseEvent event) {

    }

    @FXML
    void pid_8_2_Clicked(MouseEvent event) {

    }

    @FXML
    void pid_8_3_Clicked(MouseEvent event) {

    }

    @FXML
    void pid_8_4_Clicked(MouseEvent event) {

    }

    @FXML
    void pid_8_5_Clicked(MouseEvent event) {

    }

    @FXML
    void pid_8_6_Clicked(MouseEvent event) {

    }

    @FXML
    void pid_8_7_Clicked(MouseEvent event) {

    }

    @FXML
    void pid_8_8_Clicked(MouseEvent event) {

    }

    @FXML
    void pid_8_9_Clicked(MouseEvent event) {

    }
    
    @FXML
    void pid_8_10_Clicked(MouseEvent event) {

    }

    @FXML
    void pid_9_1_Clicked(MouseEvent event) {

    }

    @FXML
    void pid_9_2_Clicked(MouseEvent event) {

    }

    @FXML
    void pid_9_3_Clicked(MouseEvent event) {

    }

    @FXML
    void pid_9_4_Clicked(MouseEvent event) {

    }

    @FXML
    void pid_9_5_Clicked(MouseEvent event) {

    }

    @FXML
    void pid_9_6_Clicked(MouseEvent event) {

    }

    @FXML
    void pid_9_7_Clicked(MouseEvent event) {

    }

    @FXML
    void pid_9_8_Clicked(MouseEvent event) {

    }

    @FXML
    void pid_9_9_Clicked(MouseEvent event) {

    }
    
    @FXML
    void pid_9_10_Clicked(MouseEvent event) {

    }
    
}
