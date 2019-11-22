package me.kyllian.netflixstatistix.controllers;

public class ControllerHandler {

    private LoginController loginController;

    public LoginController getLoginController() {
        return loginController;
    }

    public void setLoginController(LoginController loginController) {
        this.loginController = loginController;
    }
}
