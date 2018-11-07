package by.tren.tat21.naverin;

import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

//Represent receiving hash from the file using MD5 algorithm
public class ControlSum {
    private String sum;

    public String getCheckSum(File track) {

        try {
            //Scanning given file and given it's bytes hex hash representation
            MessageDigest md = MessageDigest.getInstance("MD5");
            FileInputStream input = new FileInputStream(track);
            byte[] dataBytes = new byte[1024];
            int numRead = 0;

            while ((numRead = input.read(dataBytes)) != -1) {
                md.update(dataBytes, 0, numRead);
            }
            byte[] mdBytes = md.digest();
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < mdBytes.length; i++) {
                sb.append(Integer.toString((mdBytes[i] & 0xff) + 0x100, 16).substring(1));
            }

            sum = sb.toString();
            input.close();

        } catch (IOException e){
            System.out.println("Can't find mp3 file to get check sum");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return sum;
    }
}










