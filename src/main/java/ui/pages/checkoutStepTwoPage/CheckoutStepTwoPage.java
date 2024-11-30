package ui.pages.checkoutStepTwoPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ui.pages.BasePage;
import ui.pages.checkoutCompletePage.CheckoutCompletePage;
import ui.pages.inventoryPage.InventoryPage;
import ui.pages.inventoryItemPage.InventoryItemPage;

public class CheckoutStepTwoPage extends BasePage {
    private final CheckoutStepTwoPageElements elements = new CheckoutStepTwoPageElements(driver);

    public CheckoutStepTwoPage(WebDriver driver) {
        super(driver);
    }

    public InventoryItemPage openItem(WebElement itemTitle) {
        click(itemTitle, "item title");
        return new InventoryItemPage(driver);
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
        return explicitWaitForVisibility(elements.checkoutOverviewText, "checkout overview text");
    }

    public boolean isQtyTextVisible() {
        return explicitWaitForVisibility(elements.qtyText, "quantity text");
    }

    public boolean isDescriptionTextVisible() {
        return explicitWaitForVisibility(elements.descriptionText, "description text");
    }

    public boolean areAllItemsVisible() {
        return explicitWaitForVisibilityOfList(elements.itemsList, "items list");
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
