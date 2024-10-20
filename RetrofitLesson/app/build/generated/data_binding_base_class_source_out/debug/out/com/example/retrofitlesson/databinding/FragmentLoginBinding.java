// Generated by view binder compiler. Do not edit!
package com.example.retrofitlesson.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.retrofitlesson.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentLoginBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final Button bNext;

  @NonNull
  public final Button bSignIn;

  @NonNull
  public final TextView error;

  @NonNull
  public final ImageView imageView;

  @NonNull
  public final EditText login;

  @NonNull
  public final TextView name;

  @NonNull
  public final EditText password;

  private FragmentLoginBinding(@NonNull ConstraintLayout rootView, @NonNull Button bNext,
      @NonNull Button bSignIn, @NonNull TextView error, @NonNull ImageView imageView,
      @NonNull EditText login, @NonNull TextView name, @NonNull EditText password) {
    this.rootView = rootView;
    this.bNext = bNext;
    this.bSignIn = bSignIn;
    this.error = error;
    this.imageView = imageView;
    this.login = login;
    this.name = name;
    this.password = password;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentLoginBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentLoginBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_login, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentLoginBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.bNext;
      Button bNext = ViewBindings.findChildViewById(rootView, id);
      if (bNext == null) {
        break missingId;
      }

      id = R.id.bSignIn;
      Button bSignIn = ViewBindings.findChildViewById(rootView, id);
      if (bSignIn == null) {
        break missingId;
      }

      id = R.id.error;
      TextView error = ViewBindings.findChildViewById(rootView, id);
      if (error == null) {
        break missingId;
      }

      id = R.id.imageView;
      ImageView imageView = ViewBindings.findChildViewById(rootView, id);
      if (imageView == null) {
        break missingId;
      }

      id = R.id.login;
      EditText login = ViewBindings.findChildViewById(rootView, id);
      if (login == null) {
        break missingId;
      }

      id = R.id.name;
      TextView name = ViewBindings.findChildViewById(rootView, id);
      if (name == null) {
        break missingId;
      }

      id = R.id.password;
      EditText password = ViewBindings.findChildViewById(rootView, id);
      if (password == null) {
        break missingId;
      }

      return new FragmentLoginBinding((ConstraintLayout) rootView, bNext, bSignIn, error, imageView,
          login, name, password);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
