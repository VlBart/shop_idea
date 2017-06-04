/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.entity;

import java.io.Serializable;

/**
 *
 * @author Andrei
 */
public class Producer implements Serializable {
    
    private int id;
    private int idCountry;
    private String phone;
    private String email;
    private Country country;
    private String name;
    private String address;
    
    
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
     * @param idCountry
     */
    
    public void setIdCountry(int idCountry){
        this.idCountry = idCountry;
    }
    
    /**
     * @return idCountry
     */
    
    public int getIdCountry(){
        return idCountry;
    }
    
    /**
     * @param phone
     */
    
    public void setPhone(String phone){
        this.phone = phone;
    }
    
    /**
     * @return phone
     */
    
    
    public String getPhone(){
        return phone;
    }
    
    /**
     * @param address
     */
    
    public void setAddress(String address){
        this.address = address;
    }
    
    /**
     * @return address
     */
    
    
    public String getAddress(){
        return address;
    }
    
    /**
     * @param email
     */
    
    public void setEmail(String email){
        this.email = email;
    }
    
    /**
     * @return email
     */
    
    
    public String getEmail(){
        return email;
    }
    
     /**
     * @param name
     */
    
    public void setName(String name){
        this.name = name;
    }
    
    /**
     * @return name
     */
    
    public String getName(){
        return name;
    }
    
    @Override
    public String toString(){
        return "producers [id=" + id + ", id_country=" + idCountry +  ",phone=" + phone
                + ", email=" + email + ", name=" + name + "]";
    }
    
    
    public void setCountry(Country country){
        this.country = country;
    }
    
    public Country getCountry(){
        return country;
    }
    

            
    
    
}
