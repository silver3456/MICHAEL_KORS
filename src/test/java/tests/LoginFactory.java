package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.LoginPageFactory;

import java.util.concurrent.TimeUnit;

public class LoginFactory {

    WebDriver driver;
    LoginPageFactory loginPageFactory;
    String username = "seroff.alexander@gmail.com";
    String password = "Silver@3456";

    public void loginTestPageFactory() {
        //1.Initialize driver

        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-fullscreen");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://www.michaelkors.com/");

        //2.Enter login
        loginPageFactory = new LoginPageFactory(driver);
        loginPageFactory.login(username, password);
    }
}
