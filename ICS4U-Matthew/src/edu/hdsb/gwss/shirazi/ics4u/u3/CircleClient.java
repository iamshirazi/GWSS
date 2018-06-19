package edu.hdsb.gwss.shirazi.ics4u.u3;

import java.util.Objects;

public class CircleClient {

    // INSTANCE 
    private int radius;
    private int width;
    private int height;
    private String colour;

    public static void main(String[] args) {

        CircleClient a = new CircleClient(4, 5, 6, "Blue");
        Circle b = new Circle();
        Circle c = new Circle();
        CircleClient Circle = new CircleClient();
        
        Circle.radius = 5;
        Circle.colour = "Maroon";

        System.out.println("Colour: " + a.colour);
        assert b.SHAPE_NAME.equals( c.SHAPE_NAME );
        System.out.println("Radius: " + a.radius);
        System.out.println(Circle);

    }

    // A CONSTRUCTOR MATCHES THE NAME OF A CLASS
    public CircleClient() {

    }

    public CircleClient(int radius, int width, int height, String colour) {
        this.radius = radius;
        this.width = width;
        this.height = height;
        this.colour = colour;
    }

   //public CircleClient(String colour) {
   //     this.colour = colour;
   // }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    @Override
    public String toString() {
        return "CircleClient{" + "radius=" + radius + ", width=" + width + ", height=" + height + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
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
        final CircleClient other = (CircleClient) obj;
        if (this.radius != other.radius) {
            return false;
        }
        if (this.width != other.width) {
            return false;
        }
        if (this.height != other.height) {
            return false;
        }
        if (!Objects.equals(this.colour, other.colour)) {
            return false;
        }
        return true;
    }

}
