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
public class Customer {
    
    private String lastName;
    private String firstName;
    private Address address;
    private ArrayList<Account> accounts = new ArrayList<>();
    private Account[] a;

    public Customer(String l, String f, Address a) {
        lastName = l;
        firstName = f;
        address = a;
    }

    public Customer(String l, String f) {
        lastName = l;
        firstName = f;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public Address getMailingAddress() {
        return address;
    }

    public void setMailingAddress(Address a) {
        if (a != null) {
            address = a;
        }

    }

    public Account[] getAccounts() {
        a = accounts.toArray(new Account[accounts.size()]);
        return a;
    }

    public boolean addAccount(Account a) {
        if (a != null) {
            accounts.add(a);
            return true;
        } else {
            return false;
        }

    }

    public boolean removeAccount(Account a) {
        if (accounts.contains(a)) {
            accounts.remove(a);
            return true;
        } else {
            return false;
        }
    }
    
}
