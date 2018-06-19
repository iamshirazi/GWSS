/*
 * Name: Matthew Shirazi
 * Date: May 23, 2018
 * Description: Writes album to RAF.
 */
package edu.hdsb.gwss.shirazi.ics4u.u7;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 *
 * @author 1shirazimat
 */
public class AlbumWriter {

    public static int n = 1;

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception {

        
        
//        AlbumRecord a1 = new AlbumRecord("Graduation", "Kanye West", 13, 'H', true, 54.20);
//        AlbumRecord albumTwo = new AlbumRecord("To Pimp A Butterfly", "Kendrick Lamar", 16, 'H', true, 78.85);
//        AlbumRecord albumThree = new AlbumRecord("Thriller", "Michael Jackson", 9, 'P', true, 42.32);
//        
//        

//        System.out.println("ALBUM ONE");
//        System.out.println("**************************");
//
//        recordFile.seek(0);
//
//        recordFile.writeChars(a1.getAlbumName());
//        recordFile.writeChars(a1.getArtistName());
//        recordFile.writeInt(a1.getAmountOfSongs());
//        recordFile.writeChar(a1.getGenre());
//        recordFile.writeBoolean(a1.isWentPlatinum());
//        recordFile.writeDouble(a1.getTime());
//        
//        System.out.println(recordFile.length());
//        
//        //----------------------------------------------
//
//        System.out.println();
//        System.out.println("ALBUM TWO:");
//        System.out.println("**************************");
//        
//        recordFile.writeChars(albumTwo.getAlbumName());
//        recordFile.writeChars(albumTwo.getArtistName());
//        recordFile.writeInt(albumTwo.getAmountOfSongs());
//        recordFile.writeChar(albumTwo.getGenre());
//        recordFile.writeBoolean(albumTwo.isWentPlatinum());
//        recordFile.writeDouble(albumTwo.getTime());
//        
//        System.out.println(recordFile.length());
//        
//        //----------------------------------------------
//
//        System.out.println();
//        System.out.println("ALBUM THREE:");
//        System.out.println("**************************");
//        
//        recordFile.writeChars(albumThree.getAlbumName());
//        recordFile.writeChars(albumThree.getArtistName());
//        recordFile.writeInt(albumThree.getAmountOfSongs());
//        recordFile.writeChar(albumThree.getGenre());
//        recordFile.writeBoolean(albumThree.isWentPlatinum());
//        recordFile.writeDouble(albumThree.getTime());
//        
//        System.out.println(recordFile.length());
//        
//        recordFile.close();
    }

    public static void write(RandomAccessFile recordFile, AlbumRecord a1) throws IOException {

            System.out.println("ALBUM " + n);
            System.out.println("**************************");
            n++;

            recordFile.writeChars(a1.getAlbumName());
            recordFile.writeChars(a1.getArtistName());
            recordFile.writeInt(a1.getAmountOfSongs());
            recordFile.writeChar(a1.getGenre());
            recordFile.writeBoolean(a1.isWentPlatinum());
            recordFile.writeDouble(a1.getTime());

            System.out.println(recordFile.length());
            
    }

}
