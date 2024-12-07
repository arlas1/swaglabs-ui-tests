package ui.pages.checkoutStepTwoPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ui.pages.BasePage;
import ui.pages.checkoutCompletePage.CheckoutCompletePage;
import ui.pages.inventoryPage.InventoryPage;

import java.util.List;

public class CheckoutStepTwoPage extends BasePage {
    private final CheckoutStepTwoPageElements elements = new CheckoutStepTwoPageElements(driver);

    public CheckoutStepTwoPage(WebDriver driver) {
        super(driver);
    }

    public List<WebElement> getCartItems() {
        return elements.cartItems;
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
}
