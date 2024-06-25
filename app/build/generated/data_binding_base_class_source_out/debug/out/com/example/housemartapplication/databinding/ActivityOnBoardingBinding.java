// Generated by view binder compiler. Do not edit!
package com.example.housemartapplication.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.example.housemartapplication.R;
import java.lang.NullPointerException;
import java.lang.Override;

public final class ActivityOnBoardingBinding implements ViewBinding {
  @NonNull
  private final RelativeLayout rootView;

  @NonNull
  public final RelativeLayout main;

  private ActivityOnBoardingBinding(@NonNull RelativeLayout rootView,
      @NonNull RelativeLayout main) {
    this.rootView = rootView;
    this.main = main;
  }

  @Override
  @NonNull
  public RelativeLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityOnBoardingBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityOnBoardingBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_on_boarding, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityOnBoardingBinding bind(@NonNull View rootView) {
    if (rootView == null) {
      throw new NullPointerException("rootView");
    }

    RelativeLayout main = (RelativeLayout) rootView;

    return new ActivityOnBoardingBinding((RelativeLayout) rootView, main);
  }
}
