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
public abstract class Account {
    
    private String accountNum;
    private Customer customer;
    double currentBalance;
    ArrayList<Address> a = new ArrayList<>();
    private Address[] temp;

   
    public Account(String ac, Customer c) {
        accountNum = ac;
        customer = c;
    }

    public String getAccountNumber() {
        return accountNum;
    }

    public Customer getCustomer() {
        return customer;
    }

    public double getCurrentBalance() {
        return currentBalance;
    }

    public Address[] getAddresses() {
        temp = a.toArray(new Address[a.size()]);
        return temp;
    }

    public boolean addAddress(Address add) {
        if (a != null) {
            a.add(add);
            return true;
        } else {
            return false;
        }

    }

    public boolean removeAddress(Address add) {
        if (a.contains(add)) {
            a.remove(add);
            return true;
        } else {
            return false;
        }
    }

    public void setBalance(double b) {
        currentBalance = b;
    }

    public abstract void updateBalance();
    
}
