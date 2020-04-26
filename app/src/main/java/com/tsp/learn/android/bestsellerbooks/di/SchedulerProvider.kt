package com.tsp.learn.android.bestsellerbooks.di

import io.reactivex.Scheduler

interface SchedulerProvider {
    fun io(): Scheduler
    fun ui(): Scheduler
}