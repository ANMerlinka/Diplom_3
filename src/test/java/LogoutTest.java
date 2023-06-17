import factory.Browser;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import page_object.BaseTest;
import page_object.LoginPage;
import page_object.MainPage;
import page_object.ProfilePage;

import static page_object.MainPage.personalAccountButton;

public class LogoutTest extends BaseTest {

    public LogoutTest(Browser browser) {
        super(browser);
    }

    @Test
    @DisplayName("Checking logout of your account")
    @Description("Logout by clicking the Logout button in your personal account")
    public void checkLogout() {
        MainPage objMainPage = new MainPage(getDriver());
        objMainPage.clickButton(personalAccountButton);

        LoginPage objLoginPage = new LoginPage(getDriver());
        objLoginPage.checkOpenEnterWindow();
        objLoginPage.checkLoginForm("test-data@yandex.ru", "password");
        objMainPage.checkButtonCreateOrderDisplay();

        objMainPage.clickButton(personalAccountButton);

        ProfilePage objProfilePage = new ProfilePage(getDriver());
        objProfilePage.checkExit();

        Assert.assertTrue(objLoginPage.checkLoginDisplay());
    }
}
