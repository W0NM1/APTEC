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
public class Task {
    //attributes
    private String ID;
    private String description;
    private int effort;
    private int time;
    private String attendant;
    private String tipe;
    
    //constructor metod
    public Task(String ID, String description, int effort, int time, 
            String attendant, String tipe){
        this.ID = ID;
        this.description = description;
        this.effort = effort;
        this.time = time;
        this.attendant = attendant;
        this.tipe = tipe;
    }
    
    //get ID
    public String getID(){
        return this.ID;
    }
    
    //get description
    public String getDescription(){
        return this.description;
    }
    
    //get esffort
    public int getEffort(){
        return this.effort;
    }
    
    //get time
    public int getTime(){
        return this.time;
    }
    
    //get attendant
    public String getAttendant(){
        return this.attendant;
    }
    
    //get tipe
    public String getTipe(){
        return this.tipe;
    }
}
