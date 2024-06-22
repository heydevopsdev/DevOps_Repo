// Generated by view binder compiler. Do not edit!
package com.example.housemartapplication.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.housemartapplication.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class LayoutShopsBinding implements ViewBinding {
  @NonNull
  private final LinearLayoutCompat rootView;

  @NonNull
  public final AppCompatImageView imvShop;

  @NonNull
  public final AppCompatTextView txtShopDistance;

  @NonNull
  public final AppCompatTextView txtShopName;

  @NonNull
  public final AppCompatTextView txtShopRating;

  private LayoutShopsBinding(@NonNull LinearLayoutCompat rootView,
      @NonNull AppCompatImageView imvShop, @NonNull AppCompatTextView txtShopDistance,
      @NonNull AppCompatTextView txtShopName, @NonNull AppCompatTextView txtShopRating) {
    this.rootView = rootView;
    this.imvShop = imvShop;
    this.txtShopDistance = txtShopDistance;
    this.txtShopName = txtShopName;
    this.txtShopRating = txtShopRating;
  }

  @Override
  @NonNull
  public LinearLayoutCompat getRoot() {
    return rootView;
  }

  @NonNull
  public static LayoutShopsBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static LayoutShopsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.layout_shops, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static LayoutShopsBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.imvShop;
      AppCompatImageView imvShop = ViewBindings.findChildViewById(rootView, id);
      if (imvShop == null) {
        break missingId;
      }

      id = R.id.txtShopDistance;
      AppCompatTextView txtShopDistance = ViewBindings.findChildViewById(rootView, id);
      if (txtShopDistance == null) {
        break missingId;
      }

      id = R.id.txtShopName;
      AppCompatTextView txtShopName = ViewBindings.findChildViewById(rootView, id);
      if (txtShopName == null) {
        break missingId;
      }

      id = R.id.txtShopRating;
      AppCompatTextView txtShopRating = ViewBindings.findChildViewById(rootView, id);
      if (txtShopRating == null) {
        break missingId;
      }

      return new LayoutShopsBinding((LinearLayoutCompat) rootView, imvShop, txtShopDistance,
          txtShopName, txtShopRating);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
