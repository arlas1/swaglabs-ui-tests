package swaglabs.facades;

import org.openqa.selenium.WebDriver;
import swaglabs.utils.CustomSoftAssert;
import ui.pages.checkoutCompletePage.CheckoutCompletePage;

import static swaglabs.utils.CustomAssert.assertEquals;

public class CheckoutCompleteFacade {
    private CheckoutCompletePage checkoutCompletePage;
    private CustomSoftAssert soft;

    public CheckoutCompleteFacade(WebDriver driver) {
        this.checkoutCompletePage = new CheckoutCompletePage(driver);
        this.soft = new CustomSoftAssert();
    }

    public void verifyConfirmationMessageIsVisible() {
        soft.assertTrue(checkoutCompletePage.isCheckoutCompleteTitleVisible(), "Verifying that 'Checkout: Complete!' title is visible.");
        soft.assertTrue(checkoutCompletePage.isConfirmationIconVisible(), "Verifying that confirmation icon is visible.");
        soft.assertTrue(checkoutCompletePage.isConfirmationHeaderTextVisible(), "Verifying that confirmation header text is visible.");
        soft.assertTrue(checkoutCompletePage.isConfirmationDescriptionVisible(), "Verifying that confirmation description is visible.");
        soft.assertAll();
    }

    public CheckoutCompleteFacade goBackToInventoryPage() {
        checkoutCompletePage.goBackHome();
        return this;
    }

    public void verifyRedirectTo(String redirectedToUrl) {
        String currentUrl = checkoutCompletePage.getCurrentUrl();
        assertEquals(currentUrl, redirectedToUrl,
                "Verifying that user is redirected to the inventory page."
        );
        checkoutCompletePage.goToPreviousPage();

    }
}
