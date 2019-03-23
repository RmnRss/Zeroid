package com.ensim.deezerapp.ArtistCard;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ensim.deezerapp.R;
import com.ensim.deezerapp.service.data.Artist;

import java.util.List;

public class ArtistCardAdapter extends RecyclerView.Adapter<ArtistCardViewHolder> {

    List<Artist> artistList;

    //ajouter un constructeur prenant en entrée une liste
    public ArtistCardAdapter(List<Artist> list) {
        this.artistList = list;
    }

    //cette fonction permet de créer les viewHolder
    //et par la même indiquer la vue à inflater (à partir des layout xml)
    @Override
    public ArtistCardViewHolder onCreateViewHolder(ViewGroup viewGroup, int itemType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.artist_card, viewGroup, false);
        return new ArtistCardViewHolder(view);
    }

    //c'est ici que nous allons remplir notre cellule avec le texte/image de chaque MyObjects
    @Override
    public void onBindViewHolder(ArtistCardViewHolder myViewHolder, int position) {
        Artist myObject = artistList.get(position);
        myViewHolder.bind(myObject);
    }

    @Override
    public int getItemCount() {
        return artistList.size();
    }

}
