package page;

import common.AppSetting;
import common.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver Driver) {
        super(Driver);
    }


    public static By emailAddress =By.id("email");
    public static By password = By.id("password");
    public static By loginBTN =By.xpath("//button[contains(text(),'Login')]");
    public static By loginTab =By.xpath("//li[contains(text(),'Login')]");
    public static By getLoggedInUserName = By.xpath("//a/span[2]");


    public void clickLoginTab() {
        driver.findElement(loginTab).click();
    }

    public void enterDataInEmailField() {
        driver.findElement(emailAddress).sendKeys(AppSetting.getInstance().getEmail());
    }

    public void enterDataInPasswordField() {
        driver.findElement(password).sendKeys(AppSetting.getInstance().getPassword());
    }

    public void clickLoginButton() {
        driver.findElement(loginBTN).click();
    }


    public String getLoggedUserName() {
        return driver.findElement(getLoggedInUserName).getText();
    }


}
