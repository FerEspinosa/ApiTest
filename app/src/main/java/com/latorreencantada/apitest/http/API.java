package com.latorreencantada.apitest.http;

import com.latorreencantada.apitest.http.Twitch.Twitch;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

public interface API {

    @GET("games/top")
    Call<Twitch> getTopGames(@Header("client-id") String clientId, @Header("Authorization") String token);


}
