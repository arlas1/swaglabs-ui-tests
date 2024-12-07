package ui.pages.inventoryPage;

import org.openqa.selenium.By;
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

    public InventoryPage addToCart(WebElement itemAddToCartButton) {
        click(itemAddToCartButton, "add to cart button");
        return this;
    }

    public InventoryPage removeFromCart(WebElement itemRemoveButton) {
        click(itemRemoveButton, "remove item button");
        return this;
    }

    public InventoryPage openFilter() {
        click(elements.filterSelect, "filter select");
        return this;
    }

    public InventoryPage filterByNameAtoZ() {
        return filterByOption(elements.filterOptionNameAtoZ);
    }

    public InventoryPage filterByNameZtoA() {
        return filterByOption(elements.filterOptionNameZtoA);
    }

    public InventoryPage filterByPriceLowToHigh() {
        return filterByOption(elements.filterOptionPriceLowToHigh);
    }

    public InventoryPage filterByPriceHighToLow() {
        return filterByOption(elements.filterOptionPriceHighToLow);
    }

    private InventoryPage filterByOption(WebElement filterOption) {
        String filterValue = filterOption.getAttribute("value");
        String filterDescription = filterOption.getText();
        selectDropdownByValue(elements.filterSelect, filterValue, "filter by " + filterDescription);
        return this;
    }

    public boolean isItemTitleTextColorChangedOnHover(WebElement item) {
        WebElement title = getItemTitle(item);
        return isTextColorChangedOnHover(title, "item title");
    }
}
