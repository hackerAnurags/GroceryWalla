// Generated by view binder compiler. Do not edit!
package com.hackeranushi.grocerywalla.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.hackeranushi.grocerywalla.R;
import com.skydoves.elasticviews.ElasticButton;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentColdDrinksBinding implements ViewBinding {
  @NonNull
  private final FrameLayout rootView;

  @NonNull
  public final LinearLayout clickNext;

  @NonNull
  public final EditText cuttedPrice;

  @NonNull
  public final CardView footerCard;

  @NonNull
  public final EditText keyFeatures;

  @NonNull
  public final EditText pCountry;

  @NonNull
  public final EditText pCustomerCare;

  @NonNull
  public final EditText pDescription;

  @NonNull
  public final EditText pDisclaimer;

  @NonNull
  public final ImageView pImage;

  @NonNull
  public final EditText pIndex;

  @NonNull
  public final EditText pIngredients;

  @NonNull
  public final EditText pLife;

  @NonNull
  public final EditText pManufacture;

  @NonNull
  public final EditText pMarkedUp;

  @NonNull
  public final EditText pName;

  @NonNull
  public final EditText pNutrition;

  @NonNull
  public final EditText pOffer;

  @NonNull
  public final EditText pPrice;

  @NonNull
  public final EditText pRating;

  @NonNull
  public final EditText pSeller;

  @NonNull
  public final EditText pUnit;

  @NonNull
  public final ElasticButton pickImage;

  @NonNull
  public final ElasticButton saveData;

  private FragmentColdDrinksBinding(@NonNull FrameLayout rootView, @NonNull LinearLayout clickNext,
      @NonNull EditText cuttedPrice, @NonNull CardView footerCard, @NonNull EditText keyFeatures,
      @NonNull EditText pCountry, @NonNull EditText pCustomerCare, @NonNull EditText pDescription,
      @NonNull EditText pDisclaimer, @NonNull ImageView pImage, @NonNull EditText pIndex,
      @NonNull EditText pIngredients, @NonNull EditText pLife, @NonNull EditText pManufacture,
      @NonNull EditText pMarkedUp, @NonNull EditText pName, @NonNull EditText pNutrition,
      @NonNull EditText pOffer, @NonNull EditText pPrice, @NonNull EditText pRating,
      @NonNull EditText pSeller, @NonNull EditText pUnit, @NonNull ElasticButton pickImage,
      @NonNull ElasticButton saveData) {
    this.rootView = rootView;
    this.clickNext = clickNext;
    this.cuttedPrice = cuttedPrice;
    this.footerCard = footerCard;
    this.keyFeatures = keyFeatures;
    this.pCountry = pCountry;
    this.pCustomerCare = pCustomerCare;
    this.pDescription = pDescription;
    this.pDisclaimer = pDisclaimer;
    this.pImage = pImage;
    this.pIndex = pIndex;
    this.pIngredients = pIngredients;
    this.pLife = pLife;
    this.pManufacture = pManufacture;
    this.pMarkedUp = pMarkedUp;
    this.pName = pName;
    this.pNutrition = pNutrition;
    this.pOffer = pOffer;
    this.pPrice = pPrice;
    this.pRating = pRating;
    this.pSeller = pSeller;
    this.pUnit = pUnit;
    this.pickImage = pickImage;
    this.saveData = saveData;
  }

  @Override
  @NonNull
  public FrameLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentColdDrinksBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentColdDrinksBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_cold_drinks, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentColdDrinksBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.clickNext;
      LinearLayout clickNext = ViewBindings.findChildViewById(rootView, id);
      if (clickNext == null) {
        break missingId;
      }

      id = R.id.cutted_price;
      EditText cuttedPrice = ViewBindings.findChildViewById(rootView, id);
      if (cuttedPrice == null) {
        break missingId;
      }

      id = R.id.footerCard;
      CardView footerCard = ViewBindings.findChildViewById(rootView, id);
      if (footerCard == null) {
        break missingId;
      }

      id = R.id.key_features;
      EditText keyFeatures = ViewBindings.findChildViewById(rootView, id);
      if (keyFeatures == null) {
        break missingId;
      }

      id = R.id.p_country;
      EditText pCountry = ViewBindings.findChildViewById(rootView, id);
      if (pCountry == null) {
        break missingId;
      }

      id = R.id.p_customer_care;
      EditText pCustomerCare = ViewBindings.findChildViewById(rootView, id);
      if (pCustomerCare == null) {
        break missingId;
      }

      id = R.id.p_description;
      EditText pDescription = ViewBindings.findChildViewById(rootView, id);
      if (pDescription == null) {
        break missingId;
      }

      id = R.id.p_disclaimer;
      EditText pDisclaimer = ViewBindings.findChildViewById(rootView, id);
      if (pDisclaimer == null) {
        break missingId;
      }

      id = R.id.p_image;
      ImageView pImage = ViewBindings.findChildViewById(rootView, id);
      if (pImage == null) {
        break missingId;
      }

      id = R.id.p_index;
      EditText pIndex = ViewBindings.findChildViewById(rootView, id);
      if (pIndex == null) {
        break missingId;
      }

      id = R.id.p_ingredients;
      EditText pIngredients = ViewBindings.findChildViewById(rootView, id);
      if (pIngredients == null) {
        break missingId;
      }

      id = R.id.p_life;
      EditText pLife = ViewBindings.findChildViewById(rootView, id);
      if (pLife == null) {
        break missingId;
      }

      id = R.id.p_manufacture;
      EditText pManufacture = ViewBindings.findChildViewById(rootView, id);
      if (pManufacture == null) {
        break missingId;
      }

      id = R.id.p_markedUp;
      EditText pMarkedUp = ViewBindings.findChildViewById(rootView, id);
      if (pMarkedUp == null) {
        break missingId;
      }

      id = R.id.p_name;
      EditText pName = ViewBindings.findChildViewById(rootView, id);
      if (pName == null) {
        break missingId;
      }

      id = R.id.p_nutrition;
      EditText pNutrition = ViewBindings.findChildViewById(rootView, id);
      if (pNutrition == null) {
        break missingId;
      }

      id = R.id.p_offer;
      EditText pOffer = ViewBindings.findChildViewById(rootView, id);
      if (pOffer == null) {
        break missingId;
      }

      id = R.id.p_price;
      EditText pPrice = ViewBindings.findChildViewById(rootView, id);
      if (pPrice == null) {
        break missingId;
      }

      id = R.id.p_rating;
      EditText pRating = ViewBindings.findChildViewById(rootView, id);
      if (pRating == null) {
        break missingId;
      }

      id = R.id.p_seller;
      EditText pSeller = ViewBindings.findChildViewById(rootView, id);
      if (pSeller == null) {
        break missingId;
      }

      id = R.id.p_unit;
      EditText pUnit = ViewBindings.findChildViewById(rootView, id);
      if (pUnit == null) {
        break missingId;
      }

      id = R.id.pickImage;
      ElasticButton pickImage = ViewBindings.findChildViewById(rootView, id);
      if (pickImage == null) {
        break missingId;
      }

      id = R.id.saveData;
      ElasticButton saveData = ViewBindings.findChildViewById(rootView, id);
      if (saveData == null) {
        break missingId;
      }

      return new FragmentColdDrinksBinding((FrameLayout) rootView, clickNext, cuttedPrice,
          footerCard, keyFeatures, pCountry, pCustomerCare, pDescription, pDisclaimer, pImage,
          pIndex, pIngredients, pLife, pManufacture, pMarkedUp, pName, pNutrition, pOffer, pPrice,
          pRating, pSeller, pUnit, pickImage, saveData);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
