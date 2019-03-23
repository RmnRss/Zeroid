package com.ensim.deezerapp.ArtistCard;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.ensim.deezerapp.ArtistDetails;
import com.ensim.deezerapp.R;
import com.ensim.deezerapp.service.data.Artist;
import com.squareup.picasso.Picasso;

public class ArtistCardViewHolder extends RecyclerView.ViewHolder {

    private TextView artistName;
    private ImageView artistImage;
    private Artist artistToSend;

    //itemView est la vue correspondante à 1 cellule
    public ArtistCardViewHolder(final View itemView) {
        super(itemView);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent albumActivityIntent = new Intent(itemView.getContext(), ArtistDetails.class);
                albumActivityIntent.putExtra("ArtistId", artistToSend.getId());
                albumActivityIntent.putExtra("ArtistName", artistToSend.getName());
                itemView.getContext().startActivity(albumActivityIntent);
            }
        });

        artistName = (TextView) itemView.findViewById(R.id.artist_name);
        artistImage = (ImageView) itemView.findViewById(R.id.artist_image);
    }

    //puis ajouter une fonction pour remplir la cellule en fonction d'un MyObject
    public void bind(Artist anArtist) {
        artistToSend = anArtist;
        artistName.setText(anArtist.getName());
        Picasso.get().load(anArtist.getPicture_big()).into(artistImage);
    }
}