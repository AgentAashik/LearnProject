package com.learning_project_spring_boot.LearnProject.Controller;


import org.springframework.web.bind.annotation.*;

@RestController
public class BasicWebAnnotation {
    @GetMapping
    public String getEndpoint(){

        return "Get End point is triggred Aashik";
    }

    @PostMapping
    public String PostData(){
        return "Post Endpoint is Triggred Aashik";
    }

    @PutMapping
    public String putEndpoint(){
        return "Put Endpoint is Triggred Aashik";
    }

    @DeleteMapping
    public String deleteEndpoint(){

        return "Delete Endpoint is triggred Aashik";
    }

    @PatchMapping
    public String patchEndpoint(){

        return "Patch Mapping Endpoint Aashik";
    }
}
