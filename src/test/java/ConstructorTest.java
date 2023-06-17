import factory.Browser;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.hamcrest.MatcherAssert;
import org.junit.Test;
import page_object.BaseTest;
import page_object.MainPage;

import static org.hamcrest.CoreMatchers.containsString;

public class ConstructorTest extends BaseTest {
    public ConstructorTest(Browser browser) {
        super(browser);
    }

    @Test
    @DisplayName("Checking transitions to the Bun section")
    @Description("Transitions to the Bun section")
    public void checkBunsSection() {
        MainPage objMainPage = new MainPage(getDriver());
        objMainPage.checkSelectSouce();
        objMainPage.checkSelectBun();

        MatcherAssert.assertThat(objMainPage.getClassBun(), containsString("text text_type_main-default"));
    }

    @Test
    @DisplayName("Checking transitions to the Souce section")
    @Description("Transitions to the Souce section")
    public void checkSouceSection() {
        MainPage objMainPage = new MainPage(getDriver());
        objMainPage.checkSelectSouce();

        MatcherAssert.assertThat(objMainPage.getClassSouce(), containsString("text text_type_main-default"));
    }

    @Test
    @DisplayName("Checking transitions to the Ingredient section")
    @Description("Transitions to the Ingredient section")
    public void checkIngredientSection() {
        MainPage objMainPage = new MainPage(getDriver());
        objMainPage.checkSelectIngredient();

        MatcherAssert.assertThat(objMainPage.getClassIngredient(), containsString("text text_type_main-default"));
    }
}
