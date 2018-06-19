package edu.hdsb.gwss.shirazi.ics4u.u5;

/**
 *
 * @author 1shirazimat
 */
public interface LockInterface {
    
    /*
    * Gets the serial number
    */
    public int getSerialNumber();
    
    /*
    * Checks to see if the lock is locked
    */
    public boolean isLocked();
    
    /*
    * Locks the lock
    */
    public void lock();
    
    /*
    * Gets combination
    */
    public int[] obtainCombo();
    
    /*
    * Unlocks the lock
    */
    public boolean unlockLock(int[] combo);
}
