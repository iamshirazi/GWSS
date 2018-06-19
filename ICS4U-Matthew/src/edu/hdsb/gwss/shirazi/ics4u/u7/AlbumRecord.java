/*
 * Name: Matthew Shirazi
 * Date: May 23, 2018
 * Description: Creates a RAF for albums.
 */
package edu.hdsb.gwss.shirazi.ics4u.u7;

import java.io.*;

/**
 *
 * @author 1shirazimat
 */
public class AlbumRecord implements Serializable{

    protected static final int RECORD_SIZE = 85;
    protected static final int LENGTH_ARTIST_NAME = 15;
    protected static final int LENGTH_ALBUM_NAME = 20;

    private int id;
    private boolean wentPlatinum;
    private char genre;
    private String albumName;
    private String artistName;
    private int amountOfSongs;
    private double time;

    public AlbumRecord() {
        
    }

    public AlbumRecord(String albumName, String artistName, int amountOfSongs,
        char genre, boolean wentPlatinum, double time) {
        this.setAlbumName(albumName);
        this.setArtistName(artistName);
        this.setAmountOfSongs(amountOfSongs);
        this.setGenre (genre);
        this.setWentPlatinum (wentPlatinum);
        this.setTime (time);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        StringBuilder temp = new StringBuilder();

        if (albumName != null) {
            temp.append(albumName.trim());
        } else {
            temp.append("TBD");
        }

        // trucates or pads the string
        temp.setLength(LENGTH_ALBUM_NAME);
        this.albumName = temp.toString();
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        StringBuilder temp = new StringBuilder();

        if (artistName != null) {
            temp.append(artistName.trim());
        } else {
            temp.append("TBD");
        }

        // trucates or pads the string
        temp.setLength(LENGTH_ARTIST_NAME);
        this.artistName = temp.toString();
    }

    public int getAmountOfSongs() {
        return amountOfSongs;
    }

    public void setAmountOfSongs(int amountOfSongs) {
        this.amountOfSongs = amountOfSongs;
    }
    
    public boolean isWentPlatinum() {
        return wentPlatinum;
    }

    public void setWentPlatinum(boolean wentPlatinum) {
        this.wentPlatinum = wentPlatinum;
    }

    public char getGenre() {
        return genre;
    }

    public void setGenre(char genre) {
        this.genre = genre;
    }

    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "AlbumRecord{ " + "Went Platinum = " + wentPlatinum + ", Genre = " + genre + ", Album = " + albumName + ", Artist = " + artistName + ", Number Of Songs = " + amountOfSongs + ", Time = " + time + " minutes " + '}';
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        
        
    }

}
