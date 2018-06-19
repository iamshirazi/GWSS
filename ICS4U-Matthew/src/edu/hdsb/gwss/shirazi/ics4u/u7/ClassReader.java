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
public class ClassReader {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {

        int id = 0;

        RandomAccessFile recordFile = new RandomAccessFile("class_info.txt", "rw");

        recordFile.seek((long) (id - 1) * ClassRecord.RECORD_SIZE);

        
        ClassRecord c1 = new ClassRecord();
        
        char teacherName[] = new char[ClassRecord.LENGTH_TEACHER];
        for (int i = 0; i < ClassRecord.LENGTH_TEACHER; i++) {
            teacherName[i] = recordFile.readChar();
        }        
        c1.setTeacherName(new String(teacherName));
        
        char subjectName[] = new char[ClassRecord.LENGTH_SUBJECT];
        for (int i = 0; i < ClassRecord.LENGTH_SUBJECT; i++) {
            subjectName[i] = recordFile.readChar();
        }        
        c1.setSubjectName(new String(subjectName));
        
        c1.setClassSize( recordFile.readInt() );
        
        
        System.out.println( c1.toString() );

    }

}
