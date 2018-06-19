package edu.hdsb.gwss.ics4u.pt;

/**
 * Open Hash Table Tester
 *
 * @version v2016.S2
 */
public class Tester {

    /**
     */
    public static void main( String[] args ) {

        CSStudent studentAA1 = new CSStudent( "Arielle", "A", 7111, 11 );
        CSStudent studentAA2 = new CSStudent( "Ali", "A", 2221, 12 );
        CSStudent studentJB = new CSStudent( "James", "B", 2332, 12 );
        CSStudent studentRD = new CSStudent( "Raidi", "D", 1443, 12 );
        CSStudent studentAE = new CSStudent( "Ahmad", "E", 2554, 12 );
        CSStudent studentJG = new CSStudent( "Gillian", "J", 6665, 12 );
        CSStudent studentYK = new CSStudent( "Yulia", "K", 7976, 12 );
        CSStudent studentRL = new CSStudent( "Ryan", "L", 8387, 12 );
        CSStudent studentRM = new CSStudent( "Ruiling", "M", 9098, 11 );
        CSStudent studentYM = new CSStudent( "Youssef", "M", 1120, 12 );
        CSStudent studentFS = new CSStudent( "Faisal", "S", 2231, 12 );
        CSStudent studentKSE = new CSStudent( "Karim", "SE", 8695, 12 );
        CSStudent studentMS = new CSStudent( "Matthew", "S", 3695, 12 );
        CSStudent studentCW = new CSStudent( "Christiana", "W", 2691, 12 );
        CSStudent studentEX = new CSStudent( "Ellie", "X", 1234, 11 );
        CSStudent studentIY = new CSStudent( "Irmak", "Y", 1234, 12 );
        
        OpenHashTable ht = new OpenHashTable();
        System.out.println( ht.toString() );
        
        // EMPTY?
        assert(ht.isEmpty());
        assert (ht.capacity() == 11);
        assert (ht.size() == 0);
        assert (!ht.containsKey(1));
        
        // MAKE FULL, THEN EMPTY
        ht.put(studentMS);
        System.out.println( ht.toString() );

    }

}
