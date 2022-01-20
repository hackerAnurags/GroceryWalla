package com.hackeranushi.grocerywalla.HomeProductModel;

public class CartModel {

    String cartProductName, cartProductImage,cartProductPrice;
    double cartProductCutPrice, cartProductTotalPrice;
    int cartProductCountItem;

    public CartModel(String cartProductName, String cartProductImage, String cartProductPrice,
                     double cartProductCutPrice, double cartProductTotalPrice, int cartProductCountItem) {
        this.cartProductName = cartProductName;
        this.cartProductImage = cartProductImage;
        this.cartProductPrice = cartProductPrice;
        this.cartProductCutPrice = cartProductCutPrice;
        this.cartProductTotalPrice = cartProductTotalPrice;
        this.cartProductCountItem = cartProductCountItem;
    }

    public CartModel(){}

    public String getCartProductName() {
        return cartProductName;
    }

    public void setCartProductName(String cartProductName) {
        this.cartProductName = cartProductName;
    }

    public String getCartProductImage() {
        return cartProductImage;
    }

    public void setCartProductImage(String cartProductImage) {
        this.cartProductImage = cartProductImage;
    }

    public String getCartProductPrice() {
        return cartProductPrice;
    }

    public void setCartProductPrice(String cartProductPrice) {
        this.cartProductPrice = cartProductPrice;
    }

    public double getCartProductCutPrice() {
        return cartProductCutPrice;
    }

    public void setCartProductCutPrice(double cartProductCutPrice) {
        this.cartProductCutPrice = cartProductCutPrice;
    }

    public double getCartProductTotalPrice() {
        return cartProductTotalPrice;
    }

    public void setCartProductTotalPrice(double cartProductTotalPrice) {
        this.cartProductTotalPrice = cartProductTotalPrice;
    }

    public int getCartProductCountItem() {
        return cartProductCountItem;
    }

    public void setCartProductCountItem(int cartProductCountItem) {
        this.cartProductCountItem = cartProductCountItem;
    }
}
