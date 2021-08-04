package com.example.lab1first;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.common.api.internal.RegisterListenerMethod;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Register extends AppCompatActivity {
    private FirebaseAuth auth;
    private  EditText email;
    private  EditText password1;
    private  EditText password2;
    private  EditText phoneNumber;
    private  EditText name;
    private  Button   button2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        EditText email = findViewById(R.id.editTextTextEmailAddress3);
        EditText password1 = findViewById(R.id.editTextTextPassword3);
        EditText password2 = findViewById(R.id.editTextTextPassword4);
        EditText phoneNumber = findViewById(R.id.editTextPhone);
        EditText name = findViewById(R.id.editTextTextPersonName2);
        Button button2 = findViewById(R.id.button);
        auth = FirebaseAuth.getInstance();

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txtname = name.getText().toString();
                String txtemail = email.getText().toString();
                String txtpassword1 = password1.getText().toString();
                String txtpassword2 = password2.getText().toString();
                String txtphoneNumber = phoneNumber.getText().toString();
                if (TextUtils.isEmpty(txtemail) || TextUtils.isEmpty(txtpassword1) || TextUtils.isEmpty(txtpassword2) || TextUtils.isEmpty(txtphoneNumber) || TextUtils.isEmpty(txtname)) {
                    Toast.makeText(Register.this, "Empty credentials", Toast.LENGTH_SHORT).show();
                    name.setError("need to fill all");
                } else if ((txtpassword1.length() < 8 || txtpassword2.length() < 8)) {
                    Toast.makeText(Register.this, "password very short minimum 8 character", Toast.LENGTH_SHORT).show();
                    password1.setError("password too small");
                    password2.setError("password too small");
                } else if ((password1.equals(password2))) {
                    Toast.makeText(Register.this, "two password are not matched", Toast.LENGTH_SHORT).show();
                    password1.setError("password are not matched");

                } else {
                    registerUser(txtemail, txtpassword1);



                }
            }
        });
    }



    private void  registerUser(String email,String password1){
        auth.createUserWithEmailAndPassword(email,password1).addOnCompleteListener(Register.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull  Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(Register.this, "Registering user successfully", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(Register.this,MainActivity.class));
                    finish();
                }
                else {
                    Toast.makeText(Register.this, "Registering failed", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }



        }


