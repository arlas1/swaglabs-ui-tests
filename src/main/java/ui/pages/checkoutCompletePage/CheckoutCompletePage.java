package ui.pages.checkoutCompletePage;

import org.openqa.selenium.WebDriver;
import ui.pages.BasePage;
import ui.pages.inventoryPage.InventoryPage;

public class CheckoutCompletePage extends BasePage {
    private final CheckoutCompletePageElements elements = new CheckoutCompletePageElements(driver);

    public CheckoutCompletePage(WebDriver driver) {
        super(driver);
    }

    public InventoryPage goBackHome() {
        customActions.click(elements.backHomeButton, "back home button");
        return new InventoryPage(driver);
    }

    public boolean isCheckoutCompleteTextVisible() {
        return customActions.explicitWaitForVisibility(elements.checkoutCompleteText, "checkout complete text");
    }

    public boolean isConfirmationIconVisible() {
        return customActions.explicitWaitForVisibility(elements.confirmationIcon, "confirmation icon");
    }

    public boolean isConfirmationHeaderVisible() {
        return customActions.explicitWaitForVisibility(elements.confirmationHeader, "confirmation header");
    }

    public boolean isConfirmationDescriptionVisible() {
        return customActions.explicitWaitForVisibility(elements.confirmationDescription, "confirmation description");
    }
}
