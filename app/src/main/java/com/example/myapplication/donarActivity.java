package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class donarActivity extends AppCompatActivity {
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{6,}$";
    ProgressDialog progressDialog;
    FirebaseDatabase rootnode;

    DatabaseReference reference;
    EditText donarname, donarphone, donaremail, donarpassword;
    FirebaseAuth mAuth;
    FirebaseUser mUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donar);

        donarname = findViewById(R.id.donarname);
        donarphone = findViewById(R.id.donarphone);
        donaremail = findViewById(R.id.donaremail);
        donarpassword = findViewById(R.id.donarpassword);
        Button donarbtnreg = findViewById(R.id.donarreg);
        progressDialog = new ProgressDialog(this);
        mAuth = FirebaseAuth.getInstance();
        mUser = mAuth.getCurrentUser();

        Spinner sp = findViewById(R.id.donarspinner);
        String[] bloodGroups = {
                "A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-"
        };

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, bloodGroups);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp.setAdapter(adapter);

        donarbtnreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                performAuth();
                performDatabase();
            }

            private void performAuth() {
                String name = donarname.getText().toString().trim();
                String phone = donarphone.getText().toString().trim();
                String email = donaremail.getText().toString().trim();
                String password = donarpassword.getText().toString().trim();

                if (!email.matches(emailPattern)) {
                    donaremail.setError("Enter a valid Email");
                } else if (!password.matches(PASSWORD_PATTERN)) {
                    donarpassword.setError("Password must contain at least one digit, one lower case, one upper case, one special character, and be at least 6 characters long");
                } else {
                    progressDialog.setMessage("Please wait while we register you");
                    progressDialog.setTitle("Register");
                    progressDialog.setCanceledOnTouchOutside(false);
                    progressDialog.show();

                    mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            progressDialog.dismiss();
                            if (task.isSuccessful()) {
                                nextActivity();
                                Toast.makeText(donarActivity.this, "Registration Successful", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(donarActivity.this, "Registration Failed: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });
    }

    private void performDatabase() {
        rootnode =FirebaseDatabase.getInstance();
        reference=rootnode.getReference("Donar");
        String name=donarname.getText().toString();
        String email=donaremail.getText().toString();
        String phone=donarphone.getText().toString();
        String password=donarpassword.getText().toString();
       DonarHelperClass donarHelperClass=new DonarHelperClass( name , phone , email , password );
        reference.child(name).setValue(donarHelperClass);

    }

    private void nextActivity() {
        Intent intent = new Intent(donarActivity.this, InsideActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}
