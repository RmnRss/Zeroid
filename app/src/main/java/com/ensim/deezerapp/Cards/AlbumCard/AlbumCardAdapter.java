package com.ensim.deezerapp.Cards.AlbumCard;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ensim.deezerapp.Class.Album;
import com.ensim.deezerapp.R;

import java.util.List;

public class AlbumCardAdapter extends RecyclerView.Adapter<AlbumCardViewHolder> {

    private List<Album> albumList;

    public AlbumCardAdapter(List<Album> list) {
        this.albumList = list;
    }

    // Creates view holder and set layout for the inflater
    @Override
    public AlbumCardViewHolder onCreateViewHolder(ViewGroup viewGroup, int itemType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.picture_card, viewGroup, false);
        return new AlbumCardViewHolder(view);
    }

    // Sets View Content
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
