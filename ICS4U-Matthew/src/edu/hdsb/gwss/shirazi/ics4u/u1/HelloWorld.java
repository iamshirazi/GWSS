/*
 * Name: Matthew Shirazi
 * Date: February 5,  2018
 * Description: Hello World!
 */
package edu.hdsb.gwss.shirazi.ics4u.u1;

import java.util.Scanner;

/**
 *
 * Day 01 - Hello World
 * @author 1shirazimat
 */
public class HelloWorld {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        
        System.out.println("Hello (ICS4U) World.");
        
        
        
        // THIS IS ARRAY PRACTICE
        
//        int n = 6;
//        int a = 0;
//        int [] array = new int [ (int) (Math.random() * 10 ) ];
//
//        System.out.println( (int) (Math.random() * 10 ) + 10);
        
        
        int [][] marks = {
            {1},
            {2,3,4},
            {5},
            {6,7,8,9,10}  
            
        };
        
        for (int row = 0; row < marks.length; row++) {
            for (int col = 0; col < marks.length; col++) {
                System.out.println( row + " " + col);
                marks[row][col] = Integer.parseInt (input.nextLine());
            }
            
        }
        
        
//        int [][] results = new int [6][6];
//        
//        int die1;
//        int die2;
//        
//        for (int m = 0; m < 10000000; m++) {
//            die1 = (int) (Math.random() * 6);
//            die2 = (int) (Math.random() * 6);
//            
//            results[die1][die2]++;
//        }
//        
//        for ( die1 = 0; die1 < results.length; die1++) {
//            for ( die2 = 0; die2 < results[die1].length; die2++) {
//                System.out.format("%8s", results[die1][die2]);
//                System.out.println( "" );
//        }
//        
//    }
    
  }  
}
