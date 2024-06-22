// Generated by view binder compiler. Do not edit!
package com.example.housemartapplication.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.housemartapplication.R;
import com.google.android.material.button.MaterialButton;
import de.hdodenhof.circleimageview.CircleImageView;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityParentAuthBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final ImageView bgImg;

  @NonNull
  public final ConstraintLayout main;

  @NonNull
  public final MaterialButton parentSignUpBtn;

  @NonNull
  public final CircleImageView profileIconImg;

  private ActivityParentAuthBinding(@NonNull ConstraintLayout rootView, @NonNull ImageView bgImg,
      @NonNull ConstraintLayout main, @NonNull MaterialButton parentSignUpBtn,
      @NonNull CircleImageView profileIconImg) {
    this.rootView = rootView;
    this.bgImg = bgImg;
    this.main = main;
    this.parentSignUpBtn = parentSignUpBtn;
    this.profileIconImg = profileIconImg;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityParentAuthBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityParentAuthBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_parent_auth, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityParentAuthBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.bg_img;
      ImageView bgImg = ViewBindings.findChildViewById(rootView, id);
      if (bgImg == null) {
        break missingId;
      }

      ConstraintLayout main = (ConstraintLayout) rootView;

      id = R.id.parentSignUpBtn;
      MaterialButton parentSignUpBtn = ViewBindings.findChildViewById(rootView, id);
      if (parentSignUpBtn == null) {
        break missingId;
      }

      id = R.id.profile_icon_img;
      CircleImageView profileIconImg = ViewBindings.findChildViewById(rootView, id);
      if (profileIconImg == null) {
        break missingId;
      }

      return new ActivityParentAuthBinding((ConstraintLayout) rootView, bgImg, main,
          parentSignUpBtn, profileIconImg);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
