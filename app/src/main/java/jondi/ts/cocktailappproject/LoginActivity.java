package jondi.ts.cocktailappproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.nfc.Tag;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity {
    Button btnLogin;
    Button btnRegister;
    private static final int PASSWORD_LENGTH = 5;
    EditText etEmail;
    EditText etPassword;
    CheckBox showPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btnLogin = findViewById(R.id.btnLogin);
        btnRegister = findViewById(R.id.btnRegister);
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        showPassword = findViewById(R.id.showPassword);

        showPassword.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    etPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }else {
                    etPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
            }
        });
        btnLogin.setOnClickListener(v -> {

            if (!isEmailValid() | !isPasswwordValid())
                return;
            //if login takes time show some dialog
            toggleProgressDialog(true);

            String email = etEmail.getText().toString();
            String password = etPassword.getText().toString();
            //ref to the Auth Object of firebase:
            FirebaseAuth mAuth = FirebaseAuth.getInstance();
            //use the createUserWithEmailAndPassword(email ,password) method:
            mAuth.signInWithEmailAndPassword(getEmail(), getPassword()).
                    addOnSuccessListener(this, authResult -> {
                        goToMainActivity();
                    }).addOnFailureListener(this, e -> {
                showErrorDialog(e);

            });

        });

        btnRegister.setOnClickListener(v -> {
//if password or email are not valid close the method
            if (!isEmailValid() | !isPasswwordValid())
                return;
            //if login takes time show some dialog
            toggleProgressDialog(true);

            String email = etEmail.getText().toString();
            String password = etPassword.getText().toString();
            //ref to the Auth Object of firebase:
            FirebaseAuth mAuth = FirebaseAuth.getInstance();
            //use the createUserWithEmailAndPassword(email ,password) method:
            mAuth.createUserWithEmailAndPassword(getEmail(), getPassword()).
                    addOnSuccessListener(this, authResult -> {
                        AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this, R.style.AlertDialogTheme);
                        View view = LayoutInflater.from(LoginActivity.this).inflate(R.layout.laoyout_success_dialog,
                                (ConstraintLayout) findViewById(R.id.layoutDialogContainer));
                        builder.setView(view);
                        ((TextView) view.findViewById(R.id.textTitle)).setText("Welcome");
                        ((TextView) view.findViewById(R.id.textMessage)).setText(" account has been successfully created.");
                        ((Button) view.findViewById(R.id.buttonAction)).setText("OK");
                        ((ImageView) view.findViewById(R.id.imageICon)).setImageResource(R.drawable.ic_success);

                        AlertDialog alertDialog = builder.create();
                        alertDialog.setCancelable(false);
                        view.findViewById(R.id.buttonAction).setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                                goToMainActivity();
                            }
                        });
                        if (alertDialog.getWindow() != null) {
                            alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
                        }
                        alertDialog.show();

                    }).addOnFailureListener(this, e -> {
                showErrorDialog(e);
            });

        });

    }

    private void showErrorDialog(Exception e) {
        toggleProgressDialog(false);
        AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this, R.style.AlertDialogTheme);
        View view = LayoutInflater.from(LoginActivity.this).inflate(R.layout.layout_error_dialog,
                (ConstraintLayout) findViewById(R.id.layoutDialogContainer));
        builder.setView(view);
        ((TextView) view.findViewById(R.id.textTitle)).setText("Error");
        ((TextView) view.findViewById(R.id.textMessage)).setText(e.getMessage());
        ((Button) view.findViewById(R.id.buttonAction)).setText("OK");
        ((ImageView) view.findViewById(R.id.imageICon)).setImageResource(R.drawable.ic_error);

        AlertDialog alertDialog = builder.create();
        view.findViewById(R.id.buttonAction).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
            }
        });
        if (alertDialog.getWindow() != null) {
            alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        }
        alertDialog.show();
    }

    private void showSuccesDialog() {

    }


    private void goToMainActivity() {
        toggleProgressDialog(false);
        //success! Go to Main Activity using an intent:
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish(); //make sure back button does not send us back to login
    }

    private String getEmail() {
        return etEmail.getText().toString();
    }

    private String getPassword() {
        return etPassword.getText().toString();
    }

    private boolean isEmailValid() {
        boolean isValid = Patterns.EMAIL_ADDRESS.matcher(getEmail()).matches();
        if (!isValid) {
            etEmail.setError("Email is not valid");
        }
        return isValid;
    }

    private boolean isPasswwordValid() {
        boolean isValid = getPassword().length() > PASSWORD_LENGTH;
        if (!isValid) {
            etPassword.setError("Password must contain at least 6 characters");
        }
        return isValid;
    }

    private ProgressDialog progressDialog; // shows progress circle

    public void toggleProgressDialog(boolean shouldShow) {
        if (progressDialog == null) {
            progressDialog = new ProgressDialog(this);
            progressDialog.setTitle("Please wait");
            progressDialog.setMessage("Connecting  to remote server");

        }
        if (shouldShow)
            progressDialog.show();
        else
            progressDialog.dismiss();

    }


}