import factory.Browser;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import page_object.BaseTest;
import page_object.LoginPage;
import page_object.MainPage;
import page_object.RegisterPage;

import static page_object.MainPage.*;

@RunWith(Parameterized.class)
public class RegisterTest extends BaseTest {

    private final By accountButton;
    private final String name;
    private final String email;
    private final String password;
    private final String expectedStatus;


    public RegisterTest(Browser browser, By accountButton, String name, String email, String password, String expectedStatus) {
        super(browser);
        this.accountButton = accountButton;
        this.name = name;
        this.email = email;
        this.password = password;
        this.expectedStatus = expectedStatus;
    }

    @Parameterized.Parameters(name = "Browser={0}, User={2}")
    public static Object[][] data() {
        return new Object[][] {
                { Browser.Chrome, enterInAccountButton, "Username1", RandomStringUtils.randomAlphabetic(15)+"@yandex.ru", "password", "success" },
                { Browser.Chrome, personalAccountButton, "Username2", RandomStringUtils.randomAlphabetic(15)+"@yandex.ru", "password", "success" },
                { Browser.Chrome, enterInAccountButton, "Username3", RandomStringUtils.randomAlphabetic(15)+"@yandex.ru", "passw", "error" },
                { Browser.Chrome, personalAccountButton, "Username4", RandomStringUtils.randomAlphabetic(15)+"@yandex.ru", "passw", "error" },
                { Browser.Yandex, enterInAccountButton, "Username1", RandomStringUtils.randomAlphabetic(15)+"@yandex.ru", "password", "success" },
                { Browser.Yandex, personalAccountButton, "Username2", RandomStringUtils.randomAlphabetic(15)+"@yandex.ru", "password", "success" },
                { Browser.Yandex, enterInAccountButton, "Username3", RandomStringUtils.randomAlphabetic(15)+"@yandex.ru", "passw", "error" },
                { Browser.Yandex, personalAccountButton, "Username4", RandomStringUtils.randomAlphabetic(15)+"@yandex.ru", "passw", "error" },
        };
    }

    @Test
    @DisplayName("Checking registration")
    @Description("Register using the Sign in account or Personal account button")
    @Step("Status register - {this.expectedStatus}")
    public void checkRegistration() {
        MainPage objMainPage = new MainPage(getDriver());
        objMainPage.clickButton(accountButton);

        LoginPage objLoginPage = new LoginPage(getDriver());
        objLoginPage.clickRegister();

        RegisterPage objRegisterPage = new RegisterPage(getDriver());
        objRegisterPage.checkFillRegisterForm(name, email, password);

        if (expectedStatus.equals("success")) {
            objLoginPage.checkOpenEnterWindow();
            Assert.assertTrue(objLoginPage.checkSuccessDisplay());
        }
        else {
            Assert.assertTrue(objLoginPage.checkErrorDisplay());
        }

    }

}
