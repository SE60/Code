/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se_restaurant_real.Controller;

import RestaurantDB.Ordered;

import RestaurantDB.food_menu;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.Pagination;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.util.Callback;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import se_restaurant_real.LoadCost;
import se_restaurant_real.Main_Customer;
import se_restaurant_real.LoadMenuName;
import se_restaurant_real.LoadPicture;
import se_restaurant_real.LoadQuality;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javax.persistence.Query;
import se_restaurant_real.DB_Connection;
import se_restaurant_real.DupicateOrdered;
import se_restaurant_real.LoadOrdered;
import static se_restaurant_real.Main_Customer.cOrder;
import se_restaurant_real.SetPageOrdered;

/**
 *
 * @author l3oat
 */
public class CustomerMenu_Controller {
    
    @FXML private Label text_1;
    @FXML private List<AnchorPane> pagiViewList_1,pagiViewList_2,pagiViewList_3,pagiViewList_4,pagiViewList_5,pagiViewList_6,pagiViewList_7,pagiViewList_8,pagiViewList_9 ;
    @FXML private List<ImageView> imageViewList_1,imageViewList_2,imageViewList_3,imageViewList_4,imageViewList_5,imageViewList_6,imageViewList_7,imageViewList_8,imageViewList_9 ;    
    @FXML private List<Label> nameViewList_1,nameViewList_2,nameViewList_3,nameViewList_4,nameViewList_5,nameViewList_6,nameViewList_7,nameViewList_8,nameViewList_9 ;
    @FXML private List<Label> costViewList_1,costViewList_2,costViewList_3,costViewList_4,costViewList_5,costViewList_6,costViewList_7,costViewList_8,costViewList_9 ;
    @FXML private List<Label> currencyViewList_1,currencyViewList_2,currencyViewList_3,currencyViewList_4,currencyViewList_5,currencyViewList_6,currencyViewList_7,currencyViewList_8,currencyViewList_9 ;
    @FXML private List<Label> orderedViewList;
    @FXML private List<Spinner<Integer>> increaseViewList;
    @FXML private List<ImageView> deleteViewList; 
    @FXML private AnchorPane A_2_AfterOrdered,A_1_BeforeOrdered;
    @FXML private List<Pagination> slideViewList;
    @FXML private List<AnchorPane> catalogueViewList;
    @FXML public  Label tableNumber;
    @FXML private ScrollPane ordered_Scroll;
    public int tempTableNumber;
    
   //----------------------------Define ArrayList--------------------------------------// 
    private ArrayList<List<ImageView>> imageViewList=new ArrayList<List<ImageView>>();
    private ArrayList<List<Label>> nameViewList=new ArrayList<List<Label>>();
    private ArrayList<List<Label>> costViewList=new ArrayList<List<Label>>();
    private ArrayList<List<Label>> currencyViewList=new ArrayList<List<Label>>();
    private ArrayList<Double> priceViewList=new ArrayList<Double>();
    
   //--------------------------------------------Set initial value-----------------------------------------//
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
           currencyViewList_1.get(i).setVisible(false);
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
           currencyViewList_2.get(i).setVisible(false);
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
           currencyViewList_3.get(i).setVisible(false);
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
           currencyViewList_4.get(i).setVisible(false);
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
           currencyViewList_5.get(i).setVisible(false);
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
           currencyViewList_6.get(i).setVisible(false);
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
           currencyViewList_7.get(i).setVisible(false);
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
           currencyViewList_8.get(i).setVisible(false);
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
           currencyViewList_9.get(i).setVisible(false);
       }
//-------------------------------------Set pagination pane------------------------------------------------//     
       //-------------------get database connection------------------------------//
        DB_Connection conn=new DB_Connection();
        EntityManager em=conn.getConnection();
        //------------------------------------------------------------------------//
       em.getTransaction().begin();
       

       slideViewList.get(0).setPageCount(quality.loadQuality_1());
       slideViewList.get(0).setPageFactory(new Callback<Integer,Node>() {
           @Override
           public Node call(Integer param){     
            imageViewList_1.get(param).setVisible(true);
            nameViewList_1.get(param).setVisible(true);
            costViewList_1.get(param).setVisible(true);
            currencyViewList_1.get(param).setVisible(true);
            return pagiViewList_1.get(param);
           }
       });
//----------------------------------------end page 1-----------------------------------------------------//
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
             currencyViewList_2.get(param*2).setVisible(true);
             currencyViewList_2.get(param*2+1).setVisible(true);
            return pagiViewList_2.get(param);
           }
       });
//----------------------------------------end page 2-----------------------------------------------------//       
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
             currencyViewList_3.get(param*2).setVisible(true);
             currencyViewList_3.get(param*2+1).setVisible(true);
            return pagiViewList_3.get(param);
           }
       });
//----------------------------------------end page 3-----------------------------------------------------//
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
             currencyViewList_4.get(param*2).setVisible(true);
             currencyViewList_4.get(param*2+1).setVisible(true);
            return pagiViewList_4.get(param);
           }
       });
//----------------------------------------end page 4-----------------------------------------------------//
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
             currencyViewList_5.get(param*2).setVisible(true);
             currencyViewList_5.get(param*2+1).setVisible(true);
            return pagiViewList_5.get(param);
           }
       });
//----------------------------------------end page 5-----------------------------------------------------//
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
             currencyViewList_6.get(param*2).setVisible(true);
             currencyViewList_6.get(param*2+1).setVisible(true);
            return pagiViewList_6.get(param);
           }
       });
////----------------------------------------end page 6-----------------------------------------------------//
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
             currencyViewList_7.get(param*2).setVisible(true);
             currencyViewList_7.get(param*2+1).setVisible(true);
            return pagiViewList_7.get(param);
           }
       });
////----------------------------------------end page 7-----------------------------------------------------//
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
             currencyViewList_8.get(param*2).setVisible(true);
             currencyViewList_8.get(param*2+1).setVisible(true);
            return pagiViewList_8.get(param);
           }
       });
////----------------------------------------end page 8-----------------------------------------------------//
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
             currencyViewList_9.get(param*2).setVisible(true);
             currencyViewList_9.get(param*2+1).setVisible(true);
            return pagiViewList_9.get(param);
           }
       });
////----------------------------------------end page 9-----------------------------------------------------//
//------------------------------------------add imageViewList----------------------------------------------//
        imageViewList.add(imageViewList_1);
        imageViewList.add(imageViewList_2);
        imageViewList.add(imageViewList_3);
        imageViewList.add(imageViewList_4);
        imageViewList.add(imageViewList_5);
        imageViewList.add(imageViewList_6);
        imageViewList.add(imageViewList_7);
        imageViewList.add(imageViewList_8);
        imageViewList.add(imageViewList_9);
//------------------------------------------Add nameViewList----------------------------------------------//
        nameViewList.add(nameViewList_1);
        nameViewList.add(nameViewList_2);
        nameViewList.add(nameViewList_3);
        nameViewList.add(nameViewList_4);
        nameViewList.add(nameViewList_5);
        nameViewList.add(nameViewList_6);
        nameViewList.add(nameViewList_7);
        nameViewList.add(nameViewList_8);
        nameViewList.add(nameViewList_9);
//------------------------------------------Add costViewList---------------------------------------------//
        costViewList.add(costViewList_1);
        costViewList.add(costViewList_2);
        costViewList.add(costViewList_3);
        costViewList.add(costViewList_4);
        costViewList.add(costViewList_5);
        costViewList.add(costViewList_6);
        costViewList.add(costViewList_7);
        costViewList.add(costViewList_8);
        costViewList.add(costViewList_9);
        
        //--------------------------close connection---------------------------------------------------//
        conn.closeConnection();
        
    }
    
    
    @FXML
    void ordered_Clicked(MouseEvent event) {
        ArrayList<String> aName=new ArrayList<String>();
        ArrayList<Integer> quality=new ArrayList<Integer>();
        int checkEmpty=0;
        for(int i=0;i<orderedViewList.size();i++){
            if(orderedViewList.get(i).getText()=="") checkEmpty++;
        }
        if(checkEmpty==orderedViewList.size()){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning Dialog");
            alert.setHeaderText("Your list is empty");
            alert.setContentText("Please list your menu before order");
            alert.showAndWait();
        }
        
        else
        {
            //-------------------get database connection------------------------------//
            DB_Connection conn=new DB_Connection();
            EntityManager em=conn.getConnection();
            //------------------------------------------------------------------------//
            em.getTransaction().begin();
            for(int i=0;i<orderedViewList.size();i++){
                aName.add(orderedViewList.get(i).getText());
                quality.add(increaseViewList.get(i).getValue());                            
            }
            Ordered ordered=new Ordered(SelectTable_Controller.tableInt,aName,quality,priceViewList,false);
            em.persist(ordered);
            em.getTransaction().commit();
            System.out.println("Save order in database");
            //------------------close connection-------------------------------------//
            conn.closeConnection();
            //-----------------------------Clear order list------------------------------------//
            for(int i=0;i<orderedViewList.size();i++){
                increaseViewList.get(i).setVisible(false);
                increaseViewList.get(i).getValueFactory().setValue(1);
                deleteViewList.get(i).setVisible(false);
                orderedViewList.get(i).setText("");               
            } 
            //----------------------Clear Price-------------------------------//
            priceViewList.clear();
            ordered_Scroll.setVvalue(0);
            //----------Change page if orderedViewList not empty--------------//
            SetPageOrdered setPageOrdered=new SetPageOrdered(A_2_AfterOrdered,A_1_BeforeOrdered);
            setPageOrdered.setPageInVisislbe();
            A_1_BeforeOrdered=setPageOrdered.getA_1_BeforeOrdered();
            A_2_AfterOrdered=setPageOrdered.getA_2_AfterOrdered();   
            // ----------------------------- Ploy edit -----------------------------------------
            try {
            FXMLLoader loader;
            loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/GUI/src/sample/CustomerToChef.fxml"));
            cOrder = loader.load();
            // ---------------------------------------------------------------------------------------
            } catch (IOException ex) {
                Logger.getLogger(Main_Customer.class.getName()).log(Level.SEVERE, null, ex);
            }
            Main_Customer.mainStage.getScene().setRoot(Main_Customer.cOrder);
            // ---------------------------------------------------------------------------------
        }
        
        
    }

//-----------------Ordered Check Method-----------------------//
    public void checkOrdered(String name,double price){
        DupicateOrdered dupicateOrdered=new DupicateOrdered(orderedViewList,name,increaseViewList);
        if(!dupicateOrdered.isDupicate()&&!dupicateOrdered.isOver14())
            for(int i=0;i<orderedViewList.size();i++){
                if(orderedViewList.get(i).getText()== ""){
                    if(i>=7) 
                    ordered_Scroll.setVvalue((double)i/orderedViewList.size());                   
                    priceViewList.add(price);
                    orderedViewList.get(i).setText(name);
                    increaseViewList.get(i).setVisible(true);
                    deleteViewList.get(i).setVisible(true);
                    break;
                }
            }
    }
   
//-----------------Picture Clicked Method--------------------//
    @FXML
    void pid_Clicked(MouseEvent event) {  
        //----------Change page if orderedViewList not empty--------------//
        SetPageOrdered setPageOrdered=new SetPageOrdered(A_2_AfterOrdered,A_1_BeforeOrdered);
        setPageOrdered.setPageVisible();
        A_1_BeforeOrdered=setPageOrdered.getA_1_BeforeOrdered();
        A_2_AfterOrdered=setPageOrdered.getA_2_AfterOrdered();
        //--------------------Find menu name-----------------------------//
        ImageView cbtn = (ImageView)event.getSource();
        int indexOfCatalogue=slideViewList.indexOf(((ImageView)event.getSource()).getParent().getParent().getParent());
        int indexOfPicture = imageViewList.get(indexOfCatalogue).indexOf(cbtn);
        LoadOrdered loadOrdered=new LoadOrdered(indexOfPicture,nameViewList.get(indexOfCatalogue),costViewList.get(indexOfCatalogue));
        checkOrdered(loadOrdered.getName(),loadOrdered.getCost());
    }
    
    @FXML
    void order_1_deleted(MouseEvent event) {
        
        ImageView cbtn = (ImageView)event.getSource();
        int index = deleteViewList.indexOf(cbtn);
        priceViewList.remove(index);
        deleteMeal(index);
    }
    
    @FXML
    void deleteMeal(int index) {
        if(index<13)
            if(increaseViewList.get(index+1) == null || !increaseViewList.get(index+1).isVisible())
                {
                    deleteGui(index);
                }
            else
                {
                    copyValue(index+1,index);
                    deleteMeal(index+1);
                }
        else{
            deleteGui(index);
        }     
    }
    
    @FXML
    void deleteGui(int index) {
       orderedViewList.get(index).setText("");
       increaseViewList.get(index).setVisible(false);
       increaseViewList.get(index).getValueFactory().setValue(1);
       deleteViewList.get(index).setVisible(false);
    }
    
    @FXML
    void copyValue(int source,int destination){
        orderedViewList.get(destination).setText(orderedViewList.get(source).getText());
        increaseViewList.get(destination).getValueFactory().setValue(increaseViewList.get(source).getValue());
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
