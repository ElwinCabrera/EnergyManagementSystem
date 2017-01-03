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
public class Mailing extends Address{
    // private String unit;

    public Mailing(String s, int n, String z, String t){
        super(s,n,z,t);
       // unit = u;
    }
    @Override
    public String getType() {
        return "mailing";
    }
    
}
