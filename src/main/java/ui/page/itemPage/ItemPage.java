package ui.page.itemPage;

import org.openqa.selenium.WebDriver;
import ui.page.BasePage;
import ui.page.inventoryPage.InventoryPage;

public class ItemPage extends BasePage {
    private final ItemPageElements elements = new ItemPageElements(driver);

    public ItemPage(WebDriver driver) {
        super(driver);
    }

    public InventoryPage goBackToProducts() {
        customActions.click(elements.backToProductsButton, "back to products button");
        return new InventoryPage(driver);
    }

    public ItemPage addItemToCart() {
        customActions.click(elements.itemAddToCartButton, "add to cart button");
        return this;
    }

    public ItemPage removeItemFromCart() {
        customActions.click(elements.itemRemoveButton, "remove from cart button");
        return this;
    }

    public ItemPage hoverOverItemTitle() {
        customActions.moveToElement(elements.itemTitle, "item title");
        return this;
    }

    public boolean isItemImageVisible() {
        return customActions.explicitWaitForVisibility(elements.itemImage, "item image");
    }

    public boolean isItemDescriptionVisible() {
        return customActions.explicitWaitForVisibility(elements.itemDescription, "item description");
    }

    public boolean isItemPriceVisible() {
        return customActions.explicitWaitForVisibility(elements.itemPrice, "item price");
    }
}
