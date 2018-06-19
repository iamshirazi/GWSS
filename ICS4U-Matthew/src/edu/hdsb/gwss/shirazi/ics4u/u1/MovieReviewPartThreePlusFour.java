/*
 * Name: Matthew Shirazi
 * Date: February 19,  2018
 * Description: Continuation of MovieReview.java, but this part determines the 
 * most positive and most negative word. 
 */
package edu.hdsb.gwss.shirazi.ics4u.u1;

import java.io.File;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.BufferedWriter;

/**
 *
 * @author Matt
 */
public class MovieReviewPartThreePlusFour {

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main( String[] args ) throws Exception {
        
    // MOVIE REVIEW FILE
        File reviews = new File ( ".\\data\\movie.review\\MovieReviews.txt" );
        File wordList = new File ("");    
        
        // VARIABLES
        int number = 0;
        int score = 0;
        double average = 0;
        
        // OBJECTS
        String word = ""; 
        Scanner input = new Scanner(System.in);
        
       // OUTPUT
       MovieReviewPartThreePlusFour.multipleWordScore( wordList, reviews );
       MovieReviewPartThreePlusFour.multipleWordScoreSort( wordList, reviews ); 
    }
    
    
    /**
     * This method will count the number of reviews that contain the key word.
     *
     * @param wordList
     * @param reviews the file that contains the movie reviews.
     * @return the number of reviews that contain the key work at least once.
     */
    
    public static double multipleWordScore( File wordList, File reviews ) throws Exception {

        // VARIABLES
        int number = 0;
        double wordAmount = 0;
        double totalScore = 0;
        double mostPos = 0;
        double mostNeg = 4;
        
        // OBJECTS
        String name;
        String word;
        String wordPos = "";
        String wordNeg = "";
        Scanner input = new Scanner(System.in);
        Scanner movieFile = new Scanner( reviews );
        
        // INPUT
        System.out.println("Please enter the name of a file, with words, to find"
        + " the most positive and most negative words.");
        name = input.nextLine();
        System.out.println();
        
        wordList = new File ( ".\\data\\movie.review\\" + name);
            // NEW OBJECT
                Scanner fileScanner = new Scanner( wordList );
                
        // PROCESSING 
        while ( fileScanner.hasNextLine() ) {
           String line = fileScanner.nextLine();
           word = line;
           
            number = MovieReview.wordCount( word, reviews );
            
            int score = MovieReview.wordTotalScore( word, reviews, number );
            
            double average = MovieReview.wordAverage( word, reviews, score, number );
             
             if ( average > mostPos ) {
                 wordPos = word;
                 mostPos = average;
             } if ( average < mostNeg ) {
                 wordNeg = word;
                 mostNeg = average;
             }
        }
        
        System.out.println("The most positive word in the file " + name + " is '"
        + wordPos + "' which has a score of " + mostPos);
        
        System.out.println();
        
        System.out.println("The most negative word in the file " + name + " is '"
        + wordNeg + "' which has a score of " + mostNeg);
                
        return -1;
 }
    
    public static double multipleWordScoreSort( File wordList, File reviews) throws Exception {

        // VARIABLES
        int number;
        double wordAmount;
        double totalScore;
        
        // OBJECTS
        String name;
        String word;
        String wordPos;
        String wordNeg;
        Scanner input = new Scanner(System.in);
        Scanner movieFile = new Scanner( reviews );
        File positive = new File (".\\data\\movie.review\\positive.txt");
        File negative = new File (".\\data\\movie.review\\negative.txt");
        FileWriter writerPos = new FileWriter (positive.getAbsoluteFile(), true);
        FileWriter writerNeg = new FileWriter (negative.getAbsoluteFile(), true);
        BufferedWriter buffPos = new BufferedWriter(writerPos);
        BufferedWriter buffNeg = new BufferedWriter(writerNeg); 
        
        // BEFORE INPUT
        if (!positive.exists() ) {
            positive.createNewFile();
        } if (!negative.exists()) {
            negative.createNewFile();
        }
        
        // INPUT
        System.out.println("Please enter the name of a file with words that you"
        + " want to sort into positive.txt and negative.txt");
        name = input.nextLine();
        System.out.println();
        
        wordList = new File ( ".\\data\\movie.review\\" + name);
            // NEW OBJECT
                Scanner fileScanner = new Scanner( wordList );
                
        // OUTPUT 
        while ( fileScanner.hasNextLine() ) {
           String line = fileScanner.nextLine();
           word = line;
           
            number = MovieReview.wordCount( word, reviews );
            
            int score = MovieReview.wordTotalScore( word, reviews, number );
            
            double average = MovieReview.wordAverage( word, reviews, score, number );
            
             if ( average > 2.1 ) {
                 wordPos = word;
                 buffPos.write(wordPos + "\r\n");
                 
             } if ( average < 1.9 ) {
                 wordNeg = word;
                 buffNeg.write(wordNeg + "\r\n");
             }
        }
        buffPos.close();
        buffNeg.close();
        System.out.println("Program was successful.");
        
        return -1;
 }
}
