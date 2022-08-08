package com.latorreencantada.apitest;

import com.latorreencantada.apitest.http.TwitchModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component (modules = {ApplicationModule.class, TwitchModule.class})
public interface ApplicationComponent {

    void inject (MainActivity target);
}
