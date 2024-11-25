package swaglabs.constants;

public class ErrorConstants {

    public enum ErrorType {
        USERNAME_REQUIRED("Epic sadface: Username is required"),
        PASSWORD_REQUIRED("Epic sadface: Password is required"),
        INVALID_USERNAME_OR_PASSWORD("Epic sadface: Username and password do not match any user in this service"),
        USER_LOCKED("Epic sadface: Sorry, this user has been locked out.");

        private final String message;

        ErrorType(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }
}

