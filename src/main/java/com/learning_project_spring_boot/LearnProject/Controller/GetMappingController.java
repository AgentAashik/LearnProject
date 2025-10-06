package com.learning_project_spring_boot.LearnProject.Controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/get/")
public class GetMappingController {

    @GetMapping("allProducts")
    public String getAllData(){
        return "All Data will comming soon...";
    }

    @GetMapping("product/{id:[0-9]+}")
    public String getIdbasedSearchProduct(
            @PathVariable long id
    ){

        return "Your Prodjct id is " + id;
    }
    @GetMapping("product/{productName:[a-zA-Z]+}")
    public String searchByProductName(
            @PathVariable String productName
    ){

        return "Your Searching Productname is = " + productName;
    }

    @GetMapping("product/{id}/{productName}")
    public String getIDandNamebasedSearch(
            @PathVariable String id,
            @PathVariable  String productName
    ){

        return "Product Id is = "+id+" productName = " +  productName;
    }

    @GetMapping("searchProduct")
    public String searchProductwithQueryParam(
            @RequestParam("id") long productId,
            @RequestParam("pname")  String productName
    ){

        return "Query Param Id = " +productId + "Query Param product Name =" + productName;
    }




}