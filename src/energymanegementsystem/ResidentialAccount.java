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
public class ResidentialAccount extends Account implements Constants{
    
    double value;
    public ResidentialAccount(String ac, Customer c) {
        super(ac, c);
    }
    
    @Override
    public void updateBalance() {
        for (Address add : a) {
            for (Meter m : add.getMeters()) {
                for (MeterReading mr : m.getReadings()) {
                    value = mr.getReading() + value;
                }
            }
        }
        this.setBalance(value * residentialUnitRate);
    } 
    
}
