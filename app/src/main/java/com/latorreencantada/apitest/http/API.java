package com.latorreencantada.apitest.http;

import com.latorreencantada.apitest.http.Twitch.Twitch;

import retrofit2.Call;
import retrofit2.http.GET;

public interface API {

    @GET("games/top")
    Call<Twitch> getTopGames();


}
