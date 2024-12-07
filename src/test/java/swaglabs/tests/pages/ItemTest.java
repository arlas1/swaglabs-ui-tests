package swaglabs.tests.pages;

import listener.TestListener;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import swaglabs.facades.ItemFacade;
import swaglabs.tests.setup.SetUp;

import static swaglabs.constants.PageUrl.*;

@Listeners(TestListener.class)
public class ItemTest extends BaseTest {
    private ItemFacade itemFacade;

    @BeforeClass
    public void loginToAccessInventoryPageAndClickOnItem() {
        SetUp setUp = new SetUp(driver);
        setUp.loginAsStandardUser()
             .openItemPage();
        this.itemFacade = new ItemFacade(driver);
    }

    @Test
    public void givenItemTitleDescriptionPriceImage_WhenItemPageIsLoaded_ThenTitleDescriptionPriceImageAreVisible() {
        itemFacade
                .verifyItemTitleIsVisible()
                .verifyItemDescriptionIsVisible()
                .verifyItemPriceIsVisible()
                .verifyItemImageIsVisible();
    }

    @Test
    public void givenBackToProductsButton_WhenClickedOn_ThenUserIsRedirectedToInventoryPage() {
        itemFacade
                .goBackToProducts()
                .verifyRedirectTo(INVENTORY_PAGE);
    }

    @Test
    public void givenAddToCartButton_WhenClickedOn_ThenCartBadgeDisplays1_givenRemoveButton_WhenClickedOn_ThenCartBardeDisplays0() {
        itemFacade
                .addItemToCart()
                .verifyCartBadgeDisplays(1)
                .removeItemFromCart()
                .verifyCartBadgeDisplays(0);
    }
}
