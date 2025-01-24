package com.fetchbrowser.app.controller;

import com.fetchbrowser.app.core.Browser;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.web.WebView;

import java.util.Arrays;

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

    public void txtSearchOnAction(ActionEvent actionEvent) {
        String url = txtSearch.getText();
        if (url.isBlank()) return;
        loadWebPage(url.strip());
    }

    private void loadWebPage(String url) {
        String protocol = "";
        String host = "";
        String path = "";
        int port = -1;

        String[] urlParts = Browser.splitUrl(url);

    }


}
