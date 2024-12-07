package swaglabs.tests.pages;

import config.Config;
import factory.BrowserFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import swaglabs.facades.*;

public abstract class BaseTest {
    protected WebDriver driver;
    protected LoginFacade loginPageFacade;

    @BeforeClass
    protected void setUp() {
        this.driver = BrowserFactory.valueOf(Config.browser).getDriver();
        this.loginPageFacade = new LoginFacade(driver);
    }

    @AfterClass
    protected void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}
