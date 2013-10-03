/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.judepereira.inventry.beans;

import java.sql.*;
import java.util.ArrayList;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@Named(value = "inventoryBean")
@ApplicationScoped
public class InventoryBean {

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            // handle
        }
    }
    private ItemEntity ie = new ItemEntity();

    public ItemEntity getIe() {
        return ie;
    }

    public void setIe(ItemEntity ie) {
        this.ie = ie;
    }

    public ArrayList<ItemEntity> getItems() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost/inventory", "jude", "helloworld");
            ResultSet rs = conn.createStatement().executeQuery("select name, quantity from items");
            ArrayList<ItemEntity> items = new ArrayList<ItemEntity>();
            while (rs.next()) {
                ItemEntity ie = new ItemEntity();
                ie.setName(rs.getString("name"));
                ie.setQuantity(rs.getInt("quantity"));
                items.add(ie);
            }
            return items;
        } catch (SQLException ex) {
            return null;
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    // handle
                }
            }
        }
    }

    public void addItem() {
        ItemEntity ie = new ItemEntity();
        ie.setName(this.ie.getName());
        ie.setQuantity(this.ie.getQuantity());

        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost/inventory", "jude", "helloworld");

            PreparedStatement ps = conn.prepareStatement("insert into items(name, quantity) values(?, ?)");
            ps.setString(1, ie.getName());
            ps.setInt(2, ie.getQuantity());
            ps.execute();
        } catch (SQLException ex) {
            // handle
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    // handle
                }
            }
        }
    }
}
