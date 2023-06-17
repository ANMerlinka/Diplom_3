package page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {
    protected static final String PAGE_URL = "https://stellarburgers.nomoreparties.site/";

    // кнопка Войти в аккаунт
    public static By enterInAccountButton = By.xpath(".//button[text()='Войти в аккаунт']");

    // кнопка Личный кабинет
    public static By personalAccountButton = By.xpath(".//p[text()='Личный Кабинет']");

    // кнопка Оформить заказ
    public static By createOrderButton = By.xpath(".//button[text()='Оформить заказ']");

    // раздел Булки
    public static By buttonBun = By.xpath(".//span[text()='Булки']");
    // раздел Соусы
    public static By buttonSouce = By.xpath(".//span[text()='Соусы']");
    // раздел Начинки
    public static By buttonIngredient = By.xpath(".//span[text()='Начинки']");

    // Верх бергера
    public static By constructorView = By.xpath(".//div[@class='constructor-element constructor-element_pos_top']");


    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickButton(By button) {
        driver.findElement(button).click();
    }

    //ожидание появления элементов
    public void waitClickable(By locator) {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(locator));
    }
    public void waitPresentOfElement(By locator) {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public boolean checkButtonCreateOrderDisplay() {
        waitPresentOfElement(createOrderButton);
        return driver.findElement(createOrderButton).isDisplayed();
    }

    public boolean checkConstructorViewDisplay() {
        waitPresentOfElement(constructorView);
        return driver.findElement(constructorView).isDisplayed();
    }
    public String getClassBun() {
        return driver.findElement(buttonBun).getAttribute("class");
    }

    public String getClassSouce() {
        return driver.findElement(buttonSouce).getAttribute("class");
    }

    public String getClassIngredient() {
        return driver.findElement(buttonIngredient).getAttribute("class");
    }

    public void checkSelectBun() {
        clickButton(buttonBun);
    }

    public void checkSelectSouce() {
        clickButton(buttonSouce);
    }

    public void checkSelectIngredient() {
        clickButton(buttonIngredient);
    }

}
