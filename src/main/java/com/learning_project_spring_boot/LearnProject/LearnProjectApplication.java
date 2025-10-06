package com.learning_project_spring_boot.LearnProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class LearnProjectApplication {


	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(LearnProjectApplication.class, args);
		System.out.println("Hello World");

	}

}