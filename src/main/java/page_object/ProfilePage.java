package page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePage {
    // Профиль
    private static final By accountProfile = By.xpath(".//a[@href='/account/profile' and text()='Профиль']");;

    //Выход
    private static final By buttonExit = By.xpath(".//button[text()='Выход']");;

    // кнопка Конструктор
    public static By buttonСonstructor = By.xpath(".//a[@href='/']");


    private WebDriver driver;

    public ProfilePage(WebDriver driver) {
        this.driver = driver;
    }

    public void waitPresentOfElement(By locator) {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public void clickButton(By button) {
        driver.findElement(button).click();
    }

    public boolean checkAccountProfileDisplay() {
        waitPresentOfElement(accountProfile);
        return driver.findElement(accountProfile).isDisplayed();
    }

    public void checkAccountProfile() {
        waitPresentOfElement(accountProfile);
        clickButton(buttonСonstructor);
    }

    public void checkExit() {
        waitPresentOfElement(accountProfile);
        clickButton(buttonExit);
    }
}
