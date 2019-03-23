package com.ensim.deezerapp.TracksCard;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.ensim.deezerapp.SingleMediaPlayer;
import com.ensim.deezerapp.R;
import com.ensim.deezerapp.service.data.Track;

import java.io.IOException;

public class TrackCardViewHolder extends RecyclerView.ViewHolder {

    private TextView trackName;
    private TextView trackLength;
    private TextView trackNumber;

    private Track track;

    public TrackCardViewHolder(final View itemView) {
        super(itemView);

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

    public void bind(Track track) {
        this.track = track;
        trackName.setText(track.getTitle());
        trackLength.setText(track.getDuration());
        trackNumber.setText(track.getTrack_position());
    }
}