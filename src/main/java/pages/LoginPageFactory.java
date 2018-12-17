package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageFactory {

    //Define Web elements at class level

    private WebDriver driver;

    @FindBy(xpath = "//input[@type = 'email']")
    WebElement usernameBox;

    @FindBy(xpath = "//input[@type = 'password']")
    WebElement passwordBox;

    @FindBy(xpath = "//span[text() = 'Remember me']/following::button[@type = 'submit']")
    WebElement signInButton;

    @FindBy(xpath = "//a[@title = 'Sign In']")
    WebElement signInLink;

    //Steps
    public void withUsername(String username) {
        usernameBox.clear();
        usernameBox.sendKeys(username);
    }

    public void withPassword(String password) {
        passwordBox.sendKeys(password);

    }

    public void clickSignIn() {
        signInButton.click();
    }

    //Actions

    public void login(String username, String password) {
        withUsername(username);
        withPassword(password);
        clickSignIn();
    }

    public void navigateToLoginForm() {
        driver.findElement(By.xpath("//a[@title = 'Sign In']")).click();
    }

    public void tearDown() {
        driver.quit();
    }

    //Constructor initializes the state of a driver
    public LoginPageFactory(WebDriver driver) {
        this.driver = driver;

        //Initialize web elements
        PageFactory.initElements(driver, this);
    }
}

//    Close VIP offer window when we go on main page
//    public void closePopUpWindow(){
//        driver.findElement(By.xpath("//*[@id=\"en_US\"]")).click();
//    }


//    Click Sign in link on main page
//    public void navigateToLoginForm() {
//        driver.findElement(By.xpath("//a[@title = 'Sign In']")).click();
//    }



