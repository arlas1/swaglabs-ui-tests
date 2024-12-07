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
        click(elements.backHomeButton, "back home button");
        return new InventoryPage(driver);
    }

    public boolean isCheckoutCompleteTitleVisible() {
        return explicitWaitForVisibility(elements.checkoutCompleteTitle, "'Checkout: Complete!' title");
    }

    public boolean isConfirmationIconVisible() {
        return explicitWaitForVisibility(elements.confirmationIcon, "confirmation icon");
    }

    public boolean isConfirmationHeaderTextVisible() {
        return explicitWaitForVisibility(elements.confirmationHeaderText, "confirmation header text");
    }

    public boolean isConfirmationDescriptionVisible() {
        return explicitWaitForVisibility(elements.confirmationDescription, "confirmation description");
    }
}
