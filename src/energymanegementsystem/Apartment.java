/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package energymanegementsystem;

/**
 *
 * @author Elwin Cabrera
 */
public class Apartment extends Address{
    
    private String unit;
    public Apartment(String s, int n, String z, String t, String u) {
        super(s, n, z, t);
        unit = u;
    }

    @Override
    public String getType() {
        return "apartment";
    }
    
    public boolean setUnit(String u){
        if(u != null){
            unit = u;
            return true;
        }else{
            return false;
        }
    }
    public String getUnit(){
        if(unit != null){
            return unit;    
        }else{
            return "No Unit";
        }
        
    }
    
}
