package com.uesugi.library.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by lizhenning on 2017/4/27.
 */

public class UserDefaultHelper {

    public static String SP_KEY = "com.uesugi.library.preferences";
    public static String PRE = "uesugi_";

    public static void saveValue(Context context, String key, String value) {

        SharedPreferences preferences = context.getSharedPreferences(SP_KEY, Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = preferences.edit();

        editor.putString(PRE + key, value);

        editor.commit();

    }

    public static String getValue(Context context, String key) {

        SharedPreferences preferences = context.getSharedPreferences(SP_KEY, Context.MODE_PRIVATE);
        return preferences.getString(PRE + key, null);

    }

    public static void clearValue(Context context, String key) {

        SharedPreferences preferences = context.getSharedPreferences(SP_KEY, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.remove(PRE + key);
        editor.commit();

    }

}
