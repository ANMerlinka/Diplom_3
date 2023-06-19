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

public class TransferToPersonalAccountTest extends BaseTest {

    public TransferToPersonalAccountTest(Browser browser) {
        super(browser);
    }

    @Test
    @DisplayName("Checking transfer to your personal account")
    @Description("Transfer to your personal account")
    public void checkTransferToPersonalAccount() {
        MainPage objMainPage = new MainPage(getDriver());
        objMainPage.clickButton(personalAccountButton);

        LoginPage objLoginPage = new LoginPage(getDriver());
        objLoginPage.checkOpenEnterWindow();
        objLoginPage.checkLoginForm("test-data@yandex.ru", "password");
        objMainPage.checkButtonCreateOrderDisplay();

        objMainPage.clickButton(personalAccountButton);

        ProfilePage objProfilePage = new ProfilePage(getDriver());

        Assert.assertTrue(objProfilePage.checkAccountProfileDisplay());

    }
}
