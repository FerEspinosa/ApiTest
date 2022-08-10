package com.latorreencantada.apitest.root;

import com.latorreencantada.apitest.MainActivity;
import com.latorreencantada.apitest.TwitchTopGames.TopGamesModule;
import com.latorreencantada.apitest.TwitchTopGames.TwitchTopGamesActivity;
import com.latorreencantada.apitest.http.TwitchModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component (modules = {ApplicationModule.class, TwitchModule.class, TopGamesModule.class})
public interface ApplicationComponent {

    void inject (MainActivity target);
    void injectTopGame (TwitchTopGamesActivity target);
}
