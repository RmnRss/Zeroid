package com.ensim.deezerapp.Cards.TrackCard;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ensim.deezerapp.Class.Track;
import com.ensim.deezerapp.R;

import java.util.List;

public class TrackCardAdapter extends RecyclerView.Adapter<TrackCardViewHolder> {

    private List<Track> trackList;

    public TrackCardAdapter(List<Track> list) {
        this.trackList = list;
    }

    // Creates view holder and set layout for the inflater
    @Override
    public TrackCardViewHolder onCreateViewHolder(ViewGroup viewGroup, int itemType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.tracks, viewGroup, false);
        return new TrackCardViewHolder(view);
    }

    // Sets View Content
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
