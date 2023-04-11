package server.persistance;

import client.user.SimpleUser;

import java.sql.*;

public class MyDatabase extends Object
{

    private Connection connection;
    private String driver;
    private String url;
    private String user;
    private String password;

    public MyDatabase(String driver, String url, String user, String pw)
            throws ClassNotFoundException
    {
        this.driver = driver;
        this.url = url;
        this.user = user;
        this.password = pw;
        try
            {
            this.connection = DriverManager.getConnection(url, user, pw);
            } catch (SQLException e)
            {
            e.printStackTrace();
            }
    }

    public void save(String title, int year, int size, String condition,
                     String email, String username, int ratePerMinute, String description)
    {
        try
            {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO VinylListings.vinyl (title, year, size, condition, email, username, rateperminute, description) VALUES (?, ?, ?, ?, ?, ?, ?, ?);");
            statement.setString(1, title);
            statement.setInt(2, year);
            statement.setInt(3, size);
            statement.setString(4, condition);
            statement.setString(5, email);
            statement.setString(6, username);
            statement.setInt(7, ratePerMinute);
            statement.setString(8, description);
            // execute update
            int updates = statement.executeUpdate();
            System.out.println("Number of updates: " + updates);
            } catch (SQLException e)
            {
            e.printStackTrace();
            }
    }

  /*public ArrayList<Object[]> query(String sql, Object statementElements)
  {

  }
  */


    public void saveUser(String username, String password, String email)
    {

        try
            {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO vinyllistings._user (username, password, email) VALUES (?, ?, ?);");
            statement.setString(1, username);
            statement.setString(2, password);
            statement.setString(3, email);
            statement.executeUpdate();
            } catch (SQLException e)
            {
            e.printStackTrace();
            }
    }

    public boolean userLogin(String username, String password) {
        try {
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM vinyllistings._user WHERE username = '"+username+"';");
        ResultSet user = statement.executeQuery();
        if(user.next())
            return username.equals(user.getString(2)) && password.equals(user.getString(3));
        else
            return false;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
}