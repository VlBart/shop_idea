/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.entity;

import java.io.Serializable;

/**
 *
 * @author Vlad
 */
public class Order implements Serializable {
    
    private int id;
    private int amount;
    private int price;
    private String date;
    private int idUser;
    private int idModel;
    private User user;
    private Model model;
    private int idProducer;
    private int cost;
    private Producer producer;
    
         /**
     * @param id
     */
    public void setId(int id){
        this.id = id;
    }
    
    /**
     * @return id
     */
    
    public int getId(){
        return id;
    }
    
     /**
     * @return price
     * 
     */
    
    public int getPrice(){
        return price;
        
    }
    
    /**
     * @param price
     * 
     */
    
    public void setPrice(int price){
        this.price = price;
        
    }
    
     /**
     * 
     * @return amount
     * 
     */
    
    public int getAmount(){
        return amount;
    }
    
    /**
     * @param amount
     * 
     */
    
    public void setAmount(int amount){
        this.amount = amount;
        
    }
    
    public String getDate(){
        return date;
    }
    
    public void setDate(String date){
        this.date = date;
    }
    
    public int getIdUser(){
        return idUser;
    }
    
    public void setIdUser(int idUser){
        this.idUser = idUser;
    }
    
    public int getIdModel(){
        return idModel;
    }
    
    public void setIdModel(int idModel){
        this.idModel = idModel;
        
    }
    
    @Override
    public String toString(){
        return "orders [id=" + id + ", amount=" + amount + ", price="
		+ price + ", id_user=" + idUser + ", id_model=" + idModel + ", date=" + date + "]";
				
    }
    
    public void setModel(Model model){
        this.model = model;
    }
    
    public Model getModel(){
        return model;
    }
    
    public void setUser(User user){
        this.user = user;
    }
    
    public User getUser(){
        return user;
    }
    
    public void setIdProducer(int idProducer){
        this.idProducer = idProducer;
    }
    
    public int getIdProducer(){
        return idProducer;
    }
    
    public void setCost(int cost){
        this.cost = cost;
    }
    
    public int getCost(){
        return cost;
    }
        
    public void setProducer(Producer producer){
        this.producer = producer;
    }
    
    public Producer getProducer(){
        return producer;
    }        
    
}
