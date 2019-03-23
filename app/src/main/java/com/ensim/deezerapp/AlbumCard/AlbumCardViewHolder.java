package com.ensim.deezerapp.AlbumCard;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.ensim.deezerapp.R;
import com.ensim.deezerapp.TrackActivity;
import com.ensim.deezerapp.service.data.Album;
import com.squareup.picasso.Picasso;

public class AlbumCardViewHolder extends RecyclerView.ViewHolder {

    private TextView albumName;
    private ImageView albumCover;
    private Album albumToSend;

    //itemView est la vue correspondante à 1 cellule
    public AlbumCardViewHolder(final View itemView) {
        super(itemView);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent albumActivityIntent = new Intent(itemView.getContext(), TrackActivity.class);
                albumActivityIntent.putExtra("AlbumId", albumToSend.getId());
                albumActivityIntent.putExtra("AlbumTitle", albumToSend.getTitle());
                itemView.getContext().startActivity(albumActivityIntent);
            }
        });

        albumName = (TextView) itemView.findViewById(R.id.artist_name);
        albumCover = (ImageView) itemView.findViewById(R.id.artist_image);
    }

    //puis ajouter une fonction pour remplir la cellule en fonction d'un MyObject
    public void bind(Album anAlbum) {
        albumToSend = anAlbum;
        albumName.setText(anAlbum.getTitle());
        Picasso.get().load(anAlbum.getCover_big()).into(albumCover);
    }
}