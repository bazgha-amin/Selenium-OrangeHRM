import com.SeleniumDemo.Config.BaseClass;
import com.SeleniumDemo.Config.ScreenShot;
import com.SeleniumDemo.Parameters.LoginParameters;
import jdk.nashorn.internal.runtime.ScriptRuntime;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginTest extends BaseClass {
    LoginParameters param = new LoginParameters();
   // private WebDriverWait wait;

//    public LoginTest(WebDriver driver) {
//        PageFactory.initElements(driver, this);
//        wait = new WebDriverWait(driver, 15);
//    }
    //WebDriverWait wait = new WebDriverWait(driver,15);

    @Test(priority = 6)
    public void LoginWithValidCredentials() throws InterruptedException, IOException {
        getElementById(param.username).clear();
        getElementById(param.password).clear();
        getElementById(param.username).sendKeys("admin");
        getElementById(param.password).sendKeys("admin123");
        getElementById(param.loginButton).click();
        Assert.assertTrue(getElementByCssSelector(param.labelDashboard).isDisplayed());
        Assert.assertTrue(getElementById(param.successMessage).isDisplayed());
        ScreenShot.captureFullPageScreenshot(driver,"Dashboard");
        //  getElementByPartialLinkText(param.toolbarText).click();
        //  Thread.sleep(4000);
        //  getElementByPartialLinkText(param.logoutButton).click();
    }

    @Test(priority = 1)
    public void LoginWithInvalidUsername() throws InterruptedException {
        //getElementById(param.username).sendKeys("abc");
        WebDriverWait wait = new WebDriverWait(driver,15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(param.username))).sendKeys("abc");
        getElementById(param.password).sendKeys("admin123");
        getElementById(param.loginButton).click();
        Assert.assertTrue(getElementByXPath(param.errorMessage).isDisplayed());

    }

    @Test(priority = 2)
    public void LoginWithInvalidPassword() {
        getElementById(param.username).sendKeys("admin");
        getElementById(param.password).sendKeys("admin");
        getElementById(param.loginButton).click();
        Assert.assertTrue(getElementByXPath(param.errorMessage).isDisplayed());
    }

    @Test(priority = 3)
    public void LoginWithEmptyPassword() throws InterruptedException {
        getElementById(param.username).sendKeys("admin");
        getElementById(param.loginButton).click();
        //Thread.sleep(3000);
        WebDriverWait wait = new WebDriverWait(driver,15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(param.emptyField)));
        //Assert.assertTrue(getElementByXPath(param.emptyField).isDisplayed());
        Assert.assertEquals(getElementByXPath(param.emptyField).getText(), "Password cannot be empty");
    }

    @Test(priority = 4)
    public void LoginWithEmptyUsername() throws InterruptedException, IOException {
        getElementById(param.password).sendKeys("admin123");
        getElementById(param.username).clear();
        getElementById(param.loginButton).click();
        //Thread.sleep(3000);
        WebDriverWait wait = new WebDriverWait(driver,15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(param.emptyField)));
        // Assert.assertTrue(getElementByXPath(param.emptyField).isDisplayed());
        Assert.assertEquals(getElementByXPath(param.emptyField).getText(), "Username cannot be empty");
        ScreenShot.sectionScreenshot(driver,"//div[@id='divLoginImage']","LoginPage");


    }

    @Test(priority = 5)
    public void LogoDisplayed() {
        Assert.assertTrue(getElementById(param.Logo).isDisplayed());

    }
}

