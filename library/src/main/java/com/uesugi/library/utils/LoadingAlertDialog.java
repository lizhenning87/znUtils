package com.uesugi.library.utils;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.uesugi.library.R;

/**
 * Created by lizhenning on 2016/12/25.
 */

public class LoadingAlertDialog extends AlertDialog {

    private Context context;
    private ImageView ivLoading;
    private RelativeLayout layoutBackground;
    private AnimationDrawable animationDrawable;

    public LoadingAlertDialog(Context context) {
        super(context, R.style.library_loaddialog);
        this.context = context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.library_layout_loading);

        layoutBackground = (RelativeLayout)findViewById(R.id.library_layout_loading);
        ivLoading = (ImageView)findViewById(R.id.library_iv_loading);
        ivLoading.setBackgroundResource(R.drawable.library_animation_list);
        animationDrawable = (AnimationDrawable)ivLoading.getBackground();
        animationDrawable.setOneShot(false);

        setCanceledOnTouchOutside(false);
    }

    public void show() {

        super.show();
        animationDrawable.start();

    }



    public void hide() {

        super.hide();

        animationDrawable.stop();

    }


}
