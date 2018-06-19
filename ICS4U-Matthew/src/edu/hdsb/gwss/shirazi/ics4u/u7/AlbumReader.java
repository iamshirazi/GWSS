/*
 * Name: Matthew Shirazi
 * Date: May 28, 2018
 * Description: Reads Album in RAF
 */
package edu.hdsb.gwss.shirazi.ics4u.u7;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 *
 * @author 1shirazimat
 */
public class AlbumReader {

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception {
        
//         int id = 0;

//        try (RandomAccessFile recordFile = new RandomAccessFile("album_info.txt", "rw")) {
//            recordFile.seek(0);
//            
//            
//            AlbumRecord album = new AlbumRecord();
//            AlbumRecord albumTwo = new AlbumRecord();
//            AlbumRecord albumThree = new AlbumRecord();
//            
//            
//            char a[] = new char[AlbumRecord.LENGTH_ALBUM_NAME];
//            for (int i = 0; i < AlbumRecord.LENGTH_ALBUM_NAME; i++) {
//                a[i] = recordFile.readChar();
//            }
//            album.setAlbumName(new String(a));
//            System.out.println( album.getAlbumName() );
//            
//            a = new char[AlbumRecord.LENGTH_ARTIST_NAME];
//            for (int i = 0; i < AlbumRecord.LENGTH_ARTIST_NAME; i++) {
//                a[i] = recordFile.readChar();
//            }
//            album.setArtistName(new String(a));
//            System.out.println( album.getArtistName());
//            
//            album.setAmountOfSongs(recordFile.readInt());
//            System.out.println( album.getAmountOfSongs());
//            
//            album.setGenre(recordFile.readChar());
//            System.out.println(album.getGenre());
//            
//            album.setWentPlatinum(recordFile.readBoolean());
//            System.out.println(album.isWentPlatinum());
//            
//            album.setTime(recordFile.readDouble());
//            System.out.println(album.getTime());
//            
//            System.out.println();
//            System.out.println(album.toString());
//            System.out.println();
//            System.out.println();
//            
//            
//            //---------------------------------
//            
//            a = new char[AlbumRecord.LENGTH_ALBUM_NAME];
//            for (int i = 0; i < AlbumRecord.LENGTH_ALBUM_NAME; i++) {
//                a[i] = recordFile.readChar();
//            }
//            albumTwo.setAlbumName(new String(a));
//            System.out.println( albumTwo.getAlbumName() );
//            
//            a = new char[AlbumRecord.LENGTH_ARTIST_NAME];
//            for (int i = 0; i < AlbumRecord.LENGTH_ARTIST_NAME; i++) {
//                a[i] = recordFile.readChar();
//            }
//            albumTwo.setArtistName(new String(a));
//            System.out.println( albumTwo.getArtistName());
//            
//            albumTwo.setAmountOfSongs(recordFile.readInt());
//            System.out.println( albumTwo.getAmountOfSongs());
//            
//            albumTwo.setGenre(recordFile.readChar());
//            System.out.println(albumTwo.getGenre());
//            
//            albumTwo.setWentPlatinum(recordFile.readBoolean());
//            System.out.println(albumTwo.isWentPlatinum());
//            
//            albumTwo.setTime(recordFile.readDouble());
//            System.out.println(albumTwo.getTime());
//            
//            System.out.println();
//            System.out.println(albumTwo.toString());
//            System.out.println();
//            System.out.println();
//            
//            //----------------------------
//            
//            a = new char[AlbumRecord.LENGTH_ALBUM_NAME];
//            for (int i = 0; i < AlbumRecord.LENGTH_ALBUM_NAME; i++) {
//                a[i] = recordFile.readChar();
//            }
//            albumThree.setAlbumName(new String(a));
//            System.out.println( albumThree.getAlbumName() );
//            
//            a = new char[AlbumRecord.LENGTH_ARTIST_NAME];
//            for (int i = 0; i < AlbumRecord.LENGTH_ARTIST_NAME; i++) {
//                a[i] = recordFile.readChar();
//            }
//            albumThree.setArtistName(new String(a));
//            System.out.println( albumThree.getArtistName());
//            
//            albumThree.setAmountOfSongs(recordFile.readInt());
//            System.out.println( albumThree.getAmountOfSongs());
//            
//            albumThree.setGenre(recordFile.readChar());
//            System.out.println(albumThree.getGenre());
//            
//            albumThree.setWentPlatinum(recordFile.readBoolean());
//            System.out.println(albumThree.isWentPlatinum());
//            
//            albumThree.setTime(recordFile.readDouble());
//            System.out.println(albumThree.getTime());
//            
//            System.out.println();
//            System.out.println(albumThree.toString());
//            System.out.println();
//            System.out.println();
//            recordFile.close();
//        }
    }
    
    public static void read(RandomAccessFile recordFile, AlbumRecord album) throws IOException {
        
        int id = 0;
        
        char a[] = new char[AlbumRecord.LENGTH_ALBUM_NAME];
            for (int i = 0; i < AlbumRecord.LENGTH_ALBUM_NAME; i++) {
                a[i] = recordFile.readChar();
            }
            album.setAlbumName(new String(a));
            System.out.println( album.getAlbumName() );
            
            a = new char[AlbumRecord.LENGTH_ARTIST_NAME];
            for (int i = 0; i < AlbumRecord.LENGTH_ARTIST_NAME; i++) {
                a[i] = recordFile.readChar();
            }
            album.setArtistName(new String(a));
            System.out.println( album.getArtistName());
            
            album.setAmountOfSongs(recordFile.readInt());
            System.out.println( album.getAmountOfSongs());
            
            album.setGenre(recordFile.readChar());
            System.out.println(album.getGenre());
            
            album.setWentPlatinum(recordFile.readBoolean());
            System.out.println(album.isWentPlatinum());
            
            album.setTime(recordFile.readDouble());
            System.out.println(album.getTime());
            
            System.out.println();
            System.out.println(album.toString());
            System.out.println();
            System.out.println();
            
    }
    
}
