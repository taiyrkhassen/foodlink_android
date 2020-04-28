package com.example.foodlink_android

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import com.example.foodlink_android.common.base.BaseViewModel
import com.example.foodlink_android.repositories.RepositoryAuthImpl
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class SplashViewModel @Inject constructor(
    private val authRepo: RepositoryAuthImpl
) : BaseViewModel() {

    val state = MediatorLiveData<State>()
    val stateLiveData by lazy {  MutableLiveData<State>()  }
    fun checkAuth() {
        addDisposable(
            authRepo.checkIsAuthorised()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                        state.value = State.Result(it)
                    }, {
                        state.value = State.Error(it.localizedMessage?: "Suka blyat")
                    }
                )
        )
    }

    sealed class State() {
        data class Result(val isFirstTime: Boolean): State()
        data class Error(val messageError: String):State()
    }
}


