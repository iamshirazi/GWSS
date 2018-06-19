/*
 * Name: Matthew A. Shirazi
 * Date: April 5,  2018
 * Description: Reads a file of elevation data and draws a map of the best path.
 */
package edu.hdsb.gwss.shirazi.ics4u.u3;

import java.util.Scanner;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.StringTokenizer;

/**
 *
 * @author 1shirazimat
 */
public class MountainPaths {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {

        // VARIABLES
        String fileName = "Colorado.844x480.dat";

        // OBJECTS
        Scanner input = new Scanner(System.in);

        // READ
        int[][] data = read(fileName);

        DrawingPanel panel = new DrawingPanel(data[0].length, data.length);
        Graphics g = panel.getGraphics();

        System.out.println("TASK 2: HIGHEST / LOWEST ELEVATION");
        int min = findMinValue(data);
        System.out.println("\tMin: " + min);

        int max = findMaxValue(data);
        System.out.println("\tMax: " + max);

        System.out.println("TASK 3: DRAW MAP");
        drawMap(g, data);

        System.out.println("TASK 4A: INDEX OF MIN IN COL 0");
        int minRow = indexOfMinInCol(data, 0);
        System.out.println("\tRow with lowest Col 0 Value: " + minRow);

        System.out.println("TASK 4B: PATH from LOWEST STARTING ELEVATION");
        g.setColor(Color.RED);
        int totalChange = drawLowestElevPath(g, data, minRow, 0); //
        System.out.println("\tLowest-Elevation-Change Path starting at row "
                + minRow + " gives total change of: " + totalChange);

        //System.out.println("TASK 5: Find BEST path");
        //g.setColor( Color.RED );
        //int bestRow = indexOfLowestElevPath( g, data );
        //System.out.println("TASK 6: DRAW BEST PATH");
        //g.setColor( Color.GREEN ); //set brush to green for drawing best path
        //totalChange = drawLowestElevPath( g, data, bestRow, 0 );
        //System.out.println( "\tThe Lowest-Elevation-Change Path starts at row:
        //" + bestRow + " and gives a total change of: " + totalChange );
    }

    public static int[][] read(String fileName) throws FileNotFoundException {

        // VARIABLE
        int[][] data = null;
        int numRows = 0, numCols = 0;

        File mapData = new File(".\\data\\mountain.paths\\" + fileName);

        // OBJECT
        Scanner pathFile = new Scanner(mapData);

        // HOW MANY COLUMS?
        String line = pathFile.nextLine();
        numRows++;
        StringTokenizer st = new StringTokenizer(line, " ");
        numCols = st.countTokens();

        // HOW MANY ROWS?
        while (pathFile.hasNextLine()) {
            pathFile.nextLine();
            numRows++;
        }

        data = new int[numRows][numCols];

        // MOVE FILE POINTER TO THE TOP
        pathFile = new Scanner(mapData);

        for (int row = 0; row < data.length; row++) {
            line = pathFile.nextLine();
            st = new StringTokenizer(line, " ");
            for (int col = 0; col < data[row].length; col++) {
                data[row][col] = Integer.parseInt(st.nextToken());
            }
        }

        return data;
    }

    public static int findMinValue(int[][] data) {

        // VARIABLES
        int min = 1000000; // ONE MILLION

        // PROCESSING
        for (int r = 0; r < data.length; r++) {
            for (int c = 0; c < data[r].length; c++) {

                if (data[r][c] < min) {
                    min = data[r][c];
                }
            }
        }
        return min;

    }

    public static int findMaxValue(int[][] data) {

        // VARIABLES
        int max = 0;

        // PROCESSING
        for (int r = 0; r < data.length; r++) {
            for (int c = 0; c < data[r].length; c++) {

                if (data[r][c] > max) {
                    max = data[r][c];
                }
            }
        }
        return max;
    }

    public static void drawMap(Graphics g, int[][] data) {

        // VARIABLES
        int minE = findMinValue(data);
        int maxE = findMaxValue(data);
        double grayScaleFactor = (maxE - minE) / 255.0;
        int elev;
        int colour;

        // PROCESSING
        for (int r = 0; r < data.length; r++) {

            for (int c = 0; c < data[r].length; c++) {
                elev = data[r][c];
                elev = elev - minE;
                colour = ((int) (elev / grayScaleFactor));
                g.setColor(new Color(colour, colour, colour));
                g.fillRect(c, r, 1, 1);
            }
        }
    }

    public static int indexOfMinInCol(int[][] data, int col) {

        int minElevRow = 0;

        for (int r = 1; r < data.length; r++) {
            if (data[r][col] < data[minElevRow][col]) {
                minElevRow = r;
            }
        }
        return minElevRow;
    }

    /**
     * Find the minimum elevation-change route from West-to-East in the given
     * grid, from the given starting row, and draw it using the given graphics
     * context
     *
     * @param g - the graphics context to use
     * @param data - the 2D array of elevation values
     * @param col
     * @param row - the starting row for traversing to find the min path
     * @param totalElev
     * @return total elevation of the route
     */
    public static int drawLowestElevPath(Graphics g, int[][] data, int row, int col ) {

        // X MARKS THE SPOT!  YOU ARE HERE!
        g.fillRect(col, row, 1, 1);

        // VARIABLES
        int upElev;
        int downElev;
        int random = (int) (Math.random() * 3) + 1;
        
        // BASE CASE; LAST COLUMN
        if( col == data[row].length - 1 ) {
            return 0;
        }
        
//      ----------------------- ELEVATION CHANGES -------------------------

        // CAN'T GO UP
        if( row == 0 ) {
            upElev = Integer.MAX_VALUE;
        }
        else {
           upElev = Math.abs( data[row][col] - data[row-1][col+1] ); 
        }
        // STRAIGHT
        int straightElev = Math.abs( data[row][col] - data[row][col+1] ); 
       
        // CAN'T GO DOWN
        if ( row == 480 ) {
           downElev = Integer.MAX_VALUE;
        }
        else {
            downElev = Math.abs(data[row][col] - data[row+1][col+1]);
        }
        
        // MOVE FOR?
        if( straightElev <= upElev && straightElev <= downElev ) {
            return straightElev + drawLowestElevPath( g, data, row, col+1 );
        }
       
        // EQUAL; RAMDOM
        if ( upElev == downElev && downElev == straightElev ) {
            if (random == 1) {
                return upElev + drawLowestElevPath( g, data, row-1, col+1 );
            }
            if (random == 2) {
                return straightElev + drawLowestElevPath( g, data, row, col+1 );
            }
            else {
                return downElev + drawLowestElevPath( g, data, row+1, col+1 );
            }    
        }
        
        // MOVE UP?
        if( upElev <= straightElev && upElev <= downElev ) {
            return upElev + drawLowestElevPath( g, data, row-1, col+1 );
        }
        
        // MOVE DOWN?
        else {
            return downElev + drawLowestElevPath( g, data, row+1, col+1 );
        }
       
     }
//        if ( col < data[row].length - 1 ) {
//
//            // X MARKS THE SPOT!  YOU ARE HERE!
//            g.fillRect(col, row, 1, 1);
//
//            // CALCULATE ELEVATION CHANGES:  UP, DOWN, STRAIGHT
//            int up = data[row - 1][col + 1];
//            int down = data[row + 1][col + 1];
//            int straight = data[row][col + 1];
//            int value = data[row][col];
//            int a, b, c;
//            int newRow;
//            int newCol;
//            int random = (int) (Math.random() * 2) + 1;
//            int tripleRand = (int) (Math.random() * 3) + 1;
//
//            a = Math.abs(value - straight);
//            b = Math.abs(value - up);
//            c = Math.abs(value - down);
//
//            // STRAIGHT?
//            if (a < b && a < c) {
//                newCol = col + 1;
//                totalElev = totalElev + a;
//                drawLowestElevPath(g, data, row, newCol, totalElev);
//            } // UP?
//            if (b < a && b < c) {
//                newCol = col + 1;
//                newRow = row - 1;
//                totalElev = totalElev + b;
//                drawLowestElevPath(g, data, newRow, newCol, totalElev);
//            } // DOWN?
//            if (c < a && c < b) {
//                newCol = col + 1;
//                newRow = row + 1;
//                totalElev = totalElev + c;
//                drawLowestElevPath(g, data, newRow, newCol, totalElev);
//            } // SPECIAL CASES
//            if (a == b && a < c) {
//                if (random == 1) {
//                    // GO STRAIGHT 
//                    newCol = col + 1;
//                    totalElev = totalElev + a;
//                    drawLowestElevPath(g, data, row, newCol, totalElev);
//                } else {
//                    // GO UP
//                    newCol = col + 1;
//                    newRow = row - 1;
//                    totalElev = totalElev + b;
//                    drawLowestElevPath(g, data, newRow, newCol, totalElev);
//                }
//            }
//            if (a == c && a < b) {
//                if (random == 1) {
//                    // GO STRAIGHT 
//                    newCol = col + 1;
//                    totalElev = totalElev + a;
//                    drawLowestElevPath(g, data, row, newCol, totalElev);
//                } else {
//                    // GO DOWN
//                    newCol = col + 1;
//                    newRow = row + 1;
//                    totalElev = totalElev + c;
//                    drawLowestElevPath(g, data, newRow, newCol, totalElev);
//                }
//            }
//            if (b == c && b < a) {
//                if (random == 1) {
//                    // UP
//                    newCol = col + 1;
//                    newRow = row - 1;
//                    totalElev = totalElev + b;
//                    drawLowestElevPath(g, data, newRow, newCol, totalElev);
//                } else {
//                    // DOWN
//                    newCol = col + 1;
//                    newRow = row + 1;
//                    totalElev = totalElev + c;
//                    drawLowestElevPath(g, data, newRow, newCol, totalElev);
//                }
//            }
//            if (b == a && b < c) {
//                if (random == 1) {
//                    // UP
//                    newCol = col + 1;
//                    newRow = row - 1;
//                    totalElev = totalElev + b;
//                    drawLowestElevPath(g, data, newRow, newCol, totalElev);
//                } else {
//                    // STRAIGHT
//                    newCol = col + 1;
//                    totalElev = totalElev + a;
//                    drawLowestElevPath(g, data, row, newCol, totalElev);
//                }
//            }
//            if (c == a && c < b) {
//                if (random == 1) {
//                    // DOWN
//                    newCol = col + 1;
//                    newRow = row + 1;
//                    totalElev = totalElev + c;
//                    drawLowestElevPath(g, data, newRow, newCol, totalElev);
//                } else {
//                    // STRAIGTT
//                    newCol = col + 1;
//                    totalElev = totalElev + a;
//                    drawLowestElevPath(g, data, row, newCol, totalElev);
//                }
//            }
//            if (c == b && c < a) {
//                if (random == 1) {
//                    // DOWN
//                    newCol = col + 1;
//                    newRow = row + 1;
//                    totalElev = totalElev + c;
//                    drawLowestElevPath(g, data, newRow, newCol, totalElev);
//                } else {
//                    // UP
//                    newCol = col + 1;
//                    newRow = row - 1;
//                    totalElev = totalElev + b;
//                    drawLowestElevPath(g, data, newRow, newCol, totalElev);
//                }
//            }
//            if (c == b && b == a && a == c) {
//                if (tripleRand == 1) {
//                    // GO STRAIGHT
//                    newCol = col + 1;
//                    totalElev = totalElev + a;
//                    drawLowestElevPath(g, data, row, newCol, totalElev);
//                }
//                if (tripleRand == 2) {
//                    // GO UP
//                    newCol = col + 1;
//                    newRow = row - 1;
//                    totalElev = totalElev + b;
//                    drawLowestElevPath(g, data, newRow, newCol, totalElev);
//                } else {
//                    // GO DOWN
//                    newCol = col + 1;
//                    newRow = row + 1;
//                    totalElev = totalElev + c;
//                    drawLowestElevPath(g, data, newRow, newCol, totalElev);
//                }
//            }
//        }   
    

    /**
     * Generate all west-to-east paths, find the one with the lowest total
     * elevation change, and return the index of the row that path starts on.
     *
     * @param g - the graphics context to use
     * @param data - the 2D array of elevation values
     * @return the index of the row where the lowest elevation-change path
     * starts.
     */
    public static int indexOfLowestElevPath(Graphics g, int[][] data) {

        for (int row = 0; row < data.length; row++) {

            MountainPaths.drawLowestElevPath(g, data, row, 0);
            
        }

        return -1;
    }

}
