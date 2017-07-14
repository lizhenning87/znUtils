package com.uesugi.library.utils;

/**
 * Created by lizhenning on 2017/1/4.
 */

public class HttpErrorBean {


    private String message;
    private int status_code;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus_code() {
        return status_code;
    }

    public void setStatus_code(int status_code) {
        this.status_code = status_code;
    }
}
