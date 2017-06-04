/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.entity;

import java.io.Serializable;

/**
 * Class for describing model
 * 
 * @author Vlad
 */
public class Model implements Serializable {
    private int id;
    private int idType;
    private String name;
    private String imageURL;
    private int price;
    private int amount;
    private int idProducer;
    private Type type;
    private Producer producer;
    private int age_for;

    public void setAge_for(int age_for) {
        this.age_for = age_for;
    }

    public int getAge_for() {
        return age_for;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setIdType(int idType) {
        this.idType = idType;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setIdProducer(int idProducer) {
        this.idProducer = idProducer;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public void setProducer(Producer producer) {
        this.producer = producer;
    }
    
    public int getId() {
        return id;
    }

    public int getIdType() {
        return idType;
    }

    public String getName() {
        return name;
    }

    public String getImageURL() {
        return imageURL;
    }

    public int getPrice() {
        return price;
    }

    public int getAmount() {
        return amount;
    }

    public int getIdProducer() {
        return idProducer;
    }

    public Type getType() {
        return type;
    }

    public Producer getProducer() {
        return producer;
    }
    
    
    
    
    
   
    
    @Override
    public String toString(){
      return "models [id=" + id + ", id_type=" + idType + ", name="
				+ name +  ", price=" + price + ", amount=" + amount + ", id_producer=" + idProducer ;
        
    }
    
}
