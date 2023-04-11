package server.model;

import client.user.SimpleUser;
import shared.util.Subject;

public interface Model extends Subject
{
  void save(String title, int year, int size, String condition,
      String email, String username, int ratePerMinute, String description);

  void createAccount(SimpleUser user);

  boolean userLogin(String username, String password);
}
