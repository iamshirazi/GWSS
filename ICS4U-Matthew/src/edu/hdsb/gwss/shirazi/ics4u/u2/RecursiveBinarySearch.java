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
public class RecursiveBinarySearch {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       int[]data = {1,22,33,44,67,77,88,99,102,107};
       
        System.out.println( bS( 44, data ) );
       
    }
    
    public static int bS(int sV, int[]data) {
        
        return bS( sV, data, 0, data.length-1 );
    }
    
    private static int bS( int sV, int[] data, int L, int R ) {
        
      if ( L > R ) return -1;
      
      int mid = ( L + R ) /2;
      
      if ( data[mid] == sV ) return mid;
          
      // RIGHT SIDE?
      if ( data[mid] < sV ) return bS( sV, data, mid+1, R);
      
      // LEFT SIDE?
      return bS( sV, data, L, mid-1);
    }
    
}
