package com.learning_project_spring_boot.LearnProject.Controller;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employee/")
public class GetEmployeeController {

    @GetMapping("allEmployees")
    public String fetchCompleteEmployeeList(){
        return "Employee database loading in progress...";
    }

    @GetMapping("employee/{id:[0-9]+}")
    public String retrieveEmployeeByIdentifier(
            @PathVariable long id
    ){

        return "Employee identifier retrieved: " + id;
    }

    @GetMapping("employee/{employeeName:[a-zA-Z]+}")
    public String findEmployeeByFullName(
            @PathVariable String employeeName
    ){

        return "Searching for employee with name: " + employeeName;
    }

    @GetMapping("employee/{id}/{employeeName}")
    public String locateEmployeeByIdAndName(
            @PathVariable String id,
            @PathVariable  String employeeName
    ){

        return "Located employee - ID: "+id+", Name: " +  employeeName;
    }

    @GetMapping("searchEmployee")
    public String filterEmployeeWithParams(
            @RequestParam("id") long employeeId,
            @RequestParam("ename")  String employeeName
    ){

        return "Filtered results - Employee ID: " +employeeId + ", Employee Name: " + employeeName;
    }




}
