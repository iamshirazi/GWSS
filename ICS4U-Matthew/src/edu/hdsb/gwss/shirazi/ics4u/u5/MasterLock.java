/*
 * Name: Matthew Shirazi
 * Date: May 12th, 2018
 * Description: Creates a fixed, 3 code lock.
 */
package edu.hdsb.gwss.shirazi.ics4u.u5;

/**
 *
 * @author Matt
 */
public class MasterLock extends FixedLocks {
    
    public MasterLock() {
        super();
        this.name = "Master Lock";
        this.combo = new int[3];
        this.lockCapacity = 39;
    }
}
