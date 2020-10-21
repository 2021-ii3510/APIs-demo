package fr.isep.ii3510.apisdemo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ChuckNorrisService {
    @GET("jokes/random")
    Call<Joke> randomJoke();

    @GET("jokes/{jokeId}")
    Call<Joke> getJokeById(@Path("jokeId") int jokeId);

    @GET("jokes/random/{number}")
    Call<List<Joke>> randomJokes(@Path("number") int number);
}
