/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.shirazi.ics4u.u2;

/**
 *
 * @author 1shirazimat
 */
public class EuclidAlgorithm {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        int m = 33;
        int a = 0;
        int n = 27;
        int gcd = 0;
        
        if (m == n) {
            gcd = m;
            System.out.println( "The GCD is " + gcd);
        } 
        else {
            
        while ( n != 0 ) {
            
        if ( m > n ) {
          while ( n != 0 ) {  
            a = n;
            n = (m % n);
            m = a;
            gcd = m;
          }
          System.out.println( "The GCD is " + gcd );
        }
        else if ( n > m ) {
          a = m;
          m = n;
          n = a;
        }
      }
    }
  }
}
