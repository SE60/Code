/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se_restaurant_real;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author l3oat
 */
public class DBConnection {
    private static final String DRIVER="com.mysql.jdbc.Driver";
    private static final String JDBC_URL="jdbc:mysql://localhost/restaurant?"+"user=root&password=";
    public static Connection conn;
        public DBConnection(){
            try {
                this.conn=DriverManager.getConnection(JDBC_URL);
                if(this.conn != null){
                    System.out.println("Connected to Database");
                }
            } catch (SQLException ex) {
                Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
       public void createTable(){
            try {
                conn.createStatement().execute("Create TABLE Best(ID INT NOT NULL PRIMARY KEY,Name varchar(50),Age INT,Gender char(1))");
            } catch (SQLException ex) {
                Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
            }
           }
       public void insertIntoTable(int ID,String name,int age,char gender) throws SQLException{
            try {
                conn.createStatement().execute("INSERT INTO Best Values ("+ID+",'"+name+"',"+age+",'"+gender+"')");
            } catch (SQLException ex) {
                System.out.println("KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK");
            }
              
       }
       public void printAll(){
        try {
            Statement statement =this.conn.createStatement();
            ResultSet res =statement.executeQuery("Select * FROM catalogueFood");
            while(res.next()){
                System.out.println(res.getString("name"));
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
       }
       
}
