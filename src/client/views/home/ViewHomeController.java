package client.views.home;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.views.ViewController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.awt.*;

public class ViewHomeController implements ViewController
{
  private ViewHomeModel viewModel;
  private ViewHandler viewHandler;

  public ViewHomeController(){}

  public void init(ViewHandler vh, ViewModelFactory vmf)
  {
    this.viewModel = vmf.getViewHomeModel();
    this.viewHandler = vh;
  }

  public void reset() {
  }


  @FXML
  void addBtn()
  {
    viewHandler.openAddVinyl();
  }

/*
  @FXML
  void onLoginFromHome()
  {
    viewHandler.openLogin();
  }*/
}
