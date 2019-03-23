package com.ensim.deezerapp.Medias;

import android.media.MediaPlayer;

/***
 * Class to ensure only one media player is used all around the application
 */
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
