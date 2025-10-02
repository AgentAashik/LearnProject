package com.learning_project_spring_boot.LearnProject.TightCoupling;

public class Pencil {

    private String pencilType;
    private int pencilCost;
    private String pencilName;

    public Pencil(String pencilType, int pencilCost, String pencilName) {
        this.pencilType = pencilType;
        this.pencilCost = pencilCost;
        this.pencilName = pencilName;
    }

    public String getPencilType() {
        return pencilType;
    }

    public void setPencilType(String pencilType) {
        this.pencilType = pencilType;
    }

    public int getPencilCost() {
        return pencilCost;
    }

    public void setPencilCost(int pencilCost) {
        this.pencilCost = pencilCost;
    }

    public String getPencilName() {
        return pencilName;
    }

    public void setPencilName(String pencilName) {
        this.pencilName = pencilName;
    }
}