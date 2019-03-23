package com.ensim.deezerapp.Cards.ArtistCard;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ensim.deezerapp.Class.Artist;
import com.ensim.deezerapp.R;

import java.util.List;

public class ArtistCardAdapter extends RecyclerView.Adapter<ArtistCardViewHolder> {

    private List<Artist> artistList;

    public ArtistCardAdapter(List<Artist> list) {
        this.artistList = list;
    }

    // Creates view holder and set layout for the inflater
    @Override
    public ArtistCardViewHolder onCreateViewHolder(ViewGroup viewGroup, int itemType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.picture_card, viewGroup, false);
        return new ArtistCardViewHolder(view);
    }

    // Sets View Content
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
