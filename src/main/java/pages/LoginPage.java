package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;


    //Constructor initializes the state of a driver
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateToLoginForm() {
        driver.findElement(By.xpath("//a[@title = 'Sign In']")).click();
    }

    public void withUsername(String username) {
        driver.findElement(By.xpath("//input[@type = 'email']")).clear();
        driver.findElement(By.xpath("//input[@type = 'email']")).sendKeys(username);

    }

    public void withPassword(String password) {
        driver.findElement(By.xpath("//input[@type = 'password']")).sendKeys(password);

    }

    public void clickSignIn() {
        driver.findElement(By.xpath("//span[text() = 'Remember me']/following::button[@type = 'submit']")).click();
    }

//    public void closePopUpWindow(){
//        driver.findElement(By.xpath("//*[@id=\"en_US\"]")).click();
//    }


    public void tearDown() {
        driver.quit();
    }

}
