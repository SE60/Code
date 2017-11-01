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
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("restaurant.odb");
        EntityManager em=emf.createEntityManager();
        em.getTransaction().begin();
        TypedQuery<food_menu> q1=em.createQuery("select from food_menu where cName.id=1",food_menu.class);
        return q1.getResultList().size();
    }
    
}
