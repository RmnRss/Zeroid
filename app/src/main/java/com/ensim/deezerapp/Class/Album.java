package com.ensim.deezerapp.Class;

import java.util.ArrayList;

/***
 * Auto-generated class from Deezer's Json files
 */
public class Album {

    private Genre GenresObject;
    private ArrayList<Artist> contributors = new ArrayList<Artist>();
    private Artist ArtistObject;
    private Track TracksObject;
    private String id;
    private String title;
    private String upc;
    private String link;
    private String share;
    private String cover;
    private String cover_small;
    private String cover_medium;
    private String cover_big;
    private String cover_xl;
    private float genre_id;
    private String label;
    private float nb_tracks;
    private float duration;
    private float fans;
    private float rating;
    private String release_date;
    private String record_type;
    private boolean available;
    private String tracklist;
    private boolean explicit_lyrics;
    private float explicit_content_lyrics;
    private float explicit_content_cover;
    private String type;


    // Getter Methods

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUpc() {
        return upc;
    }

    public void setUpc(String upc) {
        this.upc = upc;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getShare() {
        return share;
    }

    public void setShare(String share) {
        this.share = share;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getCover_small() {
        return cover_small;
    }

    public void setCover_small(String cover_small) {
        this.cover_small = cover_small;
    }

    public String getCover_medium() {
        return cover_medium;
    }

    public void setCover_medium(String cover_medium) {
        this.cover_medium = cover_medium;
    }

    public String getCover_big() {
        return cover_big;
    }

    public void setCover_big(String cover_big) {
        this.cover_big = cover_big;
    }

    public String getCover_xl() {
        return cover_xl;
    }

    public void setCover_xl(String cover_xl) {
        this.cover_xl = cover_xl;
    }

    public float getGenre_id() {
        return genre_id;
    }

    public void setGenre_id(float genre_id) {
        this.genre_id = genre_id;
    }

    public Genre getGenres() {
        return GenresObject;
    }

    public void setGenres(Genre genresObject) {
        this.GenresObject = genresObject;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public float getNb_tracks() {
        return nb_tracks;
    }

    // Setter Methods

    public void setNb_tracks(float nb_tracks) {
        this.nb_tracks = nb_tracks;
    }

    public float getDuration() {
        return duration;
    }

    public void setDuration(float duration) {
        this.duration = duration;
    }

    public float getFans() {
        return fans;
    }

    public void setFans(float fans) {
        this.fans = fans;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public String getRecord_type() {
        return record_type;
    }

    public void setRecord_type(String record_type) {
        this.record_type = record_type;
    }

    public boolean getAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public String getTracklist() {
        return tracklist;
    }

    public void setTracklist(String tracklist) {
        this.tracklist = tracklist;
    }

    public boolean getExplicit_lyrics() {
        return explicit_lyrics;
    }

    public void setExplicit_lyrics(boolean explicit_lyrics) {
        this.explicit_lyrics = explicit_lyrics;
    }

    public float getExplicit_content_lyrics() {
        return explicit_content_lyrics;
    }

    public void setExplicit_content_lyrics(float explicit_content_lyrics) {
        this.explicit_content_lyrics = explicit_content_lyrics;
    }

    public float getExplicit_content_cover() {
        return explicit_content_cover;
    }

    public void setExplicit_content_cover(float explicit_content_cover) {
        this.explicit_content_cover = explicit_content_cover;
    }

    public Artist getArtist() {
        return ArtistObject;
    }

    public void setArtist(Artist artistObject) {
        this.ArtistObject = artistObject;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Track getTracks() {
        return TracksObject;
    }

    public void setTracks(Track tracksObject) {
        this.TracksObject = tracksObject;
    }
}
