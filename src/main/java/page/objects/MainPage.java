package page.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {
    WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    // Url главной страницы
    private String urlMain = "https://stellarburgers.education-services.ru";

    // Кнопка "Личный кабинет"
    private By buttonPersonalAccount = By.xpath("//p[contains(text(),'Личный Кабинет')]");

    // Кнопка "Войти в аккаунт"
    private By buttonEnterAccaunt = By.xpath("//button[contains(text(),'Войти в аккаунт')]");

    // Вкладка "Булки" не выбран
    private By bunTubNotSelect = By.cssSelector("body > div:nth-child(2) > div:nth-child(1) > main:nth-child(2) > section:nth-child(1) > div:nth-child(2) > div:nth-child(1)");

    // Вкладка "Соусы" не выбран
    private By sauceTubNotSelect = By.cssSelector("body > div:nth-child(2) > div:nth-child(1) > main:nth-child(2) > section:nth-child(1) > div:nth-child(2) > div:nth-child(2)");

    // Вкладка "Начинки" не выбран
    private By toppingTabNotSelect = By.cssSelector("body > div:nth-child(2) > div:nth-child(1) > main:nth-child(2) > section:nth-child(1) > div:nth-child(2) > div:nth-child(3)");

    private By tabYesSelect = By.xpath("//div[@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']");

    public boolean isBunTubActivity() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(tabYesSelect));
        String className = element.getAttribute("class");
        if (className.contains("tab_tab_type_current__2BEPc")) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isSauceTubActivity() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(tabYesSelect));
        String className = element.getAttribute("class");
        if (className.contains("tab_tab_type_current__2BEPc")) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isToppingTubActivity() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(tabYesSelect));
        String className = element.getAttribute("class");
        if (className.contains("tab_tab_type_current__2BEPc")) {
            return true;
        } else {
            return false;
        }
    }

    // Переход на вкладку "Булки"
    public void goBunTub() {
        driver.findElement(bunTubNotSelect).click();
    }

    // Переход на вкладку "Соусы"
    public void goSauceTub() {
        driver.findElement(sauceTubNotSelect).click();
    }

    // Переход на вкладку "Начинки"
    public void goToppingTub() {
        driver.findElement(toppingTabNotSelect).click();
    }


    //Открыть главную страницу
    public void openMainPage() {
        driver.get(urlMain);
    }

    // Клик по кнопке "Личный Кабинет"
    public void clickButtonPersonalAccount() {
        driver.findElement(buttonPersonalAccount).click();
    }

    // Клик по кнопке "Войти в аккаунт"
    public void clickButtonEnterAccount() {
        driver.findElement(buttonEnterAccaunt).click();
    }
}