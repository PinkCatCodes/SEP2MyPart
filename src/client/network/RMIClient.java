package client.network;

import client.user.SimpleUser;
import shared.networking.ClientCallBack;
import shared.networking.RMIServer;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class RMIClient implements Client, ClientCallBack, Serializable
{
  private RMIServer server;
  private PropertyChangeSupport support;

  public RMIClient()
  {
    support = new PropertyChangeSupport(this);
  }

  public void startClient() {
    try {
      UnicastRemoteObject.exportObject(this, 0);
      //Used for exporting a remote object.
    // makes remote method invocation happen
    // marshals and unmarshals remote references to the object.
    //
    // marshalling - values are converted into a stream of bytes that can be sent over the network.
    //
    //!! UnicastRemoteObject exists only as long as the server that created it still runs.

      Registry registry = LocateRegistry.getRegistry("localhost", 1099);
   // LR is used to obtain a reference to a remote object registry on a particular host
    //Registry  stores  and retrieves remote object references bound with arbitrary string names.

    //!!lets the client find the registry
    server = (RMIServer) registry.lookup("UppercaseServer");
   /* Before a client object can call a remote method, it
    needs a remote reference to the object whose method it’s going to call. A program
    retrieves this remote reference from a registry on the server where the remote object
    runs. It queries the registry by calling the registry’s lookup( ) method*/
      //server.registerClient(this);
    } catch (RemoteException | NotBoundException e) {
      e.printStackTrace();
    }
  }


  @Override public void addListener(String eventName,
      PropertyChangeListener listener)
  {
    support.addPropertyChangeListener(eventName, listener);

  }

  @Override public void removeListener(String eventName,
      PropertyChangeListener listener)
  {
    support.removePropertyChangeListener(eventName, listener);
  }


  @Override public void save(String title, int year, int size, String condition,
      String email, String username, int ratePerMinute, String description)
  {
    try
    {
      server.save(title, year, size,condition, email, username, ratePerMinute,description);
    }
    catch (RemoteException e)
    {
      e.printStackTrace();
    }
  }

  @Override
  public void newUser(SimpleUser user) throws RemoteException, NotBoundException
  {
    server.newUser(user);

  }

  @Override
  public boolean userLogin(String username, String password)
  {
    try
      {
      return server.userLogin(username, password);
      } catch (RemoteException e)
      {
      throw new RuntimeException(e);
      }
  }
}
