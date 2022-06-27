package com.example.cashio.model;

import javafx.util.Pair;

import java.util.Vector;

public class cashier extends user{

    public cashier(String userName, int password, int userID) {
        super(userName, password, userID);
    }

    public void createNewReceipt(int _totalPrice, Vector<Pair<item, Integer>> _itemList) {
        cashierReceipt.addCashierReceipt(_totalPrice, _itemList);
    }

    public cashierReceipt getLastReceipt() {
        return cashierReceipt.getLastReceipt();
    }
}
