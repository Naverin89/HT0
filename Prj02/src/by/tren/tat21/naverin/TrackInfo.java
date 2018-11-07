package by.tren.tat21.naverin;

import com.mpatric.mp3agic.ID3v1;
import com.mpatric.mp3agic.InvalidDataException;
import com.mpatric.mp3agic.Mp3File;
import com.mpatric.mp3agic.UnsupportedTagException;

import java.io.File;
import java.io.IOException;

//Represent full info about mp3 track with help mp3agic library.
public class TrackInfo {
    private String artist;
    private String title;
    private String album;
    private String path;
    private String controlSum;
    private long duration = 0;


    public TrackInfo(File track) {
        Mp3File mp3Track = null;
        try {
            mp3Track = new Mp3File(track.getAbsolutePath());
        } catch (UnsupportedTagException | InvalidDataException e) {
            System.out.println("Format of input file could be inappropriate (work only with .mp3 ");
        }catch(IOException e){
            System.out.println("File doesn't exist in this path: "+ track.getAbsolutePath());
        }

        // Checking for mp3 tags with different metadata containers (check https://en.wikipedia.org/wiki/ID3 )
        if (mp3Track.hasId3v2Tag()) {
            ID3v1 tag = mp3Track.getId3v2Tag();
            artist = tag.getArtist();
            title = tag.getTitle();
            album = tag.getAlbum();
        } else if (mp3Track.hasId3v1Tag()) {
            ID3v1 tag = mp3Track.getId3v1Tag();
            artist = tag.getArtist();
            title = tag.getTitle();
            album = tag.getAlbum();
        }
        //implement default values if there wasn't any useful metadata
        if (artist == null) {
            artist = "Unknown artist";
        }
        if (title == null) {
            title = "Unknown title";
        }
        if (album == null) {
            album = "Unknown album";
        }

        duration = mp3Track.getLengthInSeconds();
        path = track.getAbsolutePath();
        controlSum = new ControlSum().getCheckSum(track);

    }


    public String getArtist() {
        return artist;
    }

    public String getTitle() {
        return title;
    }

    public String getAlbum() {
        return album;
    }

    public String getPath() {
        return path;
    }

    public String getControlSum() {
        return controlSum;
    }

    public long getDuration() {
        return duration;
    }

}







