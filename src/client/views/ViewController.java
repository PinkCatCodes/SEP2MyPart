package client.views;

import client.core.ViewHandler;
import client.core.ViewModelFactory;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public interface ViewController
{
  void init(ViewHandler vh, ViewModelFactory vmf) throws NotBoundException, RemoteException;

}
