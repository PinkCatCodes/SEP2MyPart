package client.views.addvinyl;

import client.model.Model;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ViewAddVinylModel
{
  private Model model;
  private StringProperty title, condition, email, username, description, year, size, ratePerMinute;

  public ViewAddVinylModel(Model model)
  {
    this.model = model;
    title = new SimpleStringProperty();
    condition = new SimpleStringProperty();
    email = new SimpleStringProperty();
    username = new SimpleStringProperty();
    description = new SimpleStringProperty();

    year = new SimpleStringProperty();
    size = new SimpleStringProperty();
    ratePerMinute = new SimpleStringProperty();
  }

  void save()
  {
    model.save(title.get(),Integer.parseInt(year.get()),Integer.parseInt(size.get()), condition.get(), email.get(),
        username.get(), Integer.parseInt(ratePerMinute.get()), description.get());
  }

  public StringProperty titleProperty()
  {
    return title;
  }
  public StringProperty conditionProperty()
  {
    return condition;
  }
  public StringProperty emailProperty()
  {
    return email;
  }
  public StringProperty usernameProperty()
  {
    return username;
  }
  public StringProperty descriptionProperty()
  {
    return description;
  }
  public StringProperty yearProperty()
  {
    return year;
  }
  public StringProperty sizeProperty()
  {
    return size;
  }
  public StringProperty ratePerMinuteProperty()
  {
    return ratePerMinute;
  }

}
