package br.com.frameworksystem.marvelapp.ui.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.webkit.WebView;

import br.com.frameworksystem.marvelapp.R;
import br.com.frameworksystem.marvelapp.model.Event;

/**
 * Created by Matheus on 14/09/2016.
 */
public class DetailActivity extends BaseActivity {

    private Event event;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        setContentView(R.layout.detail_main);

        if (getIntent().hasExtra("event")){
            event = (Event) getIntent().getSerializableExtra("event");
        }
        WebView webView = (WebView) findViewById(R.id.detail_main);
        webView.loadUrl(event.getUrl());
    }
}
