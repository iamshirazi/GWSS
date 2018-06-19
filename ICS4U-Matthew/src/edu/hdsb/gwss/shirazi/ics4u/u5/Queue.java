/*
 * Name: Matthew Shirazi
 * Date: April 22nd, 2018
 * Description: Creates a Queue
 */
package edu.hdsb.gwss.shirazi.ics4u.u5;

/**
 *
 * @author Matt
 */
public class Queue implements QueueInterface {

    // INSTANCE
    private int front;
    private int back;
    private int[] queue;

    public Queue() {
        this(4);
    }

    public Queue(int size) {
        this.queue = new int[size];
        this.front = -1;
        this.back = -1;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Queue q = new Queue(4);

        // TEST #1: IS QUEUE EMPTY?
        System.out.println("TEST #1: IS QUEUE EMPTY?");
        assert (q.capacity() == 4);
        assert (q.front() == -1);
        assert (q.back() == -1);
        assert (q.dequeue() == -1);
        assert (q.size() == 0);
        assert (q.isEmpty());
        assert (!q.isFull());

        // TEST #2: FILL QUEUE
        System.out.println("TEST #2: FILL QUEUE");
        for (int i = 1; i <= 4; i++) {
            q.enqueue(i);
            System.out.println(q.toString());
            assert (q.front() == 1);
            assert (q.back() == i);
            assert (q.size() == i);
            assert (q.capacity() == 4);
            assert (!q.isEmpty());

            if (i < 4) {
                assert (!q.isFull());
            } else {
                assert (q.isFull());
            }
        }

        // TEST #3: OVER FLOW THE QUEUE
        System.out.println("TEST #3: OVER FLOW THE QUEUE");
        q.enqueue(12);
        assert (q.capacity() == 4);
        assert (q.front() == 1);
        assert (q.back() == 4);
        assert (q.size() == 4);
        assert (!q.isEmpty());
        assert (q.isFull());

        // TEST #4 - DEQUEUE UNTIL QUEUE IS EMPTY
        System.out.println("TEST #4 - DEQUEUE UNTIL QUEUE IS EMPTY");
        for (int i = 4; i >= 1; i--) {
            // QUEUE IS ALREADY FULL
            assert (q.dequeue() == 4 - i + 1);
            System.out.println(q.toString());
            assert (q.capacity() == 4);

            if (i > 1) {
                assert (q.size() == i - 1);
                assert (!q.isEmpty());
            }
            else {
                assert (q.isEmpty());
            }
        }
        
        // TEST #5 - UNDER THE QUEUE
        System.out.println("TEST #5 - UNDER THE QUEUE");
        assert (q.dequeue() == -1);
        assert (q.front() == -1);
        assert (q.back() == -1);
        assert (q.size() == 0);
        assert (q.capacity() == 4);
        assert (q.isEmpty());
        assert (!q.isFull());
        
        // TEST #6 - FILL THE QUEUE
        System.out.println("TEST #6 - FILL THE STACK AND THEN MAKE EMPTY");
        for (int i = 1; i <= 4; i++) {
            q.enqueue(i);
        }

        // MAKE IT EMPTY
        q.makeEmpty();
        assert (q.dequeue() == -1);
        assert (q.front() == -1);
        assert (q.back() == -1);
        assert (q.size() == 0);
        assert (q.capacity() == 4);
        assert (q.isEmpty());
        assert (!q.isFull());
    }

    /*
    * Returns value at front of the string
     */
    @Override
    public Integer front() {
        if (this.isEmpty()) {
            return -1;
        } else {
            return queue[front];
        }
    }

    /*
    * Returns value at back of the string
     */
    @Override
    public Integer back() {
        if (this.isEmpty()) {
            return -1;
        } else {
            return queue[back];
        }
    }

    /*
    * Adds element to queue
     */
    @Override
    public void enqueue(Integer value) {
        if (this.isFull()) {
            System.out.println("Can't enter queue, the queue is full.");
        } else if (isEmpty()) {
            back = 0;
            front = 0;
            queue[back] = value;
        } else {
            back = (back + 1) % capacity();
            queue[back] = value;
        }
    }

    /*
    * Deletes an item from the queue
     */
    @Override
    public Integer dequeue() {
        if (this.isEmpty()) { // IF EMPTY
            System.out.println("Can't dequeue, Queue is empty.");
            return -1;
        } 
        else if (size() == 1) {
            int item = queue[front];
            this.back = -1;
            this.front = -1;
            return item;
        }
           else {
            int item = queue[front];
            front = (front + 1) % capacity();
            return item;
        }
    }

    /*
    * Returns amount of numbers in the queue
     */
    @Override
    public int size() {
        if (isEmpty()) {
            return 0;
        }
        if (front == back) {
            return 1;
        }
        if (back > front) {
            return (back - front) + 1;
        }
        return ((back + capacity()) - front + 1);
    }

    /*
    * Returns capacity of queue
     */
    @Override
    public int capacity() {
        return queue.length;
    }

    /*
    * Checks if queue is empty
     */
    @Override
    public boolean isEmpty() {
        if (back == -1 && front == -1) {
            return true;
        } else {
            return false;
        }
    }

    /*
    * Checks if queue is full
     */
    @Override
    public boolean isFull() {
        if (size() == capacity()) {
            return true;
        } else {
            return false;
        }
    }

    /*
    * Makes the queue empty
     */
    @Override
    public void makeEmpty() {
        this.back = -1;
        this.front = -1;

    }

    /*
    * Creates a visual of the queue for TEST #2
     */
    @Override
    public String toString() {
        String s = "-----------------------------------\n";

        for (int i = 0; i < capacity(); i++) {
            if (front == i && back == i) {
                s = s + String.format("%4s", "FB");
            } else if (front == i) {
                s = s + String.format("%4s", "F");
            } else if (back == i) {
                s = s + String.format("%4s", "B");
            } else {
                s = s + String.format("%4s", "");
            }
        }
        s = s + "\n";

        for (int i = 0; i < capacity(); i++) {
            s = s + String.format("%4s", queue[i]);
        }

        return s + "\n";

    }
}
