package com.ensim.deezerapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.ensim.deezerapp.service.DeezerData;
import com.ensim.deezerapp.service.data.Album;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class ArtistDetails extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artist_details);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        String artistId = getIntent().getStringExtra("ArtistId");
        String artistName = getIntent().getStringExtra("ArtistName");

        getSupportActionBar().setTitle(artistName);


        TextView fanText = findViewById(R.id.nb_fans);
        fanText.setText(getIntent().getStringExtra("ArtistFans"));


        recyclerView = findViewById(R.id.album_list);

        //pour adapter en grille comme une RecyclerView, avec 2 cellules par ligne
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));

        DeezerData.getInstance().getAlbumsFromArtist(artistId, ArtistDetails.this, recyclerView);
    }

    @Override
    public void onBackPressed() {
        finish();
    }

}
