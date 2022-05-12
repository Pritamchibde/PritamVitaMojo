package page;

import common.AppSetting;
import common.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class RegistrationPage extends BasePage {

    public RegistrationPage(WebDriver Driver) {
        super(Driver);
    }

    //Locators
    public static By loginButton = By.xpath("//a[text()='Login']");
    public static By createAccountTab = By.xpath("//li[contains(text(),'Create Account')]");
    public static By nameField = By.id("firstName");
    public static By emailAddress = By.id("email");
    public static By password = By.id("password");
    public static By createAccountBTN = By.xpath("//button[contains(text(),'Create Account')]");
    public static By getLoggedInUserName = By.xpath("//a/span[2]");
    public static By countryCodeSelectIndia = By.xpath("//ul/li/span[text()='India +91']");
    public static By phoneNumberCountyCode = By.xpath("//div[@label ='Phone Number']//div[@tabindex='0']/div");
    public static By phoneNumber = By.id("phoneNumber");


    public void clickOnLoginButton() {
        driver.findElement(loginButton).click();
    }

    public void enterDataInNameField() {
        driver.findElement(nameField).sendKeys(AppSetting.getInstance().getName());
    }

    public void enterDataInEmailField() {
        driver.findElement(emailAddress).sendKeys(AppSetting.getInstance().getEmail());
    }

    public void selectCountryCode() {

        String value = "India +91";
        WebElement dropdown = driver.findElement(phoneNumberCountyCode);
        dropdown.click(); // assuming you have to click the "dropdown" to open it
        dropdown.findElement(countryCodeSelectIndia).click();

//        driver.findElement(phoneNumberCountyCode).click();
//        List<WebElement> options = dropdown.findElements(By.tagName("li"));
//        for (WebElement option : options)
//        {
//            if (option.getText().equals(searchText))
//            {
//                option.click(); // click the desired option
//                break;
//            }
//        }
//        driver.findElement(countryCodeSelectIndia).click();
    }

    public void enterDataInPhoneNumberField() {
        driver.findElement(phoneNumber).sendKeys(AppSetting.getInstance().getPhoneNumber());
    }

    public void enterDataInPasswordField() {
        driver.findElement(password).sendKeys(AppSetting.getInstance().getPassword());
    }

    public void navigateToUrl() {
        driver.get(AppSetting.getInstance().getBaseUrl());
        driver.manage().timeouts().getPageLoadTimeout();

    }

    public void clickOnCreateAccountTab() {
        driver.findElement(createAccountTab).click();
    }

    public void clickOnCreateAccountButton() {
        driver.findElement(createAccountBTN).click();
    }

    public String getLoggedUserName() {
        return driver.findElement(getLoggedInUserName).getText();
    }
}
