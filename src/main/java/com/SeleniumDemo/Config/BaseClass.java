package com.SeleniumDemo.Config;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BaseClass extends Configuration {

    public WebElement getElementById(String element) {

        return Configuration.driver.findElement(By.id(element));

    }
    public WebElement getElementByName(String element) {

        return Configuration.driver.findElement(By.name(element));

    }
    public WebElement getElementByClassName(String element) {

        return Configuration.driver.findElement(By.className(element));

    }
    public WebElement getElementByCssSelector(String element) {

        return Configuration.driver.findElement(By.cssSelector(element));

    }
    public WebElement getElementByXPath(String element) {

        return Configuration.driver.findElement(By.xpath(element));

    }
    public WebElement getElementByPartialLinkText(String element) {

        return Configuration.driver.findElement(By.partialLinkText(element));

    }
    public WebElement getElementByLinkText(String element) {

        return Configuration.driver.findElement(By.linkText(element));

    }
    public List<WebElement> getElementsByXPath(String element) {

        return Configuration.driver.findElements(By.xpath(element));

    }

}
