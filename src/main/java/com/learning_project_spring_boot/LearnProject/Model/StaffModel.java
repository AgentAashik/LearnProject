package com.learning_project_spring_boot.LearnProject.Model;


public class StaffModel {
    private int staffId;
    private String staffName;
    private String staffQualifaction;
    private String staffDepartment;
    private String staffAddress;
    private int staffSalary;

    public StaffModel(int staffId, String staffName, String staffQualifaction, String staffDepartment, String staffAddress, int staffSalary) {
        this.staffId = staffId;
        this.staffName = staffName;
        this.staffQualifaction = staffQualifaction;
        this.staffDepartment = staffDepartment;
        this.staffAddress = staffAddress;
        this.staffSalary = staffSalary;
    }

    public int getStaffId() {
        return staffId;
    }

    public void setStaffId(int staffId) {
        this.staffId = staffId;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getStaffQualifaction() {
        return staffQualifaction;
    }

    public void setStaffQualifaction(String staffQualifaction) {
        this.staffQualifaction = staffQualifaction;
    }

    public String getStaffDepartment() {
        return staffDepartment;
    }

    public void setStaffDepartment(String staffDepartment) {
        this.staffDepartment = staffDepartment;
    }

    public String getStaffAddress() {
        return staffAddress;
    }

    public void setStaffAddress(String staffAddress) {
        this.staffAddress = staffAddress;
    }

    public int getStaffSalary() {
        return staffSalary;
    }

    public void setStaffSalary(int staffSalary) {
        this.staffSalary = staffSalary;
    }
}