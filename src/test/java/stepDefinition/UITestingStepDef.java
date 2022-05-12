package stepDefinition;

import common.AppSetting;
import common.BasePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import page.LoginPage;
import page.RegistrationPage;


public class UITestingStepDef {
    public RegistrationPage registrationPage;
    public LoginPage loginPage;

    public UITestingStepDef() {
        registrationPage = new RegistrationPage(BasePage.driver);
        loginPage = new LoginPage(BasePage.driver);
    }

    @Given("User is on vita mojo demo site")
    public void user_is_on_vita_mojo_demo_site() throws Exception {
        try {
            registrationPage.navigateToUrl();
            registrationPage.clickOnLoginButton();
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    @Given("Click on Create Account Tab")
    public void click_on_create_account_tab() throws Exception {
        try {
            registrationPage.clickOnCreateAccountTab();
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    @When("user enter name, email address, phone and password")
    public void user_enter_name_email_address_and_password() throws Exception {
        try {
            registrationPage.enterDataInNameField();
            registrationPage.enterDataInEmailField();
            registrationPage.selectCountryCode();
            registrationPage.enterDataInPhoneNumberField();
            registrationPage.enterDataInPasswordField();
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    @When("user clicks on Create Account button")
    public void user_clicks_on_create_account_button() throws Exception {
        try {
        registrationPage.clickOnCreateAccountButton();
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    @Then("user should be created")
    public void user_should_be_created() throws Exception {
        try {
            Assert.assertTrue(registrationPage.getLoggedUserName().equalsIgnoreCase(AppSetting.getInstance().getName()),
                    "User is Created");
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    @Given("Click on Login Tab")
    public void click_on_login_tab() throws Exception {
        try {
            loginPage.clickLoginTab();
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    @When("user enter email address and password")
    public void user_enter_email_address_and_password() throws Exception {
        try {
            loginPage.enterDataInEmailField();
            loginPage.enterDataInPasswordField();
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    @When("user clicks on Login button")
    public void user_clicks_on_login_button() throws Exception {
        try {
            loginPage.clickLoginButton();
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    @Then("user should be redirected to Dashboard")
    public void user_should_be_redirected_to_dashboard() throws Exception {
        try {

            Assert.assertTrue(loginPage.getLoggedUserName().equalsIgnoreCase(AppSetting.getInstance().getName()),
                    "User is logged in");
        } catch (Exception e) {
            throw new Exception(e);
        }
    }
}
