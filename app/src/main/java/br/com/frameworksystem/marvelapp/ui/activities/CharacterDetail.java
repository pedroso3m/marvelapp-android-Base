package br.com.frameworksystem.marvelapp.ui.activities;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.ShareActionProvider;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import br.com.frameworksystem.marvelapp.R;
import br.com.frameworksystem.marvelapp.model.Character;

public class CharacterDetail extends BaseActivity {

    private Character character;
    private Context context;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );

        setContentView( R.layout.character_detail );

        Toolbar toolbar = (Toolbar) findViewById( R.id.toolbar );
        setSupportActionBar( toolbar );
        getSupportActionBar().setDisplayHomeAsUpEnabled( true );


        if (getIntent().hasExtra( "character" )) {
            character = (Character) getIntent().getSerializableExtra( "character" );
            setTitle( character.getName() );
        }
        ImageView imageView = (ImageView) findViewById( R.id.character_img );
        TextView textView = (TextView) findViewById( R.id.character_desc );
        TextView textView1 = (TextView) findViewById( R.id.character_title );


        textView.setText( character.getDescription() );
        imageView.setImageURI( Uri.parse( character.getThumbnailUrl() ) );
        Picasso.with( context ).load( character.getThumbnailUrl() ).centerCrop().resize( 500, 500 ).into( imageView );


    }

    private ShareActionProvider mShareActionProvider;


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.character_detail, menu);

        return super.onCreateOptionsMenu( menu );
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        Intent sendIntent = new Intent(  );
        sendIntent.setAction( Intent.ACTION_SEND );
        sendIntent.putExtra( Intent.EXTRA_TEXT,"Compartilhar");
        sendIntent.setType("text/plain");
        startActivity( sendIntent );

        return super.onOptionsItemSelected( item );
    }

    private void setShareIntent(Intent shareIntent) {
        if (mShareActionProvider != null) {
            mShareActionProvider.setShareIntent(shareIntent);
        }
    }
}
