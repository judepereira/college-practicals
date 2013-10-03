/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.judepereira.inventry.beans;

/**
 *
 * @author jude
 */
public class ItemEntity {
    private String name;
    private int quantity;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
