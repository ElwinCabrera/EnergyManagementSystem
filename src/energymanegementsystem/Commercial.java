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
public class Commercial extends Address{
    
    public Commercial(String s, int n, String z, String t) {
        super(s, n, z, t);
    }

    @Override
    public String getType() {
        return "commercial";
    }
    
}
