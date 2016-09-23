package br.com.frameworksystem.marvelapp.ui.activities;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import br.com.frameworksystem.marvelapp.R;
import br.com.frameworksystem.marvelapp.model.Character;


public class CharacterActivity extends BaseActivity {
    private Character character;
    private Context context;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        setContentView(R.layout.character_main);


        if (getIntent().hasExtra("character")){
            character = (Character) getIntent().getSerializableExtra("character");

            ImageView imageView = (ImageView) findViewById(R.id.character_img);
            TextView textView = (TextView) findViewById(R.id.character_desc);

            imageView.setImageURI(Uri.parse(character.getThumbnailUrl()));
            textView.setText(character.getDescription());
            Picasso.with(context).load(character.getThumbnailUrl()).into(imageView);

        }
    }
}
