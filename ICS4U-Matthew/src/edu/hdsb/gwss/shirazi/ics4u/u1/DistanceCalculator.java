/*
 * Name: Matthew Shirazi
 * Date: Monday February 11, 2018
 * Description: Calculates an accurate distance between two places. Takes into 
   account Earth's curvature.
 */
package edu.hdsb.gwss.shirazi.ics4u.u1;

import static java.lang.Math.acos;
import static java.lang.Math.cos;
import static java.lang.Math.sin;
import java.util.Scanner;
import java.text.NumberFormat;

/**
 *
 * @author Matt
 */
public class DistanceCalculator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    
    //VARIABLES
    double lat1, lon1, lat2, lon2, distance;
    
    //OBJECTS
    Scanner input = new Scanner(System.in);
    
    NumberFormat decimal = NumberFormat.getIntegerInstance();
    decimal.setMinimumFractionDigits(0);
    decimal.setMaximumFractionDigits(2);
    
    String place1, place2;
    
    //INPUT
    System.out.println("Please enter the name of the FIRST location:");
    place1 = input.nextLine();
    
    System.out.println("Please enter the name of the SECOND location:");
    place2 = input.nextLine();
    
    System.out.println("Please enter the LATITUDE of " + place1 + " in DEGREES:");
    lat1 = input.nextDouble();
    
    System.out.println("Please enter the LONGITUDE of " + place1 + " in DEGREES:");
    lon1 = input.nextDouble();
    
    System.out.println("Please enter the LATITUDE of " + place2 + " in DEGREES:");
    lat2 = input.nextDouble();
    
    System.out.println("Please enter the LONGITUDE of " + place2 + " in DEGREES:");
    lon2 = input.nextDouble();
        
    //OUTPUT
    distance = 6378.8 * acos(sin(lat1/57.2958) * sin(lat2/57.2958) + cos(lat1/57.2958)
        * cos(lat2/57.2958) * cos(lon2/57.2958 - lon1/57.2958));
    
    System.out.println("The distance between " + place1 + " and " + place2 + " is " + 
        decimal.format(distance) + " kilometers.");
    
    }
    
}
