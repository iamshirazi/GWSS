/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.shirazi.ics4u.u3;

/**
 *
 * @author 1shirazimat
 */
public class Book {
    
    
    // CLASS CONSTANTS
    
    final static String PUBLISHER = "Garth Publications";
    final static String[] GENRE = {"Unknown" , "Fiction" , "Non-Fiction"};

    // CLASS VARIABLES
    private static int lastId = 0;
    
    
    // OBJECT VARIABLES
    
    private long id;
    private int pages;
    private int edition;
    private int genreId;
    private String title;
    private String author;

    public Book() {
        
        
        
    }

    public Book(long id) {
        this.id = id;
        
        
    }

    public Book(int edition, String title, String author) {
        this.edition = edition;
        this.title = title;
        this.author = author;
        this.id = ++lastId;
    }
    
    
    
    

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getGenreId() {
        return genreId;
    }
    
    public String getGenre() {
        return GENRE[genreId];
    }

    public void setGenreId(int genreId) {
        if ( genreId < 0 || genreId > GENRE.length-1 ) {
            // UNKNOWN GENRE
            this.genreId = 0;
        }
        
        
        this.genreId = genreId;
    }
    
    

    @Override
    public String toString() {
        return "Book{" + "id=" + id + ", edition=" + 
                edition + ", title=" + title + ", author=" + author + '}';
    }
    
    
    
}
