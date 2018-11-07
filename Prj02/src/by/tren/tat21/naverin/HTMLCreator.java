package by.tren.tat21.naverin;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

//Represent creating an HTML page for list of mp3 files
public class HTMLCreator {

    Mp3IerarchyContainer all;
    private String defaultOutputHTML = "./src/resources/catalogue.html";

    public void createHTML(List<File> mp3s) {

        BufferedWriter bw;
        try {
            //creating a new HTML file, if it's already exist replace its contents
            bw = new BufferedWriter(new FileWriter(defaultOutputHTML));
            all = new Mp3IerarchyContainer(mp3s);
            bw.write("<!DOCTYPE html lang=\"en\"><html><head>\n" +
                    "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n" +
                    "<title>Mp3Files</title>\n" +
                    "</head><style>\n" +
                    "  h2 {\n" +
                    "    margin:10px;\n" +
                    "  }\n" +
                    "  h3 {\n" +
                    "    margin:20px;\n" +
                    "  }\n" +
                    "  h4 {\n" +
                    "    margin:30px;\n" +
                    "  }\n" +
                    "</style>");

            for (Artist artist : all.artists.values()) {
                bw.write("<h2>" + artist.getName() + "</h1>\n");
                for (Album album : artist.getAlbums().values()) {
                    bw.write("<h3>" + album.getAlbumName() + "</h2>\n");
                    for (TrackInfo track : album.getSongs().values()) {
                        bw.write("<h4>"+track.getTitle()+ " " + track.getDuration() + " seconds " +
                                 "<a href=\"" + track.getPath() + "\">" + track.getPath() +"</a></h4>");
                  }
                }
            }

            bw.write("</html>");
            bw.close();

            //Simple command could be easily realised by logging in console
            System.out.println("Done");

        } catch (IOException e) {
            System.out.println("Cannot make catalogue.html file! Check if it's exist at " + defaultOutputHTML);
        }
    }
}
