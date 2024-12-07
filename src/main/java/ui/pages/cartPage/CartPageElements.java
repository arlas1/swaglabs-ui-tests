package ui.pages.cartPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CartPageElements {

    @FindBy(className = "title")
    protected WebElement yourCartText;

    @FindBy(className = "cart_quantity_label")
    protected WebElement qtyText;

    @FindBy(className = "cart_desc_label")
    protected WebElement descriptionText;

    @FindBy(css = "div.cart_item")
    protected List<WebElement> cartItems;

    @FindBy(id = "continue-shopping")
    protected WebElement continueShoppingButton;

    @FindBy(id = "checkout")
    protected WebElement checkoutButton;

    protected CartPageElements(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
