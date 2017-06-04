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
public class User implements Serializable  {
    private String fullName;
    private String email;
    private int idCountry;
    private String userName;
    private String password;
    private String address;
    private int id;
    private short isAdmin;
    private String phone;
    //private String date;
    private Country country;
    
    /**
     * @param fullName
     * 
     */
    public void setFullName(String fullName){
        this.fullName = fullName;
    }
    
    /**
     * @return fullName
     * 
     */
    public String getFullName(){
        return fullName;
    }
    
    /**
     * @param idCountry
     * 
     */
    public void setIdCountry(int idCountry){
        this.idCountry = idCountry;
    }
    
    /**
     * @return idCountry
     */
    
    public int getIdCountry(){
        return this.idCountry;
    }
    
    
    /**
     * @param email
     */
    
    
    public void setEmail(String email){
        this.email = email;
    }
    
    /**
     * @return email
     * 
     */
    
    public String getEmail(){
        return email;
    }
    
     /**
     * @param adress
     */
    
    
    public void setAddress(String adress){
        this.address = adress;
    }
    
    /**
     * @return email
     * 
     */
    
    public String getAddress(){
        return address;
    }
    
    /**
     * #param userName
     */
    
    public void setUserName(String userName){
        this.userName = userName;
    }
    
    /**
     * @return userName
     */
    
    public String getUserName(){
        return userName;
    }
    
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
    * 
    * @param isAdmin
    */
    public void setIsAdmin(short isAdmin) {
	this.isAdmin = isAdmin;
    }
	
    /**
     * 
     * @return isAdmin
     */
     public short getIsAdmin() {
	return isAdmin;
    }
     
     /**
      * @param password
      */
     
     public void setPassword(String password){
         this.password = password;
     }
     
     /*
      * @return password
      */
     
     public String getPassword(){
         return password;
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
     
     
  /*   public void setDate(String date) {
		this.date = date;
	}
     
     
	public String getDate() {
		return date;
	}*/	
     
     	@Override
	public String toString() {
		return "users [id=" + id + ", username=" + userName + ", password="
				+ password + ", isAdmin=" + isAdmin + ", id_country=" + idCountry +  ", email=" + email
				+ ", fullName=" + fullName + ", phone=" + phone + "]";
        }
        
    public void setCountry(Country country){
        this.country = country;
    }
    
    public Country getCountry(){
        return country;
    }
    

}
