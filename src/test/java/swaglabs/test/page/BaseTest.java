package swaglabs.test.page;

import config.Config;
import factory.BrowserFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import ui.page.loginPage.LoginPage;

public abstract class BaseTest {
    public WebDriver driver;
    protected LoginPage loginPage;

    @BeforeClass
    public void setUp() {
        this.driver = BrowserFactory.valueOf(Config.browser).getDriver();
        this.loginPage = new LoginPage(driver);
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
