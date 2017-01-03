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
public class PushMeter extends Meter{
    
    private int seconds;
    
    public PushMeter(String id, String b, String t) {
        super(id, b, t);
    }

    @Override
    public String getType() {
        return "push";
    }
    
    public boolean setInterval(int s){
        if (s < 0){
            return false;
        }else{
            seconds = s;
            
            return true;
        }
    }
    public int getInterval(){
        return seconds;
    }
    
}
