package com.latorreencantada.apitest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.latorreencantada.apitest.TwitchTopGames.TwitchTopGamesActivity;
import com.latorreencantada.apitest.http.API;
import com.latorreencantada.apitest.root.App;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    @Inject
    API TwitchApi;

    Button bt_twitch;
    Button bt_googleImages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((App) getApplicationContext()).getComponent().inject(this);

        bt_twitch = findViewById(R.id.bt_twitch_games);
        bt_twitch.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, TwitchTopGamesActivity.class)));


        // Ejemplo de uso de Retrofit llamando a la API de Twitch

/*
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
*/

    }
}