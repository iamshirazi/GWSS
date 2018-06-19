/*
 * SHOWS HOW TO MAKE PROGRAM 'BULLETPROOF'
 */
package edu.hdsb.gwss.shirazi.ics4u.u7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author 1shirazimat
 */
public class TryCatchFinally {

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     * @throws java.lang.ClassNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException, ClassNotFoundException {

        // Try/Catch/Finally
        Scanner i = new Scanner(System.in);

        // pH 0 -14
        double pH;

        do {
            File file = new File("");
            try {
                pH = Double.parseDouble(i.nextLine());
                if (pH < 0 || pH > 14) {
                    System.out.println("Invalid");
                } else {
                    // WRITE
                    // CLOSE
                }
            } catch (Exception e) {
                pH = -1;
                System.out.println("pH must be a decimal/whole number in numerals.");
            } finally {

                System.out.println("FINALLY!");

                try {

                } catch (Exception e2) {

                }
            }

        } while (pH > 14 || pH < 0);
    }

}
