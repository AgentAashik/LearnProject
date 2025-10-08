package com.learning_project_spring_boot.LearnProject.Model;

import org.springframework.stereotype.Component;


public class ProductModel {
    private String productName;
    private int productPrice;
    private int totalQty;

    public ProductModel(String productName, int productPrice, int totalQty) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.totalQty = totalQty;
    }


    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }

    public int getTotalQty() {
        return totalQty;
    }

    public void setTotalQty(int totalQty) {
        this.totalQty = totalQty;
    }
}