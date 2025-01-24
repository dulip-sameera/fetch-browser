package com.fetchbrowser.app.util;

import javafx.fxml.FXMLLoader;

public class AppRouter {

    public enum Routes {
        MAIN
    }

    public static FXMLLoader getLoader(Routes route) {
        return switch (route) {
            case MAIN -> new FXMLLoader(AppRouter.class.getResource("/scene/MainScene.fxml"));
            default -> null;
        };
    }
}
