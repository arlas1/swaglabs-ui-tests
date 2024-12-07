package swaglabs.facades;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import swaglabs.constants.PageUrl;
import swaglabs.utils.CustomSoftAssert;
import ui.pages.cartPage.CartPage;

import java.util.List;

import static swaglabs.constants.PageUrl.CART_PAGE;
import static swaglabs.utils.CustomAssert.*;

public class CartFacade {
    private final CartPage cartPage;
    private final CustomSoftAssert soft;
    public InventoryFacade inventoryFacade;
    private int redirectItemId;


    public CartFacade(WebDriver driver) {
        this.cartPage = new CartPage(driver);
        inventoryFacade = new InventoryFacade(driver);
        this.soft = new CustomSoftAssert();
    }

    public CartFacade clickOnItemTitle(int position) {
        List<WebElement> cartItems = cartPage.getCartItems();
        WebElement item = cartItems.get(position);
        this.redirectItemId = cartPage.getItemId(item);
        cartPage.openItem(item);
        return this;
    }

    public CartFacade continueShopping() {
        cartPage.continueShopping();
        return this;
    }

    public CartFacade goToCheckout() {
        cartPage.goToCheckout();
        return this;
    }

    public CartFacade removeLastItemFromCart() {
        WebElement item = cartPage.getCartItems().getLast();
        cartPage.removeItem(item);
        return this;
    }

    public CartFacade verifyYourCartPageTitleIsVisible(){
        soft.assertTrue(cartPage.isYourCartTitleVisible(), "Verifying that 'Your Cart' page title is visible.");
        return this;
    }

    public CartFacade verifyQtyLabelIsVisible(){
        soft.assertTrue(cartPage.isQtyLabelVisible(), "Verifying that 'Qty' label is visible.");
        return this;
    }

    public CartFacade verifyDescriptionLabelIsVisible(){
        soft.assertTrue(cartPage.isDescriptionLabelVisible(), "Verifying that 'Description' label is visible.");
        soft.assertAll();
        return this;
    }

    public CartFacade verifyItemTitleIsVisible(WebElement item){
        assertTrue(cartPage.isItemTitleVisible(item), "Verifying that item title is visible.");
        return this;
    }

    public CartFacade verifyItemDescriptionIsVisible(WebElement item){
        assertTrue(cartPage.isItemDescriptionVisible(item), "Verifying that item description is visible.");
        return this;
    }

    public CartFacade verifyItemPriceIsVisible(WebElement item){
        assertTrue(cartPage.isItemPriceVisible(item), "Verifying that item price is visible.");
        return this;
    }

    public CartFacade verifyItemsQtyTitleDescriptionPriceAreVisible() {
        List<WebElement> cartItems = cartPage.getCartItems();
        for (WebElement item : cartItems) {
            verifyItemTitleIsVisible(item);
            verifyItemDescriptionIsVisible(item);
            verifyItemPriceIsVisible(item);
        }
        return this;
    }

    public void verifyAllItemsTitlesChangeColorOnHover() {
        List<WebElement> cartItems = cartPage.getCartItems();
        for (WebElement item : cartItems) {
            assertTrue(cartPage.isItemTitleColorChangedOnHover(item), "Verifying that item title is visible.");
        }
    }

    public CartFacade verifyRedirectTo(String redirectUrl) {
        String currentUrl = cartPage.getCurrentUrlWithoutParameters();
        assertEquals(currentUrl, redirectUrl,
                "Verifying that user is redirected to '" + redirectUrl + "'."
        );
        cartPage.goToPreviousPage();
        return this;
    }

    public void verifyRedirectToCorrespondingItemPage() {
        String expectedUrl = "https://www.saucedemo.com/inventory-item.html?id=" + this.redirectItemId;
        String actualUrl = cartPage.getCurrentUrl();

        assertEquals(actualUrl, expectedUrl, "Verifying that pressing on item title lead to right item page.");
        cartPage.openUrl(CART_PAGE);
    }
}
