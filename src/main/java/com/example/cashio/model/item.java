package com.example.cashio.model;

import java.util.Vector;

public class item {
    private String name;
    private int price, count;
    private int minimumCount;

    private static Vector<item> newItems, oldItems;
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

    public static Vector<item> getNewItems() {
        return newItems;
    }

    public static Vector<item> getAllItem() {
        return allItem;
    }

    public int getMinimumCount() { return minimumCount; }

    public void setAllItem() {
        // get items from db and copy them to allItem variable
    }

    public void addNewItem(String _name, int _price, int _count) {
        item i = new item(_name, _price, _count);
        newItems.add(i);
        // add to db ()
    }
}
