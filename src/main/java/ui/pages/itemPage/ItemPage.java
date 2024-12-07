package ui.pages.itemPage;

import org.openqa.selenium.WebDriver;
import ui.pages.BasePage;
import ui.pages.inventoryPage.InventoryPage;

public class ItemPage extends BasePage {
    private final ItemPageElements elements = new ItemPageElements(driver);

    public ItemPage(WebDriver driver) {
        super(driver);
    }

    public InventoryPage goBackToProducts() {
        click(elements.backToProductsButton, "back to products button");
        return new InventoryPage(driver);
    }

    public ItemPage addItemToCart() {
        click(elements.itemAddToCartButton, "add to cart button");
        return this;
    }

    public ItemPage removeItemFromCart() {
        click(elements.itemRemoveButton, "remove from cart button");
        return this;
    }

    public boolean isItemTitleVisible() {
        return explicitWaitForVisibility(elements.itemTitle, "item title");
    }

    public boolean isItemImageVisible() {
        return explicitWaitForVisibility(elements.itemImage, "item image");
    }

    public boolean isItemDescriptionVisible() {
        return explicitWaitForVisibility(elements.itemDescription, "item description");
    }

    public boolean isItemPriceVisible() {
        return explicitWaitForVisibility(elements.itemPrice, "item price");
    }
}
