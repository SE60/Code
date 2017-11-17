/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se_restaurant_real;

import RestaurantDB.food_menu;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author l3oat
 */
public class LoadQuality {
    public int loadQuality_1(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("$objectdb/restaurant.odb");
        EntityManager em=emf.createEntityManager();
        em.getTransaction().begin();
        TypedQuery<food_menu> q1=em.createQuery("select from food_menu where cName.id=1",food_menu.class);
        int temp=q1.getResultList().size();
        em.close();
        emf.close();
        return temp;
    }
    public int loadQuality_2(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("$objectdb/restaurant.odb");
        EntityManager em=emf.createEntityManager();
        em.getTransaction().begin();
        TypedQuery<food_menu> q1=em.createQuery("select from food_menu where cName.id=2",food_menu.class);
        int temp=q1.getResultList().size();
        em.close();
        emf.close();
        return temp;
    }
    public int loadQuality_3(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("$objectdb/restaurant.odb");
        EntityManager em=emf.createEntityManager();
        em.getTransaction().begin();
        TypedQuery<food_menu> q1=em.createQuery("select from food_menu where cName.id=3",food_menu.class);
        int temp=q1.getResultList().size();
        em.close();
        emf.close();
        return temp;
    }
    public int loadQuality_4(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("$objectdb/restaurant.odb");
        EntityManager em=emf.createEntityManager();
        em.getTransaction().begin();
        TypedQuery<food_menu> q1=em.createQuery("select from food_menu where cName.id=4",food_menu.class);
        int temp=q1.getResultList().size();
        em.close();
        emf.close();
        return temp;
    }
    public int loadQuality_5(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("$objectdb/restaurant.odb");
        EntityManager em=emf.createEntityManager();
        em.getTransaction().begin();
        TypedQuery<food_menu> q1=em.createQuery("select from food_menu where cName.id=5",food_menu.class);
        int temp=q1.getResultList().size();
        em.close();
        emf.close();
        return temp;
    }
    public int loadQuality_6(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("$objectdb/restaurant.odb");
        EntityManager em=emf.createEntityManager();
        em.getTransaction().begin();
        TypedQuery<food_menu> q1=em.createQuery("select from food_menu where cName.id=6",food_menu.class);
        int temp=q1.getResultList().size();
        em.close();
        emf.close();
        return temp;
    }
    public int loadQuality_7(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("$objectdb/restaurant.odb");
        EntityManager em=emf.createEntityManager();
        em.getTransaction().begin();
        TypedQuery<food_menu> q1=em.createQuery("select from food_menu where cName.id=7",food_menu.class);
        int temp=q1.getResultList().size();
        em.close();
        emf.close();
        return temp;
    }
    public int loadQuality_8(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("$objectdb/restaurant.odb");
        EntityManager em=emf.createEntityManager();
        em.getTransaction().begin();
        TypedQuery<food_menu> q1=em.createQuery("select from food_menu where cName.id=8",food_menu.class);
        int temp=q1.getResultList().size();
        em.close();
        emf.close();
        return temp;
    }
    public int loadQuality_9(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("$objectdb/restaurant.odb");
        EntityManager em=emf.createEntityManager();
        em.getTransaction().begin();
        TypedQuery<food_menu> q1=em.createQuery("select from food_menu where cName.id=9",food_menu.class);
        int temp=q1.getResultList().size();
        em.close();
        emf.close();
        return temp;
    }
    
}
