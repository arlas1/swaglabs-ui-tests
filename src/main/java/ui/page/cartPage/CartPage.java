package ui.page.cartPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ui.page.BasePage;
import ui.page.checkoutStepOnePage.CheckoutStepOnePage;
import ui.page.inventoryPage.InventoryPage;
import ui.page.itemPage.ItemPage;

public class CartPage extends BasePage {
    private final CartPageElements elements = new CartPageElements(driver);

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public InventoryPage continueShopping() {
        customActions.click(elements.continueShoppingButton, "continue shopping button");
        return new InventoryPage(driver);
    }

    public CheckoutStepOnePage goToCheckout() {
        customActions.click(elements.checkoutButton, "checkout button");
        return new CheckoutStepOnePage(driver);
    }

    public CartPage removeItem(WebElement removeButton) {
        customActions.click(removeButton, "remove item button");
        return this;
    }

    public ItemPage openItem(WebElement itemTitle) {
        customActions.click(itemTitle, "item title");
        return new ItemPage(driver);
    }

    public boolean isYourCartTextVisible() {
        return customActions.explicitWaitForVisibility(elements.yourCartText, "your cart text");
    }

    public boolean isQtyTextVisible() {
        return customActions.explicitWaitForVisibility(elements.qtyText, "qty text");
    }

    public boolean isDescriptionTextVisible() {
        return customActions.explicitWaitForVisibility(elements.descriptionText, "description text");
    }

    public boolean isCartItemsListVisible() {
        return customActions.explicitWaitForVisibilityOfList(elements.cartItemsList, "cart items list");
    }

    public boolean isItemQuantityVisible(WebElement cartItem) {
        WebElement itemQuantity = cartItem.findElement(By.cssSelector("div[data-test='item-quantity']"));
        return customActions.explicitWaitForVisibility(itemQuantity, "item quantity");
    }

    public boolean isItemTitleVisible(WebElement cartItem) {
        WebElement itemTitle = cartItem.findElement(By.cssSelector("div[data-test='inventory-item-name']"));
        return customActions.explicitWaitForVisibility(itemTitle, "item title");
    }

    public boolean isItemDescriptionVisible(WebElement cartItem) {
        WebElement itemDescription = cartItem.findElement(By.cssSelector("div[data-test='inventory-item-desc']"));
        return customActions.explicitWaitForVisibility(itemDescription, "item description");
    }

    public boolean isItemPriceVisible(WebElement cartItem) {
        WebElement itemPrice = cartItem.findElement(By.cssSelector("div[data-test='inventory-item-price']"));
        return customActions.explicitWaitForVisibility(itemPrice, "item price");
    }

    public boolean isItemRemoveButtonVisible(WebElement cartItem) {
        WebElement removeButton = cartItem.findElement(By.cssSelector("button[data-test^='remove-']"));
        return customActions.explicitWaitForVisibility(removeButton, "item remove button");
    }
}
