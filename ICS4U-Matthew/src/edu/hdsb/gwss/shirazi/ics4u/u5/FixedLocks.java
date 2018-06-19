/*
 * Name: Matthew Shirazi
 * Date: May 15th, 2018
 * Description: Creates a parent for the FIXED locks that makes the program more efficient. 
        Has a getCombo method that makes a fixed combination.
 */
package edu.hdsb.gwss.shirazi.ics4u.u5;

/**
 *
 * @author 1shirazimat
 */
public class FixedLocks extends LockParent {
    
    public FixedLocks() {
        super();
    }

    protected int[] getCombo() {
        
        // MAKE A THREE DIGIT CODE
        
        for (int i = 0; i < combo.length; i++) {
            combo[i] = (int) (Math.random() * lockCapacity);
        }
        System.out.println("The combo for your lock is: "
        + combo[0] + ", " + combo[1] + ", " + combo[2]);
        
        this.lock();
        return combo;
    }
    
}
