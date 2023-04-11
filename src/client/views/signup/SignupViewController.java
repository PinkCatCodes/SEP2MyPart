package client.views.signup;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.views.ViewController;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class SignupViewController implements ViewController {

    @FXML
    private TextField username;

    @FXML
    private PasswordField password;
    @FXML
    private PasswordField repeatPassword;
    @FXML
    private TextField email;
    @FXML
    private Label error;

    private SignupViewModel signupViewModel;
    private ViewHandler viewHandler;


    public SignupViewController() {

    }

    public void init(ViewHandler vh, ViewModelFactory vmf) throws NotBoundException, RemoteException
    {

        this.signupViewModel = vmf.getSignupViewModel();
        this.viewHandler = vh;

        username.textProperty().bindBidirectional(signupViewModel.usernameProperty());
        password.textProperty().bindBidirectional(signupViewModel.passwordProperty());
        repeatPassword.textProperty().bindBidirectional(signupViewModel.repeatedPasswordProperty());
        email.textProperty().bindBidirectional(signupViewModel.emailProperty());
    }

    @FXML
    public void onSignUp() throws NotBoundException, RemoteException {
//pop up alert that account has been created and take back to home
        if (password.getText().equals(repeatPassword.getText())) {
            signupViewModel.createAccount(username.getText(), password.getText(), email.getText());
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("SUCCESS!");
            alert.setHeaderText("Account successfully created!");
            alert.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("ERROR!");
            alert.setHeaderText("Failure to create an account!");
            alert.showAndWait();
        }
    }
    @FXML
    void onReset() {
        username.clear();
        password.clear();
        repeatPassword.clear();
        email.clear();
    }
    //button to cancel
    @FXML
    void onCancelButton() {
        viewHandler.openHome();
    }

    @FXML void onLogIn() {
        viewHandler.openLogin();
    }


    //and go back login, button

}




