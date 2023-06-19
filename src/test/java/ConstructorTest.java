import factory.Browser;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import page_object.BaseTest;
import page_object.MainPage;


public class ConstructorTest extends BaseTest {
    public ConstructorTest(Browser browser) {
        super(browser);
    }

    @Test
    @DisplayName("Checking transitions to the Bun section")
    @Description("Transitions to the Bun section")
    public void checkBunsSection() {
        MainPage objMainPage = new MainPage(getDriver());

        Assert.assertTrue(objMainPage.checkSelectBun());
    }

    @Test
    @DisplayName("Checking transitions to the Souce section")
    @Description("Transitions to the Sauce section")
    public void checkSauceSection() {
        MainPage objMainPage = new MainPage(getDriver());

        Assert.assertTrue(objMainPage.checkSelectSauce());
    }

    @Test
    @DisplayName("Checking transitions to the Ingredient section")
    @Description("Transitions to the Ingredient section")
    public void checkIngredientSection() {
        MainPage objMainPage = new MainPage(getDriver());

        Assert.assertTrue(objMainPage.checkSelectIngredient());
    }
}
