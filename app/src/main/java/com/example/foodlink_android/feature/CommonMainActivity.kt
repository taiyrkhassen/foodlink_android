package com.example.foodlink_android.feature

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.foodlink_android.R
import com.example.foodlink_android.common.base.BaseActivity
import com.example.foodlink_android.common.base.NavigationAnimation
import com.example.foodlink_android.common.constants.ApplicationConstants
import com.example.foodlink_android.common.helpers.changeFragment
import com.example.foodlink_android.feature.birja.BirjaFragment
import com.example.foodlink_android.feature.chefs.ChefFragment
import com.example.foodlink_android.feature.profile.ProfileFragment
import com.example.foodlink_android.feature.registration.presentation.RegistrationActivityContainer
import com.example.foodlink_android.feature.status_order.StatusFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.common_activity.*

class CommonMainActivity : BaseActivity() {

    private lateinit var navBar: BottomNavigationView

    private val mOnNavigationItemSelectedListener =
        BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.chefs -> {
                    showFragment(ApplicationConstants.CHEFS_FRAGMENT_NUMBER, null)
                    return@OnNavigationItemSelectedListener true
                }
                R.id.birja -> {
                    showFragment(ApplicationConstants.BIRJA_FRAGMENT_NUMBER, null)
                    return@OnNavigationItemSelectedListener true
                }
                R.id.orders -> {
                    showFragment(ApplicationConstants.STATUS_ORDER_FRAGMENT_NUMBER, null)
                    return@OnNavigationItemSelectedListener true
                }
                R.id.profile -> {
                    showFragment(ApplicationConstants.PROFILE_FRAGMENT_NUMBER, null)
                    return@OnNavigationItemSelectedListener true
                }
            }
            false
        }

    companion object {
        fun start(
            context: Context?,
            bundle: Bundle? = null,
            flag: Int? = null,
            page: Pair<String, Int>? = null
        ) {
            val intent = Intent(context, CommonMainActivity::class.java)
            if (bundle != null) {
                intent.putExtras(bundle)
            }
            if (flag != null) {
                intent.setFlags(flag)
            }
            if (page != null) {
                when (page.second) {
                    1 -> {
                        intent.putExtra(ApplicationConstants.FRAGMENT_NUMBER, 0)
                    }
                    2 -> {
                        intent.putExtra(ApplicationConstants.FRAGMENT_NUMBER, 1)
                    }
                    3 -> {
                        intent.putExtra(ApplicationConstants.FRAGMENT_NUMBER, 2)
                    }
                    4 -> {
                        intent.putExtra(ApplicationConstants.FRAGMENT_NUMBER, 3)
                    }
                }
            }

            (context as Activity).startActivity(intent)
            context.overridePendingTransition(R.anim.slide_up, R.anim.stay)
        }
    }

    private val fragmentsHashMap = HashMap<Int, Fragment>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.common_activity)
        setData()
        openFragment()
    }

    //for navbar fragments
    private fun openFragment() {
        navBar.menu.getItem(3)?.isChecked = true
        val fragment = intent.extras?.getInt(ApplicationConstants.FRAGMENT_NUMBER)
        if (fragment != null) {
            showFragment(fragment, intent.extras)
        } else {
            showFragment(ApplicationConstants.PROFILE_FRAGMENT_NUMBER, intent.extras)
        }

    }


    private fun showFragment(screen: Int, data: Bundle? = null) {
        fragmentsHashMap.get(screen)?.let {
            it.arguments = data
            val transaction = supportFragmentManager.beginTransaction()
                .replace(R.id.common_container, it, null)
            transaction.commitAllowingStateLoss()
        }

    }

    //for fragments inside this activity
    fun openFragment(fragment: Fragment, addToStack: Boolean = false) {
        changeFragment(
            R.id.auth_container,
            fragment,
            fragment.toString(),
            addToStack,
            if (addToStack) NavigationAnimation.SLIDE else NavigationAnimation.NONE
        )
    }

    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount > 0) {
            supportFragmentManager.popBackStack()
        } else {
            super.onBackPressed()
            overridePendingTransition(R.anim.stay, R.anim.slide_down)
        }
    }

    private fun setData() {
        navBar = findViewById(R.id.common_activity_bottom_nav)
        navBar.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        navBar.setOnNavigationItemReselectedListener {}

        fragmentsHashMap.put(
            ApplicationConstants.CHEFS_FRAGMENT_NUMBER,
            ChefFragment.newInstance(intent.extras)
        )
        fragmentsHashMap.put(
            ApplicationConstants.BIRJA_FRAGMENT_NUMBER,
            BirjaFragment.newInstance(intent.extras)
        )
        fragmentsHashMap.put(
            ApplicationConstants.STATUS_ORDER_FRAGMENT_NUMBER,
            StatusFragment.newInstance(intent.extras)
        )
        fragmentsHashMap.put(
            ApplicationConstants.PROFILE_FRAGMENT_NUMBER,
            ProfileFragment.newInstance(intent.extras)
        )
    }
}