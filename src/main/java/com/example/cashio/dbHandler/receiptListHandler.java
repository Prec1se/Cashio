package com.example.cashio.dbHandler;

import com.example.cashio.model.admin;
import com.example.cashio.model.cashierReceipt;

import java.io.File;
import java.sql.*;
import java.util.Vector;

public class receiptListHandler {
    public static Vector<cashierReceipt> getAllReceipt() {
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
            String sql = "SELECT * FROM ReceiptList WHERE;";
            ResultSet r = s.executeQuery(sql);

            while(r.next()) {
                String name = r.getString("UserName");
                int pass = r.getInt("Password");
                int id = r.getInt("UserId");
                cashierReceipt x = new cashierReceipt(name, pass, id);
                receipts.add(x);
            }
        } catch(SQLException | ClassNotFoundException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return receipts;
    }
}
