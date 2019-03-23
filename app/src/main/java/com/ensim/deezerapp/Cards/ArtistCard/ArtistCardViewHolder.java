package com.ensim.deezerapp.Cards.ArtistCard;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.ensim.deezerapp.ArtistDetailsActivity;
import com.ensim.deezerapp.Class.Artist;
import com.ensim.deezerapp.R;
import com.squareup.picasso.Picasso;


public class ArtistCardViewHolder extends RecyclerView.ViewHolder {

    private TextView artistName;
    private ImageView artistImage;
    private Artist artistToSend;

    public ArtistCardViewHolder(final View itemView) {
        super(itemView);

        // When the card is clicked, opens new activity and sends data to said activity
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent albumActivityIntent = new Intent(itemView.getContext(), ArtistDetailsActivity.class);
                albumActivityIntent.putExtra("ArtistId", artistToSend.getId());
                albumActivityIntent.putExtra("ArtistName", artistToSend.getName());
                itemView.getContext().startActivity(albumActivityIntent);
            }
        });

        artistName = itemView.findViewById(R.id.artist_name);
        artistImage = itemView.findViewById(R.id.artist_image);
    }

    // Sets the content to be displayed by binding data and views
    public void bind(Artist anArtist) {
        artistToSend = anArtist;
        artistName.setText(anArtist.getName());
        Picasso.get().load(anArtist.getPicture_big()).into(artistImage);
    }
}