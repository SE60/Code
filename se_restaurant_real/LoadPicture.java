/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se_restaurant_real;

import RestaurantDB.food_menu;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.image.Image;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author l3oat
 */
public class LoadPicture {
    public ArrayList<Image> loadPicture_Catalogue_1()
    {
        System.out.println("<LoadPicture> Loading picture form Catalogue_1...");
        
        ArrayList<Image> obj = new ArrayList<Image>();
        
        DB_Connection conn=new DB_Connection();
        EntityManager em=conn.getConnection();
        em.getTransaction().begin();
        TypedQuery<food_menu> q1=em.createQuery("select from food_menu where cName.id=1",food_menu.class);
        for(food_menu q:q1.getResultList())
        {
           File starting = new File(System.getProperty("user.dir"));
           File imgfile = new File(starting,q.getImage());
           try {
               FileInputStream fin = new FileInputStream(imgfile);
               Image image=new Image(fin); 
               obj.add(image);
               
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Main_Customer.class.getName()).log(Level.SEVERE, null, ex);
            }         

        }
        conn.closeConnection();
        return obj;
    }
    public ArrayList<Image> loadPicture_Catalogue_2()
    {
        System.out.println("<LoadPicture> Loading picture form Catalogue_2...");
        ArrayList<Image> obj = new ArrayList<Image>();
        
        DB_Connection conn=new DB_Connection();
        EntityManager em=conn.getConnection();
        em.getTransaction().begin();
        TypedQuery<food_menu> q1=em.createQuery("select from food_menu where cName.id=2",food_menu.class);
        for(food_menu q:q1.getResultList())
        {
           File starting = new File(System.getProperty("user.dir"));
           File imgfile = new File(starting,q.getImage());
           try {
               FileInputStream fin = new FileInputStream(imgfile);
               Image image=new Image(fin); 
               obj.add(image);
               
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Main_Customer.class.getName()).log(Level.SEVERE, null, ex);
            }         
  
        }
        conn.closeConnection();
        return obj;
    }
    public ArrayList<Image> loadPicture_Catalogue_3()
    {
        System.out.println("<LoadPicture> Loading picture form Catalogue_3...");
        ArrayList<Image> obj = new ArrayList<Image>();
        
        DB_Connection conn=new DB_Connection();
        EntityManager em=conn.getConnection();
        em.getTransaction().begin();
        TypedQuery<food_menu> q1=em.createQuery("select from food_menu where cName.id=3",food_menu.class);
        for(food_menu q:q1.getResultList())
        {
           File starting = new File(System.getProperty("user.dir"));
           File imgfile = new File(starting,q.getImage());
           try {
               FileInputStream fin = new FileInputStream(imgfile);
               Image image=new Image(fin); 
               obj.add(image);
               
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Main_Customer.class.getName()).log(Level.SEVERE, null, ex);
            }         
           
        }
        conn.closeConnection();
        return obj;
    }
    public ArrayList<Image> loadPicture_Catalogue_4()
    {
        System.out.println("<LoadPicture> Loading picture form Catalogue_4...");
        ArrayList<Image> obj = new ArrayList<Image>();
        
        DB_Connection conn=new DB_Connection();
        EntityManager em=conn.getConnection();
        em.getTransaction().begin();
        TypedQuery<food_menu> q1=em.createQuery("select from food_menu where cName.id=4",food_menu.class);
        for(food_menu q:q1.getResultList())
        {
           File starting = new File(System.getProperty("user.dir"));
           File imgfile = new File(starting,q.getImage());
           try {
               FileInputStream fin = new FileInputStream(imgfile);
               Image image=new Image(fin); 
               obj.add(image);
               
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Main_Customer.class.getName()).log(Level.SEVERE, null, ex);
            }         
           
        }
        conn.closeConnection();
        return obj;
    }
    public ArrayList<Image> loadPicture_Catalogue_5()
    {
        System.out.println("<LoadPicture> Loading picture form Catalogue_5...");
        ArrayList<Image> obj = new ArrayList<Image>();
        
        DB_Connection conn=new DB_Connection();
        EntityManager em=conn.getConnection();
        em.getTransaction().begin();
        TypedQuery<food_menu> q1=em.createQuery("select from food_menu where cName.id=5",food_menu.class);
        for(food_menu q:q1.getResultList())
        {
           File starting = new File(System.getProperty("user.dir"));
           File imgfile = new File(starting,q.getImage());
           try {
               FileInputStream fin = new FileInputStream(imgfile);
               Image image=new Image(fin); 
               obj.add(image);
               
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Main_Customer.class.getName()).log(Level.SEVERE, null, ex);
            }         
           
        }
        conn.closeConnection();
        return obj;
    }
    public ArrayList<Image> loadPicture_Catalogue_6()
    {
        System.out.println("<LoadPicture> Loading picture form Catalogue_6...");
        ArrayList<Image> obj = new ArrayList<Image>();
        
        DB_Connection conn=new DB_Connection();
        EntityManager em=conn.getConnection();
        em.getTransaction().begin();
        TypedQuery<food_menu> q1=em.createQuery("select from food_menu where cName.id=6",food_menu.class);
        for(food_menu q:q1.getResultList())
        {
           File starting = new File(System.getProperty("user.dir"));
           File imgfile = new File(starting,q.getImage());
           try {
               FileInputStream fin = new FileInputStream(imgfile);
               Image image=new Image(fin); 
               obj.add(image);
               
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Main_Customer.class.getName()).log(Level.SEVERE, null, ex);
            }         
           
        }
        conn.closeConnection();
        return obj;
    }
    public ArrayList<Image> loadPicture_Catalogue_7()
    {
        System.out.println("<LoadPicture> Loading picture form Catalogue_7...");
        ArrayList<Image> obj = new ArrayList<Image>();
        
        DB_Connection conn=new DB_Connection();
        EntityManager em=conn.getConnection();
        em.getTransaction().begin();
        TypedQuery<food_menu> q1=em.createQuery("select from food_menu where cName.id=7",food_menu.class);
        for(food_menu q:q1.getResultList())
        {
           File starting = new File(System.getProperty("user.dir"));
           File imgfile = new File(starting,q.getImage());
           try {
               FileInputStream fin = new FileInputStream(imgfile);
               Image image=new Image(fin); 
               obj.add(image);
               
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Main_Customer.class.getName()).log(Level.SEVERE, null, ex);
            }         
           
        }
        conn.closeConnection();
        return obj;
    }
    public ArrayList<Image> loadPicture_Catalogue_8()
    {
        System.out.println("<LoadPicture> Loading picture form Catalogue_8...");
        ArrayList<Image> obj = new ArrayList<Image>();
        
        DB_Connection conn=new DB_Connection();
        EntityManager em=conn.getConnection();
        em.getTransaction().begin();
        TypedQuery<food_menu> q1=em.createQuery("select from food_menu where cName.id=8",food_menu.class);
        for(food_menu q:q1.getResultList())
        {
           File starting = new File(System.getProperty("user.dir"));
           File imgfile = new File(starting,q.getImage());
           try {
               FileInputStream fin = new FileInputStream(imgfile);
               Image image=new Image(fin); 
               obj.add(image);
               
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Main_Customer.class.getName()).log(Level.SEVERE, null, ex);
            }         
           
        }
        conn.closeConnection();
        return obj;
    }
    public ArrayList<Image> loadPicture_Catalogue_9()
    {
        System.out.println("<LoadPicture> Loading picture form Catalogue_9...");
        ArrayList<Image> obj = new ArrayList<Image>();
        
        DB_Connection conn=new DB_Connection();
        EntityManager em=conn.getConnection();
        em.getTransaction().begin();
        TypedQuery<food_menu> q1=em.createQuery("select from food_menu where cName.id=9",food_menu.class);
        for(food_menu q:q1.getResultList())
        {
           File starting = new File(System.getProperty("user.dir"));
           File imgfile = new File(starting,q.getImage());
           try {
               FileInputStream fin = new FileInputStream(imgfile);
               Image image=new Image(fin); 
               obj.add(image);
               
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Main_Customer.class.getName()).log(Level.SEVERE, null, ex);
            }         
           
        }
        conn.closeConnection();
        return obj;
    }
}
