/*
 * Name: Matthew Shirazi
 * Date: June 5th, 2018
 * Description: Creates a Hash Function
 */
package edu.hdsb.gwss.shirazi.ics4u.u5;

/**
 *
 * @author 1shirazimat
 */
public class HashTableLP implements HashTableInterface {

    public Student[] students;

    public HashTableLP() {
        this(20);
    }

    public HashTableLP(int initialSize) {

        // YOU MUST MAKE SIZE PRIME
        students = new Student[nextPrime(initialSize)];

    }

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception {

        HashTableLP ht = new HashTableLP();

        // EMPTY
        Student a = new Student();
        Student b = new Student("Matthew Shirazi", 1);

        ht.makeEmpty();
        assert (ht.capacity() == 23);
        assert (ht.size() == 0);
        assert (ht.loadFactor() == 0);
        assert (!ht.contains(b));
        assert (!ht.containsKey(1));
        assert (ht.isEmpty());
        System.out.println(ht.toString());

        // FILL HASHTABLE TO LOAD FACTOR, DOES IT RESIZE?
        int i = 0;

        while (ht.size() != 17) {

            ht.put(i, b);
            i++;
        }
        System.out.println("Load: " + ht.loadFactor());

        System.out.println(ht.toString());

        i = 17;
        ht.put(i, b);
        System.out.println(ht.toString());
        
        assert(ht.contains(b));
        assert (ht.containsKey(1));
        assert (ht.capacity() == 73);
        assert (!ht.isEmpty());
        assert (ht.size() == 18);
        
    }

    /**
     * @return Returns the number of keys in this hashtable.
     */
    @Override
    public int size() {
        int size = 0;
        for (int i = 0; i < students.length; i++) {
            if (students[i] != null) {
                size++;
            }
        }
        return size;
    }

    /**
     * @return Returns the capacity of this hash table.
     */
    @Override
    public int capacity() {
        return students.length;
    }

    /**
     * @return The load factor of the hashtable.
     */
    @Override
    public double loadFactor() {
        return (double) size() / capacity();
    }

    /**
     * Clears this hashtable so that it contains no keys.
     */
    @Override
    public void makeEmpty() {
        // RE-DECLARE YOUR ARRAY
        int n = students.length;
        students = new Student[n];
    }

    /**
     * Tests if this hashtable maps no keys to values.
     *
     * @return
     */
    @Override
    public boolean isEmpty() {
        if (size() == 0) {
            return true;
        }
        return false;
    }

    /**
     * Increases the capacity of and internally reorganizes this hashtable, in
     * order to accommodate and access its entries more efficiently.
     */
    @Override
    public void rehash() {

        int n = size() * 4;
        n = nextPrime(n);

        // n must be the next PRIME
        Student[] old = students;

        students = new Student[n];

        for (int i = 0; i < old.length; i++) {
            if (old[i] != null) {
                put(old[i].getStudentNumber(), old[i]);
            }
        }

    }

    /**
     * Returns the value to which the specified key is mapped, or null if this
     * map contains no mapping for the key.
     *
     * @param key
     * @return
     */
    @Override
    public Student get(int key) {

        Student s = null;

        int i = hash(key);

        while (students[i] != null) {
            if (students[i].getStudentNumber() == key) {
                return students[i];
            }
            i = (i + 1) % capacity();
        }

        return s;
    }

    /**
     *
     * @param key
     * @param value
     */
    @Override
    public void put(int key, Student value) {

        int i = hash(key);

        while (students[i] != null) {
            i = (i + 1) % capacity();
        }

        students[i] = value;

        if (loadFactor() > 0.75) {
            rehash();
        }
    }

    /**
     *
     * @param value
     * @return
     */
    @Override
    public boolean contains(Student value) {
        if (get(value.getStudentNumber()) == null) {
            return false;
        }
        return true;
    }

    /**
     *
     * @param key
     * @return
     */
    @Override
    public boolean containsKey(int key) {
        if (get(key) == null) {
            return false;
        }
        return true;
    }

    /**
     *
     * @param key
     * @return
     */
    @Override
    public int hash(int key) {

        return (key % capacity());

    }

    private static int nextPrime(int n) {

        n++;
        while (!isPrime(n)) {
            n++;
        }
        return n;
    }

    private static boolean isPrime(int num) {
        for (int i = 2; 2 * i < num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {

        String s = "";

        for (int i = 0; i < students.length; i++) {

            if (students[i] == null) {
                s = s + String.format("%5s %5s %-15s\n", i, "[E]", "[EMPTY]");
            } else {

                s = s + String.format("%5s %5s %-15s\n", i, students[i].getStudentNumber(), students[i].getName());
            }
        }

        return s;

    }

}
