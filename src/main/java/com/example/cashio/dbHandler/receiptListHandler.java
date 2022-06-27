package com.example.cashio.dbHandler;

import com.example.cashio.model.admin;
import com.example.cashio.model.cashierReceipt;
import com.example.cashio.model.item;
import javafx.util.Pair;

import java.io.File;
import java.sql.*;
import java.util.Vector;

public class receiptListHandler {
    public static Vector<cashierReceipt> getAllReceipt(int cashierId) {
        Vector<cashierReceipt> receipts = null;
        Connection c = null;
        Statement s = null;

        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection(".." + File.pathSeparator +
                    ".." + File.pathSeparator +
                    "resources" + File.pathSeparator + "identifier.sqlite");
            c.setAutoCommit(false);

            s = c.createStatement();
            String sql = "SELECT * FROM ReceiptList WHERE UserId = " + cashierId + ";";
            ResultSet r = s.executeQuery(sql);

            while(r.next()) {
                int id = r.getInt("ReceiptId");
                Date date = r.getDate("Date");
                Time time = r.getTime("Time");
                int count = r.getInt("ItemCount");
                sql = "SELECT * FROM Receipt WHERE ReceiptId = " + id +";";
                ResultSet p = s.executeQuery(sql);
                Vector<Pair<item, Integer>> itemList = null;
                while(p.next()) {
                    String name = p.getString("ItemName");
                    int price = p.getInt("ItemPrice");
                    int minimumCount = p.getInt("MinimumCount");
                    int stockCount = p.getInt("InStockCount");
                    item i = new item(name, price, stockCount, minimumCount);
                    itemList.add(new Pair<>(i, count));
                }
                cashierReceipt x = new cashierReceipt(id, date, time, itemList);
                receipts.add(x);
            }
        } catch(SQLException | ClassNotFoundException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return receipts;
    }
}
