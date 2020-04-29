package com.example.foodlink_android.feature.registration.presentation

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.foodlink_android.R
import com.example.foodlink_android.common.base.BaseActivity
import com.example.foodlink_android.common.base.NavigationAnimation
import com.example.foodlink_android.common.helpers.changeFragment
import com.example.foodlink_android.feature.CommonMainActivity

class RegistrationActivityContainer: BaseActivity() {
    companion object {
        fun start(
            context: Context?,
            bundle: Bundle? = null,
            flag: Int? = null
        ) {
            val intent = Intent(context, RegistrationActivityContainer::class.java)
            if (bundle != null) {
                intent.putExtras(bundle)
            }
            if (flag != null) {
                intent.setFlags(flag)
            }

            (context as Activity).startActivity(intent)
            context.overridePendingTransition(R.anim.slide_up, R.anim.stay)
        }
    }

    private val fragments = arrayListOf(
        LoginFragment(),
        VerifyEmailFragment(),
        FillDataFragment()
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.registration_container_activity)
        openFragment(LoginFragment.newInstance())
    }


    fun openWithAnimation() {
        overridePendingTransition(R.anim.slide_up, R.anim.stay)
    }

    fun closeWithAnimation() {
        overridePendingTransition(R.anim.enter_from_left, R.anim.exit_to_right)
    }
    fun closeWithSlideDownAnimation(){
        overridePendingTransition(R.anim.stay, R.anim.slide_down)
    }


    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount > 0) {
            supportFragmentManager.popBackStack()
        } else {
            super.onBackPressed()
            overridePendingTransition(R.anim.stay, R.anim.slide_down)
        }
    }



    fun openFragment(fragment: Fragment, addToStack: Boolean = false) {
        changeFragment(
            R.id.auth_container,
            fragment,
            fragment.toString(),
            addToStack,
            if (addToStack) NavigationAnimation.SLIDE else NavigationAnimation.NONE
        )
    }

    fun finishAuth() {
        finish()
        CommonMainActivity.start(this)
    }


}