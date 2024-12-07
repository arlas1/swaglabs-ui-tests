package ui.pages.checkoutStepTwoPage;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ui.pages.BasePage;
import ui.pages.checkoutCompletePage.CheckoutCompletePage;
import ui.pages.inventoryPage.InventoryPage;
import ui.pages.itemPage.ItemPage;

import java.util.List;

public class CheckoutStepTwoPage extends BasePage {
    private final CheckoutStepTwoPageElements elements = new CheckoutStepTwoPageElements(driver);

    public CheckoutStepTwoPage(WebDriver driver) {
        super(driver);
    }

    public List<WebElement> getCartItems() {
        return elements.cartItems;
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

    public ItemPage openItem(WebElement item) {
        WebElement itemTitle = findElement(item, By.cssSelector("div[data-test='inventory-item-name']"), "item title");
        click(itemTitle, "item title");
        return new ItemPage(driver);
    }

    public InventoryPage cancelCheckout() {
        click(elements.cancelButton, "cancel button");
        return new InventoryPage(driver);
    }

    public CheckoutCompletePage finishCheckout() {
        click(elements.finishButton, "finish button");
        return new CheckoutCompletePage(driver);
    }

    public boolean isCheckoutOverviewTextVisible() {
        return explicitWaitForVisibility(elements.checkoutOverviewTitle, "checkout overview text");
    }

    public boolean isQtyLabelVisible() {
        return explicitWaitForVisibility(elements.qtyLabel, "quantity label");
    }

    public boolean isDescriptionLabelVisible() {
        return explicitWaitForVisibility(elements.descriptionLabel, "description label");
    }

    public boolean isPaymentInformationVisible() {
        return explicitWaitForVisibility(elements.paymentSummaryText, "payment information");
    }

    public boolean isItemsTotalPriceVisible() {
        return explicitWaitForVisibility(elements.itemsTotalPrice, "items total price");
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
}
