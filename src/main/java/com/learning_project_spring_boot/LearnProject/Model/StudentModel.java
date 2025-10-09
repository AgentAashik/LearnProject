package com.learning_project_spring_boot.LearnProject.Model;

import jakarta.validation.constraints.*;

public class StudentModel {

    @NotNull(message = "ID cannot be null")
    @Min(value = 1, message = "ID must be a positive number")
    private Integer id;

    @NotBlank(message = "Full name cannot be blank")
    @Size(min = 2, max = 100, message = "Name must be between 2 and 100 characters")
    private String fullName;

    @NotBlank(message = "Branch cannot be blank")
    @Size(min = 2, max = 50, message = "Branch must be between 2 and 50 characters")
    private String branch;

    @NotNull(message = "Marks cannot be null")
    @Min(value = 0, message = "Marks cannot be negative")
    @Max(value = 100, message = "Marks cannot exceed 100")
    private Integer marks;

    @NotBlank(message = "Institution cannot be blank")
    @Size(min = 3, max = 150, message = "Institution name must be between 3 and 150 characters")
    private String institution;


    public StudentModel() {
    }

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
