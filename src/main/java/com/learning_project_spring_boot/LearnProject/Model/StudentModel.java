package com.learning_project_spring_boot.LearnProject.Model;


public class StudentModel {

    private Integer id;
    private String fullName;
    private String branch;
    private Integer marks;
    private String institution;

    public StudentModel() {}

    public StudentModel(Integer id, String fullName, String branch, Integer marks, String institution) {
        this.id = id;
        this.fullName = fullName;
        this.branch = branch;
        this.marks = marks;
        this.institution = institution;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public Integer getMarks() {
        return marks;
    }

    public void setMarks(Integer marks) {
        this.marks = marks;
    }

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    @Override
    public String toString() {
        return "StudentModel{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", branch='" + branch + '\'' +
                ", marks=" + marks +
                ", institution='" + institution + '\'' +
                '}';
    }
}

