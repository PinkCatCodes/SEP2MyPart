package server.model;

import client.user.SimpleUser;
import server.domain.Vinyl;
import server.domain.VinylList;
import server.persistance.MyDatabase;

public class VinylDatabase implements VinylPersistance
{
  private MyDatabase db;
  private static final String DRIVER = "org.postgresql.Driver";
  private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
  private static final String USER = "postgres";
  private static final String PASSWORD = "Pinkcatcodes";

  public VinylDatabase() throws ClassNotFoundException
  {
    this.db= new MyDatabase(DRIVER, URL, USER, PASSWORD);
  }

  @Override public VinylList load()
  {
    return null;
  }


  @Override public void save(String title, int year, int size, String condition,
      String email, String username, int ratePerMinute, String description)
  {
    db.save(title,year,size,condition,email,username,ratePerMinute,description);
  }

  @Override public void remove(Vinyl vinyl)
  {

  }

  @Override public void clear()
  {

  }


  @Override
  public void addUser(SimpleUser user)
  {
    db.saveUser(user.getUserName(), user.getPassword(), user.getEmail());
  }

  @Override
  public boolean userLogin(String username, String password)
  {
    return db.userLogin(username, password);
  }

  /*@Override public VinylList load() throws SQLException
  {
    String sql = "SELECT ...." + "WHERE ... to see results of list";
    ArrayList<Object[]> results;
    VinylList list = new VinylList();
    // ... TODO: to be implemented
    return list;
  }

  @Override public void save(VinylList vinylList) throwsSQLException
  {
    for (int i = 0; i < vinylList.getNumberOfVinyls(); i++)
    {
      save (vinylList.getVinyl(i));
    }
  }

  @Override public void save(Vinyl vinyl) throws SQLException
  {
    // ... TODO: to be implemented
  }

  @Override public void remove(Vinyl vinyl)
  {

  }

  @Override public void clear() throws SQLException
  {
    try
    {
      //example
      String sql = "TRUNCATE TABLE CdList.track CASCADE;"; db.update(sql);
      sql = "TRUNCATE TABLE CdList.cd CASCADE;";
      db.update(sql);
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }

  }*/
}
