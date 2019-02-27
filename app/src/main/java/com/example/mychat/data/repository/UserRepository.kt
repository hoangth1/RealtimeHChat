package com.example.mychat.data.repository

import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseUser

interface UserRepository {
    fun register( email:String, password:String):Task<AuthResult>
    fun login (email:String, password:String)
    fun saveUserRemote(userInformation:HashMap<String,String>,userId:String):Task<Void>
    fun getCurrentUser():FirebaseUser?
}