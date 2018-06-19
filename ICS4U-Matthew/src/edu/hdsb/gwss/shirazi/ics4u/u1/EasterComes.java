/*
 * Name: Matthew Shirazi
 * Date: February 8,  2018
 * Description: Find out when Easter Sunday is.
 */
package edu.hdsb.gwss.shirazi.ics4u.u1;
import java.util.Scanner;

/**
 *
 * @author 1shirazimat
 */
public class EasterComes {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    
    //VARIABLES
    int a,b,c,d,e,f,g,h,i,j,k,m,p;
    int year, month, day = 0;
    
    //OBJECT
    Scanner input = new Scanner(System.in); 
    
    //INPUT 
    System.out.println("Please enter the year:");
    year = input.nextInt();
    
    //MATH
    a = (year % 19);
    b = (year / 100);
    c = (year % 100);
    d = b / 4;
    e = b % 4;
    f = (b + 8) / 25;
    g = (b-f+1) / 3;
    h = (19*a + b - d - g + 15) % 30;
    i = c / 4;
    k = c % 4;
    j = (32 + 2*e + 2*i - h - k) % 7;
    m = (a + 11*h + 22*j) / 451;
    month = (h + j - 7*m + 114) / 31;
    p = (h + j - 7*m + 114) % 31;
    day = p + 1;
    
    //OUTPUT
    if (month == 3) {
        System.out.println("Easter is on " + "March " + day + ", " + year);
    } if (month == 4) {
        System.out.println("Easter is on " + "April " + day + ", " + year);
    }
 }
}