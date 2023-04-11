package client.views.addvinyl;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.views.ViewController;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class ViewAddVinylController implements ViewController
{

  @FXML
  private TextField condition;

  @FXML
  private TextField description;

  @FXML
  private TextField email;

  @FXML
  private TextField ratePerMinute;

  @FXML
  private TextField size;

  @FXML
  private TextField title;

  @FXML
  private TextField username;

  @FXML
  private TextField year;

  private ViewAddVinylModel viewModel;
  private ViewHandler viewHandler;

  public ViewAddVinylController(){}

  public void init(ViewHandler vh, ViewModelFactory vmf)
  {

    this.viewHandler = vh;
    this.viewModel = vmf.getViewAddVinylModel();
    title.textProperty().bindBidirectional(viewModel.titleProperty());
    condition.textProperty().bindBidirectional(viewModel.conditionProperty());
    email.textProperty().bindBidirectional(viewModel.emailProperty());
    username.textProperty().bindBidirectional(viewModel.usernameProperty());
    description.textProperty().bindBidirectional(viewModel.descriptionProperty());
    year.textProperty().bindBidirectional(viewModel.yearProperty());
    size.textProperty().bindBidirectional(viewModel.sizeProperty());
    ratePerMinute.textProperty().bindBidirectional(viewModel.ratePerMinuteProperty());
  }

  @FXML
  void backBtn() {
    viewHandler.openHome();
  }
  @FXML
  void resetFields() {
    title.clear();
    year.clear();
    size.clear();
    condition.clear();
    email.clear();
    username.clear();
    ratePerMinute.clear();
    description.clear();
  }
  @FXML
  void addVinyl() {
    if(title.getLength()>50)
    {
      Alert alert = new Alert(Alert.AlertType.ERROR);
      alert.setTitle("Error");
      alert.setHeaderText("Title has more than 50 characters");
      alert.showAndWait();
    } else if(condition.getLength()>50)
    {
      Alert alert = new Alert(Alert.AlertType.ERROR);
      alert.setTitle("Error");
      alert.setHeaderText("Condition has more than 50 characters");
      alert.showAndWait();
    }else if(email.getLength()>50)
    {
      Alert alert = new Alert(Alert.AlertType.ERROR);
      alert.setTitle("Error");
      alert.setHeaderText("Email has more than 50 characters");
      alert.showAndWait();
    }else if(username.getLength()>50)
    {
      Alert alert = new Alert(Alert.AlertType.ERROR);
      alert.setTitle("Error");
      alert.setHeaderText("Username has more than 50 characters");
      alert.showAndWait();
    }else if(description.getLength()>100)
    {
      Alert alert = new Alert(Alert.AlertType.ERROR);
      alert.setTitle("Error");
      alert.setHeaderText("Description has more than 100 characters");
      alert.showAndWait();
    }
    else if(title.getLength()==0 || year.getLength()==0 || size.getLength()==0 || condition.getLength()==0 || email.getLength()==0 || username.getLength()==0
        || ratePerMinute.getLength()==0 || description.getLength()==0)
    {
      Alert alert = new Alert(Alert.AlertType.ERROR);
      alert.setTitle("Error");
      alert.setHeaderText("Fill out all the blank fields");
      alert.showAndWait();
    }
    else
    {

      viewModel.save();
      resetFields();
      backBtn();
    }
  }

}
