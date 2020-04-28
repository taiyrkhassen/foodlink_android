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
import com.example.foodlink_android.feature.profile.ProfileFragment
import com.example.foodlink_android.feature.registration.presentation.RegistrationActivityContainer

class CommonMainActivity: BaseActivity() {

    companion object {
        fun start(
            context: Context?,
            bundle: Bundle? = null,
            flag: Int? = null,
            page: Pair<String, Int>? = null
        ) {
            val intent = Intent(context, RegistrationActivityContainer::class.java)
            if (bundle != null) {
                intent.putExtras(bundle)
            }
            if (flag != null) {
                intent.setFlags(flag)
            }
            if(page!=null){
                when(page.second){
                    1 ->{
                        //change to 1st fragment
                        intent.putExtra( ApplicationConstants.PROFILE_FRAGMENT, 4)
                    }
                    2 ->{
                        intent.putExtra( ApplicationConstants.PROFILE_FRAGMENT, 4)
                    }
                    3->{
                        intent.putExtra( ApplicationConstants.PROFILE_FRAGMENT, 4)
                    }
                    4->{
                        intent.putExtra( ApplicationConstants.PROFILE_FRAGMENT, 4)
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
        fragmentsHashMap.put(4, ProfileFragment.newInstance(intent.extras))
        setContentView(R.layout.common_activity)
        openFragment()
    }


    private fun openFragment(){
        val fragment = intent.extras?.getInt(ApplicationConstants.PROFILE_FRAGMENT)
        if (fragment != null) {
            showFragment(fragment, intent.extras)
        } else {
            showFragment(4, intent.extras)
        }

    }

    private fun showFragment(screen: Int, data: Bundle? = null){
        fragmentsHashMap.get(screen)?.let {
            it.arguments = data
            val transaction = supportFragmentManager.beginTransaction()
                .replace(R.id.common_container, it, null)
            // todo check
            transaction.commitAllowingStateLoss()
            // supportFragmentManager.executePendingTransactions()
        }

    }
    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount > 0) {
            supportFragmentManager.popBackStack()
        } else {
            super.onBackPressed()
            overridePendingTransition(R.anim.stay, R.anim.slide_down)
        }
    }
}