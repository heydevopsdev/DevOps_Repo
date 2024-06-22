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

public final class ActivityUserSignUpOtpBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final ImageView imageView;

  @NonNull
  public final LinearLayout linearLayout;

  @NonNull
  public final LinearLayout linearLayout2;

  @NonNull
  public final LinearLayout llOtpSection;

  @NonNull
  public final ConstraintLayout main;

  @NonNull
  public final TextView mobileFetchTextView;

  @NonNull
  public final TextInputEditText otpTextInputEt;

  @NonNull
  public final TextView resendOtpTextView;

  @NonNull
  public final TextInputLayout textInputLayoutOtp;

  @NonNull
  public final TextView textView;

  @NonNull
  public final TextView textView2;

  @NonNull
  public final TextView textView3;

  @NonNull
  public final TextView textView4;

  @NonNull
  public final TextView txtResendText;

  @NonNull
  public final TextView txtResendTime;

  @NonNull
  public final Button verifyOTPButton;

  private ActivityUserSignUpOtpBinding(@NonNull ConstraintLayout rootView,
      @NonNull ImageView imageView, @NonNull LinearLayout linearLayout,
      @NonNull LinearLayout linearLayout2, @NonNull LinearLayout llOtpSection,
      @NonNull ConstraintLayout main, @NonNull TextView mobileFetchTextView,
      @NonNull TextInputEditText otpTextInputEt, @NonNull TextView resendOtpTextView,
      @NonNull TextInputLayout textInputLayoutOtp, @NonNull TextView textView,
      @NonNull TextView textView2, @NonNull TextView textView3, @NonNull TextView textView4,
      @NonNull TextView txtResendText, @NonNull TextView txtResendTime,
      @NonNull Button verifyOTPButton) {
    this.rootView = rootView;
    this.imageView = imageView;
    this.linearLayout = linearLayout;
    this.linearLayout2 = linearLayout2;
    this.llOtpSection = llOtpSection;
    this.main = main;
    this.mobileFetchTextView = mobileFetchTextView;
    this.otpTextInputEt = otpTextInputEt;
    this.resendOtpTextView = resendOtpTextView;
    this.textInputLayoutOtp = textInputLayoutOtp;
    this.textView = textView;
    this.textView2 = textView2;
    this.textView3 = textView3;
    this.textView4 = textView4;
    this.txtResendText = txtResendText;
    this.txtResendTime = txtResendTime;
    this.verifyOTPButton = verifyOTPButton;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityUserSignUpOtpBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityUserSignUpOtpBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_user_sign_up_otp, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityUserSignUpOtpBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
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

      id = R.id.llOtpSection;
      LinearLayout llOtpSection = ViewBindings.findChildViewById(rootView, id);
      if (llOtpSection == null) {
        break missingId;
      }

      ConstraintLayout main = (ConstraintLayout) rootView;

      id = R.id.mobileFetchTextView;
      TextView mobileFetchTextView = ViewBindings.findChildViewById(rootView, id);
      if (mobileFetchTextView == null) {
        break missingId;
      }

      id = R.id.otpTextInputEt;
      TextInputEditText otpTextInputEt = ViewBindings.findChildViewById(rootView, id);
      if (otpTextInputEt == null) {
        break missingId;
      }

      id = R.id.resendOtpTextView;
      TextView resendOtpTextView = ViewBindings.findChildViewById(rootView, id);
      if (resendOtpTextView == null) {
        break missingId;
      }

      id = R.id.textInputLayoutOtp;
      TextInputLayout textInputLayoutOtp = ViewBindings.findChildViewById(rootView, id);
      if (textInputLayoutOtp == null) {
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

      id = R.id.txtResendText;
      TextView txtResendText = ViewBindings.findChildViewById(rootView, id);
      if (txtResendText == null) {
        break missingId;
      }

      id = R.id.txtResendTime;
      TextView txtResendTime = ViewBindings.findChildViewById(rootView, id);
      if (txtResendTime == null) {
        break missingId;
      }

      id = R.id.verifyOTPButton;
      Button verifyOTPButton = ViewBindings.findChildViewById(rootView, id);
      if (verifyOTPButton == null) {
        break missingId;
      }

      return new ActivityUserSignUpOtpBinding((ConstraintLayout) rootView, imageView, linearLayout,
          linearLayout2, llOtpSection, main, mobileFetchTextView, otpTextInputEt, resendOtpTextView,
          textInputLayoutOtp, textView, textView2, textView3, textView4, txtResendText,
          txtResendTime, verifyOTPButton);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
