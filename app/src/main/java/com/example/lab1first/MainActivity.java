package com.example.lab1first;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    private FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1 = findViewById(R.id.button3);
        TextView textView1 = findViewById(R.id.textView);
        EditText email1 = findViewById(R.id.editTextTextEmailAddress);
        EditText password3 = findViewById(R.id.editTextTextPassword);
       auth = FirebaseAuth.getInstance();


        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Register.class));
                finish();
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txtemail1 = email1.getText().toString();
                String txtpasssword1 = password3.getText().toString();
                loginuser(txtemail1, txtpasssword1);

            }
        });
    }
        private void loginuser(String email1,String password3){
           auth.signInWithEmailAndPassword(email1,password3).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
               @Override
               public void onSuccess(AuthResult authResult) {

                   Toast.makeText(MainActivity.this, "Login was successfully", Toast.LENGTH_SHORT).show();
                   startActivity(new Intent(MainActivity.this,profileActivity1.class));
                   finish();
               }

           });
        }
    }
