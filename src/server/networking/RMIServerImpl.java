package server.networking;

import client.user.SimpleUser;
import server.model.Model;
import server.model.ModelImpl;
import shared.networking.RMIServer;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class RMIServerImpl implements RMIServer
{
  private Model model;

  public RMIServerImpl(Model model) throws RemoteException
  {
    UnicastRemoteObject.exportObject(this, 0);
    //makes remote method invocation happen
    // marshals and unmarshals remote references to the object
    // marshalling - values are converted into a stream of bytes that can be sent over the network

   //!! UnicastRemoteObject exists only as long as the server that created it still runs.

    //Activatable objects allow clients to reconnect to servers at different times across
    // server shutdowns and restarts and still access the same remote objects.
    // It also has static Activatable.exportObject( ) methods to invoke
    // if you don’t want to subclass Activatable.

          this.model = model;
  }

  public void startServer() throws RemoteException, AlreadyBoundException
  {
    Registry registry = LocateRegistry.createRegistry(1099);
    registry.bind("UppercaseServer", this);
    // remote objects add themselves to the registry using bind()()
    /*  keeps track of the available objects on an RMI server and the names by which they can be requested.
    Clients can then ask for that object by name or
    get a list of all the remote objects that are available*/
  }


  @Override public void save(String title, int year, int size, String condition,
      String email, String username, int ratePerMinute, String description)
      throws RemoteException
  {
      model.save(title, year, size, condition, email, username, ratePerMinute, description);
  }

  @Override
  public void newUser(SimpleUser user)
  {
    System.out.println("hey, new user!");
    model.createAccount(user);
  }

  @Override
  public boolean userLogin(String username, String password)
  {
    System.out.println(username+" " +password);
    return model.userLogin(username, password);
  }

  /* @Override
  public void newUser(SimpleUser user)
  {
    user.addUser(user);
    System.out.println("new user in server");
  }*/

}
