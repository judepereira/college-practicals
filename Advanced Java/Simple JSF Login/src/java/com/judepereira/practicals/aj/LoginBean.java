/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.judepereira.practicals.aj;

/**
 *
 * @author jude
 */
public class LoginBean {
    private String username, password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    /**
     * Creates a new instance of LoginBean
     */
    public LoginBean() {
    }
    
    public String login() {
        if(username.equals("jude")&& password.equals("jude"))
            return "success";
        else
            return "failure";
    }
}
