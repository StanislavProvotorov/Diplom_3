package page.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // Url страницы авторизации
    private String UrlLogin = "https://stellarburgers.education-services.ru/login";

    //Поле ввода "Email"
    private By emailLoginLocator = By.xpath("//input[@name='name']");

    //Поле ввода "Пароль"
    private By passwordLoginLocator = By.xpath("//input[@name='Пароль']");

    //Кнопка "Войти"
    private By buttonEnterLoginLocator = By.xpath("(//button[contains(text(),'Войти')])[1]");

    //Кнопка "Зарегистрироваться"
    private By buttonRegisterPageLoginLocator = By.xpath("(//a[contains(text(),'Зарегистрироваться')])[1]");

    //Кнопка "Восстановить пароль"
    private By buttonRecoverPasswordLoginLocator = By.xpath("(//a[contains(text(),'Восстановить пароль')])[1]");

    //Открываем страницу "Вход"
    public void openPageLogin() {
        driver.get(UrlLogin);
    }

    //Вводим "Email"
    public void inputEmailLogin(String email) {
        driver.findElement(emailLoginLocator).sendKeys(email);
    }

    //Вводим "Пароль"
    public void inputPasswordLogin(String password) {
        driver.findElement(passwordLoginLocator).sendKeys(password);
    }

    //Клик на кнопку "Войти"
    public void clickButtonEnterPageLogin() {
        driver.findElement(buttonEnterLoginLocator).click();
    }

    //Клик на кнопку "Зарегистрироваться"
    public void clickButtonRegisterPageLogin() {
        driver.findElement(buttonRegisterPageLoginLocator).click();
    }

    //Клик на кнопку "Восстановить пароль"
    public void clickButtonRecoverPasswordPageLogin() {
        driver.findElement(buttonRecoverPasswordLoginLocator).click();
    }

    //Авторизация в приложении
    public void loginApp(String email, String password) {
        inputEmailLogin(email);
        inputPasswordLogin(password);
        clickButtonEnterPageLogin();
    }
}