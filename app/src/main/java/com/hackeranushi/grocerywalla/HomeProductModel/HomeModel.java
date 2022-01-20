package com.hackeranushi.grocerywalla.HomeProductModel;

public class HomeModel {
    String productName, productImage;

    public HomeModel(String productName, String productImage) {
        this.productName = productName;
        this.productImage = productImage;
    }

    public HomeModel(){}

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }
}
