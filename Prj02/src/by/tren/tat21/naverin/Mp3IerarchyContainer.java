package by.tren.tat21.naverin;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

//Represent a container for artists, albums, songs to handful maintaining
public class Mp3IerarchyContainer {
    public Map<String,Artist> artists;
    //Follow two lists contain equal tracks by hash and name
    public List<File> sameTracks = new ArrayList<File>();
    public List<File> sameNamesTracks = new ArrayList<File>();

    public Mp3IerarchyContainer(List<File> mp3Tracks){
        artists = new TreeMap<String,Artist>();

        for(File track : mp3Tracks){
            TrackInfo song = new TrackInfo(track);

            if(!artists.containsKey(song.getArtist())) {
                artists.put(song.getArtist(), new Artist((song.getArtist())));
            }
            artists.get(song.getArtist()).addAlbum(song);
        }
    }
}
