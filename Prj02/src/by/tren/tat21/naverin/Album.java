package by.tren.tat21.naverin;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

//Representor of Album, contains it's name and list of songs in it;

public class Album {
    private String albumName;
    ArrayList<TrackInfo> sameSongsCtrlSum = new ArrayList<TrackInfo>();
    ArrayList<TrackInfo> sameSongsNames = new ArrayList<TrackInfo>();

    Map<String, TrackInfo> songs;

    public Album(String albumName) {
        this.albumName = albumName;
        songs = new TreeMap<String, TrackInfo>();
    }

    public String getAlbumName() {
        return albumName;
    }

    public Map<String, TrackInfo> getSongs() {
        return songs;
    }

    //Adding song to album and logging if it's any same songs take place
    public void addSongs(TrackInfo track) {

        Logger logger = LogManager.getLogger(Album.class);
        System.setProperty("log4j.configuration","log4j.properties");

        String title = track.getTitle();
        if (songs.containsKey(title)) {
            if (songs.get(title).getControlSum().equals(track.getControlSum())) {
                logger.info("Files have the same control sum " + track.getPath() + "\n" + songs.get(title).getPath());

                sameSongsCtrlSum.add(track);
                sameSongsCtrlSum.add(songs.get(title));
            } else {
                logger.info(track.getArtist() + " " + track.getAlbum() + " " + track.getTitle() +
                 " have the same name " + track.getPath() + "\n" + songs.get(title).getPath());
                sameSongsNames.add(track);
                sameSongsNames.add(songs.get(title));
            }
        } else {
            songs.put(title, track);
        }
    }
}
