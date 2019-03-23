package com.ensim.deezerapp;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.ensim.deezerapp.service.DeezerData;

public class TrackActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private MediaPlayer mediaPlayer = SingleMediaPlayer.getInstance();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_track);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        String albumId = getIntent().getStringExtra("AlbumId");
        String albumTitle = getIntent().getStringExtra("AlbumTitle");

        getSupportActionBar().setTitle(albumTitle);

        final FloatingActionButton fab = findViewById(R.id.music_btn);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.release();
                }
            }
        });


        recyclerView = findViewById(R.id.track_list);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        DeezerData.getInstance().getTracksFromAlbum(albumId, TrackActivity.this, recyclerView);
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}
