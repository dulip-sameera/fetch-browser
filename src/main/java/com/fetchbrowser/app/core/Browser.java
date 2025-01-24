package com.fetchbrowser.app.core;

public class Browser {

    public static String[] splitUrl(String url) {
        String protocol = "http";
        String host = "";
        int port = -1;
        String path = "/";

        // protocol
        int i = url.indexOf("://");
        boolean hasProtocol = false;
        if (i != -1) {
            protocol = url.substring(0, i);
            hasProtocol = true;
        }

        // change default port according to the protocol
        port = switch (protocol) {
            case "http" -> 80;
            case "https" -> 443;
            case null, default -> -1;
        };

        return new String[] { url };
    };

}
