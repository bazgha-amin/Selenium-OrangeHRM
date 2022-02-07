import com.SeleniumDemo.Config.BaseClass;
import com.SeleniumDemo.Parameters.Attendence;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class AttendenceTest extends BaseClass {
    Attendence param = new Attendence();

    @Test
    public void CheckInCheckOut() {
        Actions actions = new Actions(driver);
        actions.moveToElement(getElementByXPath(param.attendenceHover)).perform();
        actions.moveToElement(getElementByXPath(param.attendenceDropDown)).perform();
        getElementByXPath(param.checkInOut).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS) ;
        //getElementByXPath(param.checkInNotes).sendKeys("Checking in");
        getElementByXPath(param.checkInButton).click();
        //Assert.assertEquals(getElementByXPath(param.punchedInNote).getText(),"Checking in");
       // getElementByXPath(param.checkOutNotes).sendKeys("Checking out");
        getElementByXPath(param.checkOutButton).click();
        Assert.assertEquals(getElementByXPath(param.successfullMessage).getText(),"Successfully Saved");

    }

}
