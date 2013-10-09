/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2013 Jude Pereira
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of
 * this software and associated documentation files (the "Software"), to deal in
 * the Software without restriction, including without limitation the rights to
 * use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of
 * the Software, and to permit persons to whom the Software is furnished to do so,
 * subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS
 * FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
 * COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER
 * IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN
 * CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.judepereira.inventry.beans;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import java.sql.*;
import java.util.ArrayList;

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
            ResultSet rs = conn.createStatement().executeQuery("SELECT name, quantity FROM items");
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

            PreparedStatement ps = conn.prepareStatement("INSERT INTO items(name, quantity) VALUES(?, ?)");
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
