package swaglabs.tests.pages;

import listener.TestListener;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import swaglabs.facades.CheckoutCompleteFacade;
import swaglabs.tests.setup.SetUp;

import static swaglabs.constants.PageUrl.*;

@Listeners(TestListener.class)
public class CheckoutCompleteTest extends BaseTest {
    private CheckoutCompleteFacade checkoutCompleteFacade;

    @BeforeClass
    public void loginToAccessInventoryPage_ThenOpenItemPage_ThenOpenCartPage_ThenProceedToCheckoutStepOne_ThenProceedToCheckoutStepTwo_ThenFinishCheckout() {
        SetUp setUp = new SetUp(driver);
        setUp
             .loginAsStandardUser()
             .addTwoItemsToCartAndOpenCart()
             .proceedToCheckoutStepOne()
             .proceedToCheckoutStepTwo()
             .finishCheckout();
        this.checkoutCompleteFacade = new CheckoutCompleteFacade(driver);
    }

    @Test
    public void givenConfirmationMessage_WhenCheckoutCompletePageIsLoaded_ThenMessageIsVisible() {
        checkoutCompleteFacade.verifyConfirmationMessageIsVisible();
    }

    @Test
    public void givenBackHomeButton_WhenClickedOn_ThenUserIsRedirectedToInventoryPage() {
        checkoutCompleteFacade
                .goBackToInventoryPage()
                .verifyRedirectTo(INVENTORY_PAGE);
    }
}
