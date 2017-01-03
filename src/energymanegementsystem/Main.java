/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package energymanegementsystem;

import java.io.File;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Scanner;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;



/**
 *
 * @author Elwin Cabrera
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
                SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        List<Customer> customerList = null;

        int end = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to the Energy Management System"); 

        while (end != 1) {
            System.out.println("Enter a command:");
            String command = sc.nextLine();
            Scanner kb = new Scanner(command);
            while (kb.hasNext()) {
                String command2 = kb.next();
                if (command2.equalsIgnoreCase("load")) {
                    if (kb.hasNext()) {
                        String file = kb.next();
                        try {
                            File input = new File(file);
                            if (input.exists()) {
                                System.out.println("Load successful: " + file);
                            }
                            SAXParser sax = saxParserFactory.newSAXParser();
                            MyHandler handler = new MyHandler();
                            sax.parse(input, handler);
                            customerList = handler.getCustList();

                        } catch (Exception e) {
                            System.out.println("Invalid input file - " + file);
                        }
                    }
                } 
                
                
                
                
                
                //BIG COMMANDS
               else if (command2.equalsIgnoreCase("show")) {
                    if (kb.hasNext()) {
                        String entity = kb.next();
                        if (entity.equals("customer")) {
                            if (customerList == null) {
                                kb.next();
                                System.out.println("No records found");
                            } else {
                                if (kb.hasNext()) {
                                    String name = kb.next();
                                    for (Customer c : customerList) {
                                        if (c.getFirstName().equals(name) || c.getLastName().equals(name)) {
                                            System.out.println("Last name: " + c.getLastName());
                                            System.out.println("First name: " + c.getFirstName());
                                            System.out.println("Accounts:");
                                            for (Account a : c.getAccounts()) {
                                                System.out.println("  " + a.getAccountNumber());
                                            }
                                        }
                                    }
                                }
                            }

                        } 
                        
                         //sub commands
                        
                      else  if (entity.equalsIgnoreCase("account")) {
                            if (customerList == null) {
                                kb.next();
                                System.out.println("No records found");
                            } else {
                                if (kb.hasNext()) {
                                    String num = kb.next();
                                    for (Customer c : customerList) {
                                        for (Account a : c.getAccounts()) {
                                            if (a.getAccountNumber().equals(num)) {
                                                a.updateBalance();
                                                DecimalFormat df = new DecimalFormat("0.00");
                                                System.out.println("Account number: " + a.getAccountNumber());
                                                System.out.println("Balance: $" + df.format(a.getCurrentBalance()));
                                                System.out.println("Addresses:");
                                                for (Address ad : a.getAddresses()) {
                                                    System.out.println("  " + ad.getNumber() + " " + ad.getStreet());
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        } 
                        
                       //sub commands
                        
                      else  if (entity.equalsIgnoreCase("address")) {
                            if (customerList == null) {
                                while (kb.hasNext()) {
                                    kb.next();
                                }
                                System.out.println("No records found");
                            } else {
                                if (kb.hasNext()) {
                                    String num2 = kb.next();
                                    String street = "";

                                    while (kb.hasNext()) {

                                        String temp = kb.next();
                                        street = street + " " + temp;

                                    }
                                    street = street.substring(1, street.length());

                                    for (Customer c : customerList) {
                                        for (Account a : c.getAccounts()) {
                                            for (Address ad : a.getAddresses()) {
                                                String streetNum = "" + ad.getNumber();
                                                if (num2.equals(streetNum) && street.equals(ad.getStreet())) {
                                                    System.out.println("Number: " + ad.getNumber());
                                                    System.out.println("Street: " + ad.getStreet());
                                                    System.out.println("Zip: " + ad.getZipCode());
                                                    System.out.println("Type: " + ad.getType());
                                                    if (ad.getType().equals("apartment")) {
                                                        Apartment ap = (Apartment) ad;
                                                        System.out.println("Unit: " + ap.getUnit());

                                                    }
                                                    System.out.println("Meters:");
                                                    for (Meter m : ad.getMeters()) {
                                                        System.out.println("  " + m.getID());
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }

                        } 
                        
                         //sub commands
                        
                       else if (entity.equalsIgnoreCase("meter")) {
                            if (customerList == null) {
                                kb.next();
                                System.out.println("No records found");
                            } else {
                                if (kb.hasNext()) {
                                    String meter = kb.next();
                                    for (Customer c : customerList) {
                                        for (Account a : c.getAccounts()) {
                                            for (Address ad : a.getAddresses()) {
                                                for (Meter m : ad.getMeters()) {
                                                    
                                                    if (meter.equals(m.getID())) {
                                                        System.out.println("ID: " + m.getID());
                                                        System.out.println("Brand: " + m.getBrand());
                                                        System.out.println("Location: " + m.getLocation());
                                                        System.out.println("Type: " + m.getType());
                                                        System.out.println("Meters Readings:");
                                                        for (MeterReading mr : m.getReadings()) {
//                                                            if (mr.getFlag() != m.getType()) {
//                                                            
//                                                                System.out.println("invalid");
//                                                            }
                                                          //  System.out.println(mr.getDateTime());
                                                            System.out.println("  " + mr.getDateTime().getYear() + "-" + mr.getDateTime().getMonthValue() + "-" + mr.getDateTime().minusDays(1).getDayOfMonth() + " " + mr.getDateTime().minusHours(5).getHour() +":" + mr.getDateTime().getMinute() + ":" + mr.getDateTime().getSecond());
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                } 
               
               
               //MAIN COMMANDS 
                
               else if (command2.equalsIgnoreCase("check")) {

                    if (kb.hasNext()) {
                        String entity = kb.next();
                        if (entity.equals("customer")) {
                            if (customerList == null) {
                                System.out.println("No records found");
                            } else {

                                for (Customer c : customerList) {
                                    if (c.getAccounts().length == 0) {
                                        System.out.println(c.getLastName() + ", " + c.getFirstName());
                                    }

                                }
                            }

                        } 
                        
                        //sub commands
                        
                       else if (entity.equalsIgnoreCase("account")) {
                            if (customerList == null) {
                                System.out.println("No records found");
                            } else {
                                for (Customer c : customerList) {
                                    for (Account a : c.getAccounts()) {
                                        if (a.getAddresses().length == 0) {
                                            System.out.println(a.getAccountNumber());
                                        }
                                    }

                                }
                            }
                        } 
                         //sub commands
                        
                        else  if (entity.equalsIgnoreCase("address")) {
                            if (customerList == null) {
                                System.out.println("No records found");
                            } else {
                                for (Customer c : customerList) {
                                    for (Account a : c.getAccounts()) {
                                        for (Address ad : a.getAddresses()) {
                                            if (ad.getMeters().length == 0) {
                                                System.out.println(ad.getNumber() + ", " + ad.getStreet());
                                            }
                                        }
                                    }
                                }
                            }
                        } 
                        
                        
                         //sub commands
                        else  if (entity.equalsIgnoreCase("meter")) {
                            if (customerList == null) {
                                System.out.println("No records found");
                            } else {
                                for (Customer c : customerList) {
                                    for (Account a : c.getAccounts()) {
                                        for (Address ad : a.getAddresses()) {
                                            for (Meter m : ad.getMeters()) {
                                                if (m.getReadings().length > 0) {
                                                     if (!m.getCurrentReading().getFlag().equals(m.getType())) {
                                                                System.out.println("Invalid command");
                                                            }
                                                    
                                                }
                                                
                                                System.out.println(m.getID());
                                            }

                                        }
                                    }
                                }
                            }
                        }

                    }
                } 
                
                //MAIN COMMANDS 
               
                else if (command2.equalsIgnoreCase("report")) {
                    if (customerList == null) {
                        kb.next();
                        System.out.println("No records found");
                    } else {
                        if (kb.hasNext()) {
                            String entity = kb.next();
                            if (entity.equalsIgnoreCase("balance")) {
                                for (Customer c : customerList) {
                                    for (Account a : c.getAccounts()) {
                                        System.out.println("Account: " + a.getAccountNumber());
                                        a.updateBalance();
                                        System.out.println("  Customer: " + c.getLastName() + ", " + c.getFirstName());
                                        DecimalFormat df = new DecimalFormat("0.00");
                                        System.out.println("  Balance: $" + df.format(a.getCurrentBalance()));
                                    }
                                }

                            }
                        }
                    }

                } 
                
                else if (command2.equalsIgnoreCase("clear")) {
                    customerList = null;
                } 
                
                
                else if (command2.equalsIgnoreCase("quit")) {
                    end = 1;
                    System.out.println("Program ending");
                } else {
                    System.out.println("Invalid command: " + command);

                }
            }
        }
        
    }
    
}
