package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class DashBoardPage extends CommonMethods {

    @FindBy(xpath = "//*[text()='PIM']")
    public WebElement pimOption;

    @FindBy(xpath = "//*[@id='menu_pim_addEmployee']")
    public WebElement addEmployeeOption;

    public DashBoardPage(){
        PageFactory.initElements(driver,this);
    }

}
