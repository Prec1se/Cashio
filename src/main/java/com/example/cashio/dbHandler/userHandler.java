package com.example.cashio.dbHandler;

import com.example.cashio.model.cashier;
import com.example.cashio.model.admin;

import java.io.File;
import java.sql.*;
import java.util.Vector;

public class userHandler {
    public static void addUser(String name, int id, String category, int password) {
        Connection c = null;
        Statement s = null;

        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("");
            c.setAutoCommit(false);

            s = c.createStatement();
            String sql = "INSERT into User (UserId, Category, Password, UserName) " +
                         "VALUES (" + id + ", " + category + ", " + password + ", '" + name + "' , " + ");";
            s.executeUpdate(sql);
            s.close();
            c.commit();
            c.close();
        } catch(SQLException | ClassNotFoundException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

    public static void updateUser(int id, int newPass) {
        Connection c = null;
        Statement s = null;

        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("");
            c.setAutoCommit(false);

            s = c.createStatement();
            String sql = "UPDATE User SET Password = "+ newPass + " WHERE UserId = " + id + ";";
            s.executeUpdate(sql);

            s.close();
            c.commit();
            c.close();
        } catch(SQLException | ClassNotFoundException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

    public static void deleteUser(int id) {
        Connection c = null;
        Statement s = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("");
            c.setAutoCommit(false);

            s = c.createStatement();
            String sql = "DELETE  from User WHERE UserId = " + id + ";";
            s.executeUpdate(sql);

            s.close();
            c.commit();
            c.close();
        } catch(SQLException | ClassNotFoundException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

    public static Vector<cashier> getAllCashier() {
        Vector<cashier> us = new Vector<cashier>();
        Connection c = null;
        Statement s = null;

        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("");
            c.setAutoCommit(false);

            s = c.createStatement();
            String sql = "SELECT * FROM User WHERE Category = 'Cashier';";
            ResultSet r = s.executeQuery(sql);

            while(r.next()) {
                String name = r.getString("UserName");
                int pass = r.getInt("Password");
                int id = r.getInt("UserId");
                cashier x = new cashier(name, pass, id);
                us.add(x);
            }
        } catch(SQLException | ClassNotFoundException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return us;
    }

    public static Vector<admin> getAllAdmin() {
        Vector<admin> us = new Vector<admin>();
        Connection c = null;
        Statement s = null;

        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection(".." + File.pathSeparator +
                    ".." + File.pathSeparator +
                    "resources" + File.pathSeparator + "identifier.sqlite");
            c.setAutoCommit(false);

            s = c.createStatement();
            String sql = "SELECT * FROM User WHERE Category = 'Admin';";
            ResultSet r = s.executeQuery(sql);

            while(r.next()) {
                String name = r.getString("UserName");
                int pass = r.getInt("Password");
                int id = r.getInt("UserId");
                admin x = new admin(name, pass, id);
                us.add(x);
            }
        } catch(SQLException | ClassNotFoundException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return us;
    }

}
