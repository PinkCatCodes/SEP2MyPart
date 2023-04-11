package server.domain;

import java.io.Serializable;

public class SimpleUser implements Serializable//Objects of classes that implement the Serializable
// interface but not the Remote interface are copied using serialization.
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


    public String getUserName()
    {
        return username;
    }


    public void addUser(client.user.SimpleUser user)
    {
    }
}
