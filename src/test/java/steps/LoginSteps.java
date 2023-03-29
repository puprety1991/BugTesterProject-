package steps;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.CommonMethods;
import utils.ConfigReader;

public class LoginSteps extends CommonMethods {

    @When("user enters the valid username and password")
    public void user_enters_the_valid_username_and_password() {

        sendText(loginPage.loginUserNameField,ConfigReader.getPropertyValue("username"));
        sendText(loginPage.loginPasswordField,ConfigReader.getPropertyValue("password"));


     sendText(loginPage.loginUserNameField,ConfigReader.getPropertyValue("username"));
     sendText(loginPage.loginPasswordField,ConfigReader.getPropertyValue("password"));

    }
    @When("user clicks on login button")
    public void user_clicks_on_login_button() {
        click(loginPage.loginButton);
    }
    @Then("user successfully logged in")
    public void user_successfully_logged_in() {
        System.out.println("Successfully");
    }

}
