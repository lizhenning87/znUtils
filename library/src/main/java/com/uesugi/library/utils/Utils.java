package com.uesugi.library.utils;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by lizhenning on 2016/12/25.
 */

public class Utils {

    public static String url_base = "";

    public static String getUrl_base() {
        return url_base;
    }

    public static void setUrl_base(String url_base) {
        Utils.url_base = url_base;
    }

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

        /**
         *
         * 检查是否为空
         * @param string
         * @return
         */

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


        /**
         *
         * 检查应用是否安装
         * @param context
         * @param packageName
         * @return
         */

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


        /**
         *
         * 将assets中的文件复制到指定地方
         * @param context
         * @param fileName
         * @param path
         * @return
         */

        public static boolean copyApkFromAssets(Context context, String fileName, String path) {
            boolean copyIsFinish = false;
            try {
                InputStream is = context.getAssets().open(fileName);
                File file = new File(path);
                file.createNewFile();
                FileOutputStream fos = new FileOutputStream(file);
                byte[] temp = new byte[1024];
                int i = 0;
                while ((i = is.read(temp)) > 0) {
                    fos.write(temp, 0, i);
                }
                fos.close();
                is.close();
                copyIsFinish = true;
            } catch (IOException e) {
                e.printStackTrace();
            }
            return copyIsFinish;
        }


        /**
         *
         * 安装apk
         *
         * @param context
         * @param path
         */

        public static void installApk(Context context, String path) {

            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.setDataAndType(Uri.parse("file://" + path), "application/vnd.android.package-archive");
            context.startActivity(intent);
        }

    }

}
