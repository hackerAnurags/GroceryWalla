// Generated by view binder compiler. Do not edit!
package com.hackeranushi.grocerywalla.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.appbar.AppBarLayout;
import com.hackeranushi.grocerywalla.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityMyAddressBinding implements ViewBinding {
  @NonNull
  private final RelativeLayout rootView;

  @NonNull
  public final LinearLayout changeAddress;

  @NonNull
  public final RecyclerView showAddressRecycler;

  @NonNull
  public final Toolbar toolbar;

  @NonNull
  public final AppBarLayout toolbarLayout;

  private ActivityMyAddressBinding(@NonNull RelativeLayout rootView,
      @NonNull LinearLayout changeAddress, @NonNull RecyclerView showAddressRecycler,
      @NonNull Toolbar toolbar, @NonNull AppBarLayout toolbarLayout) {
    this.rootView = rootView;
    this.changeAddress = changeAddress;
    this.showAddressRecycler = showAddressRecycler;
    this.toolbar = toolbar;
    this.toolbarLayout = toolbarLayout;
  }

  @Override
  @NonNull
  public RelativeLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityMyAddressBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityMyAddressBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_my_address, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityMyAddressBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.change_address;
      LinearLayout changeAddress = ViewBindings.findChildViewById(rootView, id);
      if (changeAddress == null) {
        break missingId;
      }

      id = R.id.showAddress_recycler;
      RecyclerView showAddressRecycler = ViewBindings.findChildViewById(rootView, id);
      if (showAddressRecycler == null) {
        break missingId;
      }

      id = R.id.toolbar;
      Toolbar toolbar = ViewBindings.findChildViewById(rootView, id);
      if (toolbar == null) {
        break missingId;
      }

      id = R.id.toolbar_layout;
      AppBarLayout toolbarLayout = ViewBindings.findChildViewById(rootView, id);
      if (toolbarLayout == null) {
        break missingId;
      }

      return new ActivityMyAddressBinding((RelativeLayout) rootView, changeAddress,
          showAddressRecycler, toolbar, toolbarLayout);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
