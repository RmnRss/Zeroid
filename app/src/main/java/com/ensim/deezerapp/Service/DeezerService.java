package com.ensim.deezerapp.Service;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.ensim.deezerapp.Cards.AlbumCard.AlbumCardAdapter;
import com.ensim.deezerapp.Cards.ArtistCard.ArtistCardAdapter;
import com.ensim.deezerapp.Cards.TrackCard.TrackCardAdapter;
import com.ensim.deezerapp.Class.Album;
import com.ensim.deezerapp.Class.Artist;
import com.ensim.deezerapp.Class.Track;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/***
 * Services to get data from Deezer
 */
public class DeezerService {

    private static DeezerService singleton;
    private Gson gson;

    private DeezerService() {
        this.gson = new Gson();
    }

    public static DeezerService getInstance() {
        if (singleton == null) {
            singleton = new DeezerService();
        }
        return singleton;
    }

    /***
     * Uses volley JsonRequest to get Json from deezer, then parse Json content into a list of object that is displayed using the recyclerView
     * @param searchedTerms terms entered by the user
     * @param context Current app context
     * @param recyclerView view that should contain deezer data
     */
    public void getArtistFromSearch(String searchedTerms, Context context, final RecyclerView recyclerView) {

        String url = "https://api.deezer.com/search/artist?q=" + searchedTerms;

        final List<Artist> toDisplay = new ArrayList<>();

        JsonObjectRequest getRequest = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            Log.d("Response ", response.toString());

                            JSONArray artistArray = response.getJSONArray("data");

                            for (int i = 0; i < artistArray.length(); i++) {
                                JSONObject anArtist = (JSONObject) artistArray.get(i);
                                Artist a = gson.fromJson(String.valueOf(anArtist), Artist.class);
                                toDisplay.add(a);
                            }

                            recyclerView.setAdapter(new ArtistCardAdapter(toDisplay));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("Error.Response", error.getMessage());
                    }
                }

        );

        QueueSingleton.getInstance(context).addToRequestQueue(getRequest);
    }

    /***
     * Same as getArtistFromSearch but with different parameters
     * @param artistId the Deezer API id of the artist containing the wanted albums
     * @param context Current app context
     * @param recyclerView view that should contain deezer data
     */
    public void getAlbumsFromArtist(String artistId, Context context, final RecyclerView recyclerView) {
        String url = "https://api.deezer.com/artist/" + artistId + "/albums";

        final ArrayList<Album> toDisplay = new ArrayList<>();

        JsonObjectRequest getRequest = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            Log.d("Response ", response.toString());

                            JSONArray albumArray = response.getJSONArray("data");

                            for (int i = 0; i < albumArray.length(); i++) {
                                JSONObject anAlbum = (JSONObject) albumArray.get(i);
                                Album a = gson.fromJson(String.valueOf(anAlbum), Album.class);
                                toDisplay.add(a);
                            }

                            recyclerView.setAdapter(new AlbumCardAdapter(toDisplay));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("Error.Response", error.getMessage());
                    }
                }

        );

        QueueSingleton.getInstance(context).addToRequestQueue(getRequest);
    }

    /***
     * Same as getArtistFromSearch
     * @param albumId the Deezer API id of the album contaning the tracks
     * @param context Current app context
     * @param recyclerView view that should contain deezer data
     */
    public void getTracksFromAlbum(String albumId, Context context, final RecyclerView recyclerView) {

        String url = "https://api.deezer.com/album/" + albumId + "/tracks";

        final ArrayList<Track> toDisplay = new ArrayList<>();

        JsonObjectRequest getRequest = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            Log.d("Response ", response.toString());

                            JSONArray albumArray = response.getJSONArray("data");

                            for (int i = 0; i < albumArray.length(); i++) {
                                JSONObject tracks = (JSONObject) albumArray.get(i);
                                Track a = gson.fromJson(String.valueOf(tracks), Track.class);
                                String duration = a.getDuration();
                                a.setDuration(secondsToMin(duration));
                                Log.d("dur ", a.getDuration());
                                toDisplay.add(a);
                            }

                            recyclerView.setAdapter(new TrackCardAdapter(toDisplay));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("Error.Response", error.getMessage());
                    }
                }

        );

        QueueSingleton.getInstance(context).addToRequestQueue(getRequest);
    }

    /***
     * Reformat the duration in seconds fetched from Deezer's API to a more readable duration
     * @param toTransform duration in seconds
     * @return min:sec
     */
    private String secondsToMin(String toTransform) {
        int seconds = Integer.parseInt(toTransform);
        int minutes = seconds / 60;
        int rest = seconds - (minutes * 60);
        String minStr, restStr;

        if (minutes < 10) {
            minStr = "0" + minutes;
        } else {
            minStr = String.valueOf(minutes);
        }

        if (rest < 10) {
            restStr = "0" + rest;
        } else {
            restStr = String.valueOf(rest);
        }
        return minStr + ":" + restStr;
    }
}
