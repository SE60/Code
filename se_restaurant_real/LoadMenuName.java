/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se_restaurant_real;

import RestaurantDB.food_menu;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author l3oat
 */
public class LoadMenuName {
    public ArrayList<String> loadName_1(){
        ArrayList<String> obj = new ArrayList<String>();
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("$objectdb/restaurant.odb");
        EntityManager em=emf.createEntityManager();
        TypedQuery<food_menu> q1=em.createQuery("select from food_menu where cName.id=1",food_menu.class);
        for(food_menu q:q1.getResultList()){
            String mName=q.getmName();
            obj.add(mName);          
        }
        return obj;      
    }
    public ArrayList<String> loadName_2(){
        ArrayList<String> obj = new ArrayList<String>();   
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("$objectdb/restaurant.odb");
        EntityManager em=emf.createEntityManager();
        TypedQuery<food_menu> q1=em.createQuery("select from food_menu where cName.id=2",food_menu.class);
        for(food_menu q:q1.getResultList()){
            String mName=q.getmName();
            obj.add(mName);          
        }
        return obj;      
    }
    public ArrayList<String> loadName_3(){
        ArrayList<String> obj = new ArrayList<String>();
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("$objectdb/restaurant.odb");
        EntityManager em=emf.createEntityManager();
        TypedQuery<food_menu> q1=em.createQuery("select from food_menu where cName.id=3",food_menu.class);
        for(food_menu q:q1.getResultList()){
            String mName=q.getmName();
            obj.add(mName);          
        }
        return obj;      
    }
    public ArrayList<String> loadName_4(){
        ArrayList<String> obj = new ArrayList<String>();
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("$objectdb/restaurant.odb");
        EntityManager em=emf.createEntityManager();
        TypedQuery<food_menu> q1=em.createQuery("select from food_menu where cName.id=4",food_menu.class);
        for(food_menu q:q1.getResultList()){
            String mName=q.getmName();
            obj.add(mName);          
        }
        return obj;      
    }
    public ArrayList<String> loadName_5(){
        ArrayList<String> obj = new ArrayList<String>();
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("$objectdb/restaurant.odb");
        EntityManager em=emf.createEntityManager();
        TypedQuery<food_menu> q1=em.createQuery("select from food_menu where cName.id=5",food_menu.class);
        for(food_menu q:q1.getResultList()){
            String mName=q.getmName();
            obj.add(mName);          
        }
        return obj;      
    }
    public ArrayList<String> loadName_6(){
        ArrayList<String> obj = new ArrayList<String>();
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("$objectdb/restaurant.odb");
        EntityManager em=emf.createEntityManager();
        TypedQuery<food_menu> q1=em.createQuery("select from food_menu where cName.id=6",food_menu.class);
        for(food_menu q:q1.getResultList()){
            String mName=q.getmName();
            obj.add(mName);          
        }
        return obj;      
    }
    public ArrayList<String> loadName_7(){
        ArrayList<String> obj = new ArrayList<String>();
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("$objectdb/restaurant.odb");
        EntityManager em=emf.createEntityManager();
        TypedQuery<food_menu> q1=em.createQuery("select from food_menu where cName.id=7",food_menu.class);
        for(food_menu q:q1.getResultList()){
            String mName=q.getmName();
            obj.add(mName);          
        }
        return obj;      
    }
    public ArrayList<String> loadName_8(){
        ArrayList<String> obj = new ArrayList<String>();
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("$objectdb/restaurant.odb");
        EntityManager em=emf.createEntityManager();
        TypedQuery<food_menu> q1=em.createQuery("select from food_menu where cName.id=8",food_menu.class);
        for(food_menu q:q1.getResultList()){
            String mName=q.getmName();
            obj.add(mName);          
        }
        return obj;      
    }
    public ArrayList<String> loadName_9(){
        ArrayList<String> obj = new ArrayList<String>();
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("$objectdb/restaurant.odb");
        EntityManager em=emf.createEntityManager();
        TypedQuery<food_menu> q1=em.createQuery("select from food_menu where cName.id=9",food_menu.class);
        for(food_menu q:q1.getResultList()){
            String mName=q.getmName();
            obj.add(mName);          
        }
        return obj;      
    }

        
}
