package ui.pages.inventoryItemPage;

import org.openqa.selenium.WebDriver;
import ui.pages.BasePage;
import ui.pages.inventoryPage.InventoryPage;

public class InventoryItemPage extends BasePage {
    private final InventoryItemPageElements elements = new InventoryItemPageElements(driver);

    public InventoryItemPage(WebDriver driver) {
        super(driver);
    }

    public InventoryPage goBackToProducts() {
        click(elements.backToProductsButton, "back to products button");
        return new InventoryPage(driver);
    }

    public InventoryItemPage addItemToCart() {
        click(elements.itemAddToCartButton, "add to cart button");
        return this;
    }

    public InventoryItemPage removeItemFromCart() {
        click(elements.itemRemoveButton, "remove from cart button");
        return this;
    }

    public InventoryItemPage isItemTitleTextColorChangedOnHover() {
        isTextColorChangedOnHover(elements.itemTitle, "item title");
        return this;
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
