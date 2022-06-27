package com.example.cashio.model;

import java.util.Vector;
import com.example.cashio.dbHandler.itemHandler;

public class item {
    private String name;
    private int price, count;
    private int minimumCount;

    private static Vector<item> allItem;

    public item(String name, int price, int count) {
        this.name = name;
        this.price = price;
        this.count = count;
        minimumCount = 0;
    }

    public item(String name, int price, int count, int minimumCount) {
        this.name = name;
        this.price = price;
        this.count = count;
        this.minimumCount = minimumCount;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getCount() {
        return count;
    }

    public static Vector<item> getAllItem() {
        return allItem;
    }

    public int getMinimumCount() { return minimumCount; }

    public static void setAllItem() {
        // get items from db and copy them to allItem variable
        allItem = itemHandler.getAllItem();
    }

    public static void addNewItem(item i) {
        allItem.add(i);
        // add to db ()
        itemHandler.addItem(i);
    }

    public static void deleteItem(item i) {

    }

    public static void setPrice() {

    }

    public static void setCount(String name, int count) {
        itemHandler.updateItemCount(name, count);
    }
}
