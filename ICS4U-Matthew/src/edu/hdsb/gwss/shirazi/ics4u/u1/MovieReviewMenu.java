/*
 * Name: Matthew Shirazi
 * Date: February 19,  2018
 * Description: The good copy and combination of MovieReview and 
 * MovieReviewPartThreePlusFour. This program is a menu that does everything
 * from the two programs mentioned. 
 * the user.
 */
package edu.hdsb.gwss.shirazi.ics4u.u1;

import java.io.File;
import java.util.Scanner;

/**
 *
 * @author Matt
 */
public class MovieReviewMenu {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        
    // MOVIE REVIEW FILE
        File reviews = new File ( ".\\data\\movie.review\\MovieReviews.txt" );
        File wordList = new File ("");
        
        // VARIABLES
        int number;
        int choice = 0;
        int score = 0;
        double average = 0;
        
    // OBJECTS
        String word; 
        Scanner input = new Scanner(System.in);
        Scanner user = new Scanner(System.in);
        
    // INPUT    
    
    while ( choice != 5 ) {
        System.out.println("What would you like to do?");
        System.out.println("1: Get the score of a word ");
        System.out.println("2: Get the average score of words in a file (one word per line)");
        System.out.println("3: Find the highest and lowest scoring words in a file");
        System.out.println("4: Sort words from a file into positive.txt and negative.txt");
        System.out.println("5: Exit the program");
        choice = user.nextInt();
      
        System.out.println();
        
        switch (choice) {
            case 1:
                System.out.println("Please enter a word:");
                word = input.nextLine();
                word = word.toLowerCase();
                number = MovieReview.wordCount( word, reviews );
                System.out.println(word + " appears " + number + " times.");
                score = MovieReview.wordTotalScore(word, reviews, number);
                average = MovieReview.wordAverage(word, reviews, score, number);
                System.out.println("The average score of reviews containg the"
                 + " word '" + word + "' is " + average);
                System.out.println();
                System.out.println();
                break;
            case 2:
                MovieReview.sentenceAverage( wordList, reviews );
                System.out.println("Average score: " + average);
                System.out.println();
                System.out.println();
                break;
            case 3:
                MovieReviewPartThreePlusFour.multipleWordScore( wordList, reviews );
                System.out.println();
                System.out.println();
                break;
            case 4:
                MovieReviewPartThreePlusFour.multipleWordScoreSort( wordList, reviews );
                System.out.println();
                System.out.println();
                break;
            case 5:
                System.out.println("Thank you, have a nice day!");
                break;
            default:
                break;
        }
      }
    }
}
