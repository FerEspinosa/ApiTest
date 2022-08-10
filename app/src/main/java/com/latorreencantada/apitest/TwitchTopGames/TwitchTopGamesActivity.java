package com.latorreencantada.apitest.TwitchTopGames;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.latorreencantada.apitest.root.App;
import com.latorreencantada.apitest.GameAdapter;
import com.latorreencantada.apitest.R;
import com.latorreencantada.apitest.http.API;
import com.latorreencantada.apitest.http.Twitch.Game;
import com.latorreencantada.apitest.http.Twitch.Twitch;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TwitchTopGamesActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    GameAdapter adapter;
    @Inject
    API TwitchApi;

    FloatingActionButton bt_toast;

    private final List<Game> games = new ArrayList<>();

    int counter=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_twitch_top_games);

        ((App) getApplicationContext()).getComponent().injectTopGame(this);

        recyclerView = findViewById(R.id.twitch_topgames_rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));

        adapter = new GameAdapter(this, games);
        recyclerView.setAdapter(adapter);
        getData();

        bt_toast = findViewById(R.id.bt_toast);

        bt_toast.setOnClickListener(v -> {
            Toast.makeText(TwitchTopGamesActivity.this, games.get(counter).getName(), Toast.LENGTH_SHORT).show();
            counter++;
        });

    }

    private void getData() {


        Call<Twitch> call = TwitchApi.getTopGames("t1n7zd6epf29v4y3n938gr8j0ccvyd", "Bearer hfhwh0hcms96jyha9he9siaqlso6de");


        call.enqueue(new Callback<Twitch>() {
            @Override
            public void onResponse(@NonNull Call<Twitch> call, @NonNull Response<Twitch> response) {

                assert response.body() != null;
                List<Game> topGames = response.body().getGames();
                games.addAll(topGames);
                adapter.setGames(games);
            }
            @Override
            public void onFailure(@NonNull Call<Twitch> call, @NonNull Throwable t) {
                t.printStackTrace();
            }
        });

    }
}