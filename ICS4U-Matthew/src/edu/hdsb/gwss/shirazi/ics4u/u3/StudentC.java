/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.shirazi.ics4u.u3;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author 1shirazimat
 */
public class StudentC {

    public final static String school = "Garth Webb";

    private int nextId;

// OBJECT // INSTANCE VARIABLE
    private int studentNumber;
    private String firstName;
    private String lastName;
    private Date dob;
    private int grade;

    public StudentC() {

    }

    public StudentC(int studentNumber) {

        this.studentNumber = studentNumber;

    }

    public StudentC(String firstName, String lastName, Date dob) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "StudentC{" + "studentNumber=" + studentNumber + ", dob=" + dob + ", grade=" + grade + '}';
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
        final StudentC other = (StudentC) obj;
        if ( this.studentNumber > 0 && this.studentNumber != other.studentNumber) {
            return false;
        }
        if (!Objects.equals(this.firstName, other.firstName)) {
            return false;
        }
        if (!Objects.equals(this.lastName, other.lastName)) {
            return false;
        }
        if (!Objects.equals(this.dob, other.dob)) {
            return false;
        }
        return true;
    }
    
    
    
    public static void main(String[] args) {
        
        Date d = new Date();
        StudentC a = new StudentC( "First", "Last", d );
        StudentC b = new StudentC( "First", "Last", d );
        
        System.out.println( a == b ); // FALSE DIF OBJECT
        System.out.println( a.equals( b ) ); // TRUE SAME CONTENTS
    
        
    }

}
