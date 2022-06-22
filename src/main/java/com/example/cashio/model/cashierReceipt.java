package com.example.cashio.model;

import com.example.cashio.model.receipt;
import javafx.util.Pair;

import java.util.Vector;

public class cashierReceipt extends receipt {
    private int customerMoney;
    private cashierReceipt lastReceipt;
    private Vector<cashierReceipt> newReceipt, oldReceipt;
    public cashierReceipt() {
        super();
        customerMoney = 0;
    }
    public cashierReceipt(int customerMoney, int totalPrice, Vector<Pair<item, Integer>> itemList) {
        super(totalPrice, itemList);
        this.customerMoney = customerMoney;
    }

    public cashierReceipt getLastReceipt() {
        return lastReceipt;
    }

    public Vector<cashierReceipt> getOldReceipt() {
        return oldReceipt;
    }

    public Vector<cashierReceipt> getNewReceipt() {
        return newReceipt;
    }

    public void addCashierReceipt(int _customerMoney, int _totalPrice, Vector<Pair<item, Integer>> _itemList) {
        cashierReceipt c = new cashierReceipt(_customerMoney, _totalPrice, _itemList);
    }
}
