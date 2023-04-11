package server;

import server.model.ModelImpl;
import server.networking.RMIServerImpl;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;

public class RunServer
{
  public static void main(String[] args) throws RemoteException,
      AlreadyBoundException
  {
    RMIServerImpl ss = new RMIServerImpl(new ModelImpl());
    ss.startServer();
    System.out.println("Server started..");
  }
}
