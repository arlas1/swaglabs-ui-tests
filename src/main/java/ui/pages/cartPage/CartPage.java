package ui.pages.cartPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ui.pages.BasePage;
import ui.pages.checkoutStepOnePage.CheckoutStepOnePage;
import ui.pages.inventoryPage.InventoryPage;

import java.util.List;

public class CartPage extends BasePage {
    private final CartPageElements elements = new CartPageElements(driver);

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public List<WebElement> getCartItems() {
        return elements.cartItems;
    }

    public InventoryPage continueShopping() {
        click(elements.continueShoppingButton, "continue shopping button");
        return new InventoryPage(driver);
    }

    public CheckoutStepOnePage goToCheckout() {
        click(elements.checkoutButton, "checkout button");
        return new CheckoutStepOnePage(driver);
    }

    public CartPage removeItem(WebElement item) {
        WebElement removeButton = findElement(item, By.cssSelector("button[data-test^='remove']"), "item remove button");
        click(removeButton, "remove item button");
        return this;
    }

    public boolean isYourCartTitleVisible() {
        return explicitWaitForVisibility(elements.yourCartText, "'Your Cart' title");
    }

    public boolean isQtyLabelVisible() {
        return explicitWaitForVisibility(elements.qtyText, "'Qty' label");
    }

    public boolean isDescriptionLabelVisible() {
        return explicitWaitForVisibility(elements.descriptionText, "'Description' label");
    }

    public boolean isItemTitleVisible(WebElement item) {
        WebElement itemTitle = findElement(item, By.cssSelector("div[data-test='inventory-item-name']"), "item title");
        return itemTitle != null;
    }

    public boolean isItemDescriptionVisible(WebElement item) {
        WebElement itemDescription = findElement(item, By.cssSelector("div[data-test='inventory-item-desc']"), "item description");
        return itemDescription != null;
    }

    public boolean isItemPriceVisible(WebElement item) {
        WebElement itemPrice = findElement(item, By.cssSelector("div[data-test='inventory-item-price']"), "item price");
        return itemPrice != null;
    }

    public boolean isItemTitleColorChangedOnHover(WebElement item) {
        WebElement itemTitle = findElement(item, By.cssSelector("div[data-test='inventory-item-name']"), "item title");
        return isTextColorChangedOnHover(itemTitle, "item title");
    }
}
