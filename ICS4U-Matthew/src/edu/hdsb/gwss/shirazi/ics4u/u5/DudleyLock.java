/*
 * Name: Matthew Shirazi
 * Date: May 11th, 2018
 * Description: Creates a fixed, 3 code lock
 */
package edu.hdsb.gwss.shirazi.ics4u.u5;

/**
 *
 * @author 1shirazimat
 */
public class DudleyLock extends FixedLocks {

    public DudleyLock() {
        super();
        this.name = "Dudley Lock";
        this.combo = new int[3];
        this.lockCapacity = 59;
    }
}
