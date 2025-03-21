package com.cd7567.petls.api.common;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BaseResponse<T> {

    @JsonProperty("status")
    private CallStatus status;

    @JsonProperty("result")
    private T result;

    public BaseResponse(CallStatus status, T result) {
        this.status = status;
        this.result = result;
    }

    public CallStatus getStatus() {
        return status;
    }

    public void setStatus(CallStatus status) {
        this.status = status;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public static <T> BaseResponse<T> wrap(T result) {
        return new BaseResponse<T>(new CallStatus(200, "OK"), result);
    }
}

