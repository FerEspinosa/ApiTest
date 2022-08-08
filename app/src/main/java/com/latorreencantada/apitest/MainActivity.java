package com.latorreencantada.apitest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.latorreencantada.apitest.http.API;
import com.latorreencantada.apitest.http.Twitch.Game;
import com.latorreencantada.apitest.http.Twitch.Twitch;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Inject
    API TwitchApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((App) getApplicationContext()).getComponent().inject(this);


        // Ejemplo de uso de Retrofit llamando a la API de Twitch

        Call<Twitch> call = TwitchApi.getTopGames("t1n7zd6epf29v4y3n938gr8j0ccvyd", "Bearer hfhwh0hcms96jyha9he9siaqlso6de");


        call.enqueue(new Callback<Twitch>() {
            @Override
            public void onResponse(@NonNull Call<Twitch> call, @NonNull Response<Twitch> response) {

                if (response.body()!=null){

                    List<Game> topGames = response.body().getGames();
                    for (Game game : topGames){
                        System.out.println(game.getName());
                    }
                }
            }

            @Override
            public void onFailure(@NonNull Call<Twitch> call, @NonNull Throwable t) {
                t.printStackTrace();
            }
        });

        //------------------------------------------------------------------------------


    }
}