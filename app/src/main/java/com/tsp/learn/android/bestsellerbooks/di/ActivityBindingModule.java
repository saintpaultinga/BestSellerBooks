package com.tsp.learn.android.bestsellerbooks.di;

import com.tsp.learn.android.bestsellerbooks.HomeActivity;

import dagger.Module;

/**
 * Created by itatriev on 7/10/18.
 */

@Module
public abstract class ActivityBindingModule {
    @ActivityScoped
    abstract HomeActivity mainActivity();
}
