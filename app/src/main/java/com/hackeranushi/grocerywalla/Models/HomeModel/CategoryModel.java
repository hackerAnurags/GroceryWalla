package com.hackeranushi.grocerywalla.Models.HomeModel;

public class CategoryModel {

    String catImage, catName;

    public CategoryModel(String catImage, String catName) {
        this.catImage = catImage;
        this.catName = catName;
    }

    public String getCatImage() {
        return catImage;
    }

    public void setCatImage(String catImage) {
        this.catImage = catImage;
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }
}
