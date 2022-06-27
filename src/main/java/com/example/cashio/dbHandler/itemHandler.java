package com.example.cashio.dbHandler;

import com.example.cashio.model.item;

import java.io.File;
import java.sql.*;
import java.util.Vector;

public class itemHandler {

    private static final String low = "Low on Stock";
    private static final String zero = "No more available";
    private static final String enough = "In Stock";

    private static String stockStatus(int count, int minCount) {
        if(count == 0)
            return zero;
        if(count >= minCount)
            return enough;
        return low;
    }

    public static void addItem(item i) {
        try {
            Class.forName("org.sqlite.JDBC");
            Connection c = DriverManager.getConnection(".." + File.pathSeparator +
                    ".." + File.pathSeparator +
                    "resources" + File.pathSeparator + "identifier.sqlite");
            c.setAutoCommit(false);
            Statement s = c.createStatement();
            String stock = stockStatus(i.getCount(), i.getMinimumCount());
            String sql = "INSERT INTO Item (ItemName, ItemPrice, MinimumCount, InStockCount, StockStatus) " +
                    "VALUES (i.getName(), Integer.toString(i.getPrice()), Integer.toString(i.getMinimumCount()), Integer.toString(i.getCount()), stock);";
            s.executeUpdate(sql);
            s.close();
            c.commit();
            c.close();
        } catch (SQLException | ClassNotFoundException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
//        System.out.println("Records added successfully");
    }

    public static void updateItemCount(String name, int addCount) {
        try {
            Class.forName("org.sqlite.JDBC");
            Connection c = DriverManager.getConnection(".." + File.pathSeparator +
                    ".." + File.pathSeparator +
                    "resources" + File.pathSeparator + "identifier.sqlite");
            c.setAutoCommit(false);

            Statement s = c.createStatement();
            String x = "SELECT * FROM Item WHERE ItemName = '" + name + "';";
            ResultSet r = s.executeQuery(x);
            int count = r.getInt("ItemCount") + addCount;
            int minimumCount = r.getInt("MinimumCount");
            String stock = stockStatus(count, minimumCount);
            String sql = "UPDATE Item " +
                    "SET InStockCount = " + count +
                    ", StockStatus = '" + stock + "' WHERE ItemName = '" + name + "';";
            s.executeUpdate(sql);

            s.close();
            c.commit();
            c.close();
        } catch (SQLException | ClassNotFoundException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

    public static void updateItemPrice(String name, int newPrice) {
        try {
            Class.forName("org.sqlite.JDBC");
            Connection c = DriverManager.getConnection(".." + File.pathSeparator +
                    ".." + File.pathSeparator +
                    "resources" + File.pathSeparator + "identifier.sqlite");
            c.setAutoCommit(false);

            Statement s = c.createStatement();
            String sql = "UPDATE Item " +
                        "SET ItemPrice = " + newPrice +
                        " WHERE ItemName = '" + name + "';";
            s.executeUpdate(sql);

            s.close();
            c.commit();
            c.close();
        } catch(SQLException | ClassNotFoundException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

    public static void deleteItem(String name) {
        try {
            Class.forName("org.sqlite.JDBC");
            Connection c = DriverManager.getConnection("");
            c.setAutoCommit(false);

            Statement s = c.createStatement();
            String sql = "DELETE from Item WHERE ItemName = '" + name + "';";
            s.executeUpdate(sql);

            s.close();
            c.commit();
            c.close();
        } catch(SQLException | ClassNotFoundException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

    public static Vector<item> getAllItem() {
        Vector<item> allItem = null;
        Connection c = null;
        Statement s = null;

        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection(".." + File.pathSeparator +
                    ".." + File.pathSeparator +
                    "resources" + File.pathSeparator + "identifier.sqlite");
            c.setAutoCommit(false);

            s = c.createStatement();
            String sql = "SELECT * FROM Item;";
            ResultSet r = s.executeQuery(sql);

            while(r.next()) {
                String name = r.getString("ItemName");
                int price = r.getInt("ItemPrice");
                int count = r.getInt("InStockCount");
                item x = new item(name, price, count);
                allItem.add(x);
            }
        } catch(SQLException | ClassNotFoundException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return allItem;
    }

//    public static Vector<item> searchItem(String name) {
//        Connection c = null;
//        Statement s = null;
//        try {
//            Class.forName("org.sqlite.JDBC");
//            c = DriverManager.getConnection("");
//            c.setAutoCommit(false);
//
//            s = c.createStatement();
//            String sql = "";
//            s.executeQuery(sql);
//        } catch(SQLException | ClassNotFoundException e) {
//            System.err.println(e.getClass().getName() + ": " + e.getMessage());
//            System.exit(0);
//        }
//    }
//
//    public item getItem(String name) {
//
//    }

}
