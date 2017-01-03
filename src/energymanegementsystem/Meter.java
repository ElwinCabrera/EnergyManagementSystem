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
public abstract class Meter {
    
    private String idNum;
    private String brand;
    private String type;
    private String location;
    private Address address;
    private ArrayList<MeterReading> meterList = new ArrayList<>();
    private MeterReading[] mL;



    public Meter(String id, String b, String t) {
        idNum = id;
        brand = b;
        type = t;
    }

    public String getID() {
        return idNum;
    }

    public MeterReading[] getReadings() {
        mL = meterList.toArray(new MeterReading[meterList.size()]);
        return mL;
    }

    public MeterReading getCurrentReading() {
        if (meterList.isEmpty()){
            return null;
        }else{
            return meterList.get(meterList.size()-1);
        }
        
    }
    
    public boolean addReading(MeterReading m) {
        if (m != null) {
            meterList.add(m);
            return true;
        } else {
            return false;
        }
    }

    public String getBrand() {
        return brand;
    }

    public abstract String getType();
    
    public String getLocation() {
        return location;
    }

    public Address getAddress() {
        return address;
    }

    public void setLocation(Address a, String n) {
        address = a;
        location = n;
    }
    
}
