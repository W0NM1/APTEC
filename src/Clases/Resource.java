/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

/**
 *
 * @author wonmi
 */
public class Resource {
    //attributes
    private String ID;
    private String name;
    private String tipe;
    private String capacity;
    private String quantity;
    private String attendant;
    
    //constructor metod
    public Resource(String ID, String name, String tipe, String capacity,
            String quantity, String attendant){
        this.ID = ID;
        this.name = name;
        this.tipe = tipe;
        this.capacity = capacity;
        this.quantity = quantity;
        this.attendant = attendant;
    }
    
    //get ID
    public String getID(){
        return this.ID;
    }
    
    //get name
    public String getName(){
        return this.name;
    }
    
    //get tipe
    public String getTipe(){
        return this.tipe;
    }
    
    //get capacity
    public String getCapacity(){
        return this.capacity;
    }
    
    //get quantity
    public String getQuantity(){
        return this.quantity;
    }
    
    //get attendant
    public String getAttendant(){
        return this.attendant;
    }
    
}
