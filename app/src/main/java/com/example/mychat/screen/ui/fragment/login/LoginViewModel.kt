package com.example.mychat.screen.ui.fragment.login

import androidx.lifecycle.MutableLiveData
import com.example.mychat.data.repository.UserRepository
import com.example.mychat.screen.base.BaseViewModel

class LoginViewModel(val userRepository: UserRepository) : BaseViewModel() {
    val email = MutableLiveData<String>()
    val password = MutableLiveData<String>()
    val loginSuccess = MutableLiveData<Boolean>().apply { value = false }

    fun signInWithEmail(email: String, password: String) {
        isLoading.value = true
        userRepository.login(email, password).addOnCompleteListener {
            isLoading.value = false
            if (it.isSuccessful) {
                loginSuccess.value = true
            } else if (!it.isSuccessful) {
                onLoadFail(it.exception ?: return@addOnCompleteListener)
            }
        }
    }
}