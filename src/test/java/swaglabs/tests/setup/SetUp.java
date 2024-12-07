package swaglabs.tests.setup;

import org.openqa.selenium.WebDriver;
import swaglabs.constants.Credentials;
import swaglabs.constants.InputDetails;
import swaglabs.facades.*;

public class SetUp {
    private WebDriver driver;

    public SetUp(WebDriver driver) {
        this.driver = driver;
    }

    public SetUp loginAsStandardUser() {
        LoginFacade loginPageFacade = new LoginFacade(driver);
        loginPageFacade
                .enterValidUsername(Credentials.Usernames.STANDARD_USER)
                .enterValidPassword()
                .login();
        return this;
    }

    public SetUp openItemPage() {
        InventoryFacade inventoryFacade = new InventoryFacade(driver);
        inventoryFacade.clickOnItemTitle(0);
        return this;
    }

    public SetUp addTwoItemsToCartAndOpenCart() {
        InventoryFacade inventoryFacade = new InventoryFacade(driver);
        inventoryFacade
                .addItemToCart()
                .addItemToCart()
                .openCart();
        return this;
    }

    public SetUp proceedToCheckoutStepOne() {
        CartFacade cartFacade = new CartFacade(driver);
        cartFacade.goToCheckout();
        return this;
    }

    public SetUp proceedToCheckoutStepTwo() {
        String zipPostalCode = "11211";
        CheckoutStepOneFacade cartFacade = new CheckoutStepOneFacade(driver);
        cartFacade
                .enterRandomLastName(InputDetails.InputType.ALPHABET, InputDetails.InputLength.SHORT)
                .enterRandomFirstName(InputDetails.InputType.ALPHABET, InputDetails.InputLength.SHORT)
                .enterZipPostalCode(zipPostalCode)
                .continueCheckout();
        return this;
    }

    public SetUp finishCheckout() {
        CheckoutStepTwoFacade checkoutStepTwoFacade = new CheckoutStepTwoFacade(driver);
        checkoutStepTwoFacade.finishCheckout();
        return this;
    }
}
