/*
 * Name: Matthew Shirazi
 * Date: May 10th, 2018
 * Description: Creates a configurable, 4 code lock
 */
package edu.hdsb.gwss.shirazi.ics4u.u5;

/**
 *
 * @author 1shirazimat
 */
public class MasterULock extends ConfigurableLocks {

    public MasterULock() {
        super();
        this.name = "Master U Lock";
        this.combo = new int [4];
    }
}
