package ui.components.footer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FooterElements {

    @FindBy(className = "social_twitter")
    protected WebElement twitterIcon;

    @FindBy(className = "social_facebook")
    protected WebElement facebookIcon;

    @FindBy(className = "social_linkedin")
    protected WebElement linkedinIcon;

    @FindBy(className = "footer_copy")
    protected WebElement copyrightInfo;

    public FooterElements(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
