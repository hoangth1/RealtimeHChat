package com.example.mychat.di

import com.example.mychat.data.repository.UserRepository
import com.example.mychat.data.repository.UserRepositoryImp
import org.koin.dsl.module.module
import org.koin.experimental.builder.create

val repositoryModule = module {
    single<UserRepository> { create<UserRepositoryImp>() }
}