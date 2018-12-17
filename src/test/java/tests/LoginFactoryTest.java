package tests;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.LoginPageFactory;


import java.util.concurrent.TimeUnit;

public class LoginFactoryTest {


    WebDriver driver;

    private LoginPageFactory loginPageFactory;
    private String username = "seroff.alexander@gmail.com";
    private String password = "Silver@3456";


    @Test
    public void loginTestPageFactory() throws InterruptedException {
        //1.Initialize driver

        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-fullscreen");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://www.michaelkors.com/");

        Thread.sleep(15000);

        //2.Enter login
        loginPageFactory = new LoginPageFactory(driver);
        loginPageFactory.navigateToLoginForm();
        loginPageFactory.login(username, password);
    }
}
