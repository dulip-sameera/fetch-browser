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

        protocol = urlParts[0];
        host = urlParts[1];
        port = Integer.parseInt(urlParts[2]);
        path = urlParts[3];

        if (host == null || port == -1) {
            displayError("-1", "Invalid URL");
            return;
        }

    }

    private void displayError(String code, String error) {
        String display = Integer.parseInt(code) == -1 ? "none" : "block";
        String html = """
                <!DOCTYPE html>
                       <html lang="en">
                       <head>
                         <meta charset="UTF-8">
                         <meta name="viewport" content="width=device-width, initial-scale=1.0">
                         <title>Error</title>
                         <style>
                           body {
                             font-family: Arial, sans-serif;
                             background-color: #f8f9fa;
                             color: #333;
                             display: flex;
                             justify-content: center;
                             align-items: center;
                             height: 100vh;
                             margin: 0;
                             text-align: center;
                           }
                           .error-container {
                             max-width: 600px;
                             padding: 20px;
                             border: 1px solid #ddd;
                             border-radius: 8px;
                             background: #fff;
                             box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
                           }
                           h1 {
                             font-size: 2rem;
                             margin-bottom: 10px;
                             color: #d9534f;
                           }
                           p {
                             font-size: 1rem;
                             margin-bottom: 15px;
                             color: #666;
                           }
                           a {
                             text-decoration: none;
                             color: #007bff;
                             font-weight: bold;
                           }
                           a:hover {
                             text-decoration: underline;
                           }
                         </style>
                       </head>
                       <body>
                         <div class="error-container">
                           <h1>Error Occurred</h1>
                           <p>Something went wrong while processing your request.</p>
                           <p style="display: %s"><span class="code">Error Code:</span> %s</p>
                           <p><span class="code">Details:</span> %s</p>
                           <p style="display: %s"><a href="javascript:history.back()">Go Back</a> or <a href="/">Return to Home</a></p>
                         </div>
                       </body>
                       </html>
                """.formatted(display, code, error, display);
        wbDisplay.getEngine().loadContent(html);
    }


}
