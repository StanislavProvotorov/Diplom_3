package page.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PersonalAccountPage {
    WebDriver driver;

    public PersonalAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    // Кнопка "Профиль"
    private By buttonProfile = By.xpath("//a[contains(text(),'Профиль')]");

    //Отображение кнопки "Профиль"
    public boolean visibilityButtonProfile() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(buttonProfile));
        return driver.findElement(buttonProfile).isDisplayed();
    }
}