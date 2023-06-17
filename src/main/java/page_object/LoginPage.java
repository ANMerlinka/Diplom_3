package page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    private final WebDriver driver;

    //заголовок Вход
    private static final By headerFormEnter = By.xpath(".//div[@class='Auth_login__3hAey']/h2[text()='Вход']");

    // поля формы Email & password
    private static final By emailField = By.xpath(".//fieldset[1]/div/div/input");
    private static final By passwordField = By.xpath(".//fieldset[2]/div/div/input");

    // гиперссылка на Зарегистрироваться
    private static final By hrefRegister = By.xpath(".//a[@href='/register' and text()='Зарегистрироваться']");;

    // кнопка Войти
    private static final By enterButton = By.xpath(".//button[text()='Войти']");

    // гиперссылка на Восстановить пароль
    private static final By hrefForgotPassword = By.xpath(".//a[@href='/forgot-password' and text()='Восстановить пароль']");;

    private static final By textErrorIncorrectPWD = By.xpath(".//p[@class='input__error text_type_main-default' and text()='Некорректный пароль']");;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void waitPresentOfElement(By locator) {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(locator));
    }
    public void waitClickable(By locator) {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void clickButton(By button) {
        driver.findElement(button).click();
    }

    public void checkOpenEnterWindow(){
        waitPresentOfElement(headerFormEnter);
        waitClickable(enterButton);
    }

    public void clickRegister(){
        waitPresentOfElement(headerFormEnter);
        waitClickable(hrefRegister);
        clickButton(hrefRegister);
    }

    public boolean checkSuccessDisplay() {
        return driver.findElement(enterButton).isDisplayed();
    }

    public boolean checkErrorDisplay() {
        return driver.findElement(textErrorIncorrectPWD).isDisplayed();
    }

    public void setField(By locator, String value) {
        driver.findElement(locator).sendKeys(value);
    }


    public void checkLoginForm(String email, String password) {
        waitPresentOfElement(headerFormEnter);
        // email
        clickButton(emailField);
        setField(emailField, email);
        // password
        clickButton(passwordField);
        setField(passwordField, password);
        //
        clickButton(enterButton);
    }

    public void clickHrefForgotPassword() {
        waitPresentOfElement(headerFormEnter);
        clickButton(hrefForgotPassword);
    }
    public boolean checkLoginDisplay() {
        waitPresentOfElement(headerFormEnter);
        return driver.findElement(headerFormEnter).isDisplayed();
    }

}
