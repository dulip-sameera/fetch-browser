package com.fetchbrowser.app.core;

public class Browser {

    public static String[] splitUrl(String url) {
        String protocol = "http";
        String host = null;
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

        // port
        String urlWithOutHost = urlWithoutProtocol.substring(host.length());
        if (hasPort) {
            int m = -1;
            if ((m = urlWithOutHost.indexOf("/")) != -1) {
                port = Integer.valueOf(urlWithOutHost.substring(1, m));
            } else if ((m = urlWithOutHost.indexOf("?")) != -1) {
                port = Integer.valueOf(urlWithOutHost.substring(1, m));
            } else {
                port = Integer.valueOf(urlWithOutHost.substring(1));
            }
        }

        // path
        String urlWithOutPort = hasPort ? urlWithOutHost.substring(String.valueOf(port).length() + 1) : urlWithOutHost;
        if (!urlWithOutPort.isEmpty()) {
            path = urlWithOutPort;
        }

        return new String[] { protocol, host, String.valueOf(port), path };
    };

}
