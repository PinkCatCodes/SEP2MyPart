package client.network;

import client.user.SimpleUser;
import shared.util.Subject;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public interface Client extends Subject
{
  void startClient();
  void save(String title, int year, int size, String condition,
      String email, String username, int ratePerMinute, String description);

    void newUser(SimpleUser user) throws RemoteException, NotBoundException;

    boolean userLogin(String username, String password);

}
