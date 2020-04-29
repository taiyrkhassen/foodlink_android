package com.example.foodlink_android

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import com.example.foodlink_android.common.base.BaseViewModel
import com.example.foodlink_android.repositories.RepositoryAuthImpl
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class SplashViewModel @Inject constructor(
    private val authRepo: RepositoryAuthImpl
) : BaseViewModel() {

    val state = MediatorLiveData<State>()
    val stateLiveData:LiveData<State> = state
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


