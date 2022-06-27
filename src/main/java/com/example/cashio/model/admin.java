package com.example.cashio.model;

public class admin extends user{

    public admin() {
        super();
    }

    public admin(String userName, int password, int userID) {
        super(userName, password, userID);
    }
    public void addItem(item i) {
        item.addNewItem(i);
    }
    public void deleteItem(item i) {
        item.deleteItem(i);
    }
//    public void changeItemCount() {
//        item.
//    }
    public void changeItemPrice(int price) {

    }
}
