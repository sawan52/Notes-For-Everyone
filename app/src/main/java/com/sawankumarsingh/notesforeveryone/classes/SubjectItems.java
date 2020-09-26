package com.sawankumarsingh.notesforeveryone.classes;

public class SubjectItems {

    String subjectName, subjectUnit;

    public SubjectItems(){}

    public SubjectItems(String subjectName, String subjectUnit) {
        this.subjectName = subjectName;
        this.subjectUnit = subjectUnit;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getSubjectUnit() {
        return subjectUnit;
    }

    public void setSubjectUnit(String subjectUnit) {
        this.subjectUnit = subjectUnit;
    }
}

