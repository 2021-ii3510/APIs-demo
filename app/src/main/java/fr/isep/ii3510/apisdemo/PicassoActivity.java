package fr.isep.ii3510.apisdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class PicassoActivity extends AppCompatActivity {
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picasso);
        imageView = findViewById(R.id.picasso_imageView);

        Picasso.get()
                .load("https://i.imgflip.com/35rt5v.jpg")
                .into(imageView);
    }
}