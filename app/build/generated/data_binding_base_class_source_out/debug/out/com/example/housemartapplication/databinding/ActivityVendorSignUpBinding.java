// Generated by view binder compiler. Do not edit!
package com.example.housemartapplication.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.housemartapplication.R;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityVendorSignUpBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final TextInputEditText gstNoTextInputEt;

  @NonNull
  public final ImageView imageView;

  @NonNull
  public final LinearLayout linearLayout;

  @NonNull
  public final LinearLayout linearLayout2;

  @NonNull
  public final ConstraintLayout main;

  @NonNull
  public final TextInputEditText mobNumVendorSignUpTextInputEt;

  @NonNull
  public final TextInputEditText nameTextInputEt;

  @NonNull
  public final Button nextBtnSignupAsVendor1;

  @NonNull
  public final TextInputEditText shopNameTextInputEt;

  @NonNull
  public final TextInputLayout textInputLayoutVendorFullName;

  @NonNull
  public final TextInputLayout textInputLayoutVendorGSTNo;

  @NonNull
  public final TextInputLayout textInputLayoutVendorMobileNo;

  @NonNull
  public final TextInputLayout textInputLayoutVendorShopName;

  @NonNull
  public final TextView textView;

  @NonNull
  public final TextView textView2;

  @NonNull
  public final TextView textView3;

  @NonNull
  public final TextView textView4;

  @NonNull
  public final TextView textView5;

  @NonNull
  public final TextView textView6;

  private ActivityVendorSignUpBinding(@NonNull ConstraintLayout rootView,
      @NonNull TextInputEditText gstNoTextInputEt, @NonNull ImageView imageView,
      @NonNull LinearLayout linearLayout, @NonNull LinearLayout linearLayout2,
      @NonNull ConstraintLayout main, @NonNull TextInputEditText mobNumVendorSignUpTextInputEt,
      @NonNull TextInputEditText nameTextInputEt, @NonNull Button nextBtnSignupAsVendor1,
      @NonNull TextInputEditText shopNameTextInputEt,
      @NonNull TextInputLayout textInputLayoutVendorFullName,
      @NonNull TextInputLayout textInputLayoutVendorGSTNo,
      @NonNull TextInputLayout textInputLayoutVendorMobileNo,
      @NonNull TextInputLayout textInputLayoutVendorShopName, @NonNull TextView textView,
      @NonNull TextView textView2, @NonNull TextView textView3, @NonNull TextView textView4,
      @NonNull TextView textView5, @NonNull TextView textView6) {
    this.rootView = rootView;
    this.gstNoTextInputEt = gstNoTextInputEt;
    this.imageView = imageView;
    this.linearLayout = linearLayout;
    this.linearLayout2 = linearLayout2;
    this.main = main;
    this.mobNumVendorSignUpTextInputEt = mobNumVendorSignUpTextInputEt;
    this.nameTextInputEt = nameTextInputEt;
    this.nextBtnSignupAsVendor1 = nextBtnSignupAsVendor1;
    this.shopNameTextInputEt = shopNameTextInputEt;
    this.textInputLayoutVendorFullName = textInputLayoutVendorFullName;
    this.textInputLayoutVendorGSTNo = textInputLayoutVendorGSTNo;
    this.textInputLayoutVendorMobileNo = textInputLayoutVendorMobileNo;
    this.textInputLayoutVendorShopName = textInputLayoutVendorShopName;
    this.textView = textView;
    this.textView2 = textView2;
    this.textView3 = textView3;
    this.textView4 = textView4;
    this.textView5 = textView5;
    this.textView6 = textView6;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityVendorSignUpBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityVendorSignUpBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_vendor_sign_up, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityVendorSignUpBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.gstNoTextInputEt;
      TextInputEditText gstNoTextInputEt = ViewBindings.findChildViewById(rootView, id);
      if (gstNoTextInputEt == null) {
        break missingId;
      }

      id = R.id.imageView;
      ImageView imageView = ViewBindings.findChildViewById(rootView, id);
      if (imageView == null) {
        break missingId;
      }

      id = R.id.linearLayout;
      LinearLayout linearLayout = ViewBindings.findChildViewById(rootView, id);
      if (linearLayout == null) {
        break missingId;
      }

      id = R.id.linearLayout2;
      LinearLayout linearLayout2 = ViewBindings.findChildViewById(rootView, id);
      if (linearLayout2 == null) {
        break missingId;
      }

      ConstraintLayout main = (ConstraintLayout) rootView;

      id = R.id.mobNumVendorSignUpTextInputEt;
      TextInputEditText mobNumVendorSignUpTextInputEt = ViewBindings.findChildViewById(rootView, id);
      if (mobNumVendorSignUpTextInputEt == null) {
        break missingId;
      }

      id = R.id.nameTextInputEt;
      TextInputEditText nameTextInputEt = ViewBindings.findChildViewById(rootView, id);
      if (nameTextInputEt == null) {
        break missingId;
      }

      id = R.id.nextBtnSignupAsVendor1;
      Button nextBtnSignupAsVendor1 = ViewBindings.findChildViewById(rootView, id);
      if (nextBtnSignupAsVendor1 == null) {
        break missingId;
      }

      id = R.id.shopNameTextInputEt;
      TextInputEditText shopNameTextInputEt = ViewBindings.findChildViewById(rootView, id);
      if (shopNameTextInputEt == null) {
        break missingId;
      }

      id = R.id.textInputLayoutVendorFullName;
      TextInputLayout textInputLayoutVendorFullName = ViewBindings.findChildViewById(rootView, id);
      if (textInputLayoutVendorFullName == null) {
        break missingId;
      }

      id = R.id.textInputLayoutVendorGSTNo;
      TextInputLayout textInputLayoutVendorGSTNo = ViewBindings.findChildViewById(rootView, id);
      if (textInputLayoutVendorGSTNo == null) {
        break missingId;
      }

      id = R.id.textInputLayoutVendorMobileNo;
      TextInputLayout textInputLayoutVendorMobileNo = ViewBindings.findChildViewById(rootView, id);
      if (textInputLayoutVendorMobileNo == null) {
        break missingId;
      }

      id = R.id.textInputLayoutVendorShopName;
      TextInputLayout textInputLayoutVendorShopName = ViewBindings.findChildViewById(rootView, id);
      if (textInputLayoutVendorShopName == null) {
        break missingId;
      }

      id = R.id.textView;
      TextView textView = ViewBindings.findChildViewById(rootView, id);
      if (textView == null) {
        break missingId;
      }

      id = R.id.textView2;
      TextView textView2 = ViewBindings.findChildViewById(rootView, id);
      if (textView2 == null) {
        break missingId;
      }

      id = R.id.textView3;
      TextView textView3 = ViewBindings.findChildViewById(rootView, id);
      if (textView3 == null) {
        break missingId;
      }

      id = R.id.textView4;
      TextView textView4 = ViewBindings.findChildViewById(rootView, id);
      if (textView4 == null) {
        break missingId;
      }

      id = R.id.textView5;
      TextView textView5 = ViewBindings.findChildViewById(rootView, id);
      if (textView5 == null) {
        break missingId;
      }

      id = R.id.textView6;
      TextView textView6 = ViewBindings.findChildViewById(rootView, id);
      if (textView6 == null) {
        break missingId;
      }

      return new ActivityVendorSignUpBinding((ConstraintLayout) rootView, gstNoTextInputEt,
          imageView, linearLayout, linearLayout2, main, mobNumVendorSignUpTextInputEt,
          nameTextInputEt, nextBtnSignupAsVendor1, shopNameTextInputEt,
          textInputLayoutVendorFullName, textInputLayoutVendorGSTNo, textInputLayoutVendorMobileNo,
          textInputLayoutVendorShopName, textView, textView2, textView3, textView4, textView5,
          textView6);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
