/*
 * Name: Matthew Shirazi
 * Date: May 31, 2018
 * Description: Database for album
 */
package edu.hdsb.gwss.shirazi.ics4u.u7;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 1shirazimat
 */
public class AlbumDB {
    
    private static RandomAccessFile raf;
    
    public static void open() {
        
        try {
            raf = new RandomAccessFile("album_info.txt", "rw");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AlbumDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public static void close() {
        
        try {
            raf.close();
        } catch (IOException ex) {
            Logger.getLogger(AlbumDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public static AlbumRecord get( int id ) throws Exception {
        
        AlbumRecord album = new AlbumRecord();

        // SEEK
        id = ( album.getId() - 1 ) * AlbumRecord.RECORD_SIZE;
        
        char a[] = new char[AlbumRecord.LENGTH_ALBUM_NAME];
        for (int i = 0; i < AlbumRecord.LENGTH_ALBUM_NAME; i++) {
            a[i] = raf.readChar();
        }        
        album.setAlbumName(new String(a));
        System.out.println( album.getAlbumName() );
        
        a = new char[AlbumRecord.LENGTH_ARTIST_NAME];
        for (int i = 0; i < AlbumRecord.LENGTH_ARTIST_NAME; i++) {
            a[i] = raf.readChar();
        }        
        album.setArtistName(new String(a));
        System.out.println( album.getArtistName());
        
        album.setAmountOfSongs(raf.readInt());
        System.out.println( album.getAmountOfSongs());
        
        album.setGenre(raf.readChar());
        System.out.println(album.getGenre());
        
        album.setWentPlatinum(raf.readBoolean());
        System.out.println(album.isWentPlatinum());
        
        album.setTime(raf.readDouble());
        System.out.println(album.getTime());
        
        return album;
    }
    
    public static AlbumRecord save( AlbumRecord r ) {
        
        try {
            
            // ADD vs UPDATE
            if( r.getId() == -1 ) {
                raf.seek( raf.length() );
                
                r.setId( ((int) raf.length() / AlbumRecord.RECORD_SIZE ) + 1 );
            }
            else {
                r.setId(( r.getId() - 1 ) * AlbumRecord.RECORD_SIZE);
            }
            
            raf.writeChars(r.getAlbumName());
            raf.writeChars(r.getArtistName());
            raf.writeInt(r.getAmountOfSongs());
            raf.writeChar(r.getGenre());
            raf.writeBoolean(r.isWentPlatinum());
            raf.writeDouble(r.getTime());            
            System.out.println(raf.length());
            
        } catch (IOException ex) {
            Logger.getLogger(AlbumDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return r;
    }
}
