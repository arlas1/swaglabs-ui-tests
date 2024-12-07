package swaglabs.tests.pages;

import listener.TestListener;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import swaglabs.facades.CartFacade;
import swaglabs.tests.setup.SetUp;

import static swaglabs.constants.PageUrl.*;

@Listeners(TestListener.class)
public class CartTest extends BaseTest {
    private CartFacade cartFacade;

    @BeforeClass
    public void loginToAccessInventoryPage_ThenAddTwoItemsToCart_ThenOpenCartPage() {
        SetUp setUp = new SetUp(driver);
        setUp
             .loginAsStandardUser()
             .addTwoItemsToCartAndOpenCart();
        this.cartFacade = new CartFacade(driver);
    }

    @Test
    public void givenYourCartQtyDescriptionTexts_WhenCartPageIsLoaded_ThenYourCartQtyDescriptionTextsAreVisible() {
        cartFacade
                .verifyYourCartPageTitleIsVisible()
                .verifyQtyLabelIsVisible()
                .verifyDescriptionLabelIsVisible();
    }

    @Test
    public void givenTwoItemsOnCart_WhenCartPageIsLoaded_ThenItemsQtyTitleDescriptionPriceAreVisible() {
        cartFacade.verifyItemsQtyTitleDescriptionPriceAreVisible();
    }

    @Test
    public void givenAllItemsTitles_WhenHoveredOver_ThenTitlesChangeColor() {
        cartFacade.verifyAllItemsTitlesChangeColorOnHover();
    }

    @Test
    public void givenContinueShoppingButton_WhenClickedOn_ThenUserIsRedirectedToInventoryPage() {
        cartFacade
                .continueShopping()
                .verifyRedirectTo(INVENTORY_PAGE);
    }

    @Test
    public void givenCheckoutButtonWithTwoItemsOnCart_WhenClickedOn_ThenUserIsRedirectedToCheckoutStepOnePage() {
        cartFacade
                .goToCheckout()
                .verifyRedirectTo(CHECKOUT_STEP_ONE_PAGE);
    }

    @Test
    public void givenRemoveButtonOfLastItemOnCart_WhenClickedOn_ThenCartBadgeDisplays1() {
        cartFacade.inventoryFacade.verifyCartBadgeDisplays(2);
        cartFacade.removeLastItemFromCart();
        cartFacade.inventoryFacade.verifyCartBadgeDisplays(1);
    }

    @Test
    public void givenFirstItemTitleOnCart_WhenClickedOn_ThenUserIsRedirectedToCorrespondingItemPage() {
        cartFacade
                .clickOnItemTitle(0)
                .verifyRedirectToCorrespondingItemPage();
    }
}
