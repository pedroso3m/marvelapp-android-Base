package br.com.frameworksystem.marvelapp.ui.activities;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;

import br.com.frameworksystem.marvelapp.R;

/**
 * Created by Matheus on 21/09/2016.
 */

public class SplashActivity extends Activity {

    private static int SPLASH_TIME_OUT = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.splash_main );
        loadGalleryImages();

    }

    private void loadGalleryImages(){

        CustomPageAdapter adapter = new CustomPageAdapter();
        ViewPager myPager = (ViewPager) findViewById( R.id.viewpage );

        myPager.setAdapter( adapter );
        myPager.setCurrentItem(0);
    }

}
