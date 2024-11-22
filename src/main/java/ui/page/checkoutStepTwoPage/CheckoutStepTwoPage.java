package ui.page.checkoutStepTwoPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ui.page.BasePage;
import ui.page.checkoutCompletePage.CheckoutCompletePage;
import ui.page.inventoryPage.InventoryPage;
import ui.page.itemPage.ItemPage;

public class CheckoutStepTwoPage extends BasePage {
    private final CheckoutStepTwoPageElements elements = new CheckoutStepTwoPageElements(driver);

    public CheckoutStepTwoPage(WebDriver driver) {
        super(driver);
    }

    public ItemPage openItem(WebElement itemTitle) {
        customActions.click(itemTitle, "item title");
        return new ItemPage(driver);
    }

    public InventoryPage cancelCheckout() {
        customActions.click(elements.cancelButton, "cancel button");
        return new InventoryPage(driver);
    }

    public CheckoutCompletePage finishCheckout() {
        customActions.click(elements.finishButton, "finish button");
        return new CheckoutCompletePage(driver);
    }

    public boolean isCheckoutOverviewTextVisible() {
        return customActions.explicitWaitForVisibility(elements.checkoutOverviewText, "checkout overview text");
    }

    public boolean isQtyTextVisible() {
        return customActions.explicitWaitForVisibility(elements.qtyText, "quantity text");
    }

    public boolean isDescriptionTextVisible() {
        return customActions.explicitWaitForVisibility(elements.descriptionText, "description text");
    }

    public boolean areAllItemsVisible() {
        return customActions.explicitWaitForVisibilityOfList(elements.itemsList, "items list");
    }

    public boolean isPaymentInformationVisible() {
        return customActions.explicitWaitForVisibility(elements.paymentSummaryText, "payment information");
    }

    public boolean isItemsTotalPriceVisible() {
        return customActions.explicitWaitForVisibility(elements.itemsTotalPrice, "items total price");
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
}
