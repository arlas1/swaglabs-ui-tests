package ui.pages.inventoryPage;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ui.pages.BasePage;
import ui.pages.itemPage.ItemPage;

import java.util.List;

public class InventoryPage extends BasePage {
    private final InventoryPageElements elements = new InventoryPageElements(driver);

    public InventoryPage(WebDriver driver) {
        super(driver);
    }

    public List<WebElement> getInventoryItems() {
        return elements.inventoryItems;
    }

    public WebElement getItemImage(WebElement item) {
        return findElement(item, By.cssSelector("img.inventory_item_img"), "item image");
    }

    public WebElement getItemTitle(WebElement item) {
        return findElement(item, By.cssSelector("div[data-test='inventory-item-name']"), "item title");
    }

    public String getItemDescription(WebElement item) {
        WebElement descriptionElement = findElement(item, By.cssSelector("div[data-test='inventory-item-desc']"), "item description");
        return descriptionElement != null ? descriptionElement.getText() : "";
    }

    public String getItemPriceString(WebElement item) {
        WebElement priceElement = findElement(item, By.cssSelector("div[data-test='inventory-item-price']"), "item price");
        return priceElement != null ? priceElement.getText() : "";
    }

    public double getItemPriceDouble(WebElement item) {
        String priceText = getItemPriceString(item);
        return Double.parseDouble(priceText.replace("$", "").trim());
    }

    public WebElement getItemAddToCartButton(WebElement item) {
        return findElement(item, By.cssSelector("button[data-test^='add-to-cart']"), "add to cart button");
    }

    public WebElement getItemRemoveButton(WebElement item) {
        return findElement(item, By.cssSelector("button[data-test^='remove']"), "remove button");
    }

    public int getItemId(WebElement inventoryItem) {
        try {
            WebElement itemLink = findElement(inventoryItem, By.cssSelector("a[id*='item_']"), "item link");
            String idValue = itemLink.getAttribute("id");
            String itemId = idValue.replaceAll("\\D+", "");
            return Integer.parseInt(itemId);
        } catch (NoSuchElementException e) {
            throw new RuntimeException("Item ID not found for the given inventory item.", e);
        }
    }

    public ItemPage openItemByTitle(WebElement itemTitle) {
        click(itemTitle, "item title");
        return new ItemPage(driver);
    }

    public ItemPage openItemByImage(WebElement itemImage) {
        click(itemImage, "item image");
        return new ItemPage(driver);
    }

    public InventoryPage addToCart(WebElement itemAddToCartButton) {
        click(itemAddToCartButton, "add to cart button");
        return this;
    }

    public InventoryPage removeFromCart(WebElement itemRemoveButton) {
        click(itemRemoveButton, "remove item button");
        return this;
    }

    public boolean isItemTitleTextColorChangedOnHover(WebElement item) {
        WebElement title = getItemTitle(item);
        return isTextColorChangedOnHover(title, "item title");
    }

    public InventoryPage openFilter() {
        click(elements.filterSelect, "filter select");
        return this;
    }


    public InventoryPage filterByNameAtoZ() {
        selectDropdownByValue(elements.filterSelect, "az", "filter by name A to Z");
        return this;
    }

    public InventoryPage filterByNameZtoA() {
        selectDropdownByValue(elements.filterSelect, "za", "filter by name Z to A");
        return this;
    }

    public InventoryPage filterByPriceLowToHigh() {
        selectDropdownByValue(elements.filterSelect, "lohi", "filter by price low to high");
        return this;
    }

    public InventoryPage filterByPriceHighToLow() {
        selectDropdownByValue(elements.filterSelect, "hilo", "filter by price high to low");
        return this;
    }

//    public boolean isItemTitleVisible() {
//        return explicitWaitForVisibility(elements.itemTitle, "item title");
//    }
//
//    public boolean areAllItemsVisible() {
//        return explicitWaitForVisibilityOfList(elements.inventoryItems, "item list");
//    }
//
//    public boolean isFilterOptionActiveVisible() {
//        return explicitWaitForVisibility(elements.filterOptionActive, "active filter option");
//    }
//
//    public boolean isItemImageVisible(WebElement item) {
//        WebElement itemImage = item.findElement(By.cssSelector("img[data-test^='inventory-item']"));
//        return explicitWaitForVisibility(itemImage, "item image");
//    }
//
//    public boolean isItemTitleVisible(WebElement item) {
//        WebElement itemTitle = item.findElement(By.cssSelector("div[data-test='inventory-item-name']"));
//        return explicitWaitForVisibility(itemTitle, "item title");
//    }
//
//    public boolean isItemDescriptionVisible(WebElement item) {
//        WebElement itemDescription = item.findElement(By.cssSelector("div[data-test='inventory-item-desc']"));
//        return explicitWaitForVisibility(itemDescription, "item description");
//    }
//
//    public boolean isItemPriceVisible(WebElement item) {
//        WebElement itemPrice = item.findElement(By.cssSelector("div[data-test='inventory-item-price']"));
//        return explicitWaitForVisibility(itemPrice, "item price");
//    }
//
//    public boolean isItemAddToCartButtonVisible(WebElement item) {
//        WebElement addToCartButton = item.findElement(By.cssSelector("button[data-test^='add-to-cart']"));
//        return explicitWaitForVisibility(addToCartButton, "add to cart button");
//    }
//
//    public boolean isItemRemoveButtonVisible(WebElement item) {
//        WebElement removeButton = item.findElement(By.cssSelector("button[data-test^='remove-']"));
//        return explicitWaitForVisibility(removeButton, "remove button");
//    }
}
