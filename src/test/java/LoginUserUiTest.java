import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;

import static data.UserData.*;
import static steps.UserSteps.createUser;

public class LoginUserUiTest extends BaseUiTest {

    @Test
    @DisplayName("Вход через кнопку \"Войти в аккаунт\" на главной странице")
    public void testUiLoginUserEnterAccountMainPage() {
        createUser(user);

        main.openMainPage();
        main.clickButtonEnterAccount();
        login.loginApp(EMAIL, PASSWORD);
        main.clickButtonPersonalAccount();

        Assert.assertTrue("Вход в аккаунт через кнопку \"Войти в аккаунт\" не выполнен",
                personalAccount.visibilityButtonProfile());
    }

    @Test
    @DisplayName("Вход через кнопку \"Личный кабинет\" на главной странице")
    public void testUiLoginUserPersonalAccountMainPage() {
        createUser(user);

        main.openMainPage();
        main.clickButtonPersonalAccount();
        login.loginApp(EMAIL, PASSWORD);
        main.clickButtonPersonalAccount();

        Assert.assertTrue("Вход в аккаунт через кнопку \"Личный кабинет\" не выполнен", personalAccount.visibilityButtonProfile());
    }

    @Test
    @DisplayName("Вход через кнопку \"Войти\" в форме регистрации")
    public void testUiLoginUserRegistrationPage() {
        createUser(user);

        register.openPageRegister();
        register.clickButtonEnterPageRegister();
        login.loginApp(EMAIL, PASSWORD);
        main.clickButtonPersonalAccount();

        Assert.assertTrue("Вход в аккаунт через кнопку \"Войти\" в форме регистрации не выполнен",
                personalAccount.visibilityButtonProfile());
    }

    @Test
    @DisplayName("Вход через кнопку \"Войти\" в форме Восстановление пароля")
    public void testUiLoginUserPasswordRecoveryPage() {
        createUser(user);

        recovery.openPasswordRecovery();
        recovery.clickButtonEnterRecoveryPage();
        login.loginApp(EMAIL, PASSWORD);
        main.clickButtonPersonalAccount();

        Assert.assertTrue("Вход в аккаунт через кнопку \"Войти\" в форме регистрации не выполнен",
                personalAccount.visibilityButtonProfile());
    }
}