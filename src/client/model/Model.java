package client.model;

import client.user.User;
import shared.util.Subject;

public interface Model extends Subject
{
    void save(String title, int year, int size, String condition,
              String email, String username, int ratePerMinute, String description);


}
