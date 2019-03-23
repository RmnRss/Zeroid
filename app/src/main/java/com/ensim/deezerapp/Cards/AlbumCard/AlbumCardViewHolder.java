package com.ensim.deezerapp.Cards.AlbumCard;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.ensim.deezerapp.Class.Album;
import com.ensim.deezerapp.R;
import com.ensim.deezerapp.TrackActivity;
import com.squareup.picasso.Picasso;


public class AlbumCardViewHolder extends RecyclerView.ViewHolder {

    private TextView albumName;
    private ImageView albumCover;
    private Album albumToSend;

    public AlbumCardViewHolder(final View itemView) {
        super(itemView);

        // When the card is clicked, opens new activity and sends data to said activity
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent albumActivityIntent = new Intent(itemView.getContext(), TrackActivity.class);
                albumActivityIntent.putExtra("AlbumId", albumToSend.getId());
                albumActivityIntent.putExtra("AlbumTitle", albumToSend.getTitle());
                itemView.getContext().startActivity(albumActivityIntent);
            }
        });

        albumName = itemView.findViewById(R.id.artist_name);
        albumCover = itemView.findViewById(R.id.artist_image);
    }

    // Sets the content to be displayed by binding data and views
    public void bind(Album anAlbum) {
        albumToSend = anAlbum;
        albumName.setText(anAlbum.getTitle());
        Picasso.get().load(anAlbum.getCover_big()).into(albumCover);
    }
}