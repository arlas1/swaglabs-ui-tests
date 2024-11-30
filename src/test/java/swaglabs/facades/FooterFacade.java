package swaglabs.facades;

import org.openqa.selenium.WebDriver;
import swaglabs.constants.PageUrl;
import ui.components.footer.Footer;

import static swaglabs.utils.CustomAssert.*;

public class FooterFacade {
    private final Footer footer;

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

    public FooterFacade verifyRedirectTo(PageUrl redirectPage) {
        String currentUrl = footer.getCurrentUrl();
        assertEquals(currentUrl, redirectPage.getUrl(),
                "Verifying that user is redirected to '" + redirectPage.getUrl() + "'."
        );
        footer.closeCurrentTabAndSwitchBack();
        return this;
    }

    public FooterFacade verifyCopyrightInfoVisible() {
        footer.isCopyrightInfoVisible();
        return this;
    }
}
