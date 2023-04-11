package client.user;



import client.network.Client;
import client.network.RMIClient;



import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

public class UserModelManager implements User
{

    private Client clientInterface;


    public UserModelManager(Client clientInterface) throws NotBoundException, RemoteException {
        this.clientInterface = clientInterface;
        clientInterface = new RMIClient();
        clientInterface.startClient();

    }


    public void createAccount(String username, String password, String email) throws NotBoundException, RemoteException {
        SimpleUser user = new SimpleUser(username, password, email);
        System.out.println("SimpleUser has been created");

        clientInterface.newUser(user);

    }

    public   boolean userLogin(String username, String password) {
        return clientInterface.userLogin(username, password);
    }
}
