/*
 * Name: Matthew Shirazi
 * Date: May 31, 2018
 * Description: Tests Album Database (CLIENT)
 */
package edu.hdsb.gwss.shirazi.ics4u.u7;

import java.io.RandomAccessFile;

/**
 *
 * @author 1shirazimat
 */
public class AlbumDBTester {

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception {

        try (RandomAccessFile raf = new RandomAccessFile("album_tester.txt", "rw")) {
            raf.seek(0);

            // CREATE ALBUMS
            AlbumRecord album1 = new AlbumRecord("Graduation", "Kanye West", 13, 'H', true, 54.20);
            AlbumRecord album2 = new AlbumRecord("To Pimp A Butterfly", "Kendrick Lamar", 16, 'H', true, 78.85);
            AlbumRecord album3 = new AlbumRecord("Thriller", "Michael Jackson", 9, 'P', true, 42.32);
            AlbumRecord album4 = new AlbumRecord("Section.80", "Kendrick Lamar", 16, 'H', false, 59.40);
            AlbumRecord album5 = new AlbumRecord("Without Warning", "21 Savage", 9, 'H', false, 33.37);
            AlbumRecord album6 = new AlbumRecord("Lil Pump", "Lil Pump", 15, 'H', false, 36.70);
            AlbumRecord album7 = new AlbumRecord("808s & Heartbreak", "Kanye West", 12, 'H', true, 51.97);
            AlbumRecord album8 = new AlbumRecord("Konvicted", "Akon", 12, 'H', true, 48.08);

            // WRITE TO RAF
            AlbumWriter.write(raf, album1);
            AlbumWriter.write(raf, album2);
            AlbumWriter.write(raf, album3);
            AlbumWriter.write(raf, album4);
            AlbumWriter.write(raf, album5);
            AlbumWriter.write(raf, album6);
            AlbumWriter.write(raf, album7);
            AlbumWriter.write(raf, album8);

            raf.close();

            // READ RAF  
            AlbumReader.read(raf, album1);
            AlbumReader.read(raf, album2);
            AlbumReader.read(raf, album3);
            AlbumReader.read(raf, album4);
            AlbumReader.read(raf, album5);
            AlbumReader.read(raf, album6);
            AlbumReader.read(raf, album7);
            AlbumReader.read(raf, album8);
            raf.close();
        }

    }

}
