package com.ensim.deezerapp.TracksCard;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ensim.deezerapp.R;
import com.ensim.deezerapp.service.data.Track;

import java.util.List;

public class TrackCardAdapter extends RecyclerView.Adapter<TrackCardViewHolder> {

    List<Track> trackList;

    //ajouter un constructeur prenant en entrée une liste
    public TrackCardAdapter(List<Track> list) {
        this.trackList = list;
    }

    //cette fonction permet de créer les viewHolder
    //et par la même indiquer la vue à inflater (à partir des layout xml)
    @Override
    public TrackCardViewHolder onCreateViewHolder(ViewGroup viewGroup, int itemType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.tracks, viewGroup, false);
        return new TrackCardViewHolder(view);
    }

    //c'est ici que nous allons remplir notre cellule avec le texte/image de chaque MyObjects
    @Override
    public void onBindViewHolder(TrackCardViewHolder trackViewHolder, int position) {
        Track track = trackList.get(position);
        trackViewHolder.bind(track);
    }

    @Override
    public int getItemCount() {
        return trackList.size();
    }

}
