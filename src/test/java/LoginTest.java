import factory.Browser;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import page_object.*;

import static page_object.MainPage.enterInAccountButton;
import static page_object.MainPage.personalAccountButton;

public class LoginTest extends BaseTest {
    private final By accountButton;

    public LoginTest(Browser browser, By accountButton) {
        super(browser);
        this.accountButton = accountButton;
    }

    @Parameterized.Parameters(name = "Browser={0}")
    public static Object[][] data() {
        return new Object[][] {
                { Browser.Chrome, enterInAccountButton },
                { Browser.Chrome, personalAccountButton },
                { Browser.Yandex, enterInAccountButton },
                { Browser.Yandex, personalAccountButton },
        };
    }

    @Test
    @DisplayName("Checking login")
    @Description("Login using the button")
    public void checkLoginFromPersonAccountButton() {
        MainPage objMainPage = new MainPage(getDriver());
        objMainPage.clickButton(accountButton);

        LoginPage objLoginPage = new LoginPage(getDriver());
        objLoginPage.checkOpenEnterWindow();
        objLoginPage.checkLoginForm("test-data@yandex.ru", "password");

        Assert.assertTrue(objMainPage.checkButtonCreateOrderDisplay());
    }

    @Test
    @DisplayName("Checking login through Register account")
    @Description("Registration and then login")
    public void checkLoginThroughRegister() {
        String userName = "Username1";
        String password = "password";
        String emailRandom = RandomStringUtils.randomAlphabetic(15)+"@yandex.ru";

        MainPage objMainPage = new MainPage(getDriver());
        objMainPage.clickButton(accountButton);

        LoginPage objLoginPage = new LoginPage(getDriver());
        objLoginPage.clickRegister();

        RegisterPage objRegisterPage = new RegisterPage(getDriver());
        objRegisterPage.checkFillRegisterForm(userName, emailRandom, password);

        objLoginPage.checkOpenEnterWindow();
        objLoginPage.checkSuccessDisplay();

        objLoginPage.checkLoginForm(emailRandom, password);

        Assert.assertTrue(objMainPage.checkButtonCreateOrderDisplay());
    }

    @Test
    @DisplayName("Checking login through Password Recover")
    @Description("Login using the Personal account button")
    public void checkLoginFromPasswordRecover() {
        MainPage objMainPage = new MainPage(getDriver());
        objMainPage.clickButton(accountButton);

        LoginPage objLoginPage = new LoginPage(getDriver());
        objLoginPage.clickHrefForgotPassword();

        PasswordRecoveryPage objPasswordRecover = new PasswordRecoveryPage(getDriver());
        objPasswordRecover.checkEnterInPasswordRecoverForm();

        objLoginPage.checkOpenEnterWindow();
        objLoginPage.checkLoginForm("test-data@yandex.ru", "password");

        Assert.assertTrue(objMainPage.checkButtonCreateOrderDisplay());

    }
}
