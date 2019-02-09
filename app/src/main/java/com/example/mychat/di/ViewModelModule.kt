package com.example.mychat.di

import com.example.mychat.screen.ui.fragment.main.MainViewModel
import org.koin.android.viewmodel.experimental.builder.viewModel
import org.koin.dsl.module.module

val viewModelModule= module {
    viewModel <MainViewModel>()
}