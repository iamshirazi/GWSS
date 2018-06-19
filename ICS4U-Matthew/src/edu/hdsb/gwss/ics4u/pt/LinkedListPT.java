package edu.hdsb.gwss.ics4u.pt;

/**
 * Linked List of Students
 *
 * @version v2018.S2
 */
public class LinkedListPT {

    private NodePT head;
    private NodePT tail;

    /**
     * Constructor: Empty Linked List
     */
    public LinkedListPT() {
        this.head = null;
        this.tail = null;
    }

    /**
     * @return returns the size (# of students) in the linked list.
     */
    public int size() {
        // TO DO
        int size = 0;

        if (this.isEmpty()) {
            return 0;
        } else if (head == tail) {
            System.out.println(head.getData() + "/" + tail.getData());
            return 1;
        } else {
            size = 1;
            NodePT n = head;
            while (n.getNext() != null) {
                n = n.getNext();
                size++;
            }

            return size;
        }
    }

    /**
     * This method makes the linked list empty.
     */
    public void makeEmpty() {
        // TO DO
        this.head = null;
        this.tail = null;
    }

    /**
     * This method returns true if the linked list is empty
     *
     * @return returns true if there are no student objects in the linked list
     */
    public boolean isEmpty() {
        // TO DO
        if (head == null) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * This method adds a student object to the end of the linked list.
     *
     * @param student
     */
    public void addAtEnd(CSStudent student) {
        // TODO
        if (head == null) {
            head = new NodePT(student);
            tail = head;

        } else { //IF LINKED LIST HAS A HEAD
            NodePT shadowNode = head;

            while (shadowNode.getNext() != null) {
                shadowNode = shadowNode.getNext();
            }
            shadowNode.setNext(new NodePT(student));
            tail = shadowNode.getNext();

        }
    }

    /**
     * This method will get a student object from the linked list, given the
     * student number
     *
     * @param key student number (key)
     * @return returns the student object for the given key, or null if it
     * doesn't exist.
     */
    public CSStudent get(int key) {
        // TODO

        CSStudent student;

        if (isEmpty()) {
            return null;
        }

        NodePT n = head;

        // SPECIAL CASE; HEAD IS WHAT YOU WANT TO REMOVE
        if (n.getData().equals(key)) {
            student = n.getData();
            return student;
        } else {
            while (n.getNext() != null && !n.getNext().getData().equals(key)) {
                n = n.getNext();

            }

            if (n.getNext().getData().equals(key)) {
                if (n.getNext() == tail) {
                    student = n.getData();
                    return student;
                } else {
                    NodePT toDelete = n.getNext();
                    n.setNext(toDelete.getNext());
                    toDelete.setNext(null);
                }
            } else {
                // NOT THERE.
                System.out.println("NOT FOUND");
            }
        }

        return null;
    }

    /**
     * This method will remove a student object from the linked list, given the
     * student number.
     *
     * @param key student number (key)
     * @return returns the removed student object, or null if the key is not
     * found
     */
    public CSStudent remove(int key) {
        // TODO
        if (isEmpty()) {
            return null;
        }

        NodePT n = head;

        // SPECIAL CASE; HEAD IS WHAT YOU WANT TO REMOVE
        if (n.getData().equals(key)) {

            removeHead();
        } else {
            while (n.getNext() != null && !n.getNext().getData().equals(key)) {
                n = n.getNext();

            }

            if (n.getNext().getData().equals(key)) {
                if (n.getNext() == tail) {
                    removeTail();
                } else {
                    NodePT toDelete = n.getNext();
                    n.setNext(toDelete.getNext());
                    toDelete.setNext(null);
                }
            } else {
                // NOT THERE.
                System.out.println("NOT FOUND");
            }
        }
        return null;
    }

    /**
     * DONE FOR YOU
     *
     * @return
     */
    @Override
    public String toString() {
        return "HEAD: " + toString(this.head);
    }

    /**
     * DONE FOR YOU
     */
    private String toString(NodePT n) {
        String s = "";
        if (n != null) {
            s = n.getData() + " --> " + this.toString(n.getNext());
        }
        return s;
    }

    private CSStudent removeHead() {
        CSStudent student;

        if (this.isEmpty()) {
            return null;
        } else {
            NodePT toDelete = head;
            student = toDelete.getData();

            this.head = head.getNext();
            toDelete.setNext(null);
            return student;
        }
    }

    private CSStudent removeTail() {
        CSStudent student = null;

        if (this.isEmpty()) {
            return null;
        } else {
            if (size() == 1) {
                student = head.getData();
                makeEmpty();
            } else {
                NodePT n = head;
                while (n.getNext() != tail) {
                    n = n.getNext();
                }
                NodePT toDelete = n;
                student = toDelete.getData();

                this.tail = n;
                toDelete.setNext(null);
                return student;
            }
        }
        return student;
    }
}
