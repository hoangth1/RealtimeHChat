package com.example.mychat.screen.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mychat.data.remote.BaseException
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import java.net.SocketTimeoutException
import java.net.UnknownHostException

class BaseViewModel : ViewModel() {
    val isLoading = MutableLiveData<Boolean>()
    val errorMessage = MutableLiveData<String>()
    val compositeDisposable = CompositeDisposable()

    fun addDisposable(disposable: Disposable) {
        compositeDisposable.add(disposable)
    }

    fun onLoadFail(throwable: Throwable) {
        when (throwable) {
            is BaseException -> {
                when (throwable.cause) {
                    is UnknownHostException ->
                        errorMessage.value = "No Internet Connection"
                    is SocketTimeoutException ->
                        errorMessage.value = "Connect timeout, please retry"
                    else ->
                        errorMessage.value = throwable.message
                }

            }
            else -> errorMessage.value = throwable.message
        }
        isLoading.value = false

    }

    fun showError(e: Throwable) {
        errorMessage.value = e.message
    }

    fun clearCompositDisposable(){
        compositeDisposable.clear()
    }
}
