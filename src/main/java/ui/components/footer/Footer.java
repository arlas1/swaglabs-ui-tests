package ui.components.footer;

import org.openqa.selenium.WebDriver;
import ui.components.BaseComponent;

public class Footer extends BaseComponent {
    public FooterElements elements;

    public Footer(WebDriver driver) {
        super(driver);
        this.elements = new FooterElements(driver);
    }

    public void openSauceLabsTwitterPage(){
        scrollToElement(elements.twitterIcon, "twitter icon");
        click(elements.twitterIcon, "twitter icon");
        switchToNewTab("saucelabs twitter page");
    }

    public void openSauceLabsFacebookPage(){
        scrollToElement(elements.facebookIcon, "facebook icon");
        click(elements.facebookIcon, "facebook icon");
        switchToNewTab("saucelabs facebook page");
    }

    public void openSauceLabsLinkedInPage(){
        scrollToElement(elements.linkedinIcon, "linkedin icon");
        click(elements.linkedinIcon, "linkedin icon");
        switchToNewTab("saucelabs linkedin page");
    }

    public boolean isCopyrightInfoVisible(){
        return explicitWaitForVisibility(elements.copyrightInfo, "copyright info");
    }
}
