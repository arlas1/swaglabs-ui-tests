package swaglabs.tests.pages;

import listener.TestListener;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import swaglabs.facades.HeaderFacade;
import swaglabs.tests.setup.SetUp;

import static swaglabs.constants.PageUrl.*;

@Listeners(TestListener.class)
public class HeaderTest extends BaseTest  {
    private HeaderFacade headerFacade;

    @BeforeClass
    public void loginToAccessPageWithHeader() {
        SetUp setUp = new SetUp(driver);
        setUp.loginAsStandardUser();
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
                .verifyRedirectTo(CART_PAGE);
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
                .verifyRedirectTo(INVENTORY_PAGE);
    }

    @Test
    public void givenAboutButtonInMenu_WhenClicked_ThenUserIsRedirectedToSauceLabsPage() {
        headerFacade
                .openMenu()
                .openAboutPage()
                .verifyRedirectTo(SAUCELABS_PAGE);
    }

    @Test
    public void givenLogoutButtonInMenu_WhenClicked_ThenUserIsRedirectedToLoginPage() {
        headerFacade
                .openMenu()
                .logout()
                .verifyRedirectTo(LOGIN_PAGE);

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
