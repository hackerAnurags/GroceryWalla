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
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.hackeranushi.grocerywalla.R;
import com.skydoves.elasticviews.ElasticButton;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentBakeryBinding implements ViewBinding {
  @NonNull
  private final FrameLayout rootView;

  @NonNull
  public final LinearLayout clickNext;

  @NonNull
  public final ImageView pImage;

  @NonNull
  public final EditText pIndex;

  @NonNull
  public final EditText pName;

  @NonNull
  public final EditText pPrice;

  @NonNull
  public final EditText pRating;

  @NonNull
  public final ElasticButton pickImage;

  @NonNull
  public final ElasticButton saveData;

  private FragmentBakeryBinding(@NonNull FrameLayout rootView, @NonNull LinearLayout clickNext,
      @NonNull ImageView pImage, @NonNull EditText pIndex, @NonNull EditText pName,
      @NonNull EditText pPrice, @NonNull EditText pRating, @NonNull ElasticButton pickImage,
      @NonNull ElasticButton saveData) {
    this.rootView = rootView;
    this.clickNext = clickNext;
    this.pImage = pImage;
    this.pIndex = pIndex;
    this.pName = pName;
    this.pPrice = pPrice;
    this.pRating = pRating;
    this.pickImage = pickImage;
    this.saveData = saveData;
  }

  @Override
  @NonNull
  public FrameLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentBakeryBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentBakeryBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_bakery, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentBakeryBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.clickNext;
      LinearLayout clickNext = ViewBindings.findChildViewById(rootView, id);
      if (clickNext == null) {
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

      id = R.id.p_name;
      EditText pName = ViewBindings.findChildViewById(rootView, id);
      if (pName == null) {
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

      return new FragmentBakeryBinding((FrameLayout) rootView, clickNext, pImage, pIndex, pName,
          pPrice, pRating, pickImage, saveData);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
