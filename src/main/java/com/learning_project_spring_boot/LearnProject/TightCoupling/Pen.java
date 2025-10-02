package com.learning_project_spring_boot.LearnProject.TightCoupling;

public class Pen {

    private String penType;
    private int penCost;
    private String PenName;

    public Pen(String penType, int penCost, String penName) {
        this.penType = penType;
        this.penCost = penCost;
        PenName = penName;
    }

    public String getPenType() {
        return penType;
    }

    public void setPenType(String penType) {
        this.penType = penType;
    }

    public int getPenCost() {
        return penCost;
    }

    public void setPenCost(int penCost) {
        this.penCost = penCost;
    }

    public String getPenName() {
        return PenName;
    }

    public void setPenName(String penName) {
        PenName = penName;
    }
}