package swaglabs.constants;

public class PageUrlConstants {

    public enum PageUrl {
        LOGIN_PAGE_URL("https://www.saucedemo.com/"),
        INVENTORY_PAGE_URL("https://www.saucedemo.com/inventory.html"),
        CART_PAGE_URL("https://www.saucedemo.com/cart.html"),
        CHECKOUT_STEP_ONE_PAGE_URL("https://www.saucedemo.com/checkout-step-one.html"),
        CHECKOUT_STEP_TWO_PAGE_URL("https://www.saucedemo.com/checkout-step-two.html"),
        CHECKOUT_COMPLETE_PAGE_URL("https://www.saucedemo.com/checkout-complete.html"),
        SAUCELABS_PAGE_URL("https://saucelabs.com/"),
        FACEBOOK_PAGE_URL("https://www.facebook.com/saucelabs"),
        TWITTER_PAGE_URL("https://x.com/saucelabs"),
        LINKEDIN_PAGE_URL("https://www.linkedin.com/company/sauce-labs/");

        private final String url;

        PageUrl(String url) {
            this.url = url;
        }

        public String getUrl() {
            return url;
        }
    }
}