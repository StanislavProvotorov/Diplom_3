package page.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage {
    WebDriver driver;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    // Url страницы регистрации
    private String UrlRegister = "https://stellarburgers.education-services.ru/register";

    //Поле ввода "Имя"
    private By nameRegisterLocator = By.cssSelector("body > div:nth-child(2) > div:nth-child(1) > main:nth-child(2) > div:nth-child(1) > form:nth-child(2) > fieldset:nth-child(1) > div:nth-child(1) > div:nth-child(1) > input:nth-child(2)");

    //Поле ввода "Email"
    private By emailRegisterLocator = By.cssSelector("body > div:nth-child(2) > div:nth-child(1) > main:nth-child(2) > div:nth-child(1) > form:nth-child(2) > fieldset:nth-child(2) > div:nth-child(1) > div:nth-child(1) > input:nth-child(2)");

    //Поле ввода "Пароль"
    private By passwordRegisterLocator = By.xpath("(//input[@name='Пароль'])[1]");

    //Кнопка "Зарегистрироваться"
    private By buttonRegisterLocator = By.xpath("//button[contains(text(),'Зарегистрироваться')]");

    //Кнопка "Войти"
    private By buttonEnterPageRegisterLocator = By.xpath("(//a[contains(text(),'Войти')])[1]");

    private By textEroorPassword = By.xpath("(//p[@class='input__error text_type_main-default'])[1]");

    //Открываем страницу "Регистрация"
    public void openPageRegister() {
        driver.get(UrlRegister);
    }

    //Вводим "Имя"
    public void inputNameRegister(String name) {
        driver.findElement(nameRegisterLocator).sendKeys(name);
    }

    //Вводим "Email"
    public void inputEmailRegister(String email) {
        driver.findElement(emailRegisterLocator).sendKeys(email);
    }

    //Вводим "Пароль"
    public void inputPasswordRegister(String password) {
        driver.findElement(passwordRegisterLocator).sendKeys(password);
    }

    //Клик на кнопку "Зарегистрироваться"
    public void clickButtonRegister() {
        driver.findElement(buttonRegisterLocator).click();
    }

    //Клик на кнопку "Войти"
    public void clickButtonEnterPageRegister() {
        driver.findElement(buttonEnterPageRegisterLocator).click();
    }

    //Отображение ошибки некорректный пароль
    public String visibilityErrorPassword() {
        return driver.findElement(textEroorPassword).getText();
    }

    //Регистрация в приложении
    public void registrationApp(String name, String email, String password) {
        openPageRegister();
        inputNameRegister(name);
        inputEmailRegister(email);
        inputPasswordRegister(password);
        clickButtonRegister();
    }
}