package client.user;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface User {
    void createAccount(String username, String password, String email)
            throws RemoteException, NotBoundException;

    boolean userLogin(String username, String password);

}
