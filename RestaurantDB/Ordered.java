/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RestaurantDB;

import java.util.ArrayList;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author l3oat
 */
@Entity
public class Ordered  {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int table;
    private ArrayList<String> name=new ArrayList<String>();
    private ArrayList<Integer> quality=new ArrayList<Integer>();   
    private ArrayList<Double> price=new ArrayList<Double>();
    private boolean status;
    
    public Ordered(int table,ArrayList<String> name,ArrayList<Integer> quality,ArrayList<Double> price,boolean status){
        this.name=name;
        this.quality=quality;
        this.price=price;
        this.table=table;
        this.status=status;
    }

    public boolean getStatus(){
        return status;
    }
    
    public void setStatus(boolean status){
        this.status=status;
    }
    
    public int getTable() {
        return table;
    }

    
    public void setTable(int table) {
        this.table = table;
    }

    public ArrayList<String> getName() {
        return name;
    }

    public void setName(ArrayList<String> name) {
        this.name = name;
    }

    public ArrayList<Integer> getQuality() {
        return quality;
    }

    public void setQuality(ArrayList<Integer> quality) {
        this.quality = quality;
    }

    public ArrayList<Double> getPrice() {
        return price;
    }

    public void setPrice(ArrayList<Double> price) {
        this.price = price;
    }
    
    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ordered)) {
            return false;
        }
        Ordered other = (Ordered) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "RestaurantDB.Ordered[ id=" + id + " ]";
    }
    
}
