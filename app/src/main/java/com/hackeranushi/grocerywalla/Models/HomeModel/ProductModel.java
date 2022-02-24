package com.hackeranushi.grocerywalla.Models.HomeModel;

public class ProductModel {
    String pImage, pName, pPrice,pRating;

    public ProductModel(String pImage, String pName, String pPrice, String pRating) {
        this.pImage = pImage;
        this.pName = pName;
        this.pPrice = pPrice;
        this.pRating = pRating;
    }

    public String getpImage() {
        return pImage;
    }

    public void setpImage(String pImage) {
        this.pImage = pImage;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String getpPrice() {
        return pPrice;
    }

    public void setpPrice(String pPrice) {
        this.pPrice = pPrice;
    }

    public String getpRating() {
        return pRating;
    }

    public void setpRating(String pRating) {
        this.pRating = pRating;
    }
}
