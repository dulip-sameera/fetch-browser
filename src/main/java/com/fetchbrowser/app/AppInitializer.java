package com.fetchbrowser.app;

import com.fetchbrowser.app.util.AppRouter;
import com.fetchbrowser.app.util.ImagePaths;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class AppInitializer extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        try {
            Scene mainScene = new Scene(AppRouter.getLoader(AppRouter.Routes.MAIN).load());
            Image appIcon = new Image(ImagePaths.getAsStream(ImagePaths.Path.APP_ICON));
            primaryStage.setScene(mainScene);
            primaryStage.getIcons().add(appIcon);
            primaryStage.setTitle("Fetch Browser");
            primaryStage.show();
            primaryStage.centerOnScreen();
        } catch (IOException e) {
            System.out.println("Failed to load main scene" + e.getMessage());
            Platform.exit();
        }
    }
}
