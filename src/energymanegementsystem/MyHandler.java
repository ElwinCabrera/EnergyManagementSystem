/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package energymanegementsystem;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;
import jdk.internal.org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

/**
 *
 * @author Elwin Cabrera
 */
public class MyHandler extends DefaultHandler{
    
    // Variables to hold current values
    private List<Customer> customerList = new ArrayList<Customer>();
    private Customer currentCustomer;
    private Account currentAccount;
    private Address currentAddress;
    private Meter currentMeter;

    //getter method for employee list
    public List<Customer> getCustList() {
        return customerList;
    }
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes)
            throws SAXException {

        if (qName.equalsIgnoreCase("customer")) {
            //Create a customer object
            String lastName = attributes.getValue("lastName");
            String firstName = attributes.getValue("firstName");
            currentCustomer = new Customer(lastName, firstName);

        } else if (qName.equalsIgnoreCase("address")) {
            // Create an Addrsss object
            String street = attributes.getValue("street");
            int houseNumber = Integer.parseInt(attributes.getValue("number"));
            String zipCode = attributes.getValue("zipCode");
            String type = attributes.getValue("type");
            String unit = attributes.getValue("unit");

            if (type.equalsIgnoreCase("mailing")) {
                // this is a mailing address -- assign to current customer
                Mailing ma = new Mailing(street, houseNumber, zipCode, type);
                currentCustomer.setMailingAddress(ma);
            } else if (type.equalsIgnoreCase("house")) {
                // Create a house
                currentAddress = new House(street, houseNumber, zipCode, type);
            } else if (type.equalsIgnoreCase("commercial")) {
                // Create a commercial
                currentAddress = new Commercial(street, houseNumber, zipCode, type);
            } else if (unit != null) {
                // Create an apartment
                currentAddress = new Apartment(street, houseNumber, zipCode, type, unit);
            } else {
                System.out.println("Unknown address type:" + type);
            }


            if (currentAddress != null) {
                // Assign this account to current address
                currentAddress.setAccount(currentAccount);
                currentAccount.addAddress(currentAddress);
            }

        } else if (qName.equalsIgnoreCase("meter")) {
            // Create a meter object
            String type = attributes.getValue("type");
            String brand = attributes.getValue("brand");
            String id = attributes.getValue("id");
            if (type.equalsIgnoreCase("push")) {
                currentMeter = new PushMeter(id, brand, type);
            } else if (type.equalsIgnoreCase("poll") || type.equalsIgnoreCase("polling")) {
                currentMeter = new PollMeter(id, brand, type);
            } else {
                System.out.println("Unknown meter type: " + type);
            }


            if (currentMeter != null) {
                // Set location
                String location = attributes.getValue("location");
                currentMeter.setLocation(currentAddress, location);
                currentAddress.addMeter(currentMeter);
            }

            //System.out.println("METER:");
        } else if (qName.equalsIgnoreCase("meterReading")) {
            // Create a meter reading
            //<meterReading reading="622" date = "1413400615" flag="push"/>
            double reading = Double.parseDouble(attributes.getValue("reading"));
            //System.out.println("DATE:" );
            ZoneOffset z = ZoneOffset.ofHours(5);
            long epoch = Long.parseLong(attributes.getValue("date"));
            LocalDateTime d = LocalDateTime.ofEpochSecond(epoch,0,z);
            //System.out.println("DATE:" + d.toString());
            String flag = attributes.getValue("flag");
            MeterReading mr = new MeterReading(reading, d, flag, currentMeter);
            // Add this to current meter
            currentMeter.addReading(mr);
            //System.out.println("METERREADING:");

        } else if (qName.equalsIgnoreCase("account")) {
//    <account type="residential" accountNumber="876-543-21">
            String type = attributes.getValue("type");
            String acctNum = attributes.getValue("accountNumber");
            if (type.equalsIgnoreCase("residential")) {
                // residential account
                currentAccount = new ResidentialAccount(acctNum, currentCustomer);
            } else if (type.equalsIgnoreCase("commercial")) {
                currentAccount = new CommercialAccount(acctNum, currentCustomer);
            } else {
                System.out.println("Unknown account type:" + type);
            }
            
            if (currentAccount != null) {
                // Add this account to current customer
                currentCustomer.addAccount(currentAccount);
            }
        }
    }

    
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("customer")) {
            customerList.add(currentCustomer);
            currentCustomer = null;
        } else if (qName.equalsIgnoreCase("meter")) {
            currentMeter = null;
        } else if (qName.equalsIgnoreCase("account")) {
            currentAccount = null;
        } else if (qName.equalsIgnoreCase("address")) {
            currentAddress = null;
        }
	}
    
}
