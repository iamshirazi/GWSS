/*
 * Name: Matthew Shirazi
 * Date: April 20th, 2018
 * Description: Creates a Stack
 */
package edu.hdsb.gwss.shirazi.ics4u.u5;

/**
 *
 * @author 1shirazimat
 */
public class Stacks implements StackInterface {

    private int[] stack;
    private int top;

    public static void main(String[] args) {

        Stacks s = new Stacks(10);

        // TEST #1 - EMPTY STACK
        assert (s.top() == -1);
        assert (s.pop() == -1);
        assert (s.size() == 0);
        assert (s.capacity() == 10);
        assert (s.isEmpty());
        assert (!s.isFull());

        // TEST #2 - FILL THE STACK
        for (int i = 1; i <= 10; i++) {
            s.push(i);
            assert (s.top() == i);
            assert (s.size() == i);
            assert (s.capacity() == 10);
            assert (!s.isEmpty());

            if (i < 10) {
                assert (!s.isFull());
            } else {
                assert (s.isFull());
            }
        }

        // TEST #3 - OVER FLOW THE STACK
        s.push(999);
        assert (s.top() == 10);
        assert (s.size() == 10);
        assert (s.capacity() == 10);
        assert (!s.isEmpty());
        assert (s.isFull());

        // TEST #4 - POP IT EMPTY
        for (int i = 10; i >= 1; i--) {
            // STACK IS ALREADY FULL
            assert (s.pop() == i);

            assert (s.size() == i - 1);
            assert (s.capacity() == 10);

            if (i > 1) {
                assert (s.top() == i - 1);
                assert (!s.isEmpty());
            } else {
                assert (s.top() == -1);
                assert (s.isEmpty());
            }
        }

        // TEST #5 - UNDER THE STACK
        assert (s.pop() == -1);
        assert (s.top() == -1);
        assert (s.size() == 0);
        assert (s.capacity() == 10);
        assert (s.isEmpty());
        assert (!s.isFull());

        // MAKE EMPTY
        // TEST #6 - FILL THE STACK
        for (int i = 1; i <= 10; i++) {
            s.push(i);
        }

        // MAKE IT EMPTY
        s.makeEmpty();
        assert (s.pop() == -1);
        assert (s.top() == -1);
        assert (s.size() == 0);
        assert (s.capacity() == 10);
        assert (s.isEmpty());
        assert (!s.isFull());

    }

    /*
    * Constructor which calls other constructor and creates size of array (default 10)
     */
    public Stacks() {
        this(10);
    }

    /*
    * Constructor which creates stack size and top
     */
    public Stacks(int size) {
        this.stack = new int[size];
        this.top = -1;
    }

    /*
    * Returns top of stack
     */
    @Override
    public int top() {
        if (this.isEmpty()) {
            return -1;
        }
        return this.stack[top];
    }

    /*
    * Returns and takes out the top value on the stack
     */
    @Override
    public int pop() {
        if (this.isEmpty()) {
            return -1;
        }
        this.top--;
        return this.stack[this.top + 1];
    }

    /*
    * Adds a value onto the stack
     */
    @Override
    public void push(int value) {

        if (this.isFull()) {
            System.out.println("Can't push, stack is full.");
        } else {
            top = top + 1;
            this.stack[top] = value;
        }
    }

    /*
    * Returns amount of numbers in stack
     */
    @Override
    public int size() {
        return this.top + 1;
    }

    /*
    * Returns amount of numbers the stack can hold
     */
    @Override
    public int capacity() {
        return this.stack.length;
    }

    /*
    * Checks if stack is empty
     */
    @Override
    public boolean isEmpty() {
        if (top == -1) {
            return true;
        }
        return false;
    }

    /*
    * Checks if stack is full
     */
    @Override
    public boolean isFull() {
        if (this.size() == this.capacity()) {
            return true;
        }
        return false;
    }

    /*
    * Makes stack empty
     */
    @Override
    public void makeEmpty() {
        this.top = -1;
    }
    
}
