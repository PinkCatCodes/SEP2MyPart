package client.core;

import client.model.Model;
import client.user.User;
import client.user.UserModelManager;
import client.views.addvinyl.ViewAddVinylModel;
import client.views.home.ViewHomeModel;
import client.views.login.LoginViewModel;
import client.views.signup.SignupViewModel;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class ViewModelFactory
{
  private final ModelFactory mf;
  private ViewHomeModel viewHomeModel;
  private ViewAddVinylModel viewAddVinylModel;
  private SignupViewModel signupViewModel;
  private LoginViewModel loginViewModel;


  public ViewModelFactory(ModelFactory mf)
  {
    this.mf = mf;
  }

  public ViewAddVinylModel getViewAddVinylModel()
  {
    if (viewAddVinylModel == null)
      viewAddVinylModel = new ViewAddVinylModel(mf.getModel());
    return viewAddVinylModel;
  }
  public ViewHomeModel getViewHomeModel()
  {
    if (viewHomeModel == null)
      viewHomeModel = new ViewHomeModel(mf.getModel());
    return viewHomeModel;
  }

    public SignupViewModel getSignupViewModel() throws NotBoundException, RemoteException
    {
      mf.getModel();
      if (signupViewModel == null)
        signupViewModel = new SignupViewModel(mf.getUser());
      return signupViewModel;
    }
  public LoginViewModel getLoginViewModel() throws NotBoundException, RemoteException
  {
    mf.getModel();
    if (loginViewModel == null)
      loginViewModel = new LoginViewModel(mf.getUser());
    return loginViewModel;
  }
}
