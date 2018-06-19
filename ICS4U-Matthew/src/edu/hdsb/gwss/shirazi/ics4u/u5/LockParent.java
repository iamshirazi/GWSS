/*
 * Name: Matthew Shirazi
 * Date: May 9th, 2018
 * Description: The parent of all of it's children classes. 
        Has all of the methods that the locks share.
 */
package edu.hdsb.gwss.shirazi.ics4u.u5;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author 1shirazimat
 */
public abstract class LockParent implements LockInterface {

    // CLASS VARIABLE
    private static final ArrayList<Integer> USED_SERIAL_NUMBERS = new ArrayList<Integer>();

    // INSTANCE 
    protected int[] combo;
    private final int serialNumber;
    protected String name;
    protected boolean locked;
    protected boolean comboRevealed;
    private int tries = 3;
    protected int lockCapacity;

    public LockParent() {
        this.serialNumber = serialGenerator();
        this.locked = false;
        this.comboRevealed = false;
    }

    @Override
    public int getSerialNumber() {
        return serialNumber;
    }

    @Override
    public boolean isLocked() {
        return locked;
    }

    @Override
    public void lock() {

        this.locked = true;
        System.out.println("Lock has been locked.");

    }

    private int serialGenerator() {

        int serialNumbers;

        do {
            serialNumbers = (int) (Math.random() * 1000000 + 1);

        } while (USED_SERIAL_NUMBERS.contains(serialNumbers));

        USED_SERIAL_NUMBERS.add(serialNumbers);

        return serialNumbers;
    }

    @Override
    public int[] obtainCombo() {
        if( comboRevealed ) {
            System.out.println("No Can Do. Combo revealed already.");
            int[] x = { -1, -1, -1 };
            return x;
        }
        else {
            comboRevealed = true;
            return this.combo;
        }
    }

    @Override
    public boolean unlockLock(int[] combo) {

        if (this.locked == false) {
            System.out.println("The lock is already unlocked.");
            return (this.locked = false);
        } else if (Arrays.equals(this.combo, combo) && tries != 0) {
            System.out.println("The lock is unlocked.");
            tries = 3;
            return (this.locked = false);
        } else {
            if (tries > 0) {
                System.out.println("The lock is still locked.");
                tries--;
            }
            if (tries == 0) {
                System.out.println("You can no longer unlock this lock.");
            }
            return (this.locked = true);
        }
    }
    // MAKE TO STRING PRINTING INFORMATION ABOUT LOCK

    @Override
    public String toString() {
        return "LockParent{" + "serialNumber = " + serialNumber + ", name = " + name + ", locked = " + locked + ", comboRevealed = " + comboRevealed + '}';
    }
    
}
