package by.tren.tat21.naverin;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.setProperty("log4j.configurationFile", "./src/resources/log4j2.xml");
        try {
            if (args.length == 0) {
                System.out.println("Enter any path as a parameter \"C:\\Directory\" ");
                return;
            }

            PathSearcherForMp3 dr = new PathSearcherForMp3();;
            List<File> allSongs = new ArrayList<File>();

            //Checking for all files in all directories
            for (int i = 0; i < args.length-1;i++) {
                File file = new File(args[i]);
                allSongs.addAll(dr.mp3DirectoryFinder(file));
            }

             //Container that contains all of the songs attributes hierarchy
            Mp3IerarchyContainer cont = new Mp3IerarchyContainer(allSongs);
            //Create the HTML page with all of a mp3 files
            HTMLCreator cre = new HTMLCreator();
            cre.createHTML(allSongs);

        } catch (ArrayIndexOutOfBoundsException | NullPointerException e) {
            System.out.println("Enter correct amount of parameters (at least one), and check if you given path is exist");
        }
    }
}
