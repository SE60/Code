/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se_restaurant_real;


import java.sql.SQLException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
/**
 *
 * @author l3oat
 */
public class Main extends Application {
    
    // -------------------------------------- ploy edit ------------------------------------------------
    public static Stage mainStage;
    public static Parent root1;
    public static Parent cOrder;
    // -------------------------------------------------------------------------------------------------

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/GUI/src/sample/CustomerMenu.fxml"));
        // ---------------------------------- ploy edit ------------------------------------------
        FXMLLoader loader;
        loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/GUI/src/sample/CustomerTableOrder.fxml"));
        cOrder = loader.load();
        // ---------------------------------------------------------------------------------------
       root1 = (Parent) fxmlLoader.load();
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

    public static void main(String[] args) throws SQLException {
//----------------Save Data from File------------------//
//        try {
//            saveDataFromFile data=new saveDataFromFile();
//        } catch (FileNotFoundException ex) {
//            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (UnsupportedEncodingException ex) {
//            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
//        }

//---------------------------------------------------//
        
        
        
        launch(args);
    }
}
