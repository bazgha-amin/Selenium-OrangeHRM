package com.SeleniumDemo.Parameters;

import org.openqa.selenium.By;

public class LoginParameters {
    public static final String username = "txtUsername";
    public static final String password = "txtPassword";
    public static final String loginButton = "btnLogin";
    public static final String successMessage = "welcome";
    public static final String labelDashboard = "#content > div > div.head > h1";
    public static final String errorMessage = "//*[@id='spanMessage']";
    public static final String emptyField = "//*[@id=\"spanMessage\"]";
    //String emptyPassword = "spanMessage";
    public static final String toolbarText ="Welcome";
    public static final String logoutButton = "Logout";
    public static final String Logo = "divLogo";

}
