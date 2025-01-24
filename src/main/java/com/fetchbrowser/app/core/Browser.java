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

        //host
        String urlWithoutProtocol = hasProtocol ? url.substring(i + 3) : url;
        boolean hasPort = false;
        int j = -1, k = -1, l = -1;
        j = urlWithoutProtocol.indexOf(":");
        if (j != -1) {
            host = urlWithoutProtocol.substring(0, j);
            hasPort = true;
        } else if ((k = urlWithoutProtocol.indexOf("/")) != -1) {
            host = urlWithoutProtocol.substring(0, k);
        } else if ((l = urlWithoutProtocol.indexOf("?")) != -1) {
            host = urlWithoutProtocol.substring(0, l);
        } else {
            host = urlWithoutProtocol;
        }

        System.out.println("Protocol : " + protocol);
        System.out.println("Host : " + host);
        System.out.println("Port : " + port);
//        System.out.println("Path : " + path);

        return new String[] { url };
    };

}
