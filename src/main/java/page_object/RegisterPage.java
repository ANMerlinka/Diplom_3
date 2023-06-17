package page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterPage {
    private final WebDriver driver;

    private static final By headerFormRegister = By.xpath(".//h2[text()='Регистрация']");

    private static final By nameField = By.xpath("//label[text()='Имя']//following-sibling::input");
    private static final By emailField = By.xpath("//label[text()='Email']//following-sibling::input");
    private static final By passwordField = By.xpath("//label[text()='Пароль']//following-sibling::input");

    private static final By buttonRegister = By.xpath("//button[text()='Зарегистрироваться']");


    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    public void waitPresentOfElement(By locator) {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public void clickButton(By locator) {
        driver.findElement(locator).click();
    }

    public void setField(By locator, String value) {
        driver.findElement(locator).sendKeys(value);
    }


    public void checkFillRegisterForm(String name, String email, String password) {
        waitPresentOfElement(headerFormRegister);
        // Name
        clickButton(nameField);
        setField(nameField, name);
        // email
        clickButton(emailField);
        setField(emailField, email);
        // password
        clickButton(passwordField);
        setField(passwordField, password);
        // Зарегистрироваться
        clickButton(buttonRegister);
    }
}
