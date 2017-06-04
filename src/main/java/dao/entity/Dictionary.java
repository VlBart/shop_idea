/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.entity;

/**
 *
 * @author Andrei
 */
public class Dictionary {
    
    protected int id;
    protected String value;
    
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
     * @param name
     */
    
    public void setValue(String value){
        this.value = value;
    }
    
    /**
     * @return name
     */
    
    public String getValue(){
        return value;
        
    }
    
}
