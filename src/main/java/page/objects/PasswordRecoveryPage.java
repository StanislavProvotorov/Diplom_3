package page.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PasswordRecoveryPage {
    WebDriver driver;

    public PasswordRecoveryPage(WebDriver driver) {
        this.driver = driver;
    }

    // Url страницы "Восстановление пароля"
    private String urlRecovery = "https://stellarburgers.education-services.ru/forgot-password";

    // Кнопка "Войти"
    private By buttonEnterRecoveryPage = By.xpath("//a[contains(text(),'Войти')]");

    // Открыть страницу "Восстановление пароля"
    public void openPasswordRecovery() {
        driver.get(urlRecovery);
    }

    // Клик по кнопке войти
    public void clickButtonEnterRecoveryPage() {
        driver.findElement(buttonEnterRecoveryPage).click();
    }
}