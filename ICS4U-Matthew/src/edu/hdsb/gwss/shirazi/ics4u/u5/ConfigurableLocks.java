/*
 * Name: Matthew Shirazi
 * Date: May 12th, 2018
 * Description: Creates a parent for the CONFIGURABLE locks that makes the program more efficient.
        Has a method that allows client to set a combination for the lock.
 */
package edu.hdsb.gwss.shirazi.ics4u.u5;

/**
 *
 * @author Matt
 */
public class ConfigurableLocks extends LockParent {

    // FOR MASTER U AND ANDROID LOCKS
    
    public ConfigurableLocks() {
        super();
    }
    
    public void setCombo(int[] combo) {
      
        if ( !isLocked() ) {
            
            // VALID NUMBER CHECK
            boolean validCombo = true;
            for (int i = 0; i < combo.length; i++) {
                if (combo[i] > 9 || combo[i] < 0) {                    
                    validCombo = false;
                }
            }
            if( validCombo ) {
                for (int i = 0; i < combo.length; i++) {
                    this.combo[i] = combo[i];
                }
                comboRevealed = false;
            }
            else {
                    System.out.println("Please use another combo, these numbers are not valid.");
            }
        }
        else {
            System.out.println("You must unlock the lock in order to set the combo.");
        }
    }
}
