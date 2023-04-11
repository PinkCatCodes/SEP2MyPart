package shared.networking;

import client.user.SimpleUser;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RMIServer extends Remote//Objects of classes that implement the Remote interface
// are transferred as remote references.
// The client neither knows nor cares how the server gets the result as long as it produces the correct one.

/*The Remote interface tags objects as remote objects. It doesn’t declare any methods;
remote objects usually implement a subclass of Remote that does declare some methods. The methods that are declared in the interface are the methods that can be
invoked remotely.*/
{
  void save(String title, int year, int size, String condition,
    String email, String username, int ratePerMinute, String description) throws RemoteException;

    void newUser(SimpleUser user) throws RemoteException;

  boolean userLogin(String username, String password) throws RemoteException;
}
