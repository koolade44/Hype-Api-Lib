package com.koolade446.hypeapi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ApiRequest {
    String uuid;
    String key;
    String endpoint;

    public ApiRequest() {}

    public ApiRequest withEndpoint(ApiEndpoint endpoint) {
        this.endpoint = endpoint.toString();
        return this;
    }

    public ApiRequest withUUID(String uuid) {
        this.uuid = uuid;
        return this;
    }

    public ApiRequest withKey(String key) {
        this.key = key;
        return this;
    }

    public ApiResponse sendRequest() throws IOException, MissingFieldException {
        try {
            if (endpoint == null) {
                throw new MissingFieldException("Missing endpoint!");
            }
            StringBuilder sb = new StringBuilder();
            sb.append("https://api.hypixel.net/");
            sb.append(endpoint);
            if (uuid != null) sb.append("?uuid=" + uuid);
            if (key != null) {
                if (uuid != null) {
                    sb.append("&key=" + key);
                } else {
                    sb.append("?key=" + key);
                }
            }
            URL url = new URL(sb.toString());
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String line;

            StringBuilder outputString = new StringBuilder();

            while ((line = br.readLine()) != null) {
                outputString.append(line);
            }

            return new ApiResponse(outputString.toString());
        }
        catch (IOException e) {
            if (e.getMessage().contains("Server returned HTTP response code: 400")) {
                throw new MissingFieldException("Missing 1 or more fields! Try adding .withKey or .withUUID");
            }
        }
        return null;
    }
}
