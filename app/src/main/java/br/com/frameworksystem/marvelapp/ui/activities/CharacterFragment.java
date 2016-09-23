package br.com.frameworksystem.marvelapp.ui.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import br.com.frameworksystem.marvelapp.Mock;
import br.com.frameworksystem.marvelapp.R;

/**
 * Created by Matheus on 14/09/2016.
 */
public class CharacterFragment extends Fragment {

    private RecyclerView recyclerView;
    private CharacterAdapter characterAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.event_main, container, false);
    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState );

        GridLayoutManager layoutManager =
                new GridLayoutManager(getActivity(),2);

                recyclerView = (RecyclerView) view.findViewById(R.id.recycler);
                recyclerView.setLayoutManager(layoutManager);

        characterAdapter = new CharacterAdapter(getActivity(), Mock.getCharacters(), recyclerView);
        recyclerView.setAdapter(characterAdapter);

    }
}
