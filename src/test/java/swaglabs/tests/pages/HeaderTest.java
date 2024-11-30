package swaglabs.tests.pages;

import listener.TestListener;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import swaglabs.facades.HeaderFacade;

import static swaglabs.constants.Credentials.Usernames;
import static swaglabs.constants.PageUrlConstants.PageUrl.*;

@Listeners(TestListener.class)
public class HeaderTest extends BaseTest  {
    HeaderFacade headerFacade;

    @BeforeClass
    public void loginToAccessPageWithHeader() {
        loginPageFacade
                .enterValidUsername(Usernames.STANDARD_USER)
                .enterValidPassword()
                .login();
        this.headerFacade = new HeaderFacade(driver);
    }

    @Test
    public void givenWebsiteTitle_WhenPageWithHeaderIsLoaded_ThenWebsiteTitleIsVisible() {
        headerFacade.verifyWebsiteTitleIsVisible();
    }

    @Test
    public void givenCartIcon_WhenClicked_ThenUserIsRedirectedToCartPage() {
        headerFacade
                .openCart()
                .verifyRedirectTo(CART_PAGE_URL);
    }

    @Test
    public void givenMenuIcon_WhenClicked_ThenMenuIsVisible() {
        headerFacade
                .openMenu()
                .verifyMenuIsVisible();
    }

    @Test
    public void givenMenuItems_WhenHoveredOver_ThenTheirTextColorChanges() {
        headerFacade
                .openMenu()
                .verifyAllItemsTextColorChangesOnHover()
                .verifyAboutTextColorChangesOnHover()
                .verifyLogoutTextColorChangesOnHover()
                .verifyResetAppStateTextColorChangesOnHover();
    }

    @Test
    public void givenAllItemsButtonInMenu_WhenClicked_ThenUserIsRedirectedToInventoryPage() {
        headerFacade
                .openMenu()
                .openAllItemsPage()
                .verifyRedirectTo(INVENTORY_PAGE_URL);
    }

    @Test
    public void givenAboutButtonInMenu_WhenClicked_ThenUserIsRedirectedToSauceLabsPage() {
        headerFacade
                .openMenu()
                .openAboutPage()
                .verifyRedirectTo(SAUCELABS_PAGE_URL);
    }

    @Test
    public void givenLogoutButtonInMenu_WhenClicked_ThenUserIsRedirectedToLoginPage() {
        headerFacade
                .openMenu()
                .logout()
                .verifyRedirectTo(LOGIN_PAGE_URL);

        loginToAccessPageWithHeader();
    }

    @Test
    public void givenMenu_WhenClickedMenuCloseButton_ThenMenuIsNotVisibleForUser() {
        headerFacade
                .openMenu()
                .closeMenu()
                .verifyMenuIsNotVisible();
    }
}
