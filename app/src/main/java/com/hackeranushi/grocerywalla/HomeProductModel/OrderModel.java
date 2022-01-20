package com.hackeranushi.grocerywalla.HomeProductModel;

public class OrderModel {

    String orderProductName, orderProductPrice, orderProductCutPrice, orderProductStatus, orderProductImage;

    public OrderModel(String orderProductName, String orderProductPrice, String orderProductCutPrice, String orderProductStatus, String orderProductImage) {
        this.orderProductName = orderProductName;
        this.orderProductPrice = orderProductPrice;
        this.orderProductCutPrice = orderProductCutPrice;
        this.orderProductStatus = orderProductStatus;
        this.orderProductImage = orderProductImage;
    }

    public String getOrderProductName() {
        return orderProductName;
    }

    public void setOrderProductName(String orderProductName) {
        this.orderProductName = orderProductName;
    }

    public String getOrderProductPrice() {
        return orderProductPrice;
    }

    public void setOrderProductPrice(String orderProductPrice) {
        this.orderProductPrice = orderProductPrice;
    }

    public String getOrderProductCutPrice() {
        return orderProductCutPrice;
    }

    public void setOrderProductCutPrice(String orderProductCutPrice) {
        this.orderProductCutPrice = orderProductCutPrice;
    }

    public String getOrderProductStatus() {
        return orderProductStatus;
    }

    public void setOrderProductStatus(String orderProductStatus) {
        this.orderProductStatus = orderProductStatus;
    }

    public String getOrderProductImage() {
        return orderProductImage;
    }

    public void setOrderProductImage(String orderProductImage) {
        this.orderProductImage = orderProductImage;
    }
}
