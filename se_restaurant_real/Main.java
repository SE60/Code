/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se_restaurant_real;

import java.sql.SQLException;
import se_restaurant_real.Controller.Main_Controller;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
/**
 *
 * @author l3oat
 */
public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/GUI/menu/src/sample/sample.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root1));  
        stage.show();
        
//        Main_Controller customer=new Main_Controller();
//        customer.test();;
    }


    public static void main(String[] args) throws SQLException {
        DBConnection db=new DBConnection();
        //db.createTable();
       // db.insertIntoTable(58010860,"John",25,'M');
       // db.insertIntoTable(58010870,"Florence",23,'F');
        db.printAll();
        launch(args);
    }
}
