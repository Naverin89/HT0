package by.tren.tat21.naverin;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

// Represent of artist class. Has name field and Map as discography
public class Artist {
    private String name;
    Map<String, Album> discography;

    public Artist(String name) {
        this.name = name;
        discography = new TreeMap<String, Album>();
    }

    //Adding to Map unique album key and song from this album
    public void addAlbum(TrackInfo track) {
        if (!discography.containsKey(track.getAlbum())) {
            discography.put(track.getAlbum(), new Album(track.getAlbum()));
        }
        discography.get(track.getAlbum()).addSongs(track);
    }

    public Map<String,Album> getAlbums(){
        return discography;
    }

    public String getName(){
        return name;
    }

}
