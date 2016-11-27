package com.example.armint.testtutor;

/**
 * Created by Armin T on 2016-11-26.
 */

public class Account {

    private String userName;
    private String password;

    public Account (String userName, String password) {
        this.setUserName(userName);
        this.setPassword(password);
    }

    public String getUserName() {
        return userName;
    }

    //probably dno't need this here.
    public String getPassword() {
        //this should be more cehck validity upon log in? not sure.
        return null;
    }


    public void setUserName(String userName) {
        final String MESSAGE = "User name cannot be null and must be great than 4 characters";
        //we will need to change this later to make sure this user name doesn't exist.
        if(userName != null && userName.length() > 4) {
            this.userName = userName;
        } else {
            //Toast.makeText(CreateAccountView.class, MESSAGE, Toast.LENGTH_LONG).show();
        }
    }

    public void setPassword(String password) {
        //will need to do ome regex checks or something later
        if (password != null && password.length() > 6) {
            this.password = password;
        } else {
            //throw new IncorrectUserNameException("password cannot be null or less than 6 characters");
        }
    }
}

