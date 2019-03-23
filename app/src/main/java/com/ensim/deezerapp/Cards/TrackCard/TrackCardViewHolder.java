package com.ensim.deezerapp.Cards.TrackCard;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.ensim.deezerapp.Class.Track;
import com.ensim.deezerapp.Medias.SingleMediaPlayer;
import com.ensim.deezerapp.R;

import java.io.IOException;

public class TrackCardViewHolder extends RecyclerView.ViewHolder {

    private TextView trackName;
    private TextView trackLength;
    private TextView trackNumber;

    private Track track;

    public TrackCardViewHolder(final View itemView) {
        super(itemView);

        // When the card is clicked plays the preview
        // Clicking on another card will stop the current audiostream and start a new one
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MediaPlayer mediaPlayer = SingleMediaPlayer.getInstance();
                mediaPlayer.reset();
                mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
                try {
                    mediaPlayer.setDataSource(track.getPreview());
                    mediaPlayer.prepare();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                mediaPlayer.start();
            }
        });

        trackName = itemView.findViewById(R.id.track_name);
        trackLength = itemView.findViewById(R.id.track_length);
        trackNumber = itemView.findViewById(R.id.track_rank);
    }

    // Sets the content to be displayed by binding data and views
    public void bind(Track track) {
        this.track = track;
        trackName.setText(track.getTitle());
        trackLength.setText(track.getDuration());
        trackNumber.setText(track.getTrack_position());
    }
}