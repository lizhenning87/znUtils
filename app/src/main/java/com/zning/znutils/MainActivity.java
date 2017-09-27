package com.zning.znutils;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.uesugi.library.utils.Utils;
import com.uesugi.library.utils.views.SliderViewPager;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


//    private SliderViewPager sliderViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.e("MainActivity", Utils.getUrl_base());

//        initView();
    }

    private void initView() {


//        sliderViewPager = (SliderViewPager)findViewById(R.id.slider_view);
//
//        ArrayList<Object> list = new ArrayList<>();
//
//        list.add("http://seopic.699pic.com/photo/00005/5186.jpg_wh1200.jpg");
//        list.add("http://seopic.699pic.com/photo/00005/5186.jpg_wh1200.jpg");
//        list.add("http://seopic.699pic.com/photo/00005/5186.jpg_wh1200.jpg");
//
//        sliderViewPager.addUrls(this, list);

    }
}
