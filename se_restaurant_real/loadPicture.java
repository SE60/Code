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
public class loadPicture {
    public ArrayList<Image> LoadPicture_Catalogue_1()
    {
        ArrayList<Image> obj = new ArrayList<Image>();
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("restaurant.odb");
        EntityManager em=emf.createEntityManager();
        em.getTransaction().begin();
        TypedQuery<food_menu> q1=em.createQuery("select from food_menu where cName.id=1",food_menu.class);
        for(food_menu q:q1.getResultList())
        {
           File imgfile = new File(q.getImage());
           try {
               FileInputStream fin = new FileInputStream(imgfile);
               Image image=new Image(fin); 
               obj.add(image);
               
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }         
           
        }
        return obj;
    }
    public ArrayList<Image> LoadPicture_Catalogue_2()
    {
        ArrayList<Image> obj = new ArrayList<Image>();
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("restaurant.odb");
        EntityManager em=emf.createEntityManager();
        em.getTransaction().begin();
        TypedQuery<food_menu> q1=em.createQuery("select from food_menu where cName.id=2",food_menu.class);
        for(food_menu q:q1.getResultList())
        {
           File imgfile = new File(q.getImage());
           try {
               FileInputStream fin = new FileInputStream(imgfile);
               Image image=new Image(fin); 
               obj.add(image);
               
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }         
           
        }
        return obj;
    }
    public ArrayList<Image> LoadPicture_Catalogue_3()
    {
        ArrayList<Image> obj = new ArrayList<Image>();
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("restaurant.odb");
        EntityManager em=emf.createEntityManager();
        em.getTransaction().begin();
        TypedQuery<food_menu> q1=em.createQuery("select from food_menu where cName.id=3",food_menu.class);
        for(food_menu q:q1.getResultList())
        {
           File imgfile = new File(q.getImage());
           try {
               FileInputStream fin = new FileInputStream(imgfile);
               Image image=new Image(fin); 
               obj.add(image);
               
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }         
           
        }
        return obj;
    }
    public ArrayList<Image> LoadPicture_Catalogue_4()
    {
        ArrayList<Image> obj = new ArrayList<Image>();
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("restaurant.odb");
        EntityManager em=emf.createEntityManager();
        em.getTransaction().begin();
        TypedQuery<food_menu> q1=em.createQuery("select from food_menu where cName.id=4",food_menu.class);
        for(food_menu q:q1.getResultList())
        {
           File imgfile = new File(q.getImage());
           try {
               FileInputStream fin = new FileInputStream(imgfile);
               Image image=new Image(fin); 
               obj.add(image);
               
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }         
           
        }
        return obj;
    }
    public ArrayList<Image> LoadPicture_Catalogue_5()
    {
        ArrayList<Image> obj = new ArrayList<Image>();
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("restaurant.odb");
        EntityManager em=emf.createEntityManager();
        em.getTransaction().begin();
        TypedQuery<food_menu> q1=em.createQuery("select from food_menu where cName.id=5",food_menu.class);
        for(food_menu q:q1.getResultList())
        {
           File imgfile = new File(q.getImage());
           try {
               FileInputStream fin = new FileInputStream(imgfile);
               Image image=new Image(fin); 
               obj.add(image);
               
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }         
           
        }
        return obj;
    }
    public ArrayList<Image> LoadPicture_Catalogue_6()
    {
        ArrayList<Image> obj = new ArrayList<Image>();
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("restaurant.odb");
        EntityManager em=emf.createEntityManager();
        em.getTransaction().begin();
        TypedQuery<food_menu> q1=em.createQuery("select from food_menu where cName.id=6",food_menu.class);
        for(food_menu q:q1.getResultList())
        {
           File imgfile = new File(q.getImage());
           try {
               FileInputStream fin = new FileInputStream(imgfile);
               Image image=new Image(fin); 
               obj.add(image);
               
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }         
           
        }
        return obj;
    }
    public ArrayList<Image> LoadPicture_Catalogue_7()
    {
        ArrayList<Image> obj = new ArrayList<Image>();
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("restaurant.odb");
        EntityManager em=emf.createEntityManager();
        em.getTransaction().begin();
        TypedQuery<food_menu> q1=em.createQuery("select from food_menu where cName.id=7",food_menu.class);
        for(food_menu q:q1.getResultList())
        {
           File imgfile = new File(q.getImage());
           try {
               FileInputStream fin = new FileInputStream(imgfile);
               Image image=new Image(fin); 
               obj.add(image);
               
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }         
           
        }
        return obj;
    }
    public ArrayList<Image> LoadPicture_Catalogue_8()
    {
        ArrayList<Image> obj = new ArrayList<Image>();
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("restaurant.odb");
        EntityManager em=emf.createEntityManager();
        em.getTransaction().begin();
        TypedQuery<food_menu> q1=em.createQuery("select from food_menu where cName.id=8",food_menu.class);
        for(food_menu q:q1.getResultList())
        {
           File imgfile = new File(q.getImage());
           try {
               FileInputStream fin = new FileInputStream(imgfile);
               Image image=new Image(fin); 
               obj.add(image);
               
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }         
           
        }
        return obj;
    }
    public ArrayList<Image> LoadPicture_Catalogue_9()
    {
        ArrayList<Image> obj = new ArrayList<Image>();
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("restaurant.odb");
        EntityManager em=emf.createEntityManager();
        em.getTransaction().begin();
        TypedQuery<food_menu> q1=em.createQuery("select from food_menu where cName.id=9",food_menu.class);
        for(food_menu q:q1.getResultList())
        {
           File imgfile = new File(q.getImage());
           try {
               FileInputStream fin = new FileInputStream(imgfile);
               Image image=new Image(fin); 
               obj.add(image);
               
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }         
           
        }
        return obj;
    }
}
