package page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
    public static By buttonBun = By.xpath(".//section[@class = 'BurgerIngredients_ingredients__1N8v2']/div/div[1]");
    // раздел Соусы
    public static By buttonSauce = By.xpath(".//section[@class = 'BurgerIngredients_ingredients__1N8v2']/div/div[2]");
    // раздел Начинки
    public static By buttonIngredient = By.xpath(".//section[@class = 'BurgerIngredients_ingredients__1N8v2']/div/div[3]");

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

    private boolean checkIfSectionChosen(By locator) {
        WebElement section = driver.findElement(locator);
        return section.getAttribute("class").contains("tab_tab_type_current__2BEPc");
    }

    public boolean checkSelectBun() {
        clickButton(buttonSauce);
        clickButton(buttonBun);
        
        return checkIfSectionChosen(buttonBun);
    }

    public boolean checkSelectSauce() {
        clickButton(buttonSauce);

        return checkIfSectionChosen(buttonSauce);
    }

    public boolean checkSelectIngredient() {
        clickButton(buttonIngredient);

        return checkIfSectionChosen(buttonIngredient);
    }


}
