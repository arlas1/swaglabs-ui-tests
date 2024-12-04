package swaglabs.tests.pages;

import listener.TestListener;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import swaglabs.constants.Credentials;
import swaglabs.facades.InventoryFacade;
import swaglabs.facades.ItemFacade;

import static swaglabs.constants.PageUrl.*;

@Listeners(TestListener.class)
public class ItemTest extends BaseTest {
    InventoryFacade inventoryFacade;
    ItemFacade itemFacade;

    @BeforeClass
    public void loginToAccessInventoryPageAndClickOnItem() {
        loginPageFacade
                .enterValidUsername(Credentials.Usernames.STANDARD_USER)
                .enterValidPassword()
                .login();
        this.inventoryFacade = new InventoryFacade(driver);
        inventoryFacade
                .clickOnItemTitle(0);
        this.itemFacade = new ItemFacade(driver);
    }

    @Test
    public void givenItemTitleDescriptionPriceImage_WhenPageIsLoaded_ThenTitleDescriptionPriceImageAreVisible() {
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
