package swaglabs.facades;

import org.openqa.selenium.WebDriver;
import ui.components.footer.Footer;

import static swaglabs.utils.CustomAssert.*;

public class FooterFacade {
    private Footer footer;

    public FooterFacade(WebDriver driver) {
        this.footer = new Footer(driver);
    }

    public FooterFacade openSauceLabsTwitterPage() {
        footer.openSauceLabsTwitterPage();
        return this;
    }

    public FooterFacade openSauceLabsFacebookPage() {
        footer.openSauceLabsFacebookPage();
        return this;
    }
    public FooterFacade openSauceLabsLinkedInPage() {
        footer.openSauceLabsLinkedInPage();
        return this;
    }

    public FooterFacade verifyRedirectTo(String redirectUrl) {
        String currentUrl = footer.getCurrentUrlWithoutParameters();
        assertEquals(currentUrl, redirectUrl,
                "Verifying that user is redirected to '" + redirectUrl + "'."
        );
        footer.closeCurrentTabAndSwitchBack();
        return this;
    }

    public FooterFacade verifyCopyrightInfoVisible() {
        footer.isCopyrightInfoVisible();
        return this;
    }
}
