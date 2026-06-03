import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;

public class ConstructorMainTest extends BaseUiTest {
    @Test
    @DisplayName("Переход на вкладку \"Булки\"")
    public void testVisibilityBunConstructor() {
        main.openMainPage();
        main.goToppingTub();
        main.goBunTub();

        boolean actual = main.isBunTubActivity();

        Assert.assertTrue("Вкладка булки не активна", actual);
    }

    @Test
    @DisplayName("Переход на вкладку \"Соусы\"")
    public void testVisibilitySauceConstructor() {
        main.openMainPage();
        main.goToppingTub();
        main.goSauceTub();

        boolean actual = main.isSauceTubActivity();

        Assert.assertTrue("Вкладка соусы не активна", actual);
    }

    @Test
    @DisplayName("Переход на вкладку \"Начинки\"")
    public void testVisibilityToppingConstructor() {
        main.openMainPage();
        main.goToppingTub();

        boolean actual = main.isToppingTubActivity();

        Assert.assertTrue("Вкладка начинки не активна", actual);
    }
}