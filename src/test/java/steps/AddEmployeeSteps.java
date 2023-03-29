package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AddEmployeePage;
import utils.CommonMethods;
import utils.Constants;
import utils.ExcelReader;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class AddEmployeeSteps extends CommonMethods {
    static String empId;

    @When("user clicks on the PIM option")
    public void user_clicks_on_the_pim_option() {
        click(dashBoardPage.pimOption);
    }


    @When("user clisks Add Employee option")
    public void user_clisks_add_employee_option() {
        click(dashBoardPage.addEmployeeOption);
    }

    @When("user provide employee information from excel with sheetName {string}")
    public void user_provide_employee_information_from_excel_with_sheet_name(String sheetName) {
        List<Map<String, String>> excelFl = ExcelReader.listOfMapData(Constants.TESTDATA_FILEPATH, sheetName);
        Iterator<Map<String, String>> iterator = excelFl.iterator();
        while (iterator.hasNext()) {
            Map<String, String> empInfo1 = iterator.next();
            sendText(addEmployeePage.firstNameField, empInfo1.get("FirstName"));
            sendText(addEmployeePage.middleNameField, empInfo1.get("MiddleName"));
            sendText(addEmployeePage.lastNameField, empInfo1.get("LastName"));
            empId = addEmployeePage.empIdField.getAttribute("value");
            sendText(addEmployeePage.photofile, empInfo1.get("photograph"));
            clickRadioButton(addEmployeePage.chkLogin);
            sendText(addEmployeePage.user_Name, empInfo1.get("username"));
            sendText(addEmployeePage.user_password, empInfo1.get("password"));
            sendText(addEmployeePage.re_password, empInfo1.get("confirmed_password"));

        }

    }

    @When("user clicks the Add button")
    public void user_clicks_the_add_button() {
        click(addEmployeePage.btnSave);

    }

    @Then("user verifies the data")
    public void user_verifies_the_data() {
        System.out.println("Verifies");
    }
}
