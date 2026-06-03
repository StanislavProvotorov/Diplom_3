import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import model.UserModel;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import page.objects.*;

import java.time.Duration;

import static data.UserData.*;
import static steps.UserSteps.*;

public class BaseUiTest {
    WebDriver driver;
    RegisterPage register;
    LoginPage login;
    PersonalAccountPage personalAccount;
    MainPage main;
    PasswordRecoveryPage recovery;
    private Response response;
    private String token;
    protected UserModel userLogin;
    protected UserModel user;

    @Before
    public void startBrowser() {
        String browser = System.getProperty("browser", "chrome");
        if (browser.equals("chrome")) {
            startBrowserChrome();
        } else if (browser.equals("yandex")) {
            startBrowserYandex();
        }
    }

    public void startBrowserChrome() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        register = new RegisterPage(driver);
        login = new LoginPage(driver);
        main = new MainPage(driver);
        recovery = new PasswordRecoveryPage(driver);
        personalAccount = new PersonalAccountPage(driver);
        RestAssured.baseURI = BASE_URL;
        user = new UserModel(EMAIL, PASSWORD, NAME);
        userLogin = new UserModel(EMAIL, PASSWORD);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public void startBrowserYandex() {
        System.setProperty("webdriver.chrome.driver", "C:/WebDriver/bin/yandexdriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setBinary("C:/Program Files/Yandex/YandexBrowser/Application/browser.exe");

        driver = new ChromeDriver(options);
        register = new RegisterPage(driver);
        login = new LoginPage(driver);
        main = new MainPage(driver);
        recovery = new PasswordRecoveryPage(driver);
        personalAccount = new PersonalAccountPage(driver);
        RestAssured.baseURI = BASE_URL;
        user = new UserModel(EMAIL, PASSWORD, NAME);
        userLogin = new UserModel(EMAIL, PASSWORD);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @After
    public void closeBrowser() {
        try {
            response = loginSystemUser(userLogin);
            token = accessToken(response);
            if (token != null) {
                deleteUser(token);
            }
        } catch (Exception e) {
            System.out.println("Ошибка при очистке, токен: " + e.getMessage());
        }
        driver.quit();
    }
}