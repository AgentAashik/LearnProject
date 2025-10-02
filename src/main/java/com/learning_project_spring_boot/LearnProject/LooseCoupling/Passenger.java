package com.learning_project_spring_boot.LearnProject.LooseCoupling;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Passenger {

    @Autowired
    private  Conductor cobj;

    public void getTicket(){
        this.cobj.setTicketPrice(200);
        System.out.println("Ticket price is "+this.cobj.getTicketPrice());
    }
}