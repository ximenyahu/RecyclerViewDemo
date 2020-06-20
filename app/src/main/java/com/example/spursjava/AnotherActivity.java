package com.example.spursjava;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class AnotherActivity extends AppCompatActivity {

    private TextView mAnotherTitle;
    private TextView mAnotherDescription;
    private ImageView mAnotherImageView;
    private int mImageId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_another);
        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        String description = intent.getStringExtra("description");
        mImageId = intent.getIntExtra("image", R.mipmap.ic_launcher);
        mAnotherTitle = findViewById(R.id.another_title);
        mAnotherDescription = findViewById(R.id.another_description);
        mAnotherImageView = findViewById(R.id.another_image_view);
        mAnotherTitle.setText(title);
        mAnotherDescription.setText(description);
        mAnotherImageView.setImageResource(mImageId);
    }

}