package client.core;

import client.views.ViewController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.rmi.NotBoundException;

public class ViewHandler
{
  /*private ViewModelFactory viewModelFactory;
  private Stage primaryStage;
  private Scene currentScene;
  private ViewAddVinylController viewAddVinylController;
  private ViewHomeController viewHomeController;

  public ViewHandler(ViewModelFactory viewModelFactory){
    this.viewModelFactory = viewModelFactory;
    this.currentScene = new Scene(new Region());
  }

  public void start(Stage primaryStage)
  {
    this.primaryStage = primaryStage;
    openView("home");
  }

  public void openView(String id)
  {
    Region root = null;
    switch (id)
    {
      case "home":
        root = loadHomeView("home.fxml");
        break;
      case "addVinyl":
        root = loadAddVinylView("addVinyl.fxml");
        break;

    }
    currentScene.setRoot(root);
    String title = "";
    if(id.equals("home"))
    {
      title = "Home";
    } if(id.equals("addVinyl"))
  {
    title = "AddVinyl";
  }

    if (root.getUserData() !=  null)
    {
      title += root.getUserData();
    }

    primaryStage.setTitle(title);
    primaryStage.setScene(currentScene);
    primaryStage.setWidth(root.getPrefWidth());
    primaryStage.setHeight(root.getPrefHeight());
    primaryStage.show();
  }

  public void closeView()
  {
    primaryStage.close();
  }

  private Region loadHomeView(String fxmlFile)
  {
    Region root = null;
    if (viewHomeController == null)
    {
      try
      {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(fxmlFile));
        root = loader.load();
        viewHomeController = loader.getController();
        viewHomeController.init(root, viewModelFactory.getViewHomeModel(),this);
      }
      catch (IOException e)
      {
        e.printStackTrace();
      }
    }
    else
    {
      viewHomeController.reset();
    }
    return viewHomeController.getRoot();
  }

  private Region loadAddVinylView(String fxmlFile)
  {
    Region root = null;
    if (viewAddVinylController == null)
    {
      try
      {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(fxmlFile));
        root = loader.load();
        viewAddVinylController = loader.getController();
        viewAddVinylController.init(root, viewModelFactory.getViewAddVinylModel(),this);
      }
      catch (IOException e)
      {
        e.printStackTrace();
      }
    }
    else
    {
      viewAddVinylController.reset();
    }
    return viewAddVinylController.getRoot();
  }*/

  private Stage stage;
  private ViewModelFactory vmf;
  private Scene homeScene;
  private Scene AddVinylScene;
  private Scene loginScene;
  private Scene signupScene;

  public ViewHandler(ViewModelFactory vmf) {
    this.vmf = vmf;
  }

  public void start() {
    stage = new Stage();
    openLogin();
  }

  public void openHome() {
    if (homeScene == null) {
      try {
        Parent root = loadFXML("../views/home/home.fxml");

        stage.setTitle("SWAPi's Profile");
        homeScene = new Scene(root);
      } catch (IOException | NotBoundException e) {
        e.printStackTrace();
      }
    }
    stage.setScene(homeScene);
    stage.show();
  }

  public void openAddVinyl() {
    // no reusing a logScene, because I want the log to reload the latest every time.
    if (AddVinylScene == null) {
      try {
        Parent root = loadFXML("../views/addvinyl/addVinyl.fxml");

        AddVinylScene = new Scene(root);
        stage.setTitle("Add Vinyl");

      } catch (IOException | NotBoundException e) {
        e.printStackTrace();
      }
    }
    stage.setScene(AddVinylScene);
    stage.show();
  }

  public void openLogin()
  {
    if (loginScene == null)
      {
      try
        {
        Parent root = loadFXML("../views/login/loginView.fxml");

        stage.setTitle("Log in");
        loginScene = new Scene(root);
        } catch (IOException | NotBoundException e)
        {
        e.printStackTrace();
        }
      }
    stage.setScene(loginScene);
    stage.show();
  }

  public void openSignup()
  {
    if (signupScene == null) {
    try {
    Parent root = loadFXML("../views/signup/signupView.fxml");

    signupScene = new Scene(root);
    stage.setTitle("Sign up");

    } catch (IOException | NotBoundException e) {
    e.printStackTrace();
    }
    }
    stage.setScene(signupScene);
    stage.show();
  }

  private Parent loadFXML(String path) throws IOException, NotBoundException
  {
    FXMLLoader loader = new FXMLLoader();
    loader.setLocation(getClass().getResource(path));
    Parent root = loader.load();

    ViewController ctrl = loader.getController();
    ctrl.init(this, vmf);
    return root;
  }
}




