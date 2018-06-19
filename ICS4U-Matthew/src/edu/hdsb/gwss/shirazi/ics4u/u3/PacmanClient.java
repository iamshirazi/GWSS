/*
 * Name: Matthew A. Shirazi
 * Date: April 9th, 2018
 * Description: Pacman game.
 */
package edu.hdsb.gwss.shirazi.ics4u.u3;

import java.util.Objects;
import static javafx.scene.paint.Color.color;

/**
 *
 * @author 1shirazimat
 */
public class PacmanClient {
    
    public final static String gameName = "Pacman";
    
    private int nextId;
    
    // OBJECT // INSTANCE VARIABLE
    private int x;
    private int y;
    private String name;
    private int colour;
    
    public PacmanClient() {
        
    }

    public PacmanClient(String name, int colour, int x, int y) {
        this.x = x;
        this.y = y;
        this.name = name;
        this.colour = colour;
        
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getColour() {
        return colour;
    }

    public void setColour(int colour) {
        this.colour = colour;
    }

    @Override
    public String toString() {
        return "Pacman{" + "x=" + x + ", y=" + y + ", colour=" + colour + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final PacmanClient other = (PacmanClient) obj;
        if (this.x != other.x) {
            return false;
        }
        if (this.y != other.y) {
            return false;
        }
        if (this.colour != other.colour) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }
    
    
    
    public static void main(String[] args) {
        
       // Pacman a = new Pacman( 100, 100, "Pacman" );
        
    }
    
}
