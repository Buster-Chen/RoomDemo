package com.aoh404.roomdemo.weddinginfo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.aoh404.roomdemo.R

class WeddingInfoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wedding_info)
        replaceFragment(WeddingInfoFragment())

        ViewModelProvider(this).get(WeddingInfoActivityViewModel::class.java)
            .navigateToEditingWeddingInfoAction.observe(this, Observer {
                replaceFragment(EditingWeddingInfoFragment())
            })
    }

    override fun onBackPressed() {
        val count = supportFragmentManager.backStackEntryCount
        if (count > 1) {
            super.onBackPressed()
        } else {
            finish()
        }
    }
    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fl_container, fragment)
            .addToBackStack(fragment::class.simpleName)
            .commit()
    }
}