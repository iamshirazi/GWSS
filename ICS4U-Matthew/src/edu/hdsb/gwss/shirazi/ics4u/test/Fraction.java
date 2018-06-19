/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.shirazi.ics4u.test;

/**
 *
 * @author 1shirazimat
 */
public class Fraction implements FractionInterface {

    private int numerator;
    private int denominator;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Fraction f = new Fraction(3, 9);
        System.out.println("Size: " + f.size());
        f.reduce();
        
        Fraction g = new Fraction(2, 6);
        System.out.println(f.equals(g));
    }

    public Fraction() {

    }

    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public int getNumeratior() {
        return numerator;
    }

    public void setNumeratior(int numerator) {
        this.numerator = numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public void setDenominator(int denominator) {
        this.denominator = denominator;
    }

    @Override
    public String toString() {
        return "Fraction{ " + numerator + "/" + denominator + " " + '}';
    }
    
    
    
    // ACTUAL CODE
    
    @Override
    public double size() {

        return (double) numerator / (double) denominator;
    }

    public static double larger(Fraction f) {

        return 0;
    }

    @Override
    public double larger(Fraction f, Fraction g) {
        return 0;
    }

    public static Fraction times(Fraction f) {
        return f;
    }

    @Override
    public Fraction times(Fraction f, Fraction g) {
        return f;
    }

    @Override
    public void reduce() {

        int lcm;

        if (numerator / denominator > 0) {

            lcm = (int) this.size();
            
            while (denominator > 1) {
                numerator = numerator / lcm;
                denominator = denominator /lcm;
            }
            
            System.out.println(toString());
        }

        else if (denominator / numerator > 0) {

            while (numerator > 1 && denominator > 1) {
                lcm = denominator / (denominator / numerator);
                
                numerator = numerator / lcm;
                denominator = denominator / lcm;
            }
            System.out.println( toString() );
        }

    }

    @Override
    public boolean equals(Fraction g) {
        
        if ( this.size() == g.size() ) {
            return true;
        }
        
        else {
            return false;
        }
    }

    
    // CHANGE TO FRACTION
    @Override
    public Fraction invert() {
        
    int p = this.numerator;
        this.numerator = this.denominator;
        this.denominator = p;
        
        return this;
    }
    
}
