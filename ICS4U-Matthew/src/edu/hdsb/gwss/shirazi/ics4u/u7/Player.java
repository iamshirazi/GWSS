/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.shirazi.ics4u.u7;

import java.io.Serializable;

/**
 *
 * @author 1shirazimat
 */
public class Player implements Serializable {

    private String name;
    private int age;
    private String[] sponsors;

    public Player() {

    }

    public Player(String name, int age, String[] sponsors) {
        this.name = name;
        this.age = age;
        this.sponsors = sponsors;
    }

    @Override
    public String toString() {
        return "Player{" + "name=" + name + ", age=" + age + ", sponsors=" + sponsors + '}';
    }

}
