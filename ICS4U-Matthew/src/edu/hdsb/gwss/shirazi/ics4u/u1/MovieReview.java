/*
 *
 */
package edu.hdsb.gwss.shirazi.ics4u.u1;

import java.io.File;
import java.util.Scanner;

/**
 * Movie Review Assignment
 *
 * @author Wm.Muir
 * @version 2017-18.S2
 */
public class MovieReview {

    public static void main( String[] args ) throws Exception {

        // MOVIE REVIEW FILE
        File reviews = new File ( ".\\data\\movie.review\\MovieTest.txt" );
        File wordList = new File ("");
        
        // VARIABLES
        int number;
        int score;
        double average;
        
        // OBJECTS
        String word = ""; 
        Scanner input = new Scanner(System.in);
        
        // INPUT
        System.out.println("Please enter a word:");
        word = input.nextLine();
        word = word.toLowerCase();
        
        // OUTPUT
        number = MovieReview.wordCount(word, reviews);
        System.out.println(word + " appears " + number + " times.");
        System.out.println();
        score = MovieReview.wordTotalScore(word, reviews, number);
        average = MovieReview.wordAverage(word, reviews, score, number);
        System.out.println("Average score: " + average);
        System.out.println();
        MovieReview.sentenceAverage(wordList, reviews);
    }

    /**
     * This method will count the number of reviews that contain the key word.
     *
     * @param word the key word the review must contain.
     * @param reviews the file that contains the movie reviews.
     * @return the number of reviews that contain the key work at least once.
     */
    public static int wordCount( String word, File reviews) throws Exception {

        // VARIABLES
        int number = 0;
        
        // OBJECTS
        Scanner movieFile = new Scanner( reviews );
        
        // OUTPUT
        while ( movieFile.hasNextLine() ) {
            String review = movieFile.nextLine();
            
            if ( review.contains(word) ) {
               number++; 
            }
        }
        
       
        
        return number;
    }

    /**
     * This method will accumulate the the movie review scores that contain the
     * key word.
     *
     * @param word the key word the review must contain.
     * @param reviews the file that contains the movie reviews.
     * @param number
     * @return the sum of the scores for reviews that contain the key work at
     * least once.
     */
    public static int wordTotalScore( String word, File reviews, int number ) throws Exception {
        
        // VARIABLES
        int rating = 0;
        int score = 0;
        
        // OBJECTS
        Scanner movieFile = new Scanner( reviews );

        // OUTPUT
        while ( movieFile.hasNextLine() ) {
            rating = movieFile.nextInt();
            String review = movieFile.nextLine();
            
            if ( review.contains(word) ) {
                score = rating + score;
            }    
        }    
        return score;
    }

    /**
     * Average score of reviews containing that word, given the specified file.
     *
     * @param word the key word the review must contain.
     * @param reviews reviews the file that contains the movie reviews.
     * @param score
     * @param number
     * @return the average score for the key word. Word Total Score / Word Count
     */
    public static double wordAverage( String word, File reviews, int score, int number ) throws Exception {

        // OUTPUT
        double average = (double) score / number; 
        
       return average;
       
    }

    /**
     * This method returns the average movie review score of the words in the
     * file, given th specified movie review file.
     * @param wordList
     * @param reviews
     */
    public static double sentenceAverage( File wordList, File reviews) throws Exception {

        // VARIABLES
        int number;
        double wordAmount = 0;
        double totalScore = 0;
        
        // OBJECTS
        String name = "";
        Scanner input = new Scanner(System.in);
        Scanner movieFile = new Scanner( reviews );
        
        // INPUT
        System.out.println("Please enter the name of a file with words you want"
         + " to find the average score for: ");
        name = input.nextLine();
        System.out.println();
        
        wordList = new File ( ".\\data\\movie.review\\" + name);
            // NEW OBJECT
                Scanner fileScanner = new Scanner( wordList );
        
        // PROCESSING
        while ( fileScanner.hasNextLine() ) {
           String line = fileScanner.nextLine();
           String word = line;
           wordAmount++;
           
             number = MovieReview.wordCount(word, reviews);
             int score = MovieReview.wordTotalScore(word, reviews, number);
             double average = MovieReview.wordAverage(word, reviews, score, number);
             
             totalScore = totalScore + average;
        }
        double totalAverage = totalScore / wordAmount;
       
        // OUTPUT
        System.out.println("The average score for words in " + name + " is " + totalAverage);
        
        if (totalAverage <= 1.99) {
            System.out.println("The overall sentiment is negative.");
        } else if (totalAverage >= 2.01) {
            System.out.println("The overall sentiment is positive.");
        } else {
            System.out.println("The overall sentiment is neutral.");
        } 
        return -1.0;

    }

}
