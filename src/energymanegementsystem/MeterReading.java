/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package energymanegementsystem;

import java.time.LocalDateTime;

/**
 *
 * @author Elwin Cabrera
 */
public class MeterReading {
    
    private double reading;
    private String report;
    private Meter meter;
    private LocalDateTime dateTime;
    
    public MeterReading(double r,LocalDateTime ldt, String rep, Meter m) {
        reading = r;
        report = rep;
        meter = m;
        dateTime = ldt;
        
    }

    public double getReading() {
        return reading;
    }

    public LocalDateTime getDateTime() {
        
        return dateTime;
        
    }

    public String getFlag() {
        return report;
    }

    public Meter getMeter() {
        return meter;
    }
    
}
