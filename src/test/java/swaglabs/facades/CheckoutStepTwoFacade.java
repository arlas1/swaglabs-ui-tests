package swaglabs.facades;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import swaglabs.utils.CustomSoftAssert;
import ui.pages.checkoutStepTwoPage.CheckoutStepTwoPage;

import java.util.List;

import static swaglabs.constants.PageUrl.CART_PAGE;
import static swaglabs.utils.CustomAssert.assertEquals;

public class CheckoutStepTwoFacade {
    private CheckoutStepTwoPage checkoutStepTwoPage;
    private final CustomSoftAssert soft;
    private int redirectItemId;

    public CheckoutStepTwoFacade(WebDriver driver) {
        this.checkoutStepTwoPage = new CheckoutStepTwoPage(driver);
        this.soft = new CustomSoftAssert();
    }

    public void verifyOrderSummaryIsVisible() {
        soft.assertTrue(checkoutStepTwoPage.isCheckoutOverviewTextVisible(), "Verifying that checkout overview text is visible");
        soft.assertTrue(checkoutStepTwoPage.isQtyLabelVisible(), "Verifying that checkout 'qty' label is visible");
        soft.assertTrue(checkoutStepTwoPage.isDescriptionLabelVisible(), "Verifying that 'description' label is visible");
        soft.assertTrue(checkoutStepTwoPage.isPaymentInformationVisible(), "Verifying that payment information is visible");
        soft.assertTrue(checkoutStepTwoPage.isItemsTotalPriceVisible(), "Verifying that items total price is visible");
        soft.assertAll();
    }

    public CheckoutStepTwoFacade finishCheckout() {
        checkoutStepTwoPage.finishCheckout();
        return this;
    }

    public CheckoutStepTwoFacade cancelCheckout() {
        checkoutStepTwoPage.cancelCheckout();
        return this;
    }

    public CheckoutStepTwoFacade clickOnItemTitle(int position) {
        List<WebElement> cartItems = checkoutStepTwoPage.getCartItems();
        WebElement item = cartItems.get(position);
        this.redirectItemId = checkoutStepTwoPage.getItemId(item);
        checkoutStepTwoPage.openItem(item);
        return this;
    }

    public void verifyRedirectTo(String redirectedToUrl) {
        String currentUrl = checkoutStepTwoPage.getCurrentUrl();
        assertEquals(currentUrl, redirectedToUrl,
                "Verifying that user is redirected to the checkout complete page."
        );
        checkoutStepTwoPage.goToPreviousPage();

    }

    public void verifyRedirectToCorrespondingItemPage() {
        String expectedUrl = "https://www.saucedemo.com/inventory-item.html?id=" + this.redirectItemId;
        String actualUrl = checkoutStepTwoPage.getCurrentUrl();

        assertEquals(actualUrl, expectedUrl, "Verifying that pressing on item title lead to right item page.");
        checkoutStepTwoPage.goToPreviousPage();
    }
}
