package client.views.login;


import client.user.User;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;


public class LoginViewModel {

    private User user;
    private StringProperty username;
    private StringProperty password;


    public LoginViewModel(User user)
    {
        this.user = user;
        username = new SimpleStringProperty();
        password = new SimpleStringProperty();

    }

    public StringProperty usernameProperty() {
        return username;
    }

    public StringProperty passwordProperty() {
        return password;
    }

    public boolean login()
    {
        return   user.userLogin(username.get(), password.get());
    }


    //cancel, not a member sign up button, log in button
}


