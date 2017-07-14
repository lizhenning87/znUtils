package com.uesugi.library.utils.views.adapter;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.uesugi.library.R;

import java.util.ArrayList;

/**
 * Created by lizhenning on 2017/7/14.
 */

public class SliderAdapter extends LoopVPAdapter<Object> {

    public SliderAdapter(Context context, ArrayList<Object> datas, ViewPager viewPager) {

        super(context, datas, viewPager);

    }

    private ViewGroup.LayoutParams layoutParams;

    @Override
    protected View getItemView(Object data) {
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        }

        ImageView imageView = new ImageView(mContext);
        imageView.setLayoutParams(layoutParams);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);

        if (data instanceof String)
        {
            Glide.with(mContext).load((String) data).into(imageView);
        }else if (data instanceof Integer)
        {
            imageView.setImageResource((int)data);
        }

        return imageView;
    }


}
