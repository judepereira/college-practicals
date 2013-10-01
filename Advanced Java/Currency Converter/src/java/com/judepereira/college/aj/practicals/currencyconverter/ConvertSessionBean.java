/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.judepereira.college.aj.practicals.currencyconverter;

import javax.ejb.Stateless;

/**
 *
 * @author jude
 */
@Stateless
public class ConvertSessionBean {

    public double convert(String from, String to, double amount) {
        if (from.equals(to)) {
            return amount;
        } else if (from.equals("USD") && to.equals("INR")) {
            return amount * 60;
        } else if (from.equals("INR") && to.equals("USD")) {
            return amount / 60;
        } else {
            // invalid currency
            return -1;
        }
    }
}
