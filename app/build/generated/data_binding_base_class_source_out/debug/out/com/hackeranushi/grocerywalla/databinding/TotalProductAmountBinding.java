// Generated by view binder compiler. Do not edit!
package com.hackeranushi.grocerywalla.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.hackeranushi.grocerywalla.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class TotalProductAmountBinding implements ViewBinding {
  @NonNull
  private final RelativeLayout rootView;

  @NonNull
  public final TextView productExtraDiscount;

  @NonNull
  public final TextView productPrice;

  @NonNull
  public final TextView shipingFee;

  @NonNull
  public final TextView specialPrice;

  @NonNull
  public final TextView totalAmountExtraDiscountTv;

  @NonNull
  public final TextView totalAmountSellingpriceTv;

  @NonNull
  public final TextView totalAmountShippingFeeTv;

  @NonNull
  public final TextView totalAmountSpecialpriceTv;

  @NonNull
  public final TextView totalAmountTxtview;

  @NonNull
  public final TextView totalFinalPrice;

  private TotalProductAmountBinding(@NonNull RelativeLayout rootView,
      @NonNull TextView productExtraDiscount, @NonNull TextView productPrice,
      @NonNull TextView shipingFee, @NonNull TextView specialPrice,
      @NonNull TextView totalAmountExtraDiscountTv, @NonNull TextView totalAmountSellingpriceTv,
      @NonNull TextView totalAmountShippingFeeTv, @NonNull TextView totalAmountSpecialpriceTv,
      @NonNull TextView totalAmountTxtview, @NonNull TextView totalFinalPrice) {
    this.rootView = rootView;
    this.productExtraDiscount = productExtraDiscount;
    this.productPrice = productPrice;
    this.shipingFee = shipingFee;
    this.specialPrice = specialPrice;
    this.totalAmountExtraDiscountTv = totalAmountExtraDiscountTv;
    this.totalAmountSellingpriceTv = totalAmountSellingpriceTv;
    this.totalAmountShippingFeeTv = totalAmountShippingFeeTv;
    this.totalAmountSpecialpriceTv = totalAmountSpecialpriceTv;
    this.totalAmountTxtview = totalAmountTxtview;
    this.totalFinalPrice = totalFinalPrice;
  }

  @Override
  @NonNull
  public RelativeLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static TotalProductAmountBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static TotalProductAmountBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.total_product_amount, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static TotalProductAmountBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.product_extra_discount;
      TextView productExtraDiscount = ViewBindings.findChildViewById(rootView, id);
      if (productExtraDiscount == null) {
        break missingId;
      }

      id = R.id.product_price;
      TextView productPrice = ViewBindings.findChildViewById(rootView, id);
      if (productPrice == null) {
        break missingId;
      }

      id = R.id.shiping_fee;
      TextView shipingFee = ViewBindings.findChildViewById(rootView, id);
      if (shipingFee == null) {
        break missingId;
      }

      id = R.id.special_price;
      TextView specialPrice = ViewBindings.findChildViewById(rootView, id);
      if (specialPrice == null) {
        break missingId;
      }

      id = R.id.total_amount_extra_discount_tv;
      TextView totalAmountExtraDiscountTv = ViewBindings.findChildViewById(rootView, id);
      if (totalAmountExtraDiscountTv == null) {
        break missingId;
      }

      id = R.id.total_amount_sellingprice_tv;
      TextView totalAmountSellingpriceTv = ViewBindings.findChildViewById(rootView, id);
      if (totalAmountSellingpriceTv == null) {
        break missingId;
      }

      id = R.id.total_amount_shipping_fee_tv;
      TextView totalAmountShippingFeeTv = ViewBindings.findChildViewById(rootView, id);
      if (totalAmountShippingFeeTv == null) {
        break missingId;
      }

      id = R.id.total_amount_specialprice_tv;
      TextView totalAmountSpecialpriceTv = ViewBindings.findChildViewById(rootView, id);
      if (totalAmountSpecialpriceTv == null) {
        break missingId;
      }

      id = R.id.total_amount_txtview;
      TextView totalAmountTxtview = ViewBindings.findChildViewById(rootView, id);
      if (totalAmountTxtview == null) {
        break missingId;
      }

      id = R.id.total_final_price;
      TextView totalFinalPrice = ViewBindings.findChildViewById(rootView, id);
      if (totalFinalPrice == null) {
        break missingId;
      }

      return new TotalProductAmountBinding((RelativeLayout) rootView, productExtraDiscount,
          productPrice, shipingFee, specialPrice, totalAmountExtraDiscountTv,
          totalAmountSellingpriceTv, totalAmountShippingFeeTv, totalAmountSpecialpriceTv,
          totalAmountTxtview, totalFinalPrice);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
