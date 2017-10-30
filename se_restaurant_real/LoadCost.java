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
public class LoadCost {
    public ArrayList<Double> loadCost_1(){
        ArrayList<Double> obj = new ArrayList<Double>();
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("restaurant.odb");
        EntityManager em=emf.createEntityManager();
        TypedQuery<food_menu> q1=em.createQuery("select from food_menu where cName.id=1",food_menu.class);
        for(food_menu q:q1.getResultList()){
            Double cost=q.getPrice();
            obj.add(cost);          
        }
        return obj;      
    }
    public ArrayList<Double> loadCost_2(){
        ArrayList<Double> obj = new ArrayList<Double>();
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("restaurant.odb");
        EntityManager em=emf.createEntityManager();
        TypedQuery<food_menu> q1=em.createQuery("select from food_menu where cName.id=2",food_menu.class);
        for(food_menu q:q1.getResultList()){
            Double cost=q.getPrice();
            obj.add(cost);          
        }
        return obj;      
    }
    public ArrayList<Double> loadCost_3(){
        ArrayList<Double> obj = new ArrayList<Double>();
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("restaurant.odb");
        EntityManager em=emf.createEntityManager();
        TypedQuery<food_menu> q1=em.createQuery("select from food_menu where cName.id=2",food_menu.class);
        for(food_menu q:q1.getResultList()){
            Double cost=q.getPrice();
            obj.add(cost);          
        }
        return obj;      
    }
    public ArrayList<Double> loadCost_4(){
        ArrayList<Double> obj = new ArrayList<Double>();
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("restaurant.odb");
        EntityManager em=emf.createEntityManager();
        TypedQuery<food_menu> q1=em.createQuery("select from food_menu where cName.id=2",food_menu.class);
        for(food_menu q:q1.getResultList()){
            Double cost=q.getPrice();
            obj.add(cost);          
        }
        return obj;      
    }
    public ArrayList<Double> loadCost_5(){
        ArrayList<Double> obj = new ArrayList<Double>();
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("restaurant.odb");
        EntityManager em=emf.createEntityManager();
        TypedQuery<food_menu> q1=em.createQuery("select from food_menu where cName.id=2",food_menu.class);
        for(food_menu q:q1.getResultList()){
            Double cost=q.getPrice();
            obj.add(cost);          
        }
        return obj;      
    }
    public ArrayList<Double> loadCost_6(){
        ArrayList<Double> obj = new ArrayList<Double>();
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("restaurant.odb");
        EntityManager em=emf.createEntityManager();
        TypedQuery<food_menu> q1=em.createQuery("select from food_menu where cName.id=2",food_menu.class);
        for(food_menu q:q1.getResultList()){
            Double cost=q.getPrice();
            obj.add(cost);          
        }
        return obj;      
    }
    public ArrayList<Double> loadCost_7(){
        ArrayList<Double> obj = new ArrayList<Double>();
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("restaurant.odb");
        EntityManager em=emf.createEntityManager();
        TypedQuery<food_menu> q1=em.createQuery("select from food_menu where cName.id=2",food_menu.class);
        for(food_menu q:q1.getResultList()){
            Double cost=q.getPrice();
            obj.add(cost);          
        }
        return obj;      
    }
    public ArrayList<Double> loadCost_8(){
        ArrayList<Double> obj = new ArrayList<Double>();
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("restaurant.odb");
        EntityManager em=emf.createEntityManager();
        TypedQuery<food_menu> q1=em.createQuery("select from food_menu where cName.id=2",food_menu.class);
        for(food_menu q:q1.getResultList()){
            Double cost=q.getPrice();
            obj.add(cost);          
        }
        return obj;      
    }
    public ArrayList<Double> loadCost_9(){
        ArrayList<Double> obj = new ArrayList<Double>();
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("restaurant.odb");
        EntityManager em=emf.createEntityManager();
        TypedQuery<food_menu> q1=em.createQuery("select from food_menu where cName.id=2",food_menu.class);
        for(food_menu q:q1.getResultList()){
            Double cost=q.getPrice();
            obj.add(cost);          
        }
        return obj;      
    }
}
