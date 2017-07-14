package com.uesugi.library.utils;

import com.google.gson.Gson;

import java.io.IOException;

import retrofit2.adapter.rxjava.HttpException;

/**
 * Created by lizhenning on 2017/1/4.
 */

public class HttpErrorHandler {

    public static HttpErrorBean handle(Throwable throwable) {

        if (throwable instanceof HttpException) {
            HttpException error = (HttpException) throwable;
            try {
                return new Gson().fromJson(error.response().errorBody().string(),
                        HttpErrorBean.class);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            throwable.printStackTrace();
        }
        return null;
    }

}
