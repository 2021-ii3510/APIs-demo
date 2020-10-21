package fr.isep.ii3510.apisdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class GlideActivity extends AppCompatActivity {
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glide);

        imageView = findViewById(R.id.glide_imageView);
        Glide.with(this)
                .load("https://i.imgflip.com/35rt5v.jpg")
                .into(imageView);
    }
}