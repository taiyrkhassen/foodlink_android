package com.example.foodlink_android.common.base

import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.foodlink_android.R

abstract class BaseActivity : AppCompatActivity() {

    companion object {
        const val ANIMATION = "animation"
    }

    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount > 0) {
            supportFragmentManager.popBackStack()
        } else {
            super.onBackPressed()
        }
    }

    fun showFragment(
        fragment: Fragment,
        tag: String? = null,
        container: Int = R.id.base_container,
        animation: NavigationAnimation = NavigationAnimation.NONE,
        withDelay: Boolean = false
    ) {
        val transaction = supportFragmentManager.beginTransaction()
        when (animation) {
            NavigationAnimation.SLIDE -> {
                transaction.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left, R.anim.enter_from_left, R.anim.exit_to_right)
            }
            NavigationAnimation.SLIDE_UP -> {
                transaction.setCustomAnimations(R.anim.slide_up, R.anim.stay, R.anim.stay, R.anim.slide_down)
            }
            NavigationAnimation.NONE -> {}
        }
        if (tag.isNullOrEmpty()) {
            transaction.replace(container, fragment, tag)
        } else {
            transaction.replace(container, fragment, tag)
                .addToBackStack(tag)
        }
        if (withDelay) {
            Handler().postDelayed({
                transaction.commit()
            }, 2000)
        } else {
            transaction.commit()
        }
    }
}