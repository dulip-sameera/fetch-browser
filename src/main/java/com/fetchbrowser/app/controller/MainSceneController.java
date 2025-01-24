package com.fetchbrowser.app.controller;

import javafx.application.Platform;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.web.WebView;

public class MainSceneController {
    public AnchorPane root;
    public ImageView imgSearch;
    public TextField txtSearch;
    public WebView wbDisplay;

    public void initialize() {
        txtSearch.setText("http://www.google.com");
        txtSearch.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                Platform.runLater(() -> txtSearch.selectAll());
            }
        });
    }

    public void imgSearchOnMouseClicked(MouseEvent mouseEvent) {
        txtSearch.requestFocus();
    }
}
