/*
 * 
 */
package edu.hdsb.gwss.shirazi.ics4u.u7;

import java.io.RandomAccessFile;

/**
 *
 * @author 1shirazimat
 */
public class ClassRecord {

    protected static final int RECORD_SIZE = 58;
    protected static final int LENGTH_SUBJECT = 12;
    protected static final int LENGTH_TEACHER = 15;

    private int id;
    private String teacherName;
    private String subjectName;
    private int classSize;

    public ClassRecord(String teacherName, String subject, int classSize) {
        this.setSubjectName(subject);
        this.setTeacherName(teacherName);
        this.classSize = classSize;
    }

    public ClassRecord() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        StringBuilder temp = new StringBuilder();

        if (teacherName != null) {
            temp.append(teacherName.trim());
        } else {
            temp.append("TBD");
        }

        // trucates or pads the string
        temp.setLength(LENGTH_TEACHER);
        this.teacherName = temp.toString();
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        StringBuilder temp = new StringBuilder();

        if (subjectName != null) {
            temp.append(subjectName.trim());
        } else {
            temp.append("TBD");
        }

        // trucates or pads the string
        temp.setLength(LENGTH_SUBJECT);
        this.subjectName = temp.toString();
    }

    public int getClassSize() {
        return classSize;
    }

    public void setClassSize(int classSize) {
        this.classSize = classSize;
    }

    @Override
    public String toString() {
        return "ClassRecord{" + "id = " + id + ", teacherName = " + teacherName + ", subjectName = " + subjectName + ", classSize = " + classSize + '}';
    }

    /**
     * @param args the command line arguments
     */
    public void main(String[] args) throws Exception {

    }

}
