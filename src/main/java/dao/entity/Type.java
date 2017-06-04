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
public class Type extends Dictionary implements Serializable {
    
    @Override
    public String toString(){
       return "type [id=" + id + ", value=" + value +"]"; 
    }
    
}
