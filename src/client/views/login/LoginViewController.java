package client.views.login;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.views.ViewController;

import javafx.fxml.FXML;


import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;


public class LoginViewController implements ViewController
{

    @FXML
    private TextField username;
    @FXML
    private PasswordField password;

    private LoginViewModel loginViewModel;
    private ViewHandler viewHandler;


    public void init(ViewHandler vh, ViewModelFactory vmf) throws NotBoundException, RemoteException
    {

        this.loginViewModel = vmf.getLoginViewModel();
        this.viewHandler = vh;

        username.textProperty().bindBidirectional(loginViewModel.usernameProperty());
        password.textProperty().bindBidirectional(loginViewModel.passwordProperty());

    }

    @FXML
    void onReset()
    {
        username.clear();
        password.clear();
    }

    @FXML
    void onSignupButton()
    {
        viewHandler.openSignup();
    }

    @FXML
    private void onEnter() {
        onLogin();
    }

    @FXML
    private void onLogin() {
      boolean success =  loginViewModel.login();
      if(success) {
      Alert alert = new Alert(Alert.AlertType.INFORMATION);
      alert.setTitle("SUCCESS!");
      alert.setHeaderText("You are logged in!");
      alert.showAndWait();
      viewHandler.openHome();
      } else {
      Alert alert = new Alert(Alert.AlertType.INFORMATION);
      alert.setTitle("ERROR!");
      alert.setHeaderText("Log in failed!");
      alert.showAndWait();
      }
    }

    @FXML
    private void onCancel()
    {
        viewHandler.openHome();
    }
    //cancel button


}




