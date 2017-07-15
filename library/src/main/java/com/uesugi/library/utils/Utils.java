package com.uesugi.library.utils;

import android.content.Context;
import android.content.pm.PackageManager;
import android.widget.Toast;

/**
 * Created by lizhenning on 2016/12/25.
 */

public class Utils {

    public final static String url_base = "";

    private static Toast toast;

    public static void showShortToast(Context context, String content) {

        if (toast == null) {
            toast = Toast.makeText(context, content, Toast.LENGTH_SHORT);
        } else {
            toast.setText(content);
        }
        toast.show();
    }

    public static String encodeUrlParam(String param){
        return param.replace("/","%%");
    }

    public static String decodeUrlParam(String param){
        return param.replace("%%","/");
    }

    public static class StringUtils {

        public static boolean isEmpty(String string) {

            boolean ret = false;

            if (string == null || string.equals(""))
            {
                ret = true;
            }

            return ret;
        }

    }

    public static class App {

        public static boolean checkAppInstall(Context context, String packageName) {

            boolean ret = false;

            PackageManager pm = context.getPackageManager();
            try {

                pm.getPackageInfo(packageName, PackageManager.GET_ACTIVITIES);
                ret = true;

            }catch (PackageManager.NameNotFoundException e) {

            }

            return ret;
        }

    }

}
