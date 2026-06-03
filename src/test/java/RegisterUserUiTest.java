import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;

import static data.UserData.*;
import static steps.UserSteps.*;

public class RegisterUserUiTest extends BaseUiTest {
    @Test
    @DisplayName("Успешная регистрация пользователя")
    @Description("Успешная регистрация пользователя через UI")
    public void testRegister() {
        register.registrationApp(NAME, EMAIL, PASSWORD);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("Sleep interrupted", e);
        }
        boolean actual = loginSystemUser(userLogin)
                .then()
                .log().all()
                .extract()
                .path("success");

        Assert.assertTrue("Пользователь не зарегистрирован", actual);
    }

    @Test
    @DisplayName("Ошибка при регистрация пользователя c паролем в 5 символов")
    @Description("Ошибка Некорректный пароль")
    public void testRegisterIncorrectPassword() {
        register.registrationApp(NAME, EMAIL, "54678");

        Assert.assertEquals("Текст ошибки должен быть - Некорректный пароль", "Некорректный пароль", register.visibilityErrorPassword());
    }
}