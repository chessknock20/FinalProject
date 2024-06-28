package org.example.selenium.enums;

public enum Capability {

    BROWSER("browser", "chrome"),
    LOGIN("login", "chessknock20@gmail.com"),
    PASSWORD("password", "110v354m");

    private String key;
    private String defaultValue;

    Capability(String key, String defaultValue) {
        this.key = key;
        this.defaultValue = defaultValue;
    }

    public String getKey() {
        return key;
    }

    public String getDefaultValue() {
        return defaultValue;
    }
}
