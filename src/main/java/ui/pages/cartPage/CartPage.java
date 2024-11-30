package ui.pages.cartPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ui.pages.BasePage;
import ui.pages.checkoutStepOnePage.CheckoutStepOnePage;
import ui.pages.inventoryPage.InventoryPage;
import ui.pages.inventoryItemPage.InventoryItemPage;

public class CartPage extends BasePage {
    private final CartPageElements elements = new CartPageElements(driver);

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public InventoryPage continueShopping() {
        click(elements.continueShoppingButton, "continue shopping button");
        return new InventoryPage(driver);
    }

    public CheckoutStepOnePage goToCheckout() {
        click(elements.checkoutButton, "checkout button");
        return new CheckoutStepOnePage(driver);
    }

    public CartPage removeItem(WebElement removeButton) {
        click(removeButton, "remove item button");
        return this;
    }

    public InventoryItemPage openItem(WebElement itemTitle) {
        click(itemTitle, "item title");
        return new InventoryItemPage(driver);
    }

    public boolean isYourCartTextVisible() {
        return explicitWaitForVisibility(elements.yourCartText, "your cart text");
    }

    public boolean isQtyTextVisible() {
        return explicitWaitForVisibility(elements.qtyText, "qty text");
    }

    public boolean isDescriptionTextVisible() {
        return explicitWaitForVisibility(elements.descriptionText, "description text");
    }

    public boolean isCartItemsListVisible() {
        return explicitWaitForVisibilityOfList(elements.cartItemsList, "cart items list");
    }

    public boolean isItemQuantityVisible(WebElement cartItem) {
        WebElement itemQuantity = cartItem.findElement(By.cssSelector("div[data-test='item-quantity']"));
        return explicitWaitForVisibility(itemQuantity, "item quantity");
    }

    public boolean isItemTitleVisible(WebElement cartItem) {
        WebElement itemTitle = cartItem.findElement(By.cssSelector("div[data-test='inventory-item-name']"));
        return explicitWaitForVisibility(itemTitle, "item title");
    }

    public boolean isItemDescriptionVisible(WebElement cartItem) {
        WebElement itemDescription = cartItem.findElement(By.cssSelector("div[data-test='inventory-item-desc']"));
        return explicitWaitForVisibility(itemDescription, "item description");
    }

    public boolean isItemPriceVisible(WebElement cartItem) {
        WebElement itemPrice = cartItem.findElement(By.cssSelector("div[data-test='inventory-item-price']"));
        return explicitWaitForVisibility(itemPrice, "item price");
    }

    public boolean isItemRemoveButtonVisible(WebElement cartItem) {
        WebElement removeButton = cartItem.findElement(By.cssSelector("button[data-test^='remove-']"));
        return explicitWaitForVisibility(removeButton, "item remove button");
    }
}
