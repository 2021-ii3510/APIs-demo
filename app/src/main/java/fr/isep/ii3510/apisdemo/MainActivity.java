package fr.isep.ii3510.apisdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void picassoClicked(View view) {
        Intent intent = new Intent(this, PicassoActivity.class);
        startActivity(intent);
    }

    public void glideClicked(View view) {
        Intent intent = new Intent(this, GlideActivity.class);
        startActivity(intent);
    }

    public void volleyClicked(View view) {
        Intent intent = new Intent(this, VolleyActivity.class);
        startActivity(intent);
    }

    public void retrofitClicked(View view) {
        Intent intent = new Intent(this, RetrofitActivity.class);
        startActivity(intent);
    }
}