package server.model;

import client.user.SimpleUser;
import server.domain.Vinyl;
import server.domain.VinylList;

public interface VinylPersistance
{
  VinylList load();
  void save(String title, int year, int size, String condition, String email,
      String username, int ratePerMinute, String description);
  void remove(Vinyl vinyl);
  void clear();

  void addUser(SimpleUser user);

  boolean userLogin(String username, String password);
}
