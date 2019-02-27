package com.example.mychat.di

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import org.koin.dsl.module.module

val firebaseModule=module{
    single {createFirebaseAuthenticationReference()}
    single {createFirebaseDatabaseReference()}
}

fun createFirebaseDatabaseReference(): FirebaseDatabase {
    return FirebaseDatabase.getInstance()
}

fun createFirebaseAuthenticationReference(): FirebaseAuth {
    return FirebaseAuth.getInstance()
}

