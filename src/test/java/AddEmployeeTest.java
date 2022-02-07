import com.SeleniumDemo.Config.BaseClass;
import com.SeleniumDemo.Config.ReadExcelData;
import com.SeleniumDemo.Parameters.AddEmployee;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class AddEmployeeTest extends BaseClass {
    AddEmployee param = new AddEmployee();

    @DataProvider (name = "addEmployeeDetails")
    public Object[][] addEmployeeData() throws IOException {
//        Object data[][] = ReadExcelData.getTestData("D:\\Training\\SeleniumDemoProject\\src\\Excel\\Data.xlsx","Sheet1");
        String path = System.getProperty("user.dir");
        Object data[][] = ReadExcelData.getTestData(path + "\\src\\Excel\\Data.xlsx","Sheet1");
        return data;
    }

      @Test(priority = 1)
    public void NavigateToAddEmployee() {
          Actions actions = new Actions(driver);
          actions.moveToElement(getElementById(param.AddEmployeePage)).perform();
          getElementById(param.addEmployee).click();
          driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
////        System.out.println(fName + " " + lName);
////        getElementByCssSelector(param.EmployeeFirstName).sendKeys(fName);
////        getElementByCssSelector(param.EmployeeMiddleName).sendKeys(mName);
////        getElementByCssSelector(param.EmployeeLastName).sendKeys(lName);
////        getElementByCssSelector(param.EmployeePicture).sendKeys(picture);
////        getElementByXPath(param.SaveButton).click();
//
     }

    @Test (priority = 2)
    public void FirstNameMissing() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
        getElementByCssSelector(param.EmployeeLastName).sendKeys("Wick");
        getElementByXPath(param.SaveButton).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS) ;
        Assert.assertEquals(getElementByCssSelector(param.ValidationError).getText(), "Required");
        //Thread.sleep(2000);

    }


    @Test(priority = 3)
    public void LastNameMissing() throws InterruptedException {
        getElementByCssSelector(param.EmployeeLastName).clear();
        //Thread.sleep(3000);
        getElementByCssSelector(param.EmployeeFirstName).sendKeys("John");
        getElementByXPath(param.SaveButton).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS) ;
        String actual = getElementByCssSelector(param.ValidationError).getText();
        System.out.println("The result is " + actual);
        //Assert.assertEquals(getElementByCssSelector(param.ValidationError).getText(), "Required");
        Thread.sleep(2000);
    }

    @Test(priority = 4)
    public void FileUploadValidation() throws InterruptedException {
        getElementByCssSelector(param.EmployeeFirstName).clear();
        getElementByCssSelector(param.EmployeeFirstName).sendKeys("John");
        getElementByCssSelector(param.EmployeeLastName).sendKeys("Wick");
        getElementByName(param.EmployeePicture).sendKeys("C:\\Users\\bazgha.amin\\Downloads\\SampleFile.pdf");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS) ;
        getElementByXPath(param.SaveButton).click();
        Assert.assertEquals(getElementByXPath(param.FileValidationMessage).getText(),"Failed to Save: File Type Not Allowed");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS) ;
        getElementByCssSelector(param.EmployeeFirstName).sendKeys("John");
        getElementByCssSelector(param.EmployeeLastName).sendKeys("Wick");
        getElementByName(param.EmployeePicture).sendKeys("C:\\Users\\bazgha.amin\\Downloads\\TestImage.jpg");
        getElementByXPath(param.SaveButton).click();
        Assert.assertEquals(getElementByXPath(param.FileValidationMessage).getText(), "Failed to Save: File Size Exceeded");
    }

    @Test (dataProvider = "addEmployeeDetails", priority = 5)
    public void AddEmployeeSuccessfully(String fName, String mName, String lName, String picture) throws InterruptedException {
        Actions actions = new Actions(driver);
        getElementByCssSelector(param.EmployeeFirstName).clear();
        getElementByCssSelector(param.EmployeeLastName).clear();
        getElementByCssSelector(param.EmployeeMiddleName).clear();
        getElementByCssSelector(param.EmployeeFirstName).sendKeys(fName);
        getElementByCssSelector(param.EmployeeMiddleName).sendKeys(mName);
        getElementByCssSelector(param.EmployeeLastName).sendKeys(lName);
        getElementByName(param.EmployeePicture).sendKeys(picture);
        getElementByXPath(param.SaveButton).click();
        actions.moveToElement(getElementById(param.AddEmployeePage)).perform();
        getElementById(param.addEmployee).click();

    }

}


