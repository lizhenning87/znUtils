package com.uesugi.library.utils;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lizhenning on 2016/12/28.
 *
 * 唯思科技
 *
 * 路由协议,当前使用隐式启动activity
 *
 * v1.0
 */

public class UesugiRouteHelper {

    private String TAG = "UesugiRouteHelper";

    private static final UesugiRouteHelper singleton = new UesugiRouteHelper();

    private String DEFAULT_SCHEMA = "uesugi";

    /**
     * 是否需要登录
     */
    private static String IS_AUTH = "is_auth";

    private UesugiRouteHelper() {

    }

    public static UesugiRouteHelper getSingleton() {
        return singleton;
    }

    /**
     *
     * 注册协议头
     *
     * @param schema
     */

    public void registerSchema(String schema) {
        this.DEFAULT_SCHEMA = schema;
    }

    /**
     *
     * 解析
     *
     * 例如 ebusiness://goodsdetail?category_id=1&is_auth=1
     *
     * @param router
     * @return
     */

    public boolean parser(Context context, String router) {


        if (!schemaName(router).equals(DEFAULT_SCHEMA))
        {
            return false;
        }

        String activity = activityName(router);
        Map<String, String > map = parameters(router);

        try {

            Intent intent = new Intent();

            String action = context.getPackageName() + "." + activity;

            intent.setAction(action);

            if (map != null && !map.isEmpty())
            {
                for (Map.Entry<String, String> entry : map.entrySet())
                {
                    intent.putExtra(entry.getKey(), entry.getValue());
                }
            }

            context.startActivity(intent);

            
        }catch (Exception exception) {

            Log.e(TAG, exception.getMessage());

            return false;
        }

        return true;
    }


    /**
     *
     * 解析请求标志
     *
     * @param url
     * @return
     */

    private String[] schema(String url) {

        String[] strings = url.split("://");

        return strings;
    }

    private String schemaName(String url) {

        String string = "";

        if (schema(url) != null)
        {
            string = schema(url)[0];
        }

        return string;
    }


    /**
     *
     * 获取Activity
     *
     * @param url
     * @return
     */

    private String[] activity(String url) {

        try {

            String activity = schema(url)[1];

            String[] activitys = activity.split("\\?");

            return activitys;

        }catch (Exception exception) {

        }

        return null;
    }

    private String activityName(String url) {

        String string = "";

        if (activity(url) != null)
        {
            string = activity(url)[0];
        }

        return string;
    }


    private Map<String, String> parameters (String url) {

        try {

            String paramter = activity(url)[1];
            String[] paramters = paramter.split("&");

            Map<String, String> map = new HashMap<>();

            for (String string : paramters)
            {
                try{

                    String[] temp = string.split("=");

                    map.put(temp[0], temp[1]);

                }catch (Exception exception) {

                }
            }

            return map;

        }catch (Exception exception) {


        }

        return null;
    }

}
