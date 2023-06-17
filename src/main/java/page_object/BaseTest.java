package page_object;

import factory.Browser;
import factory.DriverFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;


import static page_object.MainPage.PAGE_URL;

@RunWith(Parameterized.class)
public class BaseTest {
    private static WebDriver driver;
    private Browser browser;

    public BaseTest(Browser browser) {
        this.browser = browser;
    }

    @Parameterized.Parameters(name = "Browser - {0}")
    public static Object[][] browsersStrings(){
        return new Object[][]
                {
                        {Browser.Chrome},
                        {Browser.Yandex}
                };
    }

    @Before
    public void setUp() {
        driver = DriverFactory.WebDriver(browser);
        driver.navigate().to(PAGE_URL);
    }

    public WebDriver getDriver() {
        return driver;
    }

    @After
    public void tearDown()
    {
        driver.quit();
    }
}
