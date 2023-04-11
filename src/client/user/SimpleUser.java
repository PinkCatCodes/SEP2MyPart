package client.user;

import java.io.Serializable;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class SimpleUser implements Serializable
{
    private String username;
    private String password;
    private String email;


    public SimpleUser(String username, String password, String email)
    {
        this.username = username;
        this.password = password;
        this.email = email;
    }



    public String getPassword()
    {
        return password;
    }

    public String getEmail()
    {
        return email;
    }


    public String getUserName() {
        return username;
    }


    public void addUser(SimpleUser user)
    {
    }
}
