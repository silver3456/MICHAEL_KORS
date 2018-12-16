package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage {

    WebDriver driver;

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getLoginConfirmation() {
        return driver.findElement(By.xpath(".//*[contains(@title, 'Hello, ')]")).getText();
    }
}
