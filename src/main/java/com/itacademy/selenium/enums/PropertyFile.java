package com.itacademy.selenium.enums;

public enum PropertyFile {

    CONFIG("config.properties");
//    USER("user.properties");

    private String pathToFile;

    PropertyFile(String pathToFile) {
        this.pathToFile = pathToFile;
    }

    public String getPathToFile() {
        return pathToFile;
    }
}
