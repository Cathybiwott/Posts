package com.example.assessment4_fetching.viewmodel

import android.app.Application
import android.content.Context

class PostsApp:Application() {
    companion object{
        lateinit var appContext: Context
    }

    override fun onCreate() {
        super.onCreate()
        appContext =applicationContext
    }
}