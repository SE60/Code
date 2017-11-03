/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se_restaurant_real.Controller;

import RestaurantDB.Ordered;
import RestaurantDB.food_Catalogue;
import RestaurantDB.food_menu;
import com.jfoenix.controls.JFXButton;
import static com.objectdb.o.MSS.ca;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
import se_restaurant_real.DupicateOrdered;
import se_restaurant_real.LoadNameOrdered;
import se_restaurant_real.SetPageOrdered;

/**
 *
 * @author l3oat
 */
public class Main_Controller {
    
    @FXML private Label text_1;
    @FXML private List<AnchorPane> pagiViewList_1,pagiViewList_2,pagiViewList_3,pagiViewList_4,pagiViewList_5,pagiViewList_6,pagiViewList_7,pagiViewList_8,pagiViewList_9 ;
    @FXML private List<ImageView> imageViewList_1,imageViewList_2,imageViewList_3,imageViewList_4,imageViewList_5,imageViewList_6,imageViewList_7,imageViewList_8,imageViewList_9 ;    
    @FXML private List<Label> nameViewList_1,nameViewList_2,nameViewList_3,nameViewList_4,nameViewList_5,nameViewList_6,nameViewList_7,nameViewList_8,nameViewList_9 ;
    @FXML private List<Label> costViewList_1,costViewList_2,costViewList_3,costViewList_4,costViewList_5,costViewList_6,costViewList_7,costViewList_8,costViewList_9 ;
    @FXML private List<Label> orderedViewList;
    @FXML private List<Spinner<Integer>> increaseViewList;
    @FXML private List<ImageView> deleteViewList;
    @FXML private AnchorPane A_2_AfterOrdered,A_1_BeforeOrdered;
    @FXML private List<Pagination> slideViewList;
    //@FXML private Spinner<Integer> inc_1,inc_2,inc_3,inc_4,inc_5,inc_6,inc_7,inc_8,inc_9,inc_10,inc_11,inc_12,inc_13,inc_14;
    //@FXML private ImageView del_1,del_2,del_3,del_4,del_5,del_6,del_7,del_8,del_9,del_10,del_11,del_12,del_13,del_14;
    
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
       //-----------------------------Variable--------------------------------//
       LoadPicture picture=new LoadPicture();
       LoadMenuName name=new LoadMenuName();
       LoadCost cost=new LoadCost();
       LoadQuality quality=new LoadQuality();    
       //--------------------Set  spinner value factory-----------------------//
           increaseViewList.get(0).setValueFactory(spinValue1);
           increaseViewList.get(1).setValueFactory(spinValue2);
           increaseViewList.get(2).setValueFactory(spinValue3);
           increaseViewList.get(3).setValueFactory(spinValue4);
           increaseViewList.get(4).setValueFactory(spinValue5);
           increaseViewList.get(5).setValueFactory(spinValue6);
           increaseViewList.get(6).setValueFactory(spinValue7);
           increaseViewList.get(7).setValueFactory(spinValue8);
           increaseViewList.get(8).setValueFactory(spinValue9);
           increaseViewList.get(9).setValueFactory(spinValue10);
           increaseViewList.get(10).setValueFactory(spinValue11);
           increaseViewList.get(11).setValueFactory(spinValue12);
           increaseViewList.get(12).setValueFactory(spinValue13);
           increaseViewList.get(13).setValueFactory(spinValue14);
       //----------------load picture name cost form database-----------------//
       for(int i=0;i<pagiViewList_1.size();i++)
       {
           Image image=picture.loadPicture_Catalogue_1().get(i);
           String mName=name.loadName_1().get(i);
           Double ccost=cost.loadCost_1().get(i);
           imageViewList_1.get(i).setImage(image);
           imageViewList_1.get(i).setVisible(false);
           nameViewList_1.get(i).setText(mName);
           nameViewList_1.get(i).setVisible(false);            
           costViewList_1.get(i).setText(ccost.toString());
           costViewList_1.get(i).setVisible(false);
       }
       for(int i=0;i<imageViewList_2.size();i++)
       {
           Image image=picture.loadPicture_Catalogue_2().get(i);
           String mName=name.loadName_2().get(i);
           Double ccost=cost.loadCost_2().get(i);
           imageViewList_2.get(i).setImage(image);
           imageViewList_2.get(i).setVisible(false);
           nameViewList_2.get(i).setText(mName);
           nameViewList_2.get(i).setVisible(false);            
           costViewList_2.get(i).setText(ccost.toString());
           costViewList_2.get(i).setVisible(false);
       }
       for(int i=0;i<imageViewList_3.size();i++)
       {
           Image image=picture.loadPicture_Catalogue_3().get(i);
           String mName=name.loadName_3().get(i);
           Double ccost=cost.loadCost_3().get(i);
           imageViewList_3.get(i).setImage(image);
           imageViewList_3.get(i).setVisible(false);
           nameViewList_3.get(i).setText(mName);
           nameViewList_3.get(i).setVisible(false);            
           costViewList_3.get(i).setText(ccost.toString());
           costViewList_3.get(i).setVisible(false);
       }
       for(int i=0;i<imageViewList_4.size();i++)
       {
           Image image=picture.loadPicture_Catalogue_4().get(i);
           String mName=name.loadName_4().get(i);
           Double ccost=cost.loadCost_4().get(i);
           imageViewList_4.get(i).setImage(image);
           imageViewList_4.get(i).setVisible(false);
           nameViewList_4.get(i).setText(mName);
           nameViewList_4.get(i).setVisible(false);            
           costViewList_4.get(i).setText(ccost.toString());
           costViewList_4.get(i).setVisible(false);
       }
       for(int i=0;i<imageViewList_5.size();i++)
       {
           Image image=picture.loadPicture_Catalogue_5().get(i);
           String mName=name.loadName_5().get(i);
           Double ccost=cost.loadCost_5().get(i);
           imageViewList_5.get(i).setImage(image);
           imageViewList_5.get(i).setVisible(false);
           nameViewList_5.get(i).setText(mName);
           nameViewList_5.get(i).setVisible(false);            
           costViewList_5.get(i).setText(ccost.toString());
           costViewList_5.get(i).setVisible(false);
       }
       for(int i=0;i<imageViewList_6.size();i++)
       {
           Image image=picture.loadPicture_Catalogue_6().get(i);
           String mName=name.loadName_6().get(i);
           Double ccost=cost.loadCost_6().get(i);
           imageViewList_6.get(i).setImage(image);
           imageViewList_6.get(i).setVisible(false);
           nameViewList_6.get(i).setText(mName);
           nameViewList_6.get(i).setVisible(false);            
           costViewList_6.get(i).setText(ccost.toString());
           costViewList_6.get(i).setVisible(false);
       }
       for(int i=0;i<imageViewList_7.size();i++)
       {
           Image image=picture.loadPicture_Catalogue_7().get(i);
           String mName=name.loadName_7().get(i);
           Double ccost=cost.loadCost_7().get(i);
           imageViewList_7.get(i).setImage(image);
           imageViewList_7.get(i).setVisible(false);
           nameViewList_7.get(i).setText(mName);
           nameViewList_7.get(i).setVisible(false);            
           costViewList_7.get(i).setText(ccost.toString());
           costViewList_7.get(i).setVisible(false);
       }
       for(int i=0;i<imageViewList_8.size();i++)
       {
           Image image=picture.loadPicture_Catalogue_8().get(i);
           String mName=name.loadName_8().get(i);
           Double ccost=cost.loadCost_8().get(i);
           imageViewList_8.get(i).setImage(image);
           imageViewList_8.get(i).setVisible(false);
           nameViewList_8.get(i).setText(mName);
           nameViewList_8.get(i).setVisible(false);            
           costViewList_8.get(i).setText(ccost.toString());
           costViewList_8.get(i).setVisible(false);
       }
       for(int i=0;i<imageViewList_9.size();i++)
       {
           Image image=picture.loadPicture_Catalogue_9().get(i);
           String mName=name.loadName_9().get(i);
           Double ccost=cost.loadCost_9().get(i);
           imageViewList_9.get(i).setImage(image);
           imageViewList_9.get(i).setVisible(false);
           nameViewList_9.get(i).setText(mName);
           nameViewList_9.get(i).setVisible(false);            
           costViewList_9.get(i).setText(ccost.toString());
           costViewList_9.get(i).setVisible(false);
       }
//-------------------------------------Set pagination pane------------------------------------------------//     
       EntityManagerFactory emf = Persistence.createEntityManagerFactory("restaurant.odb");
       EntityManager em=emf.createEntityManager();
       em.getTransaction().begin();
       
       TypedQuery<food_menu> q1=em.createQuery("select from food_menu where cName.id=1",food_menu.class);
       slideViewList.get(0).setPageCount(quality.loadQuality_1());
       slideViewList.get(0).setPageFactory(new Callback<Integer,Node>() {
           @Override
           public Node call(Integer param){     
            imageViewList_1.get(param).setVisible(true);
            nameViewList_1.get(param).setVisible(true);
            costViewList_1.get(param).setVisible(true);
            return pagiViewList_1.get(param);
           }
       });
//----------------------------------------end page 1-----------------------------------------------------//
        TypedQuery<food_menu> q2=em.createQuery("select from food_menu where cName.id=2",food_menu.class);
       slideViewList.get(1).setPageCount(quality.loadQuality_2()/2);
       slideViewList.get(1).setPageFactory(new Callback<Integer,Node>() {
           @Override
           public Node call(Integer param){ 
             imageViewList_2.get(param*2).setVisible(true);
             imageViewList_2.get(param*2+1).setVisible(true);
             nameViewList_2.get(param*2).setVisible(true);
             nameViewList_2.get(param*2+1).setVisible(true);
             costViewList_2.get(param*2).setVisible(true);
             costViewList_2.get(param*2+1).setVisible(true);
            return pagiViewList_2.get(param);
           }
       });
//----------------------------------------end page 2-----------------------------------------------------//       
       TypedQuery<food_menu> q3=em.createQuery("select from food_menu where cName.id=3",food_menu.class);
       slideViewList.get(2).setPageCount(quality.loadQuality_3()/2);
       slideViewList.get(2).setPageFactory(new Callback<Integer,Node>() {
           @Override
           public Node call(Integer param){   
             imageViewList_3.get(param*2).setVisible(true);
             imageViewList_3.get(param*2+1).setVisible(true);
             nameViewList_3.get(param*2).setVisible(true);
             nameViewList_3.get(param*2+1).setVisible(true);
             costViewList_3.get(param*2).setVisible(true);
             costViewList_3.get(param*2+1).setVisible(true);
            return pagiViewList_3.get(param);
           }
       });
//----------------------------------------end page 3-----------------------------------------------------//
       TypedQuery<food_menu> q4=em.createQuery("select from food_menu where cName.id=3",food_menu.class);
       slideViewList.get(3).setPageCount(quality.loadQuality_4()/2);
       slideViewList.get(3).setPageFactory(new Callback<Integer,Node>() {
           @Override
           public Node call(Integer param){   
             imageViewList_4.get(param*2).setVisible(true);
             imageViewList_4.get(param*2+1).setVisible(true);
             nameViewList_4.get(param*2).setVisible(true);
             nameViewList_4.get(param*2+1).setVisible(true);
             costViewList_4.get(param*2).setVisible(true);
             costViewList_4.get(param*2+1).setVisible(true);
            return pagiViewList_4.get(param);
           }
       });
//----------------------------------------end page 4-----------------------------------------------------//
        TypedQuery<food_menu> q5=em.createQuery("select from food_menu where cName.id=4",food_menu.class);
       slideViewList.get(4).setPageCount(quality.loadQuality_5()/2);
       slideViewList.get(4).setPageFactory(new Callback<Integer,Node>() {
           @Override
           public Node call(Integer param){   
             imageViewList_5.get(param*2).setVisible(true);
             imageViewList_5.get(param*2+1).setVisible(true);
             nameViewList_5.get(param*2).setVisible(true);
             nameViewList_5.get(param*2+1).setVisible(true);
             costViewList_5.get(param*2).setVisible(true);
             costViewList_5.get(param*2+1).setVisible(true);
            return pagiViewList_5.get(param);
           }
       });
//----------------------------------------end page 5-----------------------------------------------------//
        TypedQuery<food_menu> q6=em.createQuery("select from food_menu where cName.id=5",food_menu.class);
       slideViewList.get(5).setPageCount(quality.loadQuality_6()/2);
       slideViewList.get(5).setPageFactory(new Callback<Integer,Node>() {
           @Override
           public Node call(Integer param){   
             imageViewList_6.get(param*2).setVisible(true);
             imageViewList_6.get(param*2+1).setVisible(true);
             nameViewList_6.get(param*2).setVisible(true);
             nameViewList_6.get(param*2+1).setVisible(true);
             costViewList_6.get(param*2).setVisible(true);
             costViewList_6.get(param*2+1).setVisible(true);
            return pagiViewList_6.get(param);
           }
       });
////----------------------------------------end page 6-----------------------------------------------------//
        TypedQuery<food_menu> q7=em.createQuery("select from food_menu where cName.id=6",food_menu.class);
       slideViewList.get(6).setPageCount(quality.loadQuality_7()/2);
       slideViewList.get(6).setPageFactory(new Callback<Integer,Node>() {
           @Override
           public Node call(Integer param){   
             imageViewList_7.get(param*2).setVisible(true);
             imageViewList_7.get(param*2+1).setVisible(true);
             nameViewList_7.get(param*2).setVisible(true);
             nameViewList_7.get(param*2+1).setVisible(true);
             costViewList_7.get(param*2).setVisible(true);
             costViewList_7.get(param*2+1).setVisible(true);
            return pagiViewList_7.get(param);
           }
       });
////----------------------------------------end page 7-----------------------------------------------------//
        TypedQuery<food_menu> q8=em.createQuery("select from food_menu where cName.id=7",food_menu.class);
       slideViewList.get(7).setPageCount(quality.loadQuality_7()/2);
       slideViewList.get(7).setPageFactory(new Callback<Integer,Node>() {
           @Override
           public Node call(Integer param){   
             imageViewList_8.get(param*2).setVisible(true);
             imageViewList_8.get(param*2+1).setVisible(true);
             nameViewList_8.get(param*2).setVisible(true);
             nameViewList_8.get(param*2+1).setVisible(true);
             costViewList_8.get(param*2).setVisible(true);
             costViewList_8.get(param*2+1).setVisible(true);
            return pagiViewList_8.get(param);
           }
       });
////----------------------------------------end page 8-----------------------------------------------------//
        TypedQuery<food_menu> q9=em.createQuery("select from food_menu where cName.id=9",food_menu.class);
       slideViewList.get(8).setPageCount(quality.loadQuality_9()/2);
       slideViewList.get(8).setPageFactory(new Callback<Integer,Node>() {
           @Override
           public Node call(Integer param){   
             imageViewList_9.get(param*2).setVisible(true);
             imageViewList_9.get(param*2+1).setVisible(true);
             nameViewList_9.get(param*2).setVisible(true);
             nameViewList_9.get(param*2+1).setVisible(true);
             costViewList_9.get(param*2).setVisible(true);
             costViewList_9.get(param*2+1).setVisible(true);
            return pagiViewList_9.get(param);
           }
       });
////----------------------------------------end page 9-----------------------------------------------------//
    }
    
    @FXML
    void ordered_Clicked(MouseEvent event) {
        ArrayList<String> aName=new ArrayList<String>();
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("restaurant.odb");
        EntityManager em=emf.createEntityManager();
        em.getTransaction().begin();
        //Ordered ordered=new food_menu(ca,arr[0],price,arr[2]);
        System.out.println(aName);
        
    }

//-----------------Ordered Check Method-----------------------//
    public void checkOrdered(String name){
        DupicateOrdered dupicateOrdered=new DupicateOrdered(orderedViewList,name);
        if(!dupicateOrdered.isDupicate())
            for(int i=0;i<orderedViewList.size();i++){
                if(orderedViewList.get(i).getText()== ""){
                    orderedViewList.get(i).setText(name);
                    increaseViewList.get(i).setVisible(true);
                    deleteViewList.get(i).setVisible(true);
                    break;
                }
            }
    }
//-----------------Picture Clicked Method--------------------//
            
    @FXML
    void pid_1_1_Clicked(MouseEvent event) {
        
        //----------Change page if orderedViewList not empty--------------//
        SetPageOrdered setPageOrdered=new SetPageOrdered(A_2_AfterOrdered,A_1_BeforeOrdered);
        A_1_BeforeOrdered=setPageOrdered.getA_1_BeforeOrdered();
        A_2_AfterOrdered=setPageOrdered.getA_2_AfterOrdered();
        //--------------------Find menu name-----------------------------//
        LoadNameOrdered loadNameOrdered=new LoadNameOrdered(0,nameViewList_1);
        checkOrdered(loadNameOrdered.getName());
        
    }

    @FXML
    void pid_1_2_Clicked(MouseEvent event) {
        //----------Change page if orderedViewList not empty--------------//
        SetPageOrdered setPageOrdered=new SetPageOrdered(A_2_AfterOrdered,A_1_BeforeOrdered);
        A_1_BeforeOrdered=setPageOrdered.getA_1_BeforeOrdered();
        A_2_AfterOrdered=setPageOrdered.getA_2_AfterOrdered();
        //--------------------Find menu name-----------------------------//
        LoadNameOrdered loadNameOrdered=new LoadNameOrdered(1,nameViewList_1);
        checkOrdered(loadNameOrdered.getName());
    }
    
    @FXML
    void pid_1_3_Clicked(MouseEvent event) {
        //----------Change page if orderedViewList not empty--------------//
        SetPageOrdered setPageOrdered=new SetPageOrdered(A_2_AfterOrdered,A_1_BeforeOrdered);
        A_1_BeforeOrdered=setPageOrdered.getA_1_BeforeOrdered();
        A_2_AfterOrdered=setPageOrdered.getA_2_AfterOrdered();
        //--------------------Find menu name-----------------------------//
        LoadNameOrdered loadNameOrdered=new LoadNameOrdered(2,nameViewList_1);
        checkOrdered(loadNameOrdered.getName());

    }
    
    @FXML
    void pid_1_4_Clicked(MouseEvent event) {
        //----------Change page if orderedViewList not empty--------------//
        SetPageOrdered setPageOrdered=new SetPageOrdered(A_2_AfterOrdered,A_1_BeforeOrdered);
        A_1_BeforeOrdered=setPageOrdered.getA_1_BeforeOrdered();
        A_2_AfterOrdered=setPageOrdered.getA_2_AfterOrdered();
        //--------------------Find menu name-----------------------------//
        LoadNameOrdered loadNameOrdered=new LoadNameOrdered(3,nameViewList_1);
        checkOrdered(loadNameOrdered.getName());

    }
    
    @FXML
    void pid_1_5_Clicked(MouseEvent event) {
        //----------Change page if orderedViewList not empty--------------//
        SetPageOrdered setPageOrdered=new SetPageOrdered(A_2_AfterOrdered,A_1_BeforeOrdered);
        A_1_BeforeOrdered=setPageOrdered.getA_1_BeforeOrdered();
        A_2_AfterOrdered=setPageOrdered.getA_2_AfterOrdered();
        //--------------------Find menu name-----------------------------//
        LoadNameOrdered loadNameOrdered=new LoadNameOrdered(4,nameViewList_1);
        checkOrdered(loadNameOrdered.getName());
    }
    
    @FXML
    void pid_1_6_Clicked(MouseEvent event) {
        //----------Change page if orderedViewList not empty--------------//
        SetPageOrdered setPageOrdered=new SetPageOrdered(A_2_AfterOrdered,A_1_BeforeOrdered);
        A_1_BeforeOrdered=setPageOrdered.getA_1_BeforeOrdered();
        A_2_AfterOrdered=setPageOrdered.getA_2_AfterOrdered();
        //--------------------Find menu name-----------------------------//
        LoadNameOrdered loadNameOrdered=new LoadNameOrdered(5,nameViewList_1);
        checkOrdered(loadNameOrdered.getName());
    }


    @FXML
    void pid_2_1_Clicked(MouseEvent event) {
 
    }

    @FXML
    void pid_2_2_Clicked(MouseEvent event) {
          
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
    
     @FXML
    void order_10_deleted(MouseEvent event) {

    }

    @FXML
    void order_11_deleted(MouseEvent event) {

    }

    @FXML
    void order_12_deleted(MouseEvent event) {

    }

    @FXML
    void order_13_deleted(MouseEvent event) {

    }

    @FXML
    void order_14_deleted(MouseEvent event) {

    }

    @FXML
    void order_1_deleted(MouseEvent event) {

    }

    @FXML
    void order_2_deleted(MouseEvent event) {

    }

    @FXML
    void order_3_deleted(MouseEvent event) {

    }

    @FXML
    void order_4_deleted(MouseEvent event) {

    }

    @FXML
    void order_5_deleted(MouseEvent event) {

    }

    @FXML
    void order_6_deleted(MouseEvent event) {

    }

    @FXML
    void order_7_deleted(MouseEvent event) {

    }

    @FXML
    void order_8_deleted(MouseEvent event) {

    }

    @FXML
    void order_9_deleted(MouseEvent event) {

    }
    
}
