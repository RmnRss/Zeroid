package com.ensim.deezerapp.service.data;

public class Track {
    Artist ArtistObject;
    private String id;
    private boolean readable;
    private String title;
    private String title_short;
    private String title_version;
    private String link;
    private String duration;
    private String rank;
    private boolean explicit_lyrics;
    private float explicit_content_lyrics;
    private float explicit_content_cover;
    private String preview;
    private String type;
    private String track_position;

    public Track(String title, String rank, String duration) {
        this.title = title;
        this.rank = rank;
        this.duration = duration;
    }

    // Getter Methods

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean getReadable() {
        return readable;
    }

    public void setReadable(boolean readable) {
        this.readable = readable;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle_short() {
        return title_short;
    }

    public void setTitle_short(String title_short) {
        this.title_short = title_short;
    }

    public String getTitle_version() {
        return title_version;
    }

    public void setTitle_version(String title_version) {
        this.title_version = title_version;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getRank() {
        return rank;
    }

    // Setter Methods

    public void setRank(String rank) {
        this.rank = rank;
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

    public String getPreview() {
        return preview;
    }

    public void setPreview(String preview) {
        this.preview = preview;
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

    public String getTrack_position() {
        return track_position;
    }

    public void setTrack_position(String track_position) {
        this.track_position = track_position;
    }
}
