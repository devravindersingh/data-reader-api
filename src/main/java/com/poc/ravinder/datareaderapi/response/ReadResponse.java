package com.poc.ravinder.datareaderapi.response;

import com.poc.ravinder.datareaderapi.model.State;

import java.util.List;

public class ReadResponse {
    private String errorMsg;
    private String responseCode;
    private List<State> responseList;

    public ReadResponse(String errorMsg, String responseCode, List<State> responseList) {
        this.errorMsg = errorMsg;
        this.responseCode = responseCode;
        this.responseList = responseList;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public List<State> getResponseList() {
        return responseList;
    }

    public void setResponseList(List<State> responseList) {
        this.responseList = responseList;
    }
}
