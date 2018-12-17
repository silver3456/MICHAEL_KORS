package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.DashboardPage;
import pages.LoginPage;

import java.util.concurrent.TimeUnit;

public class LoginPageTest {

    WebDriver driver;

    @Test
    public void loginTestPOM() throws InterruptedException {

        //1.Initialize driver

        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-fullscreen");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://www.michaelkors.com/");

//        WebDriverWait wait = new WebDriverWait(driver, 20);
//        wait.until(ExpectedConditions.visibilityOfElementLocated((By) driver.findElement(By.xpath("//a[@title = 'Sign In']"))));


        //2.Enter login information (Login page)

        LoginPage loginPage = new LoginPage(driver);


        Thread.sleep(10000);

        // loginPage.closePopUpWindow();
        loginPage.navigateToLoginForm();
        loginPage.withUsername("seroff.alexander@gmail.com");
        loginPage.withPassword("Silver@3456");
        loginPage.clickSignIn();

        //3.Get Confirmation (Dashboard page)
        DashboardPage dashboardPage = new DashboardPage(driver);
        Thread.sleep(5000);

        //4.Assertions
        String conf = dashboardPage.getLoginConfirmation();
        Assert.assertEquals("Hello, Alex", conf);

        //5.Close the driver
        loginPage.tearDown();
    }
}
