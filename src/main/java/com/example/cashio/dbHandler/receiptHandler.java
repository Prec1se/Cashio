package com.example.cashio.dbHandler;

import com.example.cashio.model.cashierReceipt;
import com.example.cashio.model.supplyReceipt;

import java.io.File;
import java.sql.*;
import java.util.Vector;

public class receiptHandler {
    public static void addReceipt(int id, Vector<Integer> count, Vector<String> name) {
        Connection c = null;
        Statement s = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection(".." + File.pathSeparator +
                    ".." + File.pathSeparator +
                    "resources" + File.pathSeparator + "identifier.sqlite");

            s = c.createStatement();
            int i = 0;
            while(i < count.size()) {
                String sql = "INSERT into Receipt (ReceiptId, ItemCount, ItemName) VALUES (" +
                        Integer.toString(id) + ", " + Integer.toString(count.get(i)) + ", '" + name.get(i) + "');";
                s.executeUpdate(sql);
                i++;
            }
            s.close();
            c.commit();
            c.close();
        } catch(SQLException | ClassNotFoundException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

    public static cashierReceipt getReceipt() {
        cashierReceipt cr = new cashierReceipt();

        return cr;
    }
//    public static supplyReceipt getSupplyReceipt() {
//
//    }
//
//    public static cashierReceipt getCashierReceipt() {
//
//    } static cashierReceipt getCashierReceipt() {
//
//    }
}
