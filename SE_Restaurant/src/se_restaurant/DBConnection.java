/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se_restaurant;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.derby.shared.common.error.DerbySQLIntegrityConstraintViolationException;

/**
 *
 * @author l3oat
 */
public class DBConnection {
    private static final String DRIVER="org.apache.derby.jdbc.ClientDriver";
    private static final String JDBC_URL="jdbc:derby://localhost:1527/MyDbTest;create=true";
    Connection conn;
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
            } catch (DerbySQLIntegrityConstraintViolationException ex) {
                System.out.println("KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK");
            }
              
       }
       public void printAll(){
           int[] best = new int[100];
           int i=0;
        try {
            Statement statement =this.conn.createStatement();
            ResultSet res =statement.executeQuery("Select * FROM Best");
            while(res.next()){
                best[i]=res.getInt("Age"); 
                System.out.println(best[i]);
                i++;      
            }
            i=0;
            
            
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
       }
       
}
