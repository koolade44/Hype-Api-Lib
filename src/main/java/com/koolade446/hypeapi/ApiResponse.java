package com.koolade446.hypeapi;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class ApiResponse {
    String unparsedJson;

    JSONObject jso;


    public ApiResponse(String unparsedJson) throws MissingFieldException {
        this.unparsedJson = unparsedJson;

        jso = new JSONObject(unparsedJson);
    }

    public JSONObject getJsonObject() {
        return jso;
    }

    public String getRawJson() {
        return unparsedJson;
    }

    public ApiMap getParsedMap() {
        return new ApiMap(jso.toMap());
    }
}
