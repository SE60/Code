/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se_restaurant_real.Controller;

import com.jfoenix.controls.JFXButton;
import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import se_restaurant_real.DBConnection;

/**
 *
 * @author l3oat
 */
public class Main_Controller {
    @FXML
    private ImageView foodPic;
    
    @FXML
    private Label text_1;
    
    @FXML
    private ImageView cid_1_1;
    
    @FXML
    private JFXButton Boat;
    
    
    @FXML
    void choose_1(MouseEvent event) {
        cid_1_1.setVisible(false);
    }
    
    @FXML
    protected void initialize()
    {
        try{
        Statement st = DBConnection.conn.createStatement();
        String sql = ("SELECT picture FROM food_menu");
        ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                java.sql.Blob blob = rs.getBlob("picture");
                InputStream in = blob.getBinaryStream(); 
                Image image=new Image(in);
                cid_1_1.setImage(image);
                System.out.println(blob);
            }    
        }catch(SQLException ex)
        {
            ex.printStackTrace();
        }
    }
    public void test() {
        System.out.println("skadpaodkwpofkp");
        //BufferedImage image = ImageIO.read(in);
        //text_1.setText("KUYYYYY");
    }
}
