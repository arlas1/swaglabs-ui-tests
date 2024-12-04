package swaglabs.facades;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import swaglabs.constants.SortType;
import swaglabs.utils.CustomSoftAssert;
import ui.pages.inventoryPage.InventoryPage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import static swaglabs.constants.PageUrl.INVENTORY_PAGE;
import static swaglabs.utils.CustomAssert.assertEquals;

public class InventoryFacade {
    private final InventoryPage inventoryPage;
    private final CustomSoftAssert soft;

    private List<WebElement> items;
    private List<Integer> usedItemsIds = new ArrayList<>();
    private int addedItemsCount = 0;
    private int redirectItemId;

    public InventoryFacade(WebDriver driver) {
        this.inventoryPage = new InventoryPage(driver);
        this.soft = new CustomSoftAssert();
        this.items = inventoryPage.getInventoryItems();
    }

    public InventoryFacade clickOnItemTitle(int position) {
        WebElement item = this.items.get(position);
        WebElement itemTitle = inventoryPage.getItemTitle(item);
        this.redirectItemId = inventoryPage.getItemId(item);
        inventoryPage.openItemByTitle(itemTitle);
        return this;
    }

    public InventoryFacade clickOnItemImage(int position) {
        WebElement item = this.items.get(position);
        WebElement itemTitle = inventoryPage.getItemImage(item);
        this.redirectItemId = inventoryPage.getItemId(item);
        inventoryPage.openItemByImage(itemTitle);
        return this;
    }

    public InventoryFacade addItemToCart() {
        this.usedItemsIds.add(this.addedItemsCount);
        WebElement item = this.items.get(this.addedItemsCount);
        inventoryPage.addToCart(inventoryPage.getItemAddToCartButton(item));
        this.addedItemsCount++;
        return this;
    }

    public InventoryFacade removeItemFromCart() {
        this.usedItemsIds.removeLast();
        WebElement item = this.items.get(this.addedItemsCount - 1);
        inventoryPage.removeFromCart(inventoryPage.getItemRemoveButton(item));
        this.addedItemsCount--;
        return this;
    }

    public InventoryFacade filterByNameAToZ() {
        inventoryPage
                .openFilter()
                .filterByNameAtoZ();
        return this;
    }

    public InventoryFacade filterByNameZToA() {
        inventoryPage
                .openFilter()
                .filterByNameZtoA();
        return this;
    }

    public InventoryFacade filterByPriceLowToHigh() {
        inventoryPage
                .openFilter()
                .filterByPriceLowToHigh();
        return this;
    }

    public InventoryFacade filterByPriceHighToLow() {
        inventoryPage
                .openFilter()
                .filterByPriceHighToLow();
        return this;
    }

    public InventoryFacade resetAppState() {
        inventoryPage.header.openMenu();
        inventoryPage.header.resetAppState();
        this.usedItemsIds.clear();
        this.addedItemsCount = 0;
        return this;
    }

    public void verifyAllItemsDescriptionsAndPricesAreVisible() {
        for (WebElement item : this.items) {
            String itemPrice = inventoryPage.getItemPriceString(item);
            String itemDescription = inventoryPage.getItemDescription(item);

            soft.assertNotNull(itemPrice, "Verifying that item's price is set and visible.");
            soft.assertNotNull(itemDescription, "Verifying that item's description is set.");
        }
        soft.assertAll();
    }

    public void verifyAllItemsTitlesChangeColorOnHover() {
        for (WebElement item : this.items) {
            soft.assertTrue(
                    inventoryPage.isItemTitleTextColorChangedOnHover(item),
                    "Verifying that item's title change color on hover.");
        }
        soft.assertAll();
    }

    public void verifyInventoryItemsAreSortedByTitleInOrder(SortType sortType) {
        List<String> itemsTitles = new ArrayList<>();
        for (WebElement item : this.items) {
            itemsTitles.add(inventoryPage.getItemTitle(item).getText());
        }
        List<String> sortedItemsTitles = new ArrayList<>(itemsTitles);

        switch (sortType) {
            case ALPHABETIC -> Collections.sort(sortedItemsTitles);
            case REVERSE_ALPHABETIC -> sortedItemsTitles.sort(Collections.reverseOrder());
        }

        assertEquals(itemsTitles, sortedItemsTitles, "Verifying that items are sorted in order: " + sortType);
    }

    public void verifyInventoryItemsAreSortedByPriceInOrder(SortType sortType) {
        List<Double> itemsPrices = new ArrayList<>();
        for (WebElement item : this.items) {
            itemsPrices.add(inventoryPage.getItemPriceDouble(item));
        }
        List<Double> sortedItemsPrices = new ArrayList<>(itemsPrices);

        switch (sortType) {
            case ASCENDING -> Collections.sort(sortedItemsPrices);
            case DESCENDING -> sortedItemsPrices.sort(Collections.reverseOrder());
        }

        assertEquals(itemsPrices, sortedItemsPrices, "Verifying that items are sorted in order: " + sortType);
    }

    public void verifyCartBadgeDisplays(int expectedAmount) {
        int actualAmountOfItems = inventoryPage.header.getNumberOnCartBadge();
        assertEquals(actualAmountOfItems, expectedAmount, "Verifying that amount of elements on cart is equal to cart badge number");

        Iterator<Integer> iterator = usedItemsIds.iterator();
        while (iterator.hasNext()) {
            int itemId = iterator.next();
            WebElement removeButton = inventoryPage.getItemRemoveButton(this.items.get(itemId));
            String removeButtonText = removeButton.getText();
            if (removeButtonText.equals("Remove")) {
                inventoryPage.removeFromCart(removeButton);
                iterator.remove();
                this.addedItemsCount--;
            }
        }
    }

    public void verifyItemAddToCartButtonChangeToRemoveButton(int position) {
        WebElement removeButton = inventoryPage.getItemRemoveButton(this.items.get(position));
        String removeButtonText = removeButton.getText();
        String expectedText = "Remove";
        assertEquals(removeButtonText, expectedText, "Verifying that Remove button is displayed.");

        inventoryPage.removeFromCart(inventoryPage.getItemRemoveButton(this.items.get(position)));
        this.usedItemsIds.removeLast();
        this.addedItemsCount--;
    }

    public void verifyRedirectToCorrespondingItemPage() {
        String expectedUrl = "https://www.saucedemo.com/inventory-item.html?id=" + this.redirectItemId;
        String actualUrl = inventoryPage.getCurrentUrl();

        assertEquals(actualUrl, expectedUrl, "Verifying that pressing on item title lead to right page");
        inventoryPage.openUrl(INVENTORY_PAGE.getUrl());
    }
}