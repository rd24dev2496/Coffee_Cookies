package com.example.coffeeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class CookieActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cookie);
    }

    @SuppressLint("SetTextI18n")
    public void eatCookie(View view) {
        ImageView imageView = (ImageView) findViewById(R.id.android_cookie_image_view);
        imageView.setImageResource(R.drawable.after_cookie);

        // Find a reference to the TextView in the layout. Change the text.
        TextView textView = (TextView) findViewById(R.id.status_text_view);
        textView.setText("I'm so full");
    }
}