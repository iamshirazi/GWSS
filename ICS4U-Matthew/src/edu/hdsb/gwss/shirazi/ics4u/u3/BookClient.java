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
public class BookClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // EMPTY BOOK-
        Book a = new Book();
        a.setAuthor("Matthew A. Shirazi");
        a.setTitle("Turning Mankind into Kind Man");
        a.setPages(365);
        System.out.println(a);
        
        // BOOK BY ID
        Book b = new Book(123);
        System.out.println(b);
        
        // BOOK BY SECONDARY KEY
        Book c = new Book(1, "Math for Dummies", "Shirazi");
        System.out.println(c);
        Book d = new Book(1, "Math for Dummies", "Shirazi");
        System.out.println(d);
        
        System.out.println(a.equals(a));
        
        
    }
    
}
