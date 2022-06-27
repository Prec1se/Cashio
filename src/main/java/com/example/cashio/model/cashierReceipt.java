package com.example.cashio.model;

import com.example.cashio.model.receipt;
import javafx.util.Pair;

import java.sql.Time;
import java.util.Date;
import java.util.Vector;

public class cashierReceipt extends receipt {
    private static cashierReceipt lastReceipt;
    private static Vector<cashierReceipt> newReceipt, oldReceipt;
    public cashierReceipt() {
        super();
    }
    public cashierReceipt(int totalPrice, Vector<Pair<item, Integer>> itemList) {
        super(totalPrice, itemList);
    }

    public cashierReceipt(int totalPrice, Date date, Time time, Vector<Pair<item, Integer>> itemList) {
        super(totalPrice, date, time, itemList);
    }

    public static cashierReceipt getLastReceipt() {
        return lastReceipt;
    }

    public Vector<cashierReceipt> getOldReceipt() {
        return oldReceipt;
    }

    public Vector<cashierReceipt> getNewReceipt() {
        return newReceipt;
    }

    public static void addCashierReceipt(int _totalPrice, Vector<Pair<item, Integer>> _itemList) {
        cashierReceipt c = new cashierReceipt(_totalPrice, _itemList);
        newReceipt.add(c);
    }
}
