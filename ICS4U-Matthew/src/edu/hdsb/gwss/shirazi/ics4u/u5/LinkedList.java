/*
 * Name: Matthew Shirazi
 * Date: April 26th, 2018
 * Description: Creates a Linked List
 */
package edu.hdsb.gwss.shirazi.ics4u.u5;

/**
 *
 * @author 1shirazimat
 */
public class LinkedList implements LinkListInterface {

    private Node head;
    private Node tail;

    public LinkedList() {
        this.head = null;
        this.tail = null;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        LinkedList list = new LinkedList();

        // TEST #1: ADD FROM HEAD AND REMOVE HEAD
        System.out.println("TEST #1: ADD FROM HEAD AND REMOVE HEAD");
        list.addAtFront("A");
        System.out.println(list.toString());
        list.remove("A");
        System.out.println(list.toString());
        list.remove("B");
        System.out.println(list.toString());

        // TEST #2: ADD FROM HEAD AND REMOVE TAIL
        System.out.println("TEST #2: ADD FROM HEAD AND REMOVE TAIL");
        list.addAtFront("B");
        list.addAtFront("A");
        System.out.println(list.toString());
        list.remove("B");
        System.out.println(list.toString());

        // TEST #3: ADD FROM TAIL AND REMOVE HEAD
        System.out.println("TEST #3: ADD FROM TAIL AND REMOVE HEAD");
        list.makeEmpty();
        System.out.println(list.toString());
        list.addAtEnd("A");
        list.addAtEnd("B");
        list.addAtEnd("C");
        list.addAtEnd("A");
        System.out.println(list.toString());
        list.remove("A");
        System.out.println(list.toString());

        // TEST #4:
    }

    /*
    * Returns amount of values in Linked List.
     */
    @Override
    public int size() {

        int size = 0;

        if (this.isEmpty()) {
            return 0;
        } else if (head == tail) {
            System.out.println(head.getValue() + "/" + tail.getValue());
            return 1;
        } else {
            size = 1;
            Node n = head;
            while (n.getNext() != null) {
                n = n.getNext();
                size++;
            }

            return size;
        }
    }

    /*
    * Makes string empty.
     */
    @Override
    public void makeEmpty() {

        this.head = null;
        this.tail = null;
    }

    /*
    * Checks to see if string is empty.
     */
    @Override
    public boolean isEmpty() {

        if (head == null) {
            return true;
        } else {
            return false;
        }
    }

    /*
     * Adds a node to the front of the linked list.
     */
    @Override
    public void addAtFront(String str) {

        if (head == null) {
            head = new Node(str);
            tail = head;
        } else { //IF LINKED LIST HAS A HEAD
            Node shadowNode = new Node(str);
            shadowNode.setNext(head);
            head = shadowNode;
        }

    }

    /*
     * Adds a node to the end of the linked list.
     */
    @Override
    public void addAtEnd(String str) {

        if (head == null) {
            head = new Node(str);
            tail = head;

        } else { //IF LINKED LIST HAS A HEAD
            Node shadowNode = head;

            while (shadowNode.getNext() != null) {
                shadowNode = shadowNode.getNext();
            }
            shadowNode.setNext(new Node(str));
            tail = shadowNode.getNext();

        }
    }

    /*
     * Removes the first occurrence of the given string.
     */
    @Override
    public void remove(String str) {
        //
        if (isEmpty()) {
            return;
        }

        Node n = head;

        // SPECIAL CASE; HEAD IS WHAT YOU WANT TO REMOVE
        if (n.getValue().equals(str)) {

            removeHead();
        } else {
            while (n.getNext() != null && !n.getNext().getValue().equals(str)) {
                n = n.getNext();

            }

            if (n.getNext().getValue().equals(str)) {
                if (n.getNext() == tail) {
                    removeTail();
                } else {
                    Node toDelete = n.getNext();
                    n.setNext(toDelete.getNext());
                    toDelete.setNext(null);
                }
            } else {
                // NOT THERE.
                System.out.println("NOT FOUND");
            }
        }
    }

    /*
    * Removes head node and returns its value.
     */
    @Override
    public String removeHead() {

        String str;

        if (this.isEmpty()) {
            return null;
        } else {
            Node toDelete = head;
            str = toDelete.getValue();

            this.head = head.getNext();
            toDelete.setNext(null);
            return str;
        }
    }

    /*
    * Removes tail node and returns its value.
     */
    @Override
    public String removeTail() {

        String str = null;

        if (this.isEmpty()) {
            return null;
        } else {
            if (size() == 1) {
                str = head.getValue();
                makeEmpty();
            } else {
                Node n = head;
                while (n.getNext() != tail) {
                    n = n.getNext();
                }
                Node toDelete = n;
                str = toDelete.getValue();

                this.tail = n;
                toDelete.setNext(null);
                return str;
            }
        }

        return str;
    }

    /*
    * Returns value of head node.
     */
    @Override
    public String head() {

        if (!this.isEmpty()) {
            System.out.println(head.getValue());
            return head.getValue();
        } else {
            return null;
        }
    }

    /*
    * Returns value of tail node.
     */
    @Override
    public String tail() {

        if (!this.isEmpty()) {
            System.out.println(tail.getValue());
            return tail.getValue();
        } else {
            return null;
        }
    }

    public String toString() {
        String s = "H-->";
        Node n = head;
        while (n != null) {
            s = s + n.getValue() + "-->";
            n = n.getNext();
        }
        s = s + "T";
        return s;
    }

}
