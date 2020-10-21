package fr.isep.ii3510.apisdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitActivity extends AppCompatActivity {
    TextView jokeIdTextView, jokeTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit);

        jokeIdTextView = findViewById(R.id.retrofit_id_textView);
        jokeTextView = findViewById(R.id.retrofit_joke_textView);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.icndb.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ChuckNorrisService service = retrofit.create(ChuckNorrisService.class);
        service.randomJoke().enqueue(new Callback<Joke>() {
            @Override
            public void onResponse(Call<Joke> call, Response<Joke> response) {
                Value jokeValue = response.body().getValue();
                int jokeId = jokeValue.getId();
                String joke = jokeValue.getJoke();
                jokeIdTextView.setText(getString(R.string.joke_id) + " " + jokeId);
                jokeTextView.setText(getString(R.string.joke_content) + " " + joke);
            }

            @Override
            public void onFailure(Call<Joke> call, Throwable t) {
                Log.d("Retrofit", t.getMessage());
            }
        });


        // TODO: To implement so that you can actually display multiple jokes in a ListView or RecyclerView
//        service.randomJokes(3).enqueue(new Callback<List<Joke>>() {
//            @Override
//            public void onResponse(Call<List<Joke>> call, Response<List<Joke>> response) {
//                // TODO: To implement
//            }
//
//            @Override
//            public void onFailure(Call<List<Joke>> call, Throwable t) {
//                // TODO: To implement
//            }
//        });
    }
}