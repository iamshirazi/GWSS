/*
 * Name: Matthew Shirazi
 * Date: May 10th, 2018
 * Description: Creates a configurable, four code lock
 */
package edu.hdsb.gwss.shirazi.ics4u.u5;

/**
 *
 * @author 1shirazimat
 */
public class AndroidLock extends ConfigurableLocks {

    public AndroidLock() {
        super();
        this.name = "Android Lock";
        this.combo = new int[4];
    }
}
