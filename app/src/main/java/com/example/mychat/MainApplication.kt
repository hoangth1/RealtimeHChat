package com.example.mychat

import android.app.Application
import com.example.mychat.di.modules
import org.koin.android.ext.android.startKoin

class MainApplication:Application(){
    override fun onCreate() {
        super.onCreate()
        startKoin(this,modules = modules)
    }
}
