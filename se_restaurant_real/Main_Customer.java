/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se_restaurant_real;


import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import se_restaurant_real.Controller.Main_Controller;
/**
 *
 * @author l3oat
 */
public class Main_Customer extends Application {
    
    // -------------------------------------- ploy edit ------------------------------------------------
    public static Stage mainStage;
    public static Parent root1;
    public static Parent root2;
    public static Main_Controller main_Controller;
    public static Parent cOrder;
    // -------------------------------------------------------------------------------------------------

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/GUI/src/sample/SelectTable.fxml"));
        // ---------------------------------- ploy edit ------------------------------------------
        root1 = (Parent) fxmlLoader.load();
        fxmlLoader = new FXMLLoader(getClass().getResource("/GUI/src/sample/CustomerMenu.fxml"));
        root2=(Parent) fxmlLoader.load();
        main_Controller=fxmlLoader.getController();
        
        
//        Stage stage = new Stage();
//        stage.setScene(new Scene(root1));  
//        stage.show();
        // --------------------------------- ploy edit -------------------------------------------
        mainStage = primaryStage;
        mainStage.setScene(new Scene(root1));
        mainStage.show();
        // ---------------------------------------------------------------------------------------
        
//        Main_Controller customer=new Main_Controller();
//        customer.test();;
    }

       public void setCustomerOrder() {
        try {
            FXMLLoader loader;
            loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/GUI/src/sample/CustomerTableOrder.fxml"));
            cOrder = loader.load();
            // ---------------------------------------------------------------------------------------
        } catch (IOException ex) {
            Logger.getLogger(Main_Customer.class.getName()).log(Level.SEVERE, null, ex);
        }
       
       }
    public static void main(String[] args) throws SQLException {
//----------------Save Data from File------------------//
//        try {
//            saveDataFromFile data=new saveDataFromFile();
//        } catch (FileNotFoundException ex) {
//            Logger.getLogger(Main_Customer.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (UnsupportedEncodingException ex) {
//            Logger.getLogger(Main_Customer.class.getName()).log(Level.SEVERE, null, ex);
//        }

//---------------------------------------------------//
       System.setProperty("objectdb.home", System.getProperty("user.dir") + "/src/RestaurantDB");              
       launch(args);
    }
}
