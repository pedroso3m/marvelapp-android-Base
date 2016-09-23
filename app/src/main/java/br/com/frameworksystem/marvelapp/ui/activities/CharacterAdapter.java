package br.com.frameworksystem.marvelapp.ui.activities;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import br.com.frameworksystem.marvelapp.R;
import br.com.frameworksystem.marvelapp.model.Character;

/**
 * Created by Matheus on 14/09/2016.
 */
public class CharacterAdapter extends RecyclerView.Adapter<CharacterAdapter.ViewHolder>{

    private Context context;
    private List<Character> characters;
    private RecyclerView recyclerView;
    private Character  character;

    public CharacterAdapter(Context context, List<Character> characterList, RecyclerView recyclerView){

        this.context = context;
        this.characters = characterList;
        this.recyclerView = recyclerView;

    }

    public CharacterAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context)
                .inflate(R.layout.character_main, parent, false);

        CharacterAdapter.ViewHolder viewHolder = new CharacterAdapter.ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(CharacterAdapter.ViewHolder holder, int position) {
        Character character = characters.get(position);
        holder.nameTitle.setText(character.getName());
        holder.eventTitle.setText(character.getDescription());
        Picasso.with(context).load(character.getThumbnailUrl()).centerCrop().resize(400,400).into(holder.eventImg);

       // Toolbar toolbar = (toolbar) findViewById(R.id.toolbar);

        //setSupportActionBar(toolbar);

        //getSupportActionBar(). setDisplayHomeUpEnabled(true);

        //@Override
          //      public boolean onOptionsItemSelected(MenuItem intem){

           // if (item.getItemId() == R.id.action_share){
             //   share();
            //    return true;
           // }
        //}
    }

    @Override
    public int getItemCount() {

        return characters.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView eventImg;
        TextView eventTitle;
        TextView nameTitle;



        public ViewHolder(View itemView){
            super(itemView);

            eventImg = (ImageView) itemView.findViewById(R.id.character_img);
            nameTitle = (TextView) itemView.findViewById(R.id.character_title);
            eventTitle = (TextView) itemView.findViewById(R.id.character_desc);

            itemView.setOnClickListener(onClickListener);

        }
    }
    private View.OnClickListener onClickListener = new View.OnClickListener(){
        @Override
        public void onClick(View v){

            int position = recyclerView.getChildAdapterPosition(v);
            Character character = characters.get(position);

            Intent intent = new Intent(context, CharacterDetail.class);
            intent.putExtra("character", character);
            context.startActivity(intent);
        }
    };

}
