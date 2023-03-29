package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class AddEmployeePage extends CommonMethods {

@FindBy(xpath = "//*[@id='firstName']")
    public WebElement firstNameField;

@FindBy(xpath = "//*[@id='middleName']")
    public WebElement middleNameField;

@FindBy(xpath = "//*[@id='lastName']")
    public WebElement lastNameField;

@FindBy(xpath = "//*[@id='employeeId']")
    public WebElement empIdField;

@FindBy(xpath = "//*[@id='photofile']")
    public WebElement photofile;

@FindBy(xpath = "//*[@id='chkLogin']")
    public WebElement chkLogin;

@FindBy(xpath = "//*[@id='user_name']")
    public WebElement user_Name;

@FindBy(xpath = "//*[@id='user_password']")
    public WebElement user_password;
@FindBy(xpath = "//*[@id='re_password']")
    public WebElement re_password;
@FindBy(xpath = "//*[@id='btnSave']")
    public WebElement btnSave;

public AddEmployeePage(){
    PageFactory.initElements(driver,this);
}

}
