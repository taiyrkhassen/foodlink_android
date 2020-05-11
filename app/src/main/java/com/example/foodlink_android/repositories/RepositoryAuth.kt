package com.example.foodlink_android.repositories

import android.content.SharedPreferences
import com.example.foodlink_android.common.api.ApiService
import com.example.foodlink_android.common.constants.ApplicationConstants
import io.reactivex.Single
import javax.inject.Inject

interface RepositoryAuth {
    fun checkIsAuthorised(): Single<Boolean>
    fun recordUser()
}

class RepositoryAuthImpl @Inject constructor(
    private val apiService: ApiService,
    private val sharedPreferences: SharedPreferences
) : RepositoryAuth {

    override fun checkIsAuthorised(): Single<Boolean> {
        return Single.just(false)
       // return Single.just(sharedPreferences.getBoolean(ApplicationConstants.USER_NEW, false))
    }

    override fun recordUser() {
        val prefsEditor = sharedPreferences.edit()
        prefsEditor.putBoolean(ApplicationConstants.USER_NEW, true)
        prefsEditor.apply()
    }


}