package com.SeleniumDemo.Config;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;

public class ScreenShot {

    //Full Page ScreenShot
    public static void captureFullPageScreenshot(WebDriver driver, String screenshotName) throws IOException {
        TakesScreenshot screenCapture = (TakesScreenshot) driver;
        File source =  screenCapture.getScreenshotAs(OutputType.FILE);
        File destination = new File("./Screenshots/"+screenshotName+".png");
        FileUtils.copyFile(source,destination);
    }

    //Screenshot of section/webelement
    public static void sectionScreenshot(WebDriver driver,String xpathName, String screenshotName) throws IOException {
        WebElement particularSection= driver.findElement(By.xpath(xpathName));
        File source =  particularSection.getScreenshotAs(OutputType.FILE);
        File destination = new File("./Screenshots/"+screenshotName+".png");
        FileUtils.copyFile(source,destination);
    }

}
