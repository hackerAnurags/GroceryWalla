// Generated by view binder compiler. Do not edit!
package com.hackeranushi.grocerywalla.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.appbar.AppBarLayout;
import com.hackeranushi.grocerywalla.R;
import com.skydoves.elasticviews.ElasticButton;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityAdminHomeBinding implements ViewBinding {
  @NonNull
  private final RelativeLayout rootView;

  @NonNull
  public final AppBarLayout appBar;

  @NonNull
  public final EditText catName;

  @NonNull
  public final LinearLayout clickNext;

  @NonNull
  public final EditText index;

  @NonNull
  public final ElasticButton load;

  @NonNull
  public final Button logout;

  @NonNull
  public final TextView pickImage;

  @NonNull
  public final ImageView profile;

  @NonNull
  public final Toolbar toolbar;

  private ActivityAdminHomeBinding(@NonNull RelativeLayout rootView, @NonNull AppBarLayout appBar,
      @NonNull EditText catName, @NonNull LinearLayout clickNext, @NonNull EditText index,
      @NonNull ElasticButton load, @NonNull Button logout, @NonNull TextView pickImage,
      @NonNull ImageView profile, @NonNull Toolbar toolbar) {
    this.rootView = rootView;
    this.appBar = appBar;
    this.catName = catName;
    this.clickNext = clickNext;
    this.index = index;
    this.load = load;
    this.logout = logout;
    this.pickImage = pickImage;
    this.profile = profile;
    this.toolbar = toolbar;
  }

  @Override
  @NonNull
  public RelativeLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityAdminHomeBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityAdminHomeBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_admin_home, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityAdminHomeBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.app_bar;
      AppBarLayout appBar = ViewBindings.findChildViewById(rootView, id);
      if (appBar == null) {
        break missingId;
      }

      id = R.id.catName;
      EditText catName = ViewBindings.findChildViewById(rootView, id);
      if (catName == null) {
        break missingId;
      }

      id = R.id.clickNext;
      LinearLayout clickNext = ViewBindings.findChildViewById(rootView, id);
      if (clickNext == null) {
        break missingId;
      }

      id = R.id.index;
      EditText index = ViewBindings.findChildViewById(rootView, id);
      if (index == null) {
        break missingId;
      }

      id = R.id.load;
      ElasticButton load = ViewBindings.findChildViewById(rootView, id);
      if (load == null) {
        break missingId;
      }

      id = R.id.logout;
      Button logout = ViewBindings.findChildViewById(rootView, id);
      if (logout == null) {
        break missingId;
      }

      id = R.id.pickImage;
      TextView pickImage = ViewBindings.findChildViewById(rootView, id);
      if (pickImage == null) {
        break missingId;
      }

      id = R.id.profile;
      ImageView profile = ViewBindings.findChildViewById(rootView, id);
      if (profile == null) {
        break missingId;
      }

      id = R.id.toolbar;
      Toolbar toolbar = ViewBindings.findChildViewById(rootView, id);
      if (toolbar == null) {
        break missingId;
      }

      return new ActivityAdminHomeBinding((RelativeLayout) rootView, appBar, catName, clickNext,
          index, load, logout, pickImage, profile, toolbar);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
