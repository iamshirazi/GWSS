/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.shirazi.ics4u.u7;

import java.io.RandomAccessFile;

/**
 *
 * @author 1shirazimat
 */
public class ClassWriter {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {

        System.out.println("Creating 4 Class Records");
        ClassRecord c1 = new ClassRecord("Mr. Sanderson", "Chemistry", 31);
        ClassRecord c2 = new ClassRecord("Ms. Smallbone", "Biology", 32);
        ClassRecord c3 = new ClassRecord("Mr. Tennant", "Physics", 34);
        ClassRecord c4 = new ClassRecord("Mr. Muir", "Computer Science", 20);
        System.out.println("*********************");

        RandomAccessFile recordFile = new RandomAccessFile("class_info.txt", "rw");

        recordFile.seek(0);

        recordFile.writeChars(c4.getTeacherName());
        recordFile.writeChars(c4.getSubjectName());
        recordFile.writeInt(c4.getClassSize());
        System.out.println(recordFile.length());

        recordFile.writeChars(c1.getTeacherName());
        recordFile.writeChars(c1.getSubjectName());
        recordFile.writeInt(c1.getClassSize());
        System.out.println(recordFile.length());

        recordFile.writeChars(c2.getTeacherName());
        recordFile.writeChars(c2.getSubjectName());
        recordFile.writeInt(c2.getClassSize());
        System.out.println(recordFile.length());

        recordFile.writeChars(c3.getTeacherName());
        recordFile.writeChars(c3.getSubjectName());
        recordFile.writeInt(c3.getClassSize());
        System.out.println(recordFile.length());

        

        recordFile.close();
    }

}
