/*
 * Name: Matthew Shirazi
 * Date: May 9th, 2018
 * Description: Tests the lock program.
 */
package edu.hdsb.gwss.shirazi.ics4u.u5;

import java.util.Arrays;

/**
 *
 * @author 1shirazimat
 */
public class LockTester {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        int[] goodCombo = {9, 2, 3, 4};
        int[] badCombo = {9, 9, 9, 9};
        int[] badFCombo = {38, 17, 20};

        System.out.println("ANDROID LOCK");
        AndroidLock aL = new AndroidLock();
        System.out.println(aL.getSerialNumber());
        System.out.println(aL.isLocked());
        aL.setCombo(goodCombo);
        aL.lock();
        aL.unlockLock(badCombo);
        System.out.println(aL.isLocked());
        aL.unlockLock(goodCombo);
        assert ( aL.isLocked() == false );
        aL.unlockLock(goodCombo);
        System.out.println(aL.isLocked());
        System.out.println(Arrays.toString(aL.obtainCombo()));

        // CHECK TO SEE IF THEY CAN UNLOCK AFTER 3 BAD TRIES
        System.out.println();
        System.out.println("TEST: CAN YOU UNLOCK IT AFTER 3 BAD TRIES");
        System.out.println();

        aL.lock();
        aL.unlockLock(badFCombo);
        aL.unlockLock(badFCombo);
        aL.unlockLock(badFCombo);
        assert( aL.unlockLock(goodCombo) == true);
        aL.unlockLock(goodCombo);

        System.out.println();
        System.out.println("------------------------------");
        System.out.println();
        System.out.println("MASTER U LOCK");

        MasterULock mL = new MasterULock();
        System.out.println(mL.getSerialNumber());
        System.out.println(mL.isLocked());
        mL.setCombo(goodCombo);
        mL.lock();
        mL.unlockLock(badCombo);
        System.out.println(mL.isLocked());
        mL.unlockLock(goodCombo);
        assert ( mL.isLocked() == false );
        mL.unlockLock(goodCombo);
        System.out.println(mL.isLocked());
        System.out.println(Arrays.toString(mL.obtainCombo()));

        // CHECK TO SEE IF THEY CAN UNLOCK AFTER 3 BAD TRIES
        System.out.println();
        System.out.println("TEST: CAN YOU UNLOCK IT AFTER 3 BAD TRIES");
        System.out.println();

        mL.lock();
        mL.unlockLock(badFCombo);
        mL.unlockLock(badFCombo);
        mL.unlockLock(badFCombo);
        assert( mL.unlockLock(goodCombo) == true);
        mL.unlockLock(goodCombo);

        System.out.println();
        System.out.println("------------------------------");
        System.out.println();
        System.out.println("DUDLEY LOCK");

        DudleyLock dL = new DudleyLock();
        System.out.println(dL.getSerialNumber());
        System.out.println(dL.isLocked());
        int[] rightCombo = dL.getCombo();
        System.out.println(dL.isLocked());
        dL.unlockLock(badFCombo);
        System.out.println(dL.isLocked());
        dL.unlockLock(rightCombo);
        assert ( dL.isLocked() == false );
        dL.unlockLock(rightCombo);
        System.out.println(dL.isLocked());
        System.out.println(Arrays.toString(dL.obtainCombo()));

        // CHECK TO SEE IF THEY CAN UNLOCK AFTER 3 BAD TRIES
        System.out.println();
        System.out.println("TEST: CAN YOU UNLOCK IT AFTER 3 BAD TRIES");
        System.out.println();

        dL.lock();
        dL.unlockLock(badFCombo);
        dL.unlockLock(badFCombo);
        dL.unlockLock(badFCombo);
        assert( dL.unlockLock(rightCombo) == true);
        dL.unlockLock(rightCombo);

        System.out.println();
        System.out.println("------------------------------");
        System.out.println();
        System.out.println("MASTER LOCK");

        MasterLock maL = new MasterLock();
        System.out.println(maL.getSerialNumber());
        System.out.println(maL.isLocked());
        int[] greatCombo = maL.getCombo();
        System.out.println(maL.isLocked());
        maL.unlockLock(badFCombo);
        System.out.println(maL.isLocked());
        maL.unlockLock(greatCombo);
        assert ( maL.isLocked() == false );
        maL.unlockLock(greatCombo);
        System.out.println(maL.isLocked());
        System.out.println(Arrays.toString(maL.obtainCombo()));

        // CHECK TO SEE IF THEY CAN UNLOCK AFTER 3 BAD TRIES
        System.out.println();
        System.out.println("TEST: CAN YOU UNLOCK IT AFTER 3 BAD TRIES");
        System.out.println();

        maL.lock();
        maL.unlockLock(badFCombo);
        maL.unlockLock(badFCombo);
        maL.unlockLock(badFCombo);
        assert( maL.unlockLock(rightCombo) == true);
        maL.unlockLock(greatCombo);
        
        System.out.println(maL.toString() );

    }

}
