package ui.components.footer;

import actions.CustomActions;
import org.openqa.selenium.WebDriver;
import ui.components.BaseComponent;

public class Footer extends BaseComponent {
    public FooterElements elements;

    public Footer(WebDriver driver, CustomActions customActions) {
        super(driver, customActions);
        this.elements = new FooterElements(driver);
    }

    public void openSauceLabsTwitter(){
        customActions.click(elements.twitterIcon, "twitter icon");
    }

    public void openSauceLabsFacebook(){
        customActions.click(elements.facebookIcon, "facebook icon");
    }

    public void openSauceLabsLinkedIn(){
        customActions.click(elements.linkedinIcon, "linkedin icon");
    }

    public boolean isCopyrightInfoVisible(){
        return customActions.explicitWaitForVisibility(elements.copyrightInfo, "copyright info");
    }
}
