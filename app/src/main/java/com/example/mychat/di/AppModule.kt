package com.example.mychat.di

import com.example.mychat.rx.SchedulerProvider
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module.module
import org.koin.experimental.builder.create

val appModule= module {
    single { androidApplication().resources }
    single{create<SchedulerProvider>()}
}
val modules= listOf(
    appModule,
    viewModelModule,
    repositoryModule,
    firebaseModule
)
