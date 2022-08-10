package com.latorreencantada.apitest.root;

import android.app.Application;

import com.latorreencantada.apitest.DaggerApplicationComponent;
import com.latorreencantada.apitest.http.TwitchModule;

public class App extends Application {

    private ApplicationComponent component;

    @Override
    public void onCreate() {
        super.onCreate();

        component = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .twitchModule(new TwitchModule())
                .build();

    }

    public ApplicationComponent getComponent(){
        return component;
    }
}
