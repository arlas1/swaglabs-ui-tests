package swaglabs.tests.pages;

import listener.TestListener;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import swaglabs.facades.InventoryFacade;
import swaglabs.tests.setup.SetUp;

import static swaglabs.constants.SortType.*;

@Listeners(TestListener.class)
public class InventoryTest extends BaseTest {
    private InventoryFacade inventoryFacade;

    @BeforeClass
    public void loginToAccessInventoryPage() {
        SetUp setUp = new SetUp(driver);
        setUp.loginAsStandardUser();
        this.inventoryFacade = new InventoryFacade(driver);
    }

    @Test(priority = 1)
    public void givenInventoryItemsDescriptionsAndPrices_WhenInventoryPageIsLoaded_ThenDescriptionsAndPricesAreVisible() {
        inventoryFacade.verifyAllItemsDescriptionsAndPricesAreVisible();
    }

    @Test(priority = 2)
    public void givenInventoryItemsTitles_WhenHoveredOver_ThenTitlesTextColorChanges() {
        inventoryFacade.verifyAllItemsTitlesChangeColorOnHover();
    }

    @Test(priority = 3)
    public void givenTitleOfFirstItemInInventory_WhenClickOnIt_ThenUserIsRedirectedToCorrespondingItemPage() {
        inventoryFacade
                .clickOnItemTitle(0)
                .verifyRedirectToCorrespondingItemPage();
    }

    @Test(priority = 4)
    public void givenImageOfFirstItemInInventory_WhenClickOnIt_ThenUserIsRedirectedToCorrespondingItemPage() {
        inventoryFacade
                .clickOnItemImage(0)
                .verifyRedirectToCorrespondingItemPage();
    }

    @Test(priority = 5)
    public void givenFilterByNameAToZ_WhenApplied_ThenItemsAreSortedAlphabetically() {
        inventoryFacade
                .filterByNameAToZ()
                .verifyInventoryItemsAreSortedByTitleInOrder(ALPHABETIC);
    }

    @Test(priority = 6)
    public void givenFilterByNameZToA_WhenApplied_ThenItemsAreSortedInReverseAlphabeticalOrder() {
        inventoryFacade
                .filterByNameZToA()
                .verifyInventoryItemsAreSortedByTitleInOrder(REVERSE_ALPHABETIC);
    }

    @Test(priority = 7)
    public void givenFilterByPriceLowToHigh_WhenApplied_ThenItemsAreSortedByPriceAscending() {
        inventoryFacade
                .filterByPriceLowToHigh()
                .verifyInventoryItemsAreSortedByPriceInOrder(ASCENDING);
    }

    @Test(priority = 8)
    public void givenFilterByPriceHighToLow_WhenApplied_ThenItemsAreSortedByPriceDescending() {
        inventoryFacade
                .filterByPriceHighToLow()
                .verifyInventoryItemsAreSortedByPriceInOrder(DESCENDING);
    }

    @Test(priority = 9)
    public void givenFirstItemInInventory_WhenAddItemToCart_ThenItemButtonDisplaysRemove() {
        inventoryFacade
                .addItemToCart()
                .verifyItemAddToCartButtonChangeToRemoveButton(0);
    }

    @Test(priority = 10)
    public void givenFirstItemInInventory_WhenAddItemToCart_ThenCartBadgeDisplays1() {
        inventoryFacade
                .addItemToCart()
                .verifyCartBadgeDisplays(1);
    }

    @Test(priority = 11)
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

    @Test(priority = 12)
    public void givenTwoAddedToCartItem_WhenClickOnSecondItemRemoveButton_ThenCartBadgeDisplays1() {
        inventoryFacade
                .addItemToCart()
                .addItemToCart()
                .removeItemFromCart()
                .verifyCartBadgeDisplays(1);
    }

    @Test(priority = 13)
    public void givenResetAppStateButtonInMenu_WhenTwoItemsAddedToCartAndResetAppStateClicked_ThenCartBadgeDisappears() {
        inventoryFacade
                .addItemToCart()
                .addItemToCart()
                .resetAppState()
                .verifyCartBadgeDisplays(0);
    }
}
