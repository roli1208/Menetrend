package com.example.menetrend;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;

    EditText nameET;
    EditText emailET;
    EditText passwdET;
    EditText passwdET2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        nameET = findViewById(R.id.et_regname);
        emailET = findViewById(R.id.et_regemail);
        passwdET = findViewById(R.id.et_regpassword);
        passwdET2 = findViewById(R.id.et_regpassword2);
        mAuth = FirebaseAuth.getInstance();
    }

    public void backtoMain(View view) {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }

    public void registration(View view) {
        String email = emailET.getText().toString();
        String name = nameET.getText().toString();
        String password = passwdET.getText().toString();
        String password2 = passwdET2.getText().toString();
        if (password.length() >= 8 && password.equals(password2)) {
            mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        backtoMain(view);
                    }
                }
            });
        }else{
            Log.println(Log.ASSERT, "1", "hiba");
        }
    }
}