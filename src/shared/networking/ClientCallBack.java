package shared.networking;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ClientCallBack extends Remote//sole purpose is to
//  transferred as remote references
{
  void save(String title, int year, int size, String condition,
      String email, String username, int ratePerMinute, String description) throws
      RemoteException;
}
