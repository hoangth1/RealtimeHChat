package com.example.mychat.screen.ui.fragment.register

import android.content.res.Resources
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import com.example.mychat.data.repository.UserRepository
import com.example.mychat.screen.base.BaseViewModel
import com.example.mychat.utils.validateEmail
import com.example.mychat.utils.validatePasswod
import com.google.android.gms.tasks.OnFailureListener

class RegisterViewModel(
    val userRepository: UserRepository,
    val resources: Resources
) : BaseViewModel() {
    val registerSuccess = MutableLiveData<Boolean>().apply { value = false }
    val userName = MutableLiveData<String>()
    val email = MutableLiveData<String>()
    val password = MutableLiveData<String>()
    val errorEmail = MutableLiveData<String>()
    val errorPassword = MutableLiveData<String>()
    fun register(userName: String, email: String, password: String) {
        errorEmail.value = this.email.value?.validateEmail(resources)
        errorPassword.value = this.password.value?.validatePasswod(resources)
        if (errorEmail.value.isNullOrEmpty() && errorPassword.value.isNullOrEmpty()) {
            isLoading.value = true
            userRepository.register(email, password).addOnCompleteListener {
                if (it.isSuccessful) {
                    val userId = userRepository.getCurrentUser()?.uid ?: return@addOnCompleteListener
                    val userInformation = hashMapOf(
                        "id" to userId,
                        "username" to userName,
                        "email" to email
                    )
                    saveUserRemote(userInformation, userId).addOnCompleteListener {
                        isLoading.value = false
                        registerSuccess.value = true
                    }
                        .addOnFailureListener {
                            isLoading.value = false
                        }
                }

            }
                .addOnFailureListener {
                    onLoadFail(it)
                    registerSuccess.value = false
                }
        }
    }

    private fun saveUserRemote(userInformation: HashMap<String, String>, userId: String) =
        userRepository.saveUserRemote(userInformation, userId)

}
