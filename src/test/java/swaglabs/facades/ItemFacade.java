package swaglabs.facades;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import swaglabs.constants.PageUrl;
import swaglabs.utils.CustomSoftAssert;
import ui.pages.itemPage.ItemPage;

import java.util.Iterator;

import static swaglabs.utils.CustomAssert.assertEquals;
import static swaglabs.utils.CustomAssert.assertTrue;

public class ItemFacade {
    private final ItemPage itemPage;
    private final CustomSoftAssert soft;
    public InventoryFacade inventoryFacade;

    public ItemFacade(WebDriver driver) {
        this.inventoryFacade = new InventoryFacade(driver);
        this.itemPage = new ItemPage(driver);
        this.soft = new CustomSoftAssert();
    }

    public ItemFacade goBackToProducts() {
        itemPage.goBackToProducts();
        return this;
    }

    public ItemFacade addItemToCart() {
        itemPage.addItemToCart();
        return this;
    }

    public ItemFacade removeItemFromCart() {
        itemPage.removeItemFromCart();
        return this;
    }

    public ItemFacade verifyCartBadgeDisplays(int expectedAmount) {
        int actualAmountOfItems = itemPage.header.getNumberOnCartBadge();
        assertEquals(actualAmountOfItems, expectedAmount, "Verifying that amount of elements on cart is equal to cart badge number");
        return this;
    }
    public ItemFacade verifyItemTitleIsVisible() {
        soft.assertTrue(itemPage.isItemTitleVisible(), "Verify that item title is visible");
        return this;
    }

    public ItemFacade verifyItemDescriptionIsVisible() {
        soft.assertTrue(itemPage.isItemDescriptionVisible(), "Verify that item description is visible");
        return this;
    }

    public ItemFacade verifyItemPriceIsVisible() {
        soft.assertTrue(itemPage.isItemPriceVisible(), "Verify that item price is visible");
        return this;
    }

    public ItemFacade verifyItemImageIsVisible() {
        soft.assertTrue(itemPage.isItemImageVisible(), "Verify that item image is visible");
        soft.assertAll();
        return this;
    }

    public ItemFacade verifyRedirectTo(PageUrl redirectPage) {
        String currentUrl = itemPage.getCurrentUrl();
        assertEquals(currentUrl, redirectPage.getUrl(),
                "Verifying that user is redirected to '" + redirectPage.getUrl() + "'."
        );
        itemPage.goToPreviousPage();
        return this;
    }
}
