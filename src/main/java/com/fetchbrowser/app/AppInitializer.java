package com.fetchbrowser.app;

import com.fetchbrowser.app.util.AppRouter;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class AppInitializer extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        try {
            Scene mainScene = new Scene(AppRouter.getLoader(AppRouter.Routes.MAIN).load());
            primaryStage.setScene(mainScene);
            primaryStage.setTitle("Fetch Browser");
            primaryStage.show();
            primaryStage.centerOnScreen();
        } catch (IOException e) {
            System.out.println("Failed to load main scene" + e.getMessage());
            Platform.exit();
        }
    }
}
