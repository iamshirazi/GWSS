/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.shirazi.ics4u.u5;

import edu.hdsb.gwss.shirazi.ics4u.u3.*;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author 1shirazimat
 */
public class Student {

    public final static String school = "Garth Webb";

    private int nextId;

// OBJECT // INSTANCE VARIABLE
    protected int studentNumber;
    protected String name;
    private Date dob;
    private int grade;

    public Student() {

    }

    public Student(int studentNumber) {

        this.studentNumber = studentNumber;

    }

    public Student(String name, int studentNumber) {
        this.name = name;
        this.studentNumber = studentNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public int getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(int studentNumber) {
        this.studentNumber = studentNumber;
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
        final Student other = (Student) obj;
        if ( this.studentNumber > 0 && this.studentNumber != other.studentNumber) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.dob, other.dob)) {
            return false;
        }
        return true;
    }
    
    
    
    public static void main(String[] args) {

        Student a = new Student( "Jeff", 1 );
        Student b = new Student( "Jeff", 1 );
        
        System.out.println( a == b ); // FALSE DIF OBJECT
        System.out.println( a.equals( b ) ); // TRUE SAME CONTENTS
    
        
    }

}
