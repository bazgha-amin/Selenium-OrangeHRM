package com.SeleniumDemo.Config;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

public class Configuration {
    public static WebDriver driver;

    @BeforeSuite
    public void setup() throws InterruptedException {
        // Create driver
       // System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

//        if(browserName.equalsIgnoreCase("chrome")) {
//            WebDriverManager.chromedriver().setup();
//            driver = new ChromeDriver();
//        }
//        else if(browserName.equalsIgnoreCase("firefox")) {
//            WebDriverManager.firefoxdriver().setup();
//            driver = new FirefoxDriver();
//       }
        // sleep
        Thread.sleep(3000);

        // maximize browser window
        driver.manage().window().maximize();

        // open test page
        String url = "https://opensource-demo.orangehrmlive.com/";
        driver.get(url);
        System.out.println("Page is opened.");

        Thread.sleep(2000);


    }
   @AfterSuite
   public void quitDriver() {driver.quit();}


}
