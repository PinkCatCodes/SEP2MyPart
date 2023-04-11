package client.core;

import client.model.Model;
import client.model.ModelImpl;
import client.user.User;
import client.user.UserModelManager;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class ModelFactory
{
    private User user;
    private final ClientFactory cf;
    private Model model;


    public ModelFactory(ClientFactory cf)
    {
        this.cf = cf;
    }

    public Model getModel()
    {
        if (model == null)
            model = new ModelImpl(cf.getClient());
        return model;
    }

    public User getUser() throws NotBoundException, RemoteException
    {
        if (user == null)
            {
            user = new UserModelManager(cf.getClient());
            }
        return user;
    }
}
