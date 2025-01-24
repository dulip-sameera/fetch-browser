package com.fetchbrowser.app.util;

import java.io.InputStream;

public class ImagePaths {

    public enum Path {
        APP_ICON
    }

    public static String get(Path path) {
        return switch (path) {
          case APP_ICON -> "/images/app-icon.png";
          default -> null;
        };
    }

    public static InputStream getAsStream(Path path) {
        return switch (path) {
            case APP_ICON -> ImagePaths.class.getResourceAsStream("/image/app-icon.png");
            default -> null;
        };
    }
}
