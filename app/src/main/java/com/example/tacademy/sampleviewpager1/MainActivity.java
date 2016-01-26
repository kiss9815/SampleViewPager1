package com.example.tacademy.sampleviewpager1;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewParent;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    ViewPager viewPager;
    MypagerAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = (ViewPager)findViewById(R.id.pager);
        mAdapter = new MypagerAdapter();
        viewPager.setAdapter(mAdapter);
        viewPager.setPageMargin(10); // page마다 margin

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                Toast.makeText(MainActivity.this, "page selected : " + position, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        initData();

        viewPager.setCurrentItem(5); // 현재 특정 인덱스 페이지를 보이도록 하기

    }

    private void initData(){
        for(int i =0; i<10; i++){
            mAdapter.add("item : " + i);
        }
    }
}
