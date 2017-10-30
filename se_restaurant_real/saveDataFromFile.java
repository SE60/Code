/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se_restaurant_real;

import RestaurantDB.food_Catalogue;
import RestaurantDB.food_menu;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author l3oat
 */
public class saveDataFromFile {
    public saveDataFromFile() throws FileNotFoundException, FileNotFoundException, UnsupportedEncodingException{
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("restaurant.odb");
        EntityManager em=emf.createEntityManager();
        EntityManager em2=emf.createEntityManager();
        em.getTransaction().begin();        
        //em.getMetamodel().entity(application.entity.Agent.class);
            
        System.out.println("Clearing database...");
        //em.createQuery("DELETE FROM food_menu").executeUpdate();
        
        System.out.println("Inserting new sample data...");
        FileReader f;
        BufferedReader buff;
        String line = "";
        String[] arr = null;
            // Agent
        food_menu menu;
        try {          
            String filename = "data_9.txt";
            String workingDirectory = System.getProperty("user.dir");
            String absoluteFilePath = "";
            absoluteFilePath = workingDirectory + File.separator + filename;
            System.out.println("Final filepath : " + absoluteFilePath);
            buff = new BufferedReader(new InputStreamReader(new FileInputStream(absoluteFilePath),"UTF-8"));
            try {               
                while ((line = buff.readLine()) != null) {
                    arr = line.split(",");
                    System.out.println(arr[0]);
                    double price=Double.parseDouble(arr[1]);
                    System.out.println(price);
                    TypedQuery<food_Catalogue> q1 = em2.createQuery("SELECT ca FROM food_Catalogue ca WHERE ca.id = 9", food_Catalogue.class);                   
                        for (food_Catalogue ca : q1.getResultList()) {
                            menu=new food_menu(ca,arr[0],price,arr[2]);
                            em.persist(menu);
                    }                                   
                        
                }   
                em.getTransaction().commit();
                em2.close();
            } catch (IOException ex) {
                Logger.getLogger(saveDataFromFile.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(saveDataFromFile.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        
    }
        
}
