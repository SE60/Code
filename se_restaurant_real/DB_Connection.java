/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se_restaurant_real;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author l3oat
 */
public class DB_Connection {
    EntityManager em;
    EntityManagerFactory emf;
    
    public DB_Connection(){
        emf = Persistence.createEntityManagerFactory("objectdb://161.246.6.22:6136/restaurant.odb;user=admin;password=admin");
        em=emf.createEntityManager();
    }
    
    public EntityManager getConnection(){
        return em;
    }
    
    public void closeConnection(){
        em.close();
        emf.close();
    }
}
