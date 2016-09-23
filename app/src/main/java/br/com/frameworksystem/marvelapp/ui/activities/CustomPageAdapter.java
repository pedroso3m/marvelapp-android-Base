package br.com.frameworksystem.marvelapp.ui.activities;

import android.content.Context;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import br.com.frameworksystem.marvelapp.R;

/**
 * Created by Matheus on 22/09/2016.
 */

public class CustomPageAdapter extends PagerAdapter {

    Context context;

    private Integer[] Imgid = {R.raw.img1, R.raw.img2, R.raw.img3, R.raw.img4};

    public int getCount() {
        return Imgid.length;
    }

    @Override
    public Object instantiateItem(ViewGroup collection, int position) {

        ImageView img = new ImageView( collection.getContext() );
        img.setImageResource( Imgid[position] );
        ((ViewPager) collection).addView( img, 0 );
        return img;
        //int resId = 0;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ((ViewPager) container).removeView((View)object);

    }

    @Override
    public boolean isViewFromObject(View arg0, Object arg1) {
        return arg0 == ((View) arg1);
    }

    public Parcelable saveState() {
        return null;
    }


}
