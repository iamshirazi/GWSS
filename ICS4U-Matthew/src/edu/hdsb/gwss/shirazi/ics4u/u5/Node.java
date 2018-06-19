/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.shirazi.ics4u.u5;

/**
 *
 * @author Wm.Muir
 */
public class Node implements NodeInterface {
    
    private String value;
    private Node next;

    public Node(String value) {
        this.value = value;
    }
    
    @Override
    public Node getNext() {
        return next;
    }

    @Override
    public void setNext( Node newNode) {
        this.next = newNode;
    }

    @Override
    public String getValue() {
        return this.value;
    }
}
