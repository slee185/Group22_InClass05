// Generated by view binder compiler. Do not edit!
package edu.uncc.inclass05.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import edu.uncc.inclass05.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class AppsListAppRowBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final TextView appRowArtistTextView;

  @NonNull
  public final TextView appRowNameTextView;

  @NonNull
  public final TextView appRowReleaseDateTextView;

  private AppsListAppRowBinding(@NonNull ConstraintLayout rootView,
      @NonNull TextView appRowArtistTextView, @NonNull TextView appRowNameTextView,
      @NonNull TextView appRowReleaseDateTextView) {
    this.rootView = rootView;
    this.appRowArtistTextView = appRowArtistTextView;
    this.appRowNameTextView = appRowNameTextView;
    this.appRowReleaseDateTextView = appRowReleaseDateTextView;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static AppsListAppRowBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static AppsListAppRowBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.apps_list_app_row, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static AppsListAppRowBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.appRowArtistTextView;
      TextView appRowArtistTextView = ViewBindings.findChildViewById(rootView, id);
      if (appRowArtistTextView == null) {
        break missingId;
      }

      id = R.id.appRowNameTextView;
      TextView appRowNameTextView = ViewBindings.findChildViewById(rootView, id);
      if (appRowNameTextView == null) {
        break missingId;
      }

      id = R.id.appRowReleaseDateTextView;
      TextView appRowReleaseDateTextView = ViewBindings.findChildViewById(rootView, id);
      if (appRowReleaseDateTextView == null) {
        break missingId;
      }

      return new AppsListAppRowBinding((ConstraintLayout) rootView, appRowArtistTextView,
          appRowNameTextView, appRowReleaseDateTextView);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
