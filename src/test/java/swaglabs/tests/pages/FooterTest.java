package swaglabs.tests.pages;

import listener.TestListener;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import swaglabs.constants.Credentials;
import swaglabs.facades.FooterFacade;

import static swaglabs.constants.PageUrl.*;

@Listeners(TestListener.class)
public class FooterTest extends BaseTest {
    FooterFacade footerFacade;

    @BeforeClass
    public void loginToAccessPageWithFooter() {
        loginAsStandardUser();
        this.footerFacade = new FooterFacade(driver);
    }

    @Test
    public void givenTwitterIcon_WhenClicked_ThenUserIsRedirectedToSauceLabsTwitterPage() {
        footerFacade
                .openSauceLabsTwitterPage()
                .verifyRedirectTo(TWITTER_PAGE);
    }

    @Test
    public void givenFacebookIcon_WhenClicked_ThenUserIsRedirectedToSauceLabsFacebookPage() {
        footerFacade
                .openSauceLabsFacebookPage()
                .verifyRedirectTo(FACEBOOK_PAGE);
    }

    @Test
    public void givenLinkedInIcon_WhenClicked_ThenUserIsRedirectedToSauceLabsLinkedInPage() {
        footerFacade
                .openSauceLabsLinkedInPage()
                .verifyRedirectTo(LINKEDIN_PAGE);
    }

    @Test
    public void givenCopyrightInfo_WhenPageWithHeaderIsLoaded_ThenCopyrightInfoIsVisible(){
        footerFacade.verifyCopyrightInfoVisible();
    }
}
