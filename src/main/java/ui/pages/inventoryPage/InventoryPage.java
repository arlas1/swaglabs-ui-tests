package ui.pages.inventoryPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ui.pages.BasePage;
import ui.pages.inventoryItemPage.InventoryItemPage;

public class InventoryPage extends BasePage {
    private final InventoryPageElements elements = new InventoryPageElements(driver);

    public InventoryPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getItemImage(int index) {
        WebElement item = elements.productsList.get(index);
        return item.findElement(By.cssSelector("img.inventory_item_img"));
    }

    public String getItemTitle(int index) {
        WebElement item = elements.productsList.get(index);
        return item.findElement(By.cssSelector("div[data-test='inventory-item-name']")).getText();
    }

    public String getItemDescription(int index) {
        WebElement item = elements.productsList.get(index);
        return item.findElement(By.cssSelector("div[data-test='inventory-item-desc']")).getText();
    }

    public String getItemPrice(int index) {
        WebElement item = elements.productsList.get(index);
        return item.findElement(By.cssSelector("div[data-test='inventory-item-price']")).getText();
    }

    public WebElement getItemAddToCartButton(int index) {
        WebElement product = elements.productsList.get(index);
        return product.findElement(By.cssSelector("button[data-test^='add-to-cart']"));
    }

    public WebElement getItemRemoveButton(int index) {
        WebElement product = elements.productsList.get(index);
        return product.findElement(By.cssSelector("button[data-test^='remove']"));
    }

    public InventoryItemPage openItem(WebElement itemTitle) {
        click(itemTitle, "item title");
        return new InventoryItemPage(driver);
    }

    public InventoryPage addToCart(WebElement itemAddToCartButton) {
        click(itemAddToCartButton, "add to cart button");
        return this;
    }

    public InventoryPage removeFromCart(WebElement itemRemoveButton) {
        click(itemRemoveButton, "remove from cart button");
        return this;
    }

    public InventoryPage isItemTitleTextColorChangedOnHover(int index) {
        WebElement item = elements.productsList.get(index);
        WebElement title = item.findElement(By.cssSelector("div[data-test='inventory-item-name']"));
        isTextColorChangedOnHover(title, "item title");
        return this;
    }

    public InventoryPage openFilterOptions() {
        click(elements.filterSelect, "filter select");
        return this;
    }

    public InventoryPage filterByNameAtoZ() {
        click(elements.filterOptionNameAtoZ, "filter by name A to Z");
        return this;
    }

    public InventoryPage filterByNameZtoA() {
        click(elements.filterOptionNameZtoA, "filter by name Z to A");
        return this;
    }

    public InventoryPage filterByPriceLowToHigh() {
        click(elements.filterOptionPriceLowToHigh, "filter by price low to high");
        return this;
    }

    public InventoryPage filterByPriceHighToLow() {
        click(elements.filterOptionPriceHighToLow, "filter by price high to low");
        return this;
    }

    public boolean isProductsTitleVisible() {
        return explicitWaitForVisibility(elements.productsTitle, "products title");
    }

    public boolean areAllProductsVisible() {
        return explicitWaitForVisibilityOfList(elements.productsList, "products list");
    }

    public boolean isFilterOptionActiveVisible() {
        return explicitWaitForVisibility(elements.filterOptionActive, "active filter option");
    }

    public boolean isItemImageVisible(WebElement item) {
        WebElement itemImage = item.findElement(By.cssSelector("img[data-test^='inventory-item']"));
        return explicitWaitForVisibility(itemImage, "item image");
    }

    public boolean isItemTitleVisible(WebElement item) {
        WebElement itemTitle = item.findElement(By.cssSelector("div[data-test='inventory-item-name']"));
        return explicitWaitForVisibility(itemTitle, "item title");
    }

    public boolean isItemDescriptionVisible(WebElement item) {
        WebElement itemDescription = item.findElement(By.cssSelector("div[data-test='inventory-item-desc']"));
        return explicitWaitForVisibility(itemDescription, "item description");
    }

    public boolean isItemPriceVisible(WebElement item) {
        WebElement itemPrice = item.findElement(By.cssSelector("div[data-test='inventory-item-price']"));
        return explicitWaitForVisibility(itemPrice, "item price");
    }

    public boolean isItemAddToCartButtonVisible(WebElement item) {
        WebElement addToCartButton = item.findElement(By.cssSelector("button[data-test^='add-to-cart']"));
        return explicitWaitForVisibility(addToCartButton, "add to cart button");
    }

    public boolean isItemRemoveButtonVisible(WebElement item) {
        WebElement removeButton = item.findElement(By.cssSelector("button[data-test^='remove-']"));
        return explicitWaitForVisibility(removeButton, "remove button");
    }
}
