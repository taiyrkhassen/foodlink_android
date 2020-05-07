package com.example.foodlink_android.common.helpers

import android.app.Activity
import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.RecyclerView
import com.example.foodlink_android.R
import com.example.foodlink_android.common.base.NavigationAnimation



fun AppCompatActivity.changeFragment(
    layoutId: Int,
    fragment: Fragment,
    tagFragmentName: String,
    addToStack: Boolean = false,
    animation: NavigationAnimation = NavigationAnimation.NONE
) {
    val fragmentManager = supportFragmentManager
    val fragmentTransaction = fragmentManager.beginTransaction()
    if (addToStack) {
        fragmentTransaction.addToBackStack(tagFragmentName)
    }
    setTransactionAnimation(
        fragmentTransaction,
        animation
    )
    val currentFragment = fragmentManager.primaryNavigationFragment
    if (currentFragment != null) {
        fragmentTransaction.hide(currentFragment)
    }
    var fragmentTemp = fragmentManager.findFragmentByTag(tagFragmentName)
    if (fragmentTemp == null) {
        fragmentTemp = fragment
        fragmentTransaction.add(layoutId, fragmentTemp, tagFragmentName)
    } else {
        fragmentTransaction.show(fragmentTemp)
    }
    if (!isFinishing) {
        fragmentTransaction.setPrimaryNavigationFragment(fragmentTemp)
        fragmentTransaction.setReorderingAllowed(true)
        fragmentTransaction.commitAllowingStateLoss()
    }
}

private fun setTransactionAnimation(transaction: FragmentTransaction, animation: NavigationAnimation) {
    when (animation) {
        NavigationAnimation.SLIDE -> {
            transaction.setCustomAnimations(
                R.anim.enter_from_right,
                R.anim.exit_to_left,
                R.anim.enter_from_left,
                R.anim.exit_to_right
            )
        }
        NavigationAnimation.SLIDE_UP -> {
            transaction.setCustomAnimations(
                R.anim.slide_up,
                R.anim.stay,
                R.anim.stay,
                R.anim.slide_down
            )
        }
        else -> {}
    }
}

fun Activity.hideKeyboard() {
    this.currentFocus?.apply {
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(getWindowToken(), 0)
    }
}

