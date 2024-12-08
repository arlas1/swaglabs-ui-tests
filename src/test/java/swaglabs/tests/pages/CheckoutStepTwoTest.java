package swaglabs.tests.pages;

import listener.TestListener;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import swaglabs.facades.CheckoutStepTwoFacade;
import swaglabs.tests.setup.SetUp;

import static swaglabs.constants.PageUrl.*;

@Listeners(TestListener.class)
public class CheckoutStepTwoTest extends BaseTest {
    private CheckoutStepTwoFacade checkoutStepTwoFacade;

    @BeforeClass
    public void loginToAccessInventoryPage_ThenOpenItemPage_ThenOpenCartPage_ThenProceedToCheckoutStepOne_ThenProceedToCheckoutStepTwo() {
        SetUp setUp = new SetUp(driver);
        setUp.loginAsStandardUser()
                .addTwoItemsToCartAndOpenCart()
                .proceedToCheckoutStepOne()
                .proceedToCheckoutStepTwo();
        this.checkoutStepTwoFacade = new CheckoutStepTwoFacade(driver);
    }

    @Test(priority = 1)
    public void givenOrderSummaryText_WhenCheckoutStepTwoPageIsLoaded_ThenSummaryIsVisible() {
        checkoutStepTwoFacade.verifyOrderSummaryIsVisible();
    }

    @Test(priority = 2)
    public void givenCancelButton_WhenClickedOn_ThenUserIsRedirectedToInventoryPage() {
        checkoutStepTwoFacade
                .cancelCheckout()
                .verifyRedirectTo(INVENTORY_PAGE);
    }

    @Test(priority = 3)
    public void givenFirstItemsOnCartTitle_WhenClickedOn_ThenUserIsRedirectedToCorrespondingItemPage() {
        checkoutStepTwoFacade
                .clickOnItemTitle(0)
                .verifyRedirectToCorrespondingItemPage();
    }

    @Test(priority = 4)
    public void givenFinishButton_WhenClickedOn_ThenUserIsRedirectedToCheckoutCompletePage() {
        checkoutStepTwoFacade
                .finishCheckout()
                .verifyRedirectTo(CHECKOUT_COMPLETE_PAGE);
    }
}
