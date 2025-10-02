package com.learning_project_spring_boot.LearnProject.TightCoupling;

public class Exam {
    Pen obj = new Pen("hero",75,"ink-pen-blue");
    Pencil pencilobj = new Pencil("lid",5,"absara");


    public void writeExam(){
        System.out.println(obj.getPenName() + "-" + obj.getPenType());
        System.out.println(pencilobj.getPencilName() + "-" + pencilobj.getPencilType());
    }

    public void wirteHeading(){
        obj.setPenName("Ink-black");
        System.out.println("Write Heading use this = " + obj.getPenName() + "-" + obj.getPenType());
    }
    public void writeContent(){
        obj.setPenName("Ink-blue");
        System.out.println("Write Content use this =" + obj.getPenName() + "-" + obj.getPenType());
    }
    public void startExam(){
        this.wirteHeading();
        this.writeContent();

    }



}