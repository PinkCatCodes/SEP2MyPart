package server.model;

import client.user.SimpleUser;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class ModelImpl implements Model
{
  private PropertyChangeSupport support;
  private VinylPersistance vinylPersistance;
  public ModelImpl()
  {
    support = new PropertyChangeSupport(this);
    try
    {
      this.vinylPersistance = new VinylDatabase();
    }
    catch (ClassNotFoundException e)
    {
      e.printStackTrace();
    }
  }

  @Override
  public void addListener(String eventName, PropertyChangeListener listener) {
    support.addPropertyChangeListener(eventName, listener);
  }

  @Override
  public void removeListener(String eventName, PropertyChangeListener listener) {
    support.removePropertyChangeListener(eventName, listener);
  }

  @Override public void save(String title, int year, int size, String condition,
      String email, String username, int ratePerMinute, String description)
  {
    vinylPersistance.save(title, year, size, condition, email, username, ratePerMinute,description);
  }

  @Override
  public void createAccount(SimpleUser user)
  {
    vinylPersistance.addUser(user);
  }

  @Override
  public boolean userLogin(String username, String password)
  {
    return vinylPersistance.userLogin(username, password);
  }
}
