package fr.isep.ii3510.apisdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class VolleyActivity extends AppCompatActivity {
    TextView jokeIdTextView, jokeTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volley);
        jokeIdTextView = findViewById(R.id.volley_id_textView);
        jokeTextView = findViewById(R.id.volley_joke_textView);

        String url = "https://api.icndb.com/jokes/random";
        RequestQueue queue = Volley.newRequestQueue(this);

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d("Volley", response.toString());
                        try {
                            JSONObject value = response.getJSONObject("value");
                            int jokeId = value.getInt("id");
                            String joke = value.getString("joke");

                            jokeIdTextView.setText(getString(R.string.joke_id) + " " + jokeId);
                            jokeTextView.setText(getString(R.string.joke_content) + " " + joke);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("Volley", "An error occurred.");
                    }
        });

        queue.add(request);
    }
}