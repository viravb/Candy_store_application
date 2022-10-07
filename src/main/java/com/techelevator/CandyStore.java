package com.techelevator;

import com.techelevator.items.CandyStoreItem;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/*
    This class should encapsulate all the functionality of the Candy Store application, meaning it should
    contain all the "work"
 */
public class CandyStore {

    Account account = new Account();
    Inventory inventory = new Inventory();
    private Map<String,Integer> inventoryWithQuantity;
    private Map<String, CandyStoreItem> inventoryWithProperties;

    public void initialPopulateInventory() throws FileNotFoundException {
        this.inventoryWithProperties = inventory.populateInventory();
        this.inventoryWithQuantity = inventory.populateQuantities();
    }

    public double accountBalance(){
        return account.getBalance();
    }

    public Map<String, Integer> getInventoryWithQuantity() {
        return inventoryWithQuantity;
    }
    public Map<String, CandyStoreItem> getInventoryWithProperties() {
        return inventoryWithProperties;
    }

    public void takeMoney(double amount){
        account.deposit(amount);
    }
}
