package com.example.lab1first;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class profileActivity1 extends AppCompatActivity {

  private Button button1 = findViewById(R.id.button2);
  private TextView view1 = findViewById(R.id.textView2);

  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_profile);
    button1 = findViewById(R.id.button2);
    view1 = findViewById(R.id.textView2);

    button1.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        view1.setText("hello");
        FirebaseAuth.getInstance().signOut();
        Toast.makeText(profileActivity1.this, "Logout page", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(profileActivity1.this, MainActivity.class));
      }
    });
  }
}
