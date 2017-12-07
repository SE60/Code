/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se_restaurant_real;


import java.sql.SQLException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import se_restaurant_real.Controller.ChefOrderEachTable_Controller;
import se_restaurant_real.Controller.ChefTableOrder_Controller;
import static se_restaurant_real.Main_Customer.mainStage;
import static se_restaurant_real.Main_Customer.root1;



/**
 *
 * @author TryAgain
 */
public class Main_Chef extends Application {
    
    public static Stage mainStage;
    public static Parent root1;
    public static Parent root2;
    public static ChefTableOrder_Controller chefTableOrder_Controller;
    public static ChefOrderEachTable_Controller chefOrderEachTable_Controller;
    public static Parent cOrder;
    
    public void start(Stage primaryStage) throws Exception{
        //-------------------------Load fxml root 1-------------------------------------------//
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/GUI/src/sample/ChefTableOrder.fxml"));
        root1 = (Parent) fxmlLoader.load();   
        chefTableOrder_Controller=fxmlLoader.getController();
        //-------------------------Load fxml root 2-------------------------------------------//
        fxmlLoader = new FXMLLoader(getClass().getResource("/GUI/src/sample/ChefOrderEachTable.fxml"));
        root2=(Parent) fxmlLoader.load(); 
        chefOrderEachTable_Controller=fxmlLoader.getController();
        
        primaryStage.setResizable(false);
        primaryStage.setTitle("SE_RESTAURANT_CHEF");
        mainStage = primaryStage;
        mainStage.setScene(new Scene(root1,1270,710));
        mainStage.show();
    }
    
    public static void main(String[] args) throws SQLException {     
        
        //System.out.println(System.getProperty("objectdb.home"));
        launch(args);
    }
}
