package com.example.tacademy.sampleviewpager1;

import android.graphics.Color;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tacademy on 2016-01-26.
 */
public class MypagerAdapter extends PagerAdapter {

    List<String> items = new ArrayList<String>();
    List<View> scrappedView = new ArrayList<View>();

    public void add(String item){
        items.add(item);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        TextView textView = null;
        if(scrappedView.size() > 0){//안쓰는 뷰가 하나라도 있으면, 이 뷰는 destroy할 때 생성됨, listview와 비슷
            View scrapView = scrappedView.remove(0);
            textView = (TextView)scrapView;
        }else {
            textView = new TextView(container.getContext());
            textView.setBackgroundColor(Color.GREEN);
        }
        textView.setText(items.get(position));
        container.addView(textView);
        return textView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        View view = (View)object;
        container.removeView(view);
        scrappedView.add(view);  //없앤 뷰를 재활용하기 위해 scrappedView 사용
    }

    @Override
    public float getPageWidth(int position) { // 화면에 보이는 개수 , 1이면 한개, 2이면 한페이지에 두개 보임
        return 1.0f/3;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }
}
