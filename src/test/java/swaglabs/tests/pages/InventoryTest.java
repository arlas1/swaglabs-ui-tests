package swaglabs.tests.pages;

import listener.TestListener;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import swaglabs.constants.Credentials;
import swaglabs.facades.InventoryFacade;

import static swaglabs.constants.SortType.*;

@Listeners(TestListener.class)
public class InventoryTest extends BaseTest {
    InventoryFacade inventoryFacade;

    @BeforeClass
    public void loginToAccessInventoryPage() {
        loginPageFacade
                .enterValidUsername(Credentials.Usernames.STANDARD_USER)
                .enterValidPassword()
                .login();
        this.inventoryFacade = new InventoryFacade(driver);
    }


    @Test
    public void givenInventoryItemsDescriptionsAndPrices_WhenInventoryPageIsLoaded_ThenDescriptionsAndPricesAreVisible() {
        inventoryFacade.verifyAllItemsDescriptionsAndPricesAreVisible();
    }

    @Test
    public void givenInventoryItemsTitles_WhenHoveredOver_ThenTitlesTextColorChanges() {
        inventoryFacade.verifyAllItemsTitlesChangeColorOnHover();
    }

    @Test
    public void givenTitleOfFirstItemInInventory_WhenClickOnIt_ThenUserIsRedirectedToCorrespondingItemPage() {
        inventoryFacade
                .clickOnItemTitle(0)
                .verifyRedirectToCorrespondingItemPage();
    }

    @Test
    public void givenImageOfFirstItemInInventory_WhenClickOnIt_ThenUserIsRedirectedToCorrespondingItemPage() {
        inventoryFacade
                .clickOnItemImage(0)
                .verifyRedirectToCorrespondingItemPage();
    }

    @Test
    public void givenFilterByNameAToZ_WhenApplied_ThenItemsAreSortedAlphabetically() {
        inventoryFacade
                .filterByNameAToZ()
                .verifyInventoryItemsAreSortedByTitleInOrder(ALPHABETIC);
    }

    @Test
    public void givenFilterByNameZToA_WhenApplied_ThenItemsAreSortedInReverseAlphabeticalOrder() {
        inventoryFacade
                .filterByNameZToA()
                .verifyInventoryItemsAreSortedByTitleInOrder(REVERSE_ALPHABETIC);
    }

    @Test
    public void givenFilterByPriceLowToHigh_WhenApplied_ThenItemsAreSortedByPriceAscending() {
        inventoryFacade
                .filterByPriceLowToHigh()
                .verifyInventoryItemsAreSortedByPriceInOrder(ASCENDING);
    }

    @Test
    public void givenFilterByPriceHighToLow_WhenApplied_ThenItemsAreSortedByPriceDescending() {
        inventoryFacade
                .filterByPriceHighToLow()
                .verifyInventoryItemsAreSortedByPriceInOrder(DESCENDING);
    }

    @Test
    public void givenFirstItemInInventory_WhenAddItemToCart_ThenItemButtonDisplaysRemove() {
        inventoryFacade
                .addItemToCart()
                .verifyItemAddToCartButtonChangeToRemoveButton(0);
    }

    @Test
    public void givenFirstItemInInventory_WhenAddItemToCart_ThenCartBadgeDisplays1() {
        inventoryFacade
                .addItemToCart()
                .verifyCartBadgeDisplays(1);
    }

    @Test
    public void givenSixItems_WhenAddSixItemsToCart_ThenCartBadgeDisplays6() {
        inventoryFacade
                .addItemToCart()
                .addItemToCart()
                .addItemToCart()
                .addItemToCart()
                .addItemToCart()
                .addItemToCart()
                .verifyCartBadgeDisplays(6);
    }

    @Test
    public void givenTwoAddedToCartItem_WhenClickOnSecondItemRemoveButton_ThenCartBadgeDisplays1() {
        inventoryFacade
                .addItemToCart()
                .addItemToCart()
                .removeItemFromCart()
                .verifyCartBadgeDisplays(1);
    }

    @Test
    public void givenResetAppStateButtonInMenu_WhenTwoItemsAddedToCartAndResetAppStateClicked_ThenCartBadgeDisappears() {
        inventoryFacade
                .addItemToCart()
                .addItemToCart()
                .resetAppState()
                .verifyCartBadgeDisplays(0);
    }
}
