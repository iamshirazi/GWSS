package edu.hdsb.gwss.shirazi.ics4u.test;

/**
 *
 * @author 1shirazimat
 */
public interface FractionInterface {
    
    public double size();
    
 
    public double larger(Fraction f, Fraction g);
    
   
    public Fraction times(Fraction f, Fraction g);
    
  
    public void reduce();
    
    
    public boolean equals(Fraction g);
    
    
    public Fraction invert();
    
}
