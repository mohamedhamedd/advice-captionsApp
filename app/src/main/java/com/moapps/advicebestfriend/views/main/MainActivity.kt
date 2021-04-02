package com.moapps.advicebestfriend.views.main

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.moapps.advicebestfriend.R
import com.moapps.advicebestfriend.views.random.RandomActivity
import com.moapps.advicebestfriend.views.search.SearchActivity
import kotlinx.android.synthetic.main.activity_main.*
import maes.tech.intentanim.CustomIntent

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        hideSystemUI(this)

        random_advice_btn.setOnClickListener {
            val intent = Intent(this, RandomActivity::class.java)
            startActivity(intent)
            CustomIntent.customType(this, "left-to-right")
        }

        special_advice_btn.setOnClickListener {
            val intent = Intent(this, SearchActivity::class.java)
            startActivity(intent)
            CustomIntent.customType(this, "left-to-right")
        }

    }

    private fun hideSystemUI(activity: Activity) {
        val decorView = activity.window.decorView
        decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN //| View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                //| View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_FULLSCREEN // hide status bar
                or View.SYSTEM_UI_FLAG_IMMERSIVE)
    }
}