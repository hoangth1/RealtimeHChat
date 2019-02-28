package com.example.mychat.di

import com.example.mychat.screen.start.StartFragment
import com.example.mychat.screen.start.StartViewModel
import com.example.mychat.screen.ui.fragment.login.LoginViewModel
import com.example.mychat.screen.ui.fragment.main.MainViewModel
import com.example.mychat.screen.ui.fragment.register.RegisterViewModel
import org.koin.android.viewmodel.experimental.builder.viewModel
import org.koin.dsl.module.module

val viewModelModule = module {
    viewModel<MainViewModel>()
    viewModel<RegisterViewModel>()
    viewModel<StartViewModel>()
    viewModel<LoginViewModel>()
}
