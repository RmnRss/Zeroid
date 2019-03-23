package com.ensim.deezerapp.AlbumCard;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ensim.deezerapp.R;
import com.ensim.deezerapp.service.data.Album;

import java.util.List;

public class AlbumCardAdapter extends RecyclerView.Adapter<AlbumCardViewHolder> {

    List<Album> albumList;

    //ajouter un constructeur prenant en entrée une liste
    public AlbumCardAdapter(List<Album> list) {
        this.albumList = list;
    }

    //cette fonction permet de créer les viewHolder
    //et par la même indiquer la vue à inflater (à partir des layout xml)
    @Override
    public AlbumCardViewHolder onCreateViewHolder(ViewGroup viewGroup, int itemType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.artist_card, viewGroup, false);
        return new AlbumCardViewHolder(view);
    }

    //c'est ici que nous allons remplir notre cellule avec le texte/image de chaque MyObjects
    @Override
    public void onBindViewHolder(AlbumCardViewHolder myViewHolder, int position) {
        Album album = albumList.get(position);
        myViewHolder.bind(album);
    }

    @Override
    public int getItemCount() {
        return albumList.size();
    }

}
