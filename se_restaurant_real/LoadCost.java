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
        System.out.println("<LoadCost> Loading cost form Catalogue_1...");
        ArrayList<Double> obj = new ArrayList<Double>();
        
        DB_Connection conn=new DB_Connection();
        EntityManager em=conn.getConnection();
        TypedQuery<food_menu> q1=em.createQuery("select from food_menu where cName.id=1",food_menu.class);
        for(food_menu q:q1.getResultList()){
            Double cost=q.getPrice();
            obj.add(cost);          
        }
        conn.closeConnection();
        return obj;      
    }
    public ArrayList<Double> loadCost_2(){
        System.out.println("<LoadCost> Loading cost form Catalogue_2...");
        ArrayList<Double> obj = new ArrayList<Double>();
        
        DB_Connection conn=new DB_Connection();
        EntityManager em=conn.getConnection();
        TypedQuery<food_menu> q1=em.createQuery("select from food_menu where cName.id=2",food_menu.class);
        for(food_menu q:q1.getResultList()){
            Double cost=q.getPrice();
            obj.add(cost);          
        }
        conn.closeConnection();
        return obj;      
    }
    public ArrayList<Double> loadCost_3(){
        System.out.println("<LoadCost> Loading cost form Catalogue_3...");
        ArrayList<Double> obj = new ArrayList<Double>();
        
        DB_Connection conn=new DB_Connection();
        EntityManager em=conn.getConnection();
        TypedQuery<food_menu> q1=em.createQuery("select from food_menu where cName.id=2",food_menu.class);
        for(food_menu q:q1.getResultList()){
            Double cost=q.getPrice();
            obj.add(cost);          
        }
        conn.closeConnection();
        return obj;      
    }
    public ArrayList<Double> loadCost_4(){
        System.out.println("<LoadCost> Loading cost form Catalogue_4...");
        ArrayList<Double> obj = new ArrayList<Double>();
        
        DB_Connection conn=new DB_Connection();
        EntityManager em=conn.getConnection();
        TypedQuery<food_menu> q1=em.createQuery("select from food_menu where cName.id=2",food_menu.class);
        for(food_menu q:q1.getResultList()){
            Double cost=q.getPrice();
            obj.add(cost);          
        }
        conn.closeConnection();
        return obj;      
    }
    public ArrayList<Double> loadCost_5(){
        System.out.println("<LoadCost> Loading cost form Catalogue_5...");
        ArrayList<Double> obj = new ArrayList<Double>();
        
        DB_Connection conn=new DB_Connection();
        EntityManager em=conn.getConnection();
        TypedQuery<food_menu> q1=em.createQuery("select from food_menu where cName.id=2",food_menu.class);
        for(food_menu q:q1.getResultList()){
            Double cost=q.getPrice();
            obj.add(cost);          
        }
        conn.closeConnection();
        return obj;      
    }
    public ArrayList<Double> loadCost_6(){
        System.out.println("<LoadCost> Loading cost form Catalogue_6...");
        ArrayList<Double> obj = new ArrayList<Double>();
        
        DB_Connection conn=new DB_Connection();
        EntityManager em=conn.getConnection();
        TypedQuery<food_menu> q1=em.createQuery("select from food_menu where cName.id=2",food_menu.class);
        for(food_menu q:q1.getResultList()){
            Double cost=q.getPrice();
            obj.add(cost);          
        }
        conn.closeConnection();
        return obj;      
    }
    public ArrayList<Double> loadCost_7(){
        System.out.println("<LoadCost> Loading cost form Catalogue_7...");
        ArrayList<Double> obj = new ArrayList<Double>();
        
        DB_Connection conn=new DB_Connection();
        EntityManager em=conn.getConnection();
        TypedQuery<food_menu> q1=em.createQuery("select from food_menu where cName.id=2",food_menu.class);
        for(food_menu q:q1.getResultList()){
            Double cost=q.getPrice();
            obj.add(cost);          
        }
        conn.closeConnection();
        return obj;      
    }
    public ArrayList<Double> loadCost_8(){
        System.out.println("<LoadCost> Loading cost form Catalogue_8...");
        ArrayList<Double> obj = new ArrayList<Double>();
        
        DB_Connection conn=new DB_Connection();
        EntityManager em=conn.getConnection();
        TypedQuery<food_menu> q1=em.createQuery("select from food_menu where cName.id=2",food_menu.class);
        for(food_menu q:q1.getResultList()){
            Double cost=q.getPrice();
            obj.add(cost);          
        }
        conn.closeConnection();
        return obj;      
    }
    public ArrayList<Double> loadCost_9(){
        System.out.println("<LoadCost> Loading cost form Catalogue_9...");
        ArrayList<Double> obj = new ArrayList<Double>();
        
        DB_Connection conn=new DB_Connection();
        EntityManager em=conn.getConnection();
        TypedQuery<food_menu> q1=em.createQuery("select from food_menu where cName.id=2",food_menu.class);
        for(food_menu q:q1.getResultList()){
            Double cost=q.getPrice();
            obj.add(cost);          
        }
        conn.closeConnection();
        return obj;      
    }
}
