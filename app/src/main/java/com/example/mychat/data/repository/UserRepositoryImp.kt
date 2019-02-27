package com.example.mychat.data.repository

import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.FirebaseDatabase

class UserRepositoryImp(
    val firebaseAuth: FirebaseAuth,
    val firebaseDatabase: FirebaseDatabase
) : UserRepository {

    override fun saveUserRemote(userInformation: HashMap<String, String>, userId: String): Task<Void> {
        return firebaseDatabase.getReference("User").child(userId).setValue(userInformation)
    }

    override fun register(email: String, password: String): Task<AuthResult> {
        return firebaseAuth.createUserWithEmailAndPassword(email, password)
    }

    override fun login(email: String, password: String) {
    }

    override fun getCurrentUser():FirebaseUser? {
        return firebaseAuth.currentUser
    }
}