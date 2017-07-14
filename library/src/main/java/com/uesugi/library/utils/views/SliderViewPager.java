package com.uesugi.library.utils.views;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;

import com.uesugi.library.R;
import com.uesugi.library.utils.views.adapter.LoopVPAdapter;
import com.uesugi.library.utils.views.adapter.SliderAdapter;

import java.util.ArrayList;

/**
 * Created by lizhenning on 2017/7/14.
 */

public class SliderViewPager extends RelativeLayout {

    private ViewPager viewPager;

    public SliderViewPager(Context context) {
        super(context);
    }

    public SliderViewPager(Context context, AttributeSet attrs) {

        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.library_layout_slide, this);

    }


    public void addUrls(Context context, ArrayList<String> list) {

        viewPager = (ViewPager)findViewById(R.id.slide_container);
        new SliderAdapter(context, list, viewPager);

    }


}
