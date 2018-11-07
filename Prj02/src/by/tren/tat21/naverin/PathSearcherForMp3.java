package by.tren.tat21.naverin;

import org.apache.log4j.Logger;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

//represent List mp3FileHolder contains only with EXTENSION files
public class PathSearcherForMp3 {
    private static final String EXTENSION = ".*\\.mp3$";
    List<File> mp3FilesHolder = new ArrayList<File>();

    Logger log = Logger.getLogger(PathSearcherForMp3.class);

    //recursively search only for files with extension ".mp3" and add them to List.
    public List<File> mp3DirectoryFinder(File path) {
        if (path.exists()) {
            File[] filePath = path.listFiles();

            for (File file : filePath) {
                if (file.isDirectory()) {
                    mp3DirectoryFinder(file);

                } else {
                    if (file.getName().matches(EXTENSION)) {
                        mp3FilesHolder.add(file);
                    }
                }
            }
            if (mp3FilesHolder.size() == 0) {

                log.warn("There isn't any mp3 files in this directory");
                System.out.println("There isn't any mp3 files in this directory!");
                return null;
            }
            return mp3FilesHolder;

        } else {
            log.error("Path to search hadn't been found");
            System.out.println("Path to search in doesn't exist. null to return");
            return null;
        }
    }
}


