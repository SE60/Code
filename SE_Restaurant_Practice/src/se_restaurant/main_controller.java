/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se_restaurant;

import javafx.scene.input.MouseEvent;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TabPane;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author l3oat
 */
public class main_controller {
    int checkBox_1=0;
    int checkBox_2=0;
    int checkBox_3=0;
    @FXML
    private TabPane tab;
    @FXML
    private Label text_1;

    @FXML
    private Label text_2;

    @FXML
    private Label text_3;

    @FXML
    private Label text_4;

    @FXML
    private Label text_5;
    
    @FXML
    private SplitPane ordered;
    @FXML
     void handleButtonAction(ActionEvent event) {
           System.out.println("yoyoy");
    }
    
     @FXML
    void checkBox_1(ActionEvent event) {
        if (checkBox_1==0)checkBox_1=1;
        else checkBox_1=0;
        System.out.println(checkBox_1);
    }

    @FXML
    void checkBox_2(ActionEvent event) {
        if (checkBox_2==0)checkBox_2=1;
        else checkBox_2=0;
        System.out.println(checkBox_2);
    }

    @FXML
    void checkBox_3(ActionEvent event) {
        if (checkBox_3==0)checkBox_3=1;
        else checkBox_3=0;
        System.out.println(checkBox_3);
    }
    
    @FXML
    void completeButton(ActionEvent event) throws IOException {
        if(checkBox_1==1 && checkBox_2==1 && checkBox_3==1){
            //create object//
//            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("complete_GUI.fxml"));
//            Parent root1 = (Parent) fxmlLoader.load();
//            Stage stage = new Stage();
//            //stage.initModality(Modality.APPLICATION_MODAL);
//            //stage.initStyle(StageStyle.UNDECORATED);
//            stage.setTitle("Complete");
//            stage.setScene(new Scene(root1));  
//            stage.show();
              tab.setVisible(true);
            //----------------------------//
            System.out.println("Can complete");
        }
        else 
        {
            System.out.println("Cannot complete");
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setHeaderText("check all dialog");
            alert.setContentText("please check all dialog before complete");
            alert.showAndWait();
        }
    }
    
    @FXML
    void Disconnect(ActionEvent event) {
        text_1.setText("");
        text_2.setText("");
        text_3.setText("");
        text_4.setText("");
        text_5.setText("");     
        tab.setVisible(false); 
    }
    public Label checkEmptyText()
    {
        if((text_1.getText() == null || text_1.getText().trim().isEmpty())) return text_1;
        else if((text_2.getText() == null || text_2.getText().trim().isEmpty())) return text_2;
        else if((text_3.getText() == null || text_3.getText().trim().isEmpty())) return text_3;
        else if((text_4.getText() == null || text_4.getText().trim().isEmpty())) return text_4;
        else if((text_5.getText() == null || text_5.getText().trim().isEmpty())) return text_5;
        else{
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText("Limit order");
            alert.setContentText("you can not list more");

            alert.showAndWait();
            return null;
        }
    }
    public boolean isOrdered(String order)
    {
        if(text_1.getText()==order) return true;
        else if(text_2.getText()==order) return true;
        else if(text_3.getText()==order) return true;
        else if(text_4.getText()==order) return true;
        else if(text_5.getText()==order) return true;
        return false ;
    }
    @FXML
    void Choose_1(MouseEvent event) {
//        if(isOrdered("aaa"))
//        {
//            Alert alert = new Alert(AlertType.INFORMATION);
//            alert.setTitle("Information Dialog");
//            alert.setHeaderText("You have ordered");
//            alert.setContentText("please increase quality on right side");
//
//            alert.showAndWait();
//        }
        checkEmptyText().setText("aaa");
    }

    @FXML
    void Choose_2(MouseEvent event) {
        if(isOrdered("bbb"))
        {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText("You have ordered");
            alert.setContentText("please increase quality on right side");

            alert.showAndWait();
        }
        else checkEmptyText().setText("bbb");
    }
    
    @FXML
    void orderedPane(MouseEvent event) {
        ordered.setDividerPositions(0.7);
    }

}
