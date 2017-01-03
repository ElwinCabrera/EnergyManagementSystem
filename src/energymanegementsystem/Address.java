/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package energymanegementsystem;

import java.util.ArrayList;

/**
 *
 * @author Elwin Cabrera
 */
public abstract class Address {
    
    private String street;
    private int number;
    private String zipCode;
    private String type;
    private ArrayList<Meter> meters = new ArrayList<>();
    private Meter[] temp;
    private Account acc;

    
    public Address(String s, int n, String z, String t) {
        street = s;
        number = n;
        zipCode = z;
        type = t;

    }

    public String getStreet() {
        return street;
    }

    public int getNumber() {
        return number;
    }

    public String getZipCode() {
        return zipCode;
    }

    public abstract String getType();

    public Meter[] getMeters() {
        temp = meters.toArray(new Meter[meters.size()]);
        return temp;
    }

    public boolean addMeter(Meter m) {
        if (m != null) {
            meters.add(m);
            return true;
        } else {
            return false;
        }
    }

    public boolean removeMeter(String m) {
        for (Meter a : meters) {
            if(a.getID().equals(m)){
                return meters.remove(a);
            }
        }

        return false;

    }

    public Account getAccount() {
        return acc;
    }

    public boolean setAccount(Account a) {
        if (a != null) {
            acc = a;
            return true;
        } else {
            return false;
        }
    }
    
    
}
