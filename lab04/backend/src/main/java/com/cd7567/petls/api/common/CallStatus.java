package com.cd7567.petls.api.common;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CallStatus {

    @JsonProperty("status")
    private Integer status;

    @JsonProperty("message")
    private String message;

    public CallStatus(Integer status, String message) {
        this.status = status;
        this.message = message;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
