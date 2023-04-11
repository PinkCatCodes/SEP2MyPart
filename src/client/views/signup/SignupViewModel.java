package client.views.signup;


import client.user.User;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import server.model.Model;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class SignupViewModel
{
    private User user;
    private StringProperty username;
    private StringProperty password;
    private SimpleStringProperty repeatPassword;
    private SimpleStringProperty email;

    public SignupViewModel(User user)
    {

        this.user = user;
        username = new SimpleStringProperty();
        password = new SimpleStringProperty();
        repeatPassword = new SimpleStringProperty();
        email = new SimpleStringProperty();

    }


    public void createAccount(String username, String password, String email) throws NotBoundException, RemoteException
    {
        user.createAccount(username, password, email);

    }

    public StringProperty usernameProperty()
    {
        return username;
    }

    public StringProperty passwordProperty()
    {
        return password;
    }

    public StringProperty repeatedPasswordProperty()
    {
        return repeatPassword;
    }

    public StringProperty emailProperty()
    {
        return email;
    }

    /*public void onSignUp(){?

    }*/
}
