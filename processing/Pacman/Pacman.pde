public class pacman {

// CLASS CONSTANTS 
private static final int STEP_SIZE = 10;

//CLASS VARIABLES

// OBJECT VARIABLES
int xloc = 12;
int yloc = 13;

// Three Constructors: Empty, Primary Key, Secondary Key

// Getters / Setters
public int getXLocation() {
  return this.xloc;
}

// verbs; things you can do to your class/object

// .equals()

public void draw() {
  rect(xloc, yloc, 30, 30);
}

public void move() {
  this.xloc = this.xloc + STEP_SIZE;
}

}
