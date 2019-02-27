package com.example.mychat.screen.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mychat.data.remote.BaseException
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import java.lang.Exception
import java.net.SocketTimeoutException
import java.net.UnknownHostException

abstract class BaseViewModel : ViewModel() {
    val isLoading = MutableLiveData<Boolean>()
    val errorMessage = MutableLiveData<String>()
    val compositeDisposable = CompositeDisposable()

    fun addDisposable(disposable: Disposable) {
        compositeDisposable.add(disposable)
    }

    fun onLoadFail(exception: Exception) {
        when (exception) {
            is BaseException -> {
                when (exception.cause) {
                    is UnknownHostException ->
                        errorMessage.value = "No Internet Connection"
                    is SocketTimeoutException ->
                        errorMessage.value = "Connect timeout, please retry"
                    else ->
                        errorMessage.value = exception.message
                }

            }
            else -> errorMessage.value = exception.message
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
