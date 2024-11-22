package ui.page.itemPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ItemPageElements {

    @FindBy(id = "back-to-products")
    protected WebElement backToProductsButton;

    @FindBy(className = "inventory_details_img")
    protected WebElement itemImage;

    @FindBy(className = "inventory_details_name")
    protected WebElement itemTitle;

    @FindBy(className = "inventory_details_desc")
    protected WebElement itemDescription;

    @FindBy(className = "inventory_details_price")
    protected WebElement itemPrice;

    @FindBy(id = "add-to-cart")
    protected WebElement itemAddToCartButton;

    @FindBy(id = "remove")
    protected WebElement itemRemoveButton;

    public ItemPageElements(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
