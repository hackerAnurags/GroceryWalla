// Generated by view binder compiler. Do not edit!
package com.hackeranushi.grocerywalla.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.appbar.AppBarLayout;
import com.hackeranushi.grocerywalla.R;
import de.hdodenhof.circleimageview.CircleImageView;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityEditProfileBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final AppBarLayout appBar;

  @NonNull
  public final RadioButton btn1Sex;

  @NonNull
  public final RadioButton btn2Sex;

  @NonNull
  public final EditText fragDob;

  @NonNull
  public final EditText fragEmail;

  @NonNull
  public final EditText fragMob;

  @NonNull
  public final EditText fragName;

  @NonNull
  public final LinearLayout photoPicker;

  @NonNull
  public final ImageView pickImage;

  @NonNull
  public final CircleImageView profileImage;

  @NonNull
  public final RadioGroup radioGroup;

  @NonNull
  public final Button savedProfile;

  @NonNull
  public final Toolbar toolbar;

  private ActivityEditProfileBinding(@NonNull LinearLayout rootView, @NonNull AppBarLayout appBar,
      @NonNull RadioButton btn1Sex, @NonNull RadioButton btn2Sex, @NonNull EditText fragDob,
      @NonNull EditText fragEmail, @NonNull EditText fragMob, @NonNull EditText fragName,
      @NonNull LinearLayout photoPicker, @NonNull ImageView pickImage,
      @NonNull CircleImageView profileImage, @NonNull RadioGroup radioGroup,
      @NonNull Button savedProfile, @NonNull Toolbar toolbar) {
    this.rootView = rootView;
    this.appBar = appBar;
    this.btn1Sex = btn1Sex;
    this.btn2Sex = btn2Sex;
    this.fragDob = fragDob;
    this.fragEmail = fragEmail;
    this.fragMob = fragMob;
    this.fragName = fragName;
    this.photoPicker = photoPicker;
    this.pickImage = pickImage;
    this.profileImage = profileImage;
    this.radioGroup = radioGroup;
    this.savedProfile = savedProfile;
    this.toolbar = toolbar;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityEditProfileBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityEditProfileBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_edit_profile, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityEditProfileBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.app_bar;
      AppBarLayout appBar = ViewBindings.findChildViewById(rootView, id);
      if (appBar == null) {
        break missingId;
      }

      id = R.id.btn1_sex;
      RadioButton btn1Sex = ViewBindings.findChildViewById(rootView, id);
      if (btn1Sex == null) {
        break missingId;
      }

      id = R.id.btn2_sex;
      RadioButton btn2Sex = ViewBindings.findChildViewById(rootView, id);
      if (btn2Sex == null) {
        break missingId;
      }

      id = R.id.frag_dob;
      EditText fragDob = ViewBindings.findChildViewById(rootView, id);
      if (fragDob == null) {
        break missingId;
      }

      id = R.id.frag_email;
      EditText fragEmail = ViewBindings.findChildViewById(rootView, id);
      if (fragEmail == null) {
        break missingId;
      }

      id = R.id.frag_mob;
      EditText fragMob = ViewBindings.findChildViewById(rootView, id);
      if (fragMob == null) {
        break missingId;
      }

      id = R.id.fragName;
      EditText fragName = ViewBindings.findChildViewById(rootView, id);
      if (fragName == null) {
        break missingId;
      }

      id = R.id.photoPicker;
      LinearLayout photoPicker = ViewBindings.findChildViewById(rootView, id);
      if (photoPicker == null) {
        break missingId;
      }

      id = R.id.pick_image;
      ImageView pickImage = ViewBindings.findChildViewById(rootView, id);
      if (pickImage == null) {
        break missingId;
      }

      id = R.id.profile_image;
      CircleImageView profileImage = ViewBindings.findChildViewById(rootView, id);
      if (profileImage == null) {
        break missingId;
      }

      id = R.id.radio_group;
      RadioGroup radioGroup = ViewBindings.findChildViewById(rootView, id);
      if (radioGroup == null) {
        break missingId;
      }

      id = R.id.saved_profile;
      Button savedProfile = ViewBindings.findChildViewById(rootView, id);
      if (savedProfile == null) {
        break missingId;
      }

      id = R.id.toolbar;
      Toolbar toolbar = ViewBindings.findChildViewById(rootView, id);
      if (toolbar == null) {
        break missingId;
      }

      return new ActivityEditProfileBinding((LinearLayout) rootView, appBar, btn1Sex, btn2Sex,
          fragDob, fragEmail, fragMob, fragName, photoPicker, pickImage, profileImage, radioGroup,
          savedProfile, toolbar);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
