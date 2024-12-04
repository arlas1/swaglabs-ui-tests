package swaglabs.constants;

public enum PageUrl {
    LOGIN_PAGE("https://www.saucedemo.com/"),
    INVENTORY_PAGE("https://www.saucedemo.com/inventory.html"),
    CART_PAGE("https://www.saucedemo.com/cart.html"),
    CHECKOUT_STEP_ONE_PAGE("https://www.saucedemo.com/checkout-step-one.html"),
    CHECKOUT_STEP_TWO_PAGE("https://www.saucedemo.com/checkout-step-two.html"),
    CHECKOUT_COMPLETE_PAGE("https://www.saucedemo.com/checkout-complete.html"),
    SAUCELABS_PAGE("https://saucelabs.com/"),
    FACEBOOK_PAGE("https://www.facebook.com/saucelabs"),
    TWITTER_PAGE("https://x.com/saucelabs"),
    LINKEDIN_PAGE("https://www.linkedin.com/company/sauce-labs/");

    private final String url;

    PageUrl(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}