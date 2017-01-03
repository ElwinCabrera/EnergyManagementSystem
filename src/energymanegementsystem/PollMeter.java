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
public class PollMeter extends Meter{
    
    public PollMeter(String id, String b, String t) {
        super(id, b, t);
    }

    @Override
    public String getType() {
        return "poll";
    }
    
}
