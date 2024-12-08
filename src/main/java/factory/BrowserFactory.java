package factory;

import config.Config;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.time.Duration;

public enum BrowserFactory {

    CHROME {
        @Override
        public WebDriver getDriver() {
            WebDriverManager.chromedriver().setup();

            WebDriver driver = new ChromeDriver(getOptions());
            driver.manage().window().maximize();
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Config.pageLoadTimeout));
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Config.implicitWaitTime));

            driver.get(Config.baseUrl);

            return driver;
        }

        private ChromeOptions getOptions() {
            ChromeOptions options = new ChromeOptions();
            options.setAcceptInsecureCerts(true);

            if (Boolean.TRUE.equals(Config.headless)) {
                options.addArguments("--headless=new");
            }

            return options;
        }
    },

    FIREFOX {
        @Override
        public WebDriver getDriver() {
            WebDriverManager.firefoxdriver().setup();

            WebDriver driver = new FirefoxDriver(getOptions());
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Config.pageLoadTimeout));
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Config.implicitWaitTime));
            driver.manage().window().maximize();
            driver.get(Config.baseUrl);

            return driver;
        }

        private FirefoxOptions getOptions() {
            FirefoxOptions options = new FirefoxOptions();
            options.setAcceptInsecureCerts(true);

            if (Boolean.TRUE.equals(Config.headless)) {
                options.addArguments("--headless=new");
            }

            return options;
        }
    };

    public abstract WebDriver getDriver();
}

