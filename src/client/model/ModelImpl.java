package client.model;

import client.network.Client;
import client.user.User;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class ModelImpl implements Model
{
  private PropertyChangeSupport support = new PropertyChangeSupport(this);

  private Client client;
  public ModelImpl(Client client)
  {
    this.client = client;
    client.startClient();
    //client.addListener("NewLogEntry", this::onNewLogEntry);
  }
  /*private void onNewLogEntry(PropertyChangeEvent evt) {
    support.firePropertyChange(evt);
  }*/

  @Override public void save(String title, int year, int size, String condition,
      String email, String username, int ratePerMinute, String description)
  {
    client.save(title,year,size,condition,email,username,ratePerMinute,description);
  }



  @Override
  public void addListener(String eventName, PropertyChangeListener listener) {
    support.addPropertyChangeListener(eventName, listener);
  }

  @Override
  public void removeListener(String eventName, PropertyChangeListener listener) {
    support.removePropertyChangeListener(eventName, listener);
  }
}
