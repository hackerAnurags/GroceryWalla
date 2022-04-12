package com.hackeranushi.grocerywalla.Models.HomeModel;

public class HomeSliderModel {

    private String banner;

    public HomeSliderModel(String banner) {
        this.banner = banner;
    }

    public  HomeSliderModel (){}

    public String getBanner() {
        return banner;
    }

    public void setBanner(String banner) {
        this.banner = banner;
    }
}
