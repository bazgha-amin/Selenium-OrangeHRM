import com.SeleniumDemo.Config.BaseClass;
import com.SeleniumDemo.Parameters.SearchEmployeeParameters;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SearchEmployeeTest extends BaseClass {

   SearchEmployeeParameters param = new SearchEmployeeParameters();
    @Test
    public void SearchEmployee() throws InterruptedException {
        getElementByXPath(param.SearchEmployeePage).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS) ;
        getElementByXPath(param.EmployeeNameTextBox).sendKeys("Sarah");
        List<WebElement> SearchList = getElementsByXPath(param.SearchOptions);
        System.out.println("Number of elements:" +SearchList.size());
        for(int i =0;i<SearchList.size();i++) {
           System.out.println(SearchList.get(i).getText());
           if (SearchList.get(i).getText().contains("Sarah"))
           {
               SearchList.get(i).click();
               break;
           }
        }
        getElementByXPath(param.employeeSearchButton).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS) ;
    }

}
