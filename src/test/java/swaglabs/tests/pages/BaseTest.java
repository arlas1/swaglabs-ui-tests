package swaglabs.tests.pages;

import config.Config;
import factory.BrowserFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import swaglabs.facades.LoginFacade;

public abstract class BaseTest {
    public WebDriver driver;
    protected LoginFacade loginPageFacade;

    @BeforeClass
    public void setUp() {
        this.driver = BrowserFactory.valueOf(Config.browser).getDriver();
        this.loginPageFacade = new LoginFacade(driver);
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
