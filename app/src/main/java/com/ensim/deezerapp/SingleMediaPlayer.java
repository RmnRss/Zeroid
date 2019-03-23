package com.ensim.deezerapp;

import android.media.MediaPlayer;


public class SingleMediaPlayer {

    private static MediaPlayer singleton;

    private SingleMediaPlayer() {

    }

    public static MediaPlayer getInstance() {
        if (singleton == null) {
            singleton = new MediaPlayer();
        }
        return singleton;
    }
}
