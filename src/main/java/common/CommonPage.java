package common;

import org.openqa.selenium.WebDriver;

public class CommonPage  {
    protected  static ThreadLocal<WebDriver> webDriver= new ThreadLocal<>();
//public CommonPage(){
//    super((WebDriver) webDriver.get());
//}
}
