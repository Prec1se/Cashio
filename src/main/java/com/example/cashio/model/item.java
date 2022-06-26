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

    public void addNewItem(String _name, int _price, int _count) {
        item i = new item(_name, _price, _count);
        allItem.add(i);
        // add to db ()
        itemHandler.addItem(i);
    }
}
